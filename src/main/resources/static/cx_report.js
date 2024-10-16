window.registerExtension('checkmarx/cx_report', function (options) {
 
  // let's create a flag telling if the static is still displayed
  var isDisplayed = true;
   //Setting analysis date to resolve continuous page refresh issue.
   //It is observeed that until a sonar analysis is done for a project, all the pages keeps on reloading.
   //By setting analysisDate for the project resolves the issue for checkmarx pages without having to run sonar scan on the project.
   if(!options.component.analysisDate)
   {
		options.component.analysisDate = 'tempAnalysisDate';
	}
   var staticUrl = window.baseUrl +'/static/checkmarx';
    var spanSpinner;

    //-------------------------- sast vars --------------------------------------

  var sastScanResultsLink;

  //counts
  var criticalCount;
  var highCount;
  var medCount;
  var lowCount;


  //-------------------------- osa vars --------------------------------------
  /*var osaEnabled = true;

  //libraries
  var osaVulnerableAndOutdatedLibs;
  var okLibraries;

  //thresholds
  var osaThresholdsEnabled = false;

  //links
  var osaSummaryResultsLink;

  //counts
  var osaHighCount;
  var osaMedCount;
  var osaLowCount;
*/

  //-------------------------- full reports vars --------------------------------------
  //-------------- sast ------------------


  //full report info
  var sastStartDate;
  var sastEndDate;// calculateEndDate(sastStartDate, sastScanTime);
  var sastNumFiles = 10;
  var sastLoc;

    //for extracting query web requests (run repressively)
    var queryPagesCounter = 0;

    //query lists
  var criticalCveList = [];
  var highCveList = [];
  var medCveList = [];
  var lowCveList = [];


  //-------------- osa ------------------
  //this is a solution to the case scenario where OSA is disabled and osaCveList returns null which crashes the javascript code
 /* var osaList;
  var osaLibraries;

  //links
  var osaHtmlPath = osaSummaryResultsLink;

  //full report info
  var osaStartDate;//adjustDateFormat('cx.osaStartTime');
  var osaEndDate;//adjustDateFormat('cx.osaEndTime');

  var isOsaFullReady = true;

  var osaNumFiles;
*/
  //cve lists
  /*var osaHighCveList = hardcodedCve.High;
  var osaMedCveList = hardcodedCve.Medium;
  var osaLowCveList = hardcodedCve.Low;*/

  var SEVERITY = {
    CRITICAL: {value: 0, name: "critical"},
    HIGH: {value: 1, name: "high"},
    MED: {value: 2, name: "medium"},
    LOW: {value: 3, name: "low"},
    
    OSA_HIGH: {value: 3, name: "high"},
    OSA_MED: {value: 4, name: "medium"},
    OSA_LOW: {value: 5, name: "low"}
  };


  // once the request is done, and the static is still displayed (not closed already)
  if (isDisplayed) {
      loadCssFile();
      //clear page in case where the page was loaded, redirected and then redirected back
      options.el.textContent = '';
      spanSpinner = getConnectingSpinner();
      options.el.appendChild(spanSpinner);

      initDataAndLoadUi();
  }

  function loadCssFile() {
    var fileRef = document.createElement("link");
    fileRef.id = "cxReportCss";
    fileRef.rel = "stylesheet";
    fileRef.type = "text/css";
    fileRef.href = staticUrl+'/cx_report_style.css';
    document.getElementsByTagName("head")[0].appendChild(fileRef)
  }


    function getConnectingSpinner() {
        var span = document.createElement('span');
        var h1 = document.createElement('h1');
        h1.textContent = "Loading...";
        h1.id = "h1Loading";
        span.appendChild(h1);
        var spinner = document.createElement('div');
        spinner.className = "spinner";
        spinner.id = "loadingReportSpinner";
        span.appendChild(spinner);
        return span;
    }

  function initDataAndLoadUi() {
       
       return metricRequest('cx.sast.result.high').then(function (responseHigh) {
           highCount = getValue(responseHigh);
           return metricRequest('cx.sast.result.medium')
       }).then(function (responseMedium) {
           medCount = getValue(responseMedium);
           return metricRequest('cx.sast.result.low')
       }).then(function (responseLow) {
           lowCount = getValue(responseLow);
           return metricRequest('cx.sast.result.critical')
       }).then(function (responseCritical) {
           criticalCount = getValue(responseCritical);
           return metricRequest('cx.sast.result.details')
       }).then(function (responseDetails) {
           var details = getValue(responseDetails);
           setDetails(details);
       }).then(function () {
           queryPagesCounter = 0;
           return getQueriesRecursivelyAndLoadUiWhenDone();
       }).catch(function (err) {
           console.log(err.message);
           try {
               options.el.removeChild(spanSpinner);
           }catch (ignored){}
           getHtml();
           parseAndInsertVarToHtml();
       });
  }

    function metricRequest(metricKey) {
        return window.SonarRequest.getJSON('/api/measures/component', {
            resolved: false,
            component: options.component.key,
            metricKeys: metricKey
        })}
    

    function getValue(response) {
        try{
            var component = response.component;
            var measures = component.measures[0];
            return measures.value;
        }catch (e){
            return null;
        }
    }

    function setDetails(details) {
        try {
            var parsedDetails = JSON.parse(details);
            sastStartDate = parsedDetails.scanStart;
            sastEndDate = parsedDetails.scanFinish;
            sastNumFiles = parsedDetails.numOfFiles;
            sastLoc = parsedDetails.numOfCodeLines;
            sastScanResultsLink = parsedDetails.viewerUri;
        }catch (ignored){}
    }

    //using recursion (and not a loop) due to promises malfunctions on sonar pages
    function getQueriesRecursivelyAndLoadUiWhenDone(){
        ++queryPagesCounter;
        componentTreeRequest(queryPagesCounter).then(function (response) {
            var iii = response.components;
        /*    var resTest=response.paging;*/
            if (iii == undefined || iii.length == 0 ) {
                //for timely execution this code needs to be here
                return new Promise(function () {
                    options.el.removeChild(spanSpinner);
                    getHtml();
                    parseAndInsertVarToHtml();
                })
            } else {
                iii.forEach(function (element) {
                    var par = element.measures;
                    if (par.length > 0) {
                        var effectivePartOfElement = par[0].value;
                        var queriesJson = JSON.parse(effectivePartOfElement);
                        addQueriesToSummery(queriesJson);
                    }
                });
            }
                 getQueriesRecursivelyAndLoadUiWhenDone();
            });
    }

    function componentTreeRequest(pageIdx) {
        return window.SonarRequest.getJSON('/api/measures/component_tree', {
            resolved: false,
            component: options.component.key,
            metricKeys: 'cx.sast.result.queries',
            qualifier: 'FIL',
            ps : 500,
            p: pageIdx
        })}

    function addQueriesToSummery(queriesJson) {
        if(queriesJson.criticalVulnerabilityQueries.length > 0){
            addQueriesToArray(queriesJson.criticalVulnerabilityQueries, criticalCveList);
        }		
        if(queriesJson.highVulnerabilityQueries.length > 0){
            addQueriesToArray(queriesJson.highVulnerabilityQueries, highCveList);
        }
        if(queriesJson.mediumVulnerabilityQuries.length > 0){
            addQueriesToArray(queriesJson.mediumVulnerabilityQuries, medCveList);
        }
        if(queriesJson.lowVulnerabilityQueries.length > 0){
            addQueriesToArray(queriesJson.lowVulnerabilityQueries, lowCveList);
        }
    }

    function addQueriesToArray(queries, array) {
        queries.forEach(function (element) {
            //javascript hashes automatically
            var query = array[element.name];
            if(query == undefined){
                array[element.name] = element;
            }else {
               query.numberOfOccurrences = query.numberOfOccurrences + element.numberOfOccurrences;
                array[element.name] = query;
            }
        });
    }


  /******************************************************************************************************************************************/
  /*************************************************************************************************************************************/
    
    function parseAndInsertVarToHtml() {
        if (highCount != null && medCount != null && lowCount != null) {
        try {
            document.getElementById("results-report").setAttribute("style", "display:block");

            //link
            document.getElementById("sast-summary-html-link").setAttribute("href", sastScanResultsLink);
            document.getElementById("sast-code-viewer-link").setAttribute("href", sastScanResultsLink);
            //set bars height and count
            if(criticalCount != null && criticalCount > 0){
            document.getElementById("bar-count-critical").innerHTML = criticalCount;
            }
            document.getElementById("bar-count-high").innerHTML = highCount;
            document.getElementById("bar-count-med").innerHTML = medCount;
            document.getElementById("bar-count-low").innerHTML = lowCount;

            var maxCount = Math.max(criticalCount ,highCount, medCount, lowCount);
            var maxHeight = maxCount * 100 / 90;
            if(criticalCount != null && criticalCount > 0){
            document.getElementById("bar-critical").setAttribute("style", "height:" + criticalCount * 100 / maxHeight + "%");
            }
            document.getElementById("bar-high").setAttribute("style", "height:" + highCount * 100 / maxHeight + "%");
            document.getElementById("bar-med").setAttribute("style", "height:" + medCount * 100 / maxHeight + "%");
            document.getElementById("bar-low").setAttribute("style", "height:" + lowCount * 100 / maxHeight + "%");
        } catch (e) {
            console.error("Element missing in SAST summary section " + e.message);
        }
        } else {
             document.getElementById("onSastError").setAttribute("style", "display:block");
             document.getElementById("scanErrorMessage").setAttribute("style", "display:block");
             return;
         }

        //---------------------------------------------------------- osa ---------------------------------------------------------------
        /* if (osaEnabled) {
         try {
         document.getElementById("osa-summary").setAttribute("style", "display:block");
         //link
         document.getElementById("osa-summary-html-link").setAttribute("href", osaHtmlPath);

         //set bars height and count
         document.getElementById("osa-bar-count-high").innerHTML = osaHighCount;
         document.getElementById("osa-bar-count-med").innerHTML = osaMedCount;
         document.getElementById("osa-bar-count-low").innerHTML = osaLowCount;


         var osaMaxCount = Math.max(osaHighCount, osaMedCount, osaLowCount);
         var osaMaxHeight = osaMaxCount * 100 / 90;

         document.getElementById("osa-bar-high").setAttribute("style", "height:" + osaHighCount * 100 / osaMaxHeight + "%");
         document.getElementById("osa-bar-med").setAttribute("style", "height:" + osaMedCount * 100 / osaMaxHeight + "%");
         document.getElementById("osa-bar-low").setAttribute("style", "height:" + osaLowCount * 100 / osaMaxHeight + "%");

         document.getElementById("vulnerable-libraries").innerHTML = numberWithCommas(osaVulnerableAndOutdatedLibs);
         document.getElementById("ok-libraries").innerHTML = numberWithCommas(okLibraries);
         }
         catch (e) {
         console.error("Element missing in OSA summary section " + e.message);
         }

         */
        //else {
        //document.getElementById("sast-summary").setAttribute("class", "sast-summary chart-large");
        //}

        //---------------------------------------------------------- full reports ---------------------------------------------------------------
        if ( highCveList != null || medCveList != null || lowCveList != null ) {
            document.getElementById("sast-summary").setAttribute("class", "sast-summary chart-large");
            document.getElementById("sast-full").setAttribute("style", "display: block");

            //queries lists
            /*  highCveList = generateQueryList(SEVERITY.HIGH);
             medCveList = generateQueryList(SEVERITY.MED);
             lowCveList = generateQueryList(SEVERITY.LOW);*/


            try {
                //sast links
                if (sastScanResultsLink != null) {
                   document.getElementById("sast-code-viewer-link").setAttribute("href", sastScanResultsLink);
                }
                //sast info
                if (sastStartDate != null && sastEndDate != null) {
                    document.getElementById("sast-full-start-date").innerHTML = sastStartDate;
                    document.getElementById("sast-full-end-date").innerHTML = sastEndDate;
                }
                if (sastNumFiles != null) {
                    document.getElementById("sast-full-files").innerHTML = numberWithCommas(sastNumFiles);
                }
                if (sastLoc != null) {
                    document.getElementById("sast-full-loc").innerHTML = numberWithCommas(sastLoc);
                }
            } catch (e) {
                console.error("Element missing in full report info section " + e.message);
            }

            try {
                //generate full reports
                if (criticalCount == 0 && highCount == 0 && medCount == 0 && lowCount == 0) {
                    document.getElementById("sast-full").setAttribute("style", "display: none");
                } else {
					if (criticalCount > 0) {
                        generateCveTable(SEVERITY.CRITICAL);
                    }
                    if (highCount > 0) {
                        generateCveTable(SEVERITY.HIGH);
                    }
                    if (medCount > 0) {
                        generateCveTable(SEVERITY.MED);
                    }
                    if (lowCount > 0) {
                        generateCveTable(SEVERITY.LOW);
                    }
                }

            } catch (e) {
                console.error("Element missing in full report detailed table section " + e.message);
            }
        }
    }

          /*if (isOsaFullReady) {
           document.getElementById("osa-full").setAttribute("style", "display: block");
           //cve lists
           osaHighCveList = generateOsaCveList(SEVERITY.OSA_HIGH);
           osaMedCveList = generateOsaCveList(SEVERITY.OSA_MED);
           osaLowCveList = generateOsaCveList(SEVERITY.OSA_LOW);

           osaNumFiles = osaLibraries.length;

           try {


           //osa links
           document.getElementById("osa-html-link").setAttribute("href", osaHtmlPath);


           //osa info
           document.getElementById("osa-full-start-date").innerHTML = formatDate(osaStartDate, "dd/mm/yy hh:mm");
           document.getElementById("osa-full-end-date").innerHTML = formatDate(osaEndDate, "dd/mm/yy hh:mm");
           document.getElementById("osa-full-files").innerHTML = numberWithCommas(osaNumFiles);
           } catch (e) {
           console.error("Element missing in full report info section " + e.message);
           }

           try {
           //generate full reports
           if (osaHighCount == 0 && osaMedCount == 0 && osaLowCount == 0) {
           document.getElementById("osa-full").setAttribute("style", "display: none");
           } else {
           if (osaHighCount > 0) {
           generateCveTable(SEVERITY.OSA_HIGH);
           }
           if (osaMedCount > 0) {
           generateCveTable(SEVERITY.OSA_MED);
           }
           if (osaLowCount > 0) {
           generateCveTable(SEVERITY.OSA_LOW);
           }
           }
           } catch (e) {
           console.error("Element missing in full report detailed table section " + e.message);
           }
           }*/

          //functions

          function generateCveTableTitle(severity) {
                var svgIcon;
                var severityNameTtl;
                var severityCountTtl;

                var svgCriticalIcon = '<svg width=\"16\" height=\"19\" viewBox=\"0 0 16 19\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M0 10V4.31302C0 2.19129 1.0015 0.184893 3.11764 0.030931C3.39036 0.0110888 3.68409 0 4 0H11.5C12.0072 0 12.462 0.0210035 12.8688 0.0569225C14.9823 0.243543 16 2.19129 16 4.31302V10C16 12.3957 12.4926 16.7045 11.0796 18.3432C10.7135 18.7678 10.1808 19 9.6202 19H6.3798C5.81919 19 5.28652 18.7678 4.92042 18.3432C3.50742 16.7045 0 12.3957 0 10Z\" fill=\"#F8788F\"/><path d=\"M0 10V4.31302C0 2.19129 1.0015 0.184893 3.11764 0.030931C3.39036 0.0110888 3.68409 0 4 0H11.5C12.0072 0 12.462 0.0210035 12.8688 0.0569225C14.9823 0.243543 16 2.19129 16 4.31302V10C16 12.3957 12.4926 16.7045 11.0796 18.3432C10.7135 18.7678 10.1808 19 9.6202 19H6.3798C5.81919 19 5.28652 18.7678 4.92042 18.3432C3.50742 16.7045 0 12.3957 0 10Z\" fill=\"#A00909\" fill-opacity=\"0.5\"/><path d=\"M8 0L14.186 0.883717C14.659 0.951285 15.0181 1.34399 15.0432 1.82111L15.5 10.5L11 18L8 19V0Z\" fill=\"#F8788F\"/><path d=\"M8 0L14.186 0.883717C14.659 0.951285 15.0181 1.34399 15.0432 1.82111L15.5 10.5L11 18L8 19V0Z\" fill=\"#A00909\" fill-opacity=\"0.9\"/><path d=\"M0.5 10V4.31302C0.5 3.32304 0.734816 2.39306 1.18352 1.70803C1.62289 1.03727 2.2683 0.594047 3.15392 0.529613C3.41417 0.510678 3.69579 0.5 4 0.5H11.5C11.9935 0.5 12.4335 0.520434 12.8248 0.554985C13.718 0.633851 14.3695 1.07659 14.8113 1.73726C15.2621 2.41124 15.5 3.32511 15.5 4.31302V10C15.5 10.4919 15.3156 11.1324 14.9753 11.8757C14.6393 12.6095 14.1721 13.3998 13.6535 14.1783C12.6167 15.7348 11.4018 17.2038 10.7009 18.0167C10.4345 18.3257 10.0427 18.5 9.6202 18.5H6.3798C5.95733 18.5 5.56554 18.3257 5.29909 18.0167C4.59817 17.2038 3.38331 15.7348 2.34646 14.1783C1.82787 13.3998 1.36066 12.6095 1.02473 11.8757C0.684403 11.1324 0.5 10.4919 0.5 10Z\" stroke=\"#F8788F\" stroke-linecap=\"round\"/><path d=\"M0.5 10V4.31302C0.5 3.32304 0.734816 2.39306 1.18352 1.70803C1.62289 1.03727 2.2683 0.594047 3.15392 0.529613C3.41417 0.510678 3.69579 0.5 4 0.5H11.5C11.9935 0.5 12.4335 0.520434 12.8248 0.554985C13.718 0.633851 14.3695 1.07659 14.8113 1.73726C15.2621 2.41124 15.5 3.32511 15.5 4.31302V10C15.5 10.4919 15.3156 11.1324 14.9753 11.8757C14.6393 12.6095 14.1721 13.3998 13.6535 14.1783C12.6167 15.7348 11.4018 17.2038 10.7009 18.0167C10.4345 18.3257 10.0427 18.5 9.6202 18.5H6.3798C5.95733 18.5 5.56554 18.3257 5.29909 18.0167C4.59817 17.2038 3.38331 15.7348 2.34646 14.1783C1.82787 13.3998 1.36066 12.6095 1.02473 11.8757C0.684403 11.1324 0.5 10.4919 0.5 10Z\" stroke=\"#A00909\" stroke-opacity=\"0.9\" stroke-linecap=\"round\"/><path d=\"M8.15998 12.1381C7.43365 12.1381 6.80889 11.9843 6.28569 11.6765C5.76557 11.3656 5.36547 10.9348 5.0854 10.3839C4.80842 9.83298 4.66992 9.19898 4.66992 8.48189C4.66992 7.75556 4.80996 7.11849 5.09002 6.57067C5.37317 6.01977 5.7748 5.59044 6.29492 5.28267C6.81505 4.97183 7.43365 4.81641 8.15075 4.81641C8.76935 4.81641 9.31102 4.92874 9.77575 5.15341C10.2405 5.37808 10.6083 5.69354 10.8791 6.09979C11.1499 6.50604 11.2992 6.98307 11.3269 7.53089H9.47106C9.41874 7.17696 9.28024 6.89228 9.05558 6.67685C8.83398 6.45833 8.54315 6.34908 8.18306 6.34908C7.87837 6.34908 7.61216 6.43217 7.38441 6.59837C7.15974 6.76148 6.98432 7 6.85813 7.31392C6.73195 7.62784 6.66886 8.00793 6.66886 8.45419C6.66886 8.9066 6.73041 9.29131 6.85352 9.60831C6.9797 9.92531 7.15666 10.1669 7.38441 10.3331C7.61216 10.4993 7.87837 10.5824 8.18306 10.5824C8.40773 10.5824 8.60932 10.5362 8.78782 10.4439C8.9694 10.3516 9.11867 10.2177 9.23562 10.0423C9.35565 9.86375 9.43413 9.64986 9.47106 9.40057H11.3269C11.2961 9.94223 11.1484 10.4193 10.8837 10.8317C10.6221 11.241 10.2605 11.5611 9.79883 11.7919C9.33718 12.0227 8.7909 12.1381 8.15998 12.1381Z\" fill=\"white\"/></svg>';
                var svgHighIcon = '<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="16" height="19" viewBox="0 0 16 19"><title>High</title><defs><path d="M1 1l7-1 7 1s1 3.015 1 6c0 6.015-5.323 11.27-5.323 11.27-.374.403-1.12.73-1.686.73H7.01c-.558 0-1.308-.333-1.675-.76C5.335 18.24 0 12.516 0 8c0-3.172 1-7 1-7z" id="a"/><path d="M1 1l7-1 7 1s1 3.015 1 6c0 6.015-5.323 11.27-5.323 11.27-.374.403-1.12.73-1.686.73H7.01c-.558 0-1.308-.333-1.675-.76C5.335 18.24 0 12.516 0 8c0-3.172 1-7 1-7z" id="c"/></defs><g fill="none" fill-rule="evenodd"><mask id="b" fill="#fff"><use xlink:href="#a"/></mask><use fill="#D82D49" xlink:href="#a"/><path stroke="#BB1A34" d="M1.404 1.447L8 .505l6.616.945.06.205c.114.402.23.85.336 1.334.298 1.342.48 2.682.488 3.924V7c0 2.52-.966 5.112-2.582 7.62-.57.884-1.18 1.694-1.79 2.41-.214.252-.41.472-.588.66-.104.113-.178.188-.215.224-.296.32-.91.586-1.334.586H7.01c-.42 0-1.028-.274-1.296-.585-.052-.056-.127-.14-.233-.26-.178-.202-.378-.436-.593-.697-.615-.747-1.23-1.564-1.804-2.422C2.097 13.06 1.34 11.62.906 10.284.64 9.462.5 8.697.5 8c0-.433.02-.895.056-1.38C.634 5.6.786 4.51.992 3.4c.108-.584.223-1.137.34-1.64.026-.118.05-.222.072-.313z"/><path fill="#BB1A34" mask="url(#b)" d="M8 0h8v20H8z"/><mask id="d" fill="#fff"><use xlink:href="#c"/></mask><path stroke="#BB1A34" d="M1.404 1.447L8 .505l6.616.945.06.205c.114.402.23.85.336 1.334.298 1.342.48 2.682.488 3.924V7c0 2.52-.966 5.112-2.582 7.62-.57.884-1.18 1.694-1.79 2.41-.214.252-.41.472-.588.66-.104.113-.178.188-.215.224-.296.32-.91.586-1.334.586H7.01c-.42 0-1.028-.274-1.296-.585-.052-.056-.127-.14-.233-.26-.178-.202-.378-.436-.593-.697-.615-.747-1.23-1.564-1.804-2.422C2.097 13.06 1.34 11.62.906 10.284.64 9.462.5 8.697.5 8c0-.433.02-.895.056-1.38C.634 5.6.786 4.51.992 3.4c.108-.584.223-1.137.34-1.64.026-.118.05-.222.072-.313z"/><path fill="#FFF" mask="url(#d)" d="M5 12h2V9.5h2V12h2V5H9v2.5H7V5H5"/></g></svg>';
                var svgMedIcon = '<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="16" height="20" viewBox="0 0 16 20"><title>Medium</title><defs><path d="M1 1.053L8 0l7 1.053s1 3.173 1 6.315c0 6.332-5.346 11.89-5.346 11.89-.36.41-1.097.742-1.663.742H7.01c-.558 0-1.3-.34-1.652-.77 0 0-5.358-6.056-5.358-10.81 0-3.338 1-7.367 1-7.367z" id="a"/><path d="M1 1.053L8 0l7 1.053s1 3.173 1 6.315c0 6.332-5.346 11.89-5.346 11.89-.36.41-1.097.742-1.663.742H7.01c-.558 0-1.3-.34-1.652-.77 0 0-5.358-6.056-5.358-10.81 0-3.338 1-7.367 1-7.367z" id="c"/></defs><g fill="none" fill-rule="evenodd"><mask id="b" fill="#fff"><use xlink:href="#a"/></mask><use fill="#FFAC00" xlink:href="#a"/><path stroke="#E49B16" d="M1.41 1.497L8 .507l6.61.993c.02.067.04.144.064.228.114.425.23.898.337 1.407.3 1.418.48 2.83.49 4.143v.09c0 2.665-.972 5.404-2.6 8.06-.57.934-1.185 1.79-1.8 2.55-.213.264-.412.498-.59.698-.105.118-.18.198-.216.237-.282.32-.882.587-1.302.587H7.01c-.414 0-1.01-.277-1.266-.587-.05-.06-.126-.146-.233-.274-.18-.216-.38-.464-.594-.74-.62-.79-1.237-1.654-1.814-2.56-.982-1.55-1.74-3.06-2.18-4.463C.645 9.994.5 9.17.5 8.42c0-.457.02-.944.057-1.457.077-1.072.23-2.22.435-3.392.11-.614.224-1.197.34-1.73L1.41 1.5z"/><path fill="#D79201" mask="url(#b)" d="M8 0h8v20H8z"/><mask id="d" fill="#fff"><use xlink:href="#c"/></mask><path stroke="#D49100" d="M1.41 1.497L8 .507l6.61.993c.02.067.04.144.064.228.114.425.23.898.337 1.407.3 1.418.48 2.83.49 4.143v.09c0 2.665-.972 5.404-2.6 8.06-.57.934-1.185 1.79-1.8 2.55-.213.264-.412.498-.59.698-.105.118-.18.198-.216.237-.282.32-.882.587-1.302.587H7.01c-.414 0-1.01-.277-1.266-.587-.05-.06-.126-.146-.233-.274-.18-.216-.38-.464-.594-.74-.62-.79-1.237-1.654-1.814-2.56-.982-1.55-1.74-3.06-2.18-4.463C.645 9.994.5 9.17.5 8.42c0-.457.02-.944.057-1.457.077-1.072.23-2.22.435-3.392.11-.614.224-1.197.34-1.73L1.41 1.5z"/><path fill="#472F00" mask="url(#d)" d="M4.28 12.632h1.9v-4.21l1.78 2.862H8L9.79 8.4v4.232h1.93v-7.37H9.67L8 8.117 6.33 5.263H4.28"/></g></svg>';
                var svgLowIcon = '<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="16" height="19" viewBox="0 0 16 19"><title>Low</title><defs><path d="M1 1l7-1 7 1s1 3.015 1 6c0 6.015-6 12-6 12H6S0 12.515 0 8c0-3.172 1-7 1-7z" id="a"/><path d="M1 1l7-1 7 1s1 3.015 1 6c0 6.015-6 12-6 12H6S0 12.515 0 8c0-3.172 1-7 1-7z" id="c"/></defs><g fill="none" fill-rule="evenodd"><path d="M7.96 17.32L8 .015l-6.5 1s-.96 4.5-.96 8.75c1.272 4.602 5.968 9.25 5.968 9.25h.163l1.29-1.695z" fill="#EDEFF5"/><mask id="b" fill="#fff"><use xlink:href="#a"/></mask><use fill="#FFEB3B" xlink:href="#a"/><path stroke="#E4D200" d="M1.404 1.447L8 .505l6.616.945.06.205c.114.402.23.85.336 1.334.298 1.34.48 2.68.488 3.923V7c0 2.515-1.09 5.243-2.916 7.978-.644.966-1.335 1.863-2.026 2.667-.24.28-.465.53-.665.745-.04.04-.074.077-.105.11H6.222l-.105-.118c-.202-.23-.427-.492-.67-.785-.694-.837-1.388-1.744-2.035-2.687-.89-1.298-1.62-2.56-2.128-3.738C.772 9.982.5 8.912.5 8c0-.433.02-.895.056-1.38.078-1.02.23-2.11.436-3.22.108-.584.223-1.137.34-1.64.026-.118.05-.222.072-.313z"/><path fill="#DDCE00" mask="url(#b)" d="M8-8h10v32H8z"/><mask id="d" fill="#fff"><use xlink:href="#c"/></mask><path stroke="#E4D200" d="M1.404 1.447L8 .505l6.616.945.06.205c.114.402.23.85.336 1.334.298 1.34.48 2.68.488 3.923V7c0 2.515-1.09 5.243-2.916 7.978-.644.966-1.335 1.863-2.026 2.667-.24.28-.465.53-.665.745-.04.04-.074.077-.105.11H6.222l-.105-.118c-.202-.23-.427-.492-.67-.785-.694-.837-1.388-1.744-2.035-2.687-.89-1.298-1.62-2.56-2.128-3.738C.772 9.982.5 8.912.5 8c0-.433.02-.895.056-1.38.078-1.02.23-2.11.436-3.22.108-.584.223-1.137.34-1.64.026-.118.05-.222.072-.313z"/><path fill="#605900" mask="url(#d)" d="M5.54 12h5.33v-1.7H7.48V5H5.54"/></g></svg>';

                switch (severity) {
                      case SEVERITY.CRITICAL:
                            svgIcon = svgCriticalIcon;
                            severityNameTtl = "Critical";
                            severityCountTtl = criticalCount;                            
                            break;
                         
                      case SEVERITY.HIGH:
                            svgIcon = svgHighIcon;
                            severityNameTtl = "High";
                            severityCountTtl = highCount;
                            break;


                      case SEVERITY.MED:
                            svgIcon = svgMedIcon;
                            severityNameTtl = "Medium";
                            severityCountTtl = medCount;
                            break;


                      case SEVERITY.LOW:
                            svgIcon = svgLowIcon;
                            severityNameTtl = "Low";
                            severityCountTtl = lowCount;
                            break;

                }

                return '' +
                    '<div class="full-severity-title">' +
                    '<div class="severity-icon">' +
                    svgIcon +
                    '</div>' +
                    '<div class="severity-title-name">' + severityNameTtl + '</div>' +
                    '<div class="severity-count">' + severityCountTtl + '</div>' +
                    '</div>';
          }


      function generateSastCveTable(severity) {
        var severityCount;
        var severityCveList;
        var tableElementId = "";

        switch (severity) {
			
          case SEVERITY.CRITICAL:
            severityCount = criticalCount;
            severityCveList = hashedObjArrayToJsonArray(criticalCveList);
            tableElementId = "sast-cve-table-critical";
            break;
            			
          case SEVERITY.HIGH:
            severityCount = highCount;
            severityCveList = hashedObjArrayToJsonArray(highCveList);
            tableElementId = "sast-cve-table-high";
            break;

          case SEVERITY.MED:
            severityCount = medCount;
            severityCveList = hashedObjArrayToJsonArray(medCveList);
            tableElementId = "sast-cve-table-med";
            break;

          case SEVERITY.LOW:
            severityCount = lowCount;
            severityCveList = hashedObjArrayToJsonArray(lowCveList);
            tableElementId = "sast-cve-table-low";
            break;
        }

        //generate table title
        var severityTitle = generateCveTableTitle(severity);

        //generate table headers
        var tableHeadersNames = {h1: "Vulnerability Type", h2: "##"};
        var tableHeadersElement = generateCveTableHeaders(tableHeadersNames);

        //get container and create table element in it
        document.getElementById(tableElementId + '-container').innerHTML =
            severityTitle +
            '<table id="' + tableElementId + '" class="cve-table sast-cve-table ' + tableElementId + '">' +
            tableHeadersElement +
            '</table>';

        //get the created table
        var table = document.getElementById(tableElementId);

        //add rows to table
        var row;
        severityCveList.forEach( function (query) {
          row = table.insertRow();
          row.insertCell(0).innerHTML = query.name;
          row.insertCell(1).innerHTML = query.numberOfOccurrences;
        });
      }

        function hashedObjArrayToJsonArray(objects) {
            var toRet = [];
            for (var key in objects) {
                if (objects.hasOwnProperty(key))
                    toRet.push(objects[key]);
            }
            return toRet;
        }

      function addZero(i) {
        if (i < 10) {
          i = "0" + i;
        }
        return i;
      }

      function formatDate(date, format) {
        var d = new Date(date);
        var day = addZero(d.getDate());
        var month = addZero(d.getMonth() + 1); //starts from 0 (if the month is January getMonth returns 0)
        var year = d.getFullYear();
        var h = addZero(d.getHours());
        var m = addZero(d.getMinutes());

        switch (format) {
          case "date":
          case "dd-mm-yyyy":
            return day + "-" + month + "-" + year;
            break;
          case "dateTime":
          case "dd/mm/yy hh:mm":
            return day + "/" + month + "/" + year + " " + h + ":" + m;
            break;
        }

      }

      /*function generateOsaCveTable(severity) {
        var severityCount;
        var severityCveList;
        var tableElementId = "";

        switch (severity) {
          case SEVERITY.OSA_HIGH:
            severityCount = osaHighCount;
            severityCveList = osaHighCveList;
            tableElementId = "osa-cve-table-high";
            break;

          case SEVERITY.OSA_MED:
            severityCount = osaMedCount;
            severityCveList = osaMedCveList;
            tableElementId = "osa-cve-table-med";
            break;

          case SEVERITY.OSA_LOW:
            severityCount = osaLowCount;
            severityCveList = osaLowCveList;
            tableElementId = "osa-cve-table-low";
            break;
        }

        var libraryIdToName = libraryDictionary(osaLibraries);

        //generate table title
        var severityTitle = generateCveTableTitle(severity);

        //generate table headers
        var tableHeadersNames = {h1: "Vulnerability Type", h2: "Publish Date", h3: "Library"};
        var tableHeadersElement = generateCveTableHeaders(tableHeadersNames);

        //get container and create table element in it
        document.getElementById(tableElementId + '-container').innerHTML =
            severityTitle +
            '<table id="' + tableElementId + '" class="cve-table osa-cve-table ' + tableElementId + '">' +
            tableHeadersElement +
            '</table>';

        //get the created table
        var table = document.getElementById(tableElementId);

        //add rows to table
        var row;
        for (i = 0; i < severityCveList.length; i++) {
          row = table.insertRow(i + 1);
          row.insertCell(0).innerHTML = severityCveList[i].cveName;
          row.insertCell(1).innerHTML = formatDate(severityCveList[i].publishDate, "dd-mm-yyyy");
          row.insertCell(2).innerHTML = libraryIdToName[severityCveList[i].libraryId];

        }
      }*/

      function generateCveTableHeaders(headers) {
        var ret = "<tr>";

        for (h in headers) {
          ret += '<th>' + headers[h] + '</th>';
        }

        ret += "</tr>";
        return ret;
      }

      function generateCveTable(severity) {
        switch (severity) {
          case SEVERITY.CRITICAL:
          case SEVERITY.HIGH:
          case SEVERITY.MED:
          case SEVERITY.LOW:
            generateSastCveTable(severity);
            break;

          case SEVERITY.OSA_HIGH:
          case SEVERITY.OSA_MED:
          case SEVERITY.OSA_LOW:
            generateOsaCveTable(severity);
            break;
        }
      }

      function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      }

      //osa list
      function generateOsaCveList(severity) {
        var severityOsaList = [];
        //loop through queries and push the relevant query - by severity - to the new list
        for (var i = 0; i < osaList.length; i++) {
          if (osaList[i].severity.name.toLowerCase() == severity.name) {
            severityOsaList.push(osaList[i]);
          }
        }
        return severityOsaList;
      }

      function libraryDictionary(osaLibraries) {
        var libraryIdToName = {};
        for (var i = 0; i < osaLibraries.length; i++) {
          libraryIdToName[osaLibraries[i].id] = osaLibraries[i].name;
        }
        return libraryIdToName;
      }

      function calculateEndDate(startDate, scanTime) {
        var start = new Date(startDate);

        //"00h:00m:00s"
        var scanTimeHours = scanTime.substring(0, 2);
        var scanTimeMinutes = scanTime.substring(4, 6);
        var scanTimeSeconds = scanTime.substring(8, 10);
        var scanTimeMillis = scanTimeHours * 3600000 + scanTimeMinutes * 60000 + scanTimeSeconds * 1000;

        return new Date(start.getTime() + scanTimeMillis);

      }

      function adjustDateFormat(date) {
        return date.substr(0, 10) + " " + date.substr(11);
      }



          function getHtml() {
                var div = document.createElement('div');
			

                div.className = "cxCompleteReport";
                div.id = "cxReport";
				var condition = criticalCount > 0 ;
                var criticalsection = condition ? 
                  "                        <!--critical-->"+
                  "                        <li>"+
                  "                                <span class=\"bar-1\" id=\"bar-critical\">"+
                  "                                    <div id=\"tooltip-critical\"><\/div>"+
                  "                                <\/span>"+
                  "                            <div class=\"bar-title-container\">"+
                  "                                <div class=\"bar-title-icon\">"+
				  " 							<svg width=\"16\" height=\"19\" viewBox=\"0 0 16 19\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">" +
				  "								<path d=\"M0 10V4.31302C0 2.19129 1.0015 0.184893 3.11764 0.030931C3.39036 0.0110888 3.68409 0 4 0H11.5C12.0072 0 12.462 0.0210035 12.8688 0.0569225C14.9823 0.243543 16 2.19129 16 4.31302V10C16 12.3957 12.4926 16.7045 11.0796 18.3432C10.7135 18.7678 10.1808 19 9.6202 19H6.3798C5.81919 19 5.28652 18.7678 4.92042 18.3432C3.50742 16.7045 0 12.3957 0 10Z\" fill=\"#F8788F\"/>" +
				  "								<path d=\"M0 10V4.31302C0 2.19129 1.0015 0.184893 3.11764 0.030931C3.39036 0.0110888 3.68409 0 4 0H11.5C12.0072 0 12.462 0.0210035 12.8688 0.0569225C14.9823 0.243543 16 2.19129 16 4.31302V10C16 12.3957 12.4926 16.7045 11.0796 18.3432C10.7135 18.7678 10.1808 19 9.6202 19H6.3798C5.81919 19 5.28652 18.7678 4.92042 18.3432C3.50742 16.7045 0 12.3957 0 10Z\" fill=\"#A00909\" fill-opacity=\"0.5\"/>" +
				  "								<path d=\"M8 0L14.186 0.883717C14.659 0.951285 15.0181 1.34399 15.0432 1.82111L15.5 10.5L11 18L8 19V0Z\" fill=\"#F8788F\"/>" +
				  "								<path d=\"M8 0L14.186 0.883717C14.659 0.951285 15.0181 1.34399 15.0432 1.82111L15.5 10.5L11 18L8 19V0Z\" fill=\"#A00909\" fill-opacity=\"0.9\"/>" +
				  "								<path d=\"M0.5 10V4.31302C0.5 3.32304 0.734816 2.39306 1.18352 1.70803C1.62289 1.03727 2.2683 0.594047 3.15392 0.529613C3.41417 0.510678 3.69579 0.5 4 0.5H11.5C11.9935 0.5 12.4335 0.520434 12.8248 0.554985C13.718 0.633851 14.3695 1.07659 14.8113 1.73726C15.2621 2.41124 15.5 3.32511 15.5 4.31302V10C15.5 10.4919 15.3156 11.1324 14.9753 11.8757C14.6393 12.6095 14.1721 13.3998 13.6535 14.1783C12.6167 15.7348 11.4018 17.2038 10.7009 18.0167C10.4345 18.3257 10.0427 18.5 9.6202 18.5H6.3798C5.95733 18.5 5.56554 18.3257 5.29909 18.0167C4.59817 17.2038 3.38331 15.7348 2.34646 14.1783C1.82787 13.3998 1.36066 12.6095 1.02473 11.8757C0.684403 11.1324 0.5 10.4919 0.5 10Z\" stroke=\"#F8788F\" stroke-linecap=\"round\"/>" +
				  "							    <path d=\"M0.5 10V4.31302C0.5 3.32304 0.734816 2.39306 1.18352 1.70803C1.62289 1.03727 2.2683 0.594047 3.15392 0.529613C3.41417 0.510678 3.69579 0.5 4 0.5H11.5C11.9935 0.5 12.4335 0.520434 12.8248 0.554985C13.718 0.633851 14.3695 1.07659 14.8113 1.73726C15.2621 2.41124 15.5 3.32511 15.5 4.31302V10C15.5 10.4919 15.3156 11.1324 14.9753 11.8757C14.6393 12.6095 14.1721 13.3998 13.6535 14.1783C12.6167 15.7348 11.4018 17.2038 10.7009 18.0167C10.4345 18.3257 10.0427 18.5 9.6202 18.5H6.3798C5.95733 18.5 5.56554 18.3257 5.29909 18.0167C4.59817 17.2038 3.38331 15.7348 2.34646 14.1783C1.82787 13.3998 1.36066 12.6095 1.02473 11.8757C0.684403 11.1324 0.5 10.4919 0.5 10Z\" stroke=\"#A00909\" stroke-opacity=\"0.9\" stroke-linecap=\"round\"/>" +
				  "								<path d=\"M8.15998 12.1381C7.43365 12.1381 6.80889 11.9843 6.28569 11.6765C5.76557 11.3656 5.36547 10.9348 5.0854 10.3839C4.80842 9.83298 4.66992 9.19898 4.66992 8.48189C4.66992 7.75556 4.80996 7.11849 5.09002 6.57067C5.37317 6.01977 5.7748 5.59044 6.29492 5.28267C6.81505 4.97183 7.43365 4.81641 8.15075 4.81641C8.76935 4.81641 9.31102 4.92874 9.77575 5.15341C10.2405 5.37808 10.6083 5.69354 10.8791 6.09979C11.1499 6.50604 11.2992 6.98307 11.3269 7.53089H9.47106C9.41874 7.17696 9.28024 6.89228 9.05558 6.67685C8.83398 6.45833 8.54315 6.34908 8.18306 6.34908C7.87837 6.34908 7.61216 6.43217 7.38441 6.59837C7.15974 6.76148 6.98432 7 6.85813 7.31392C6.73195 7.62784 6.66886 8.00793 6.66886 8.45419C6.66886 8.9066 6.73041 9.29131 6.85352 9.60831C6.9797 9.92531 7.15666 10.1669 7.38441 10.3331C7.61216 10.4993 7.87837 10.5824 8.18306 10.5824C8.40773 10.5824 8.60932 10.5362 8.78782 10.4439C8.9694 10.3516 9.11867 10.2177 9.23562 10.0423C9.35565 9.86375 9.43413 9.64986 9.47106 9.40057H11.3269C11.2961 9.94223 11.1484 10.4193 10.8837 10.8317C10.6221 11.241 10.2605 11.5611 9.79883 11.7919C9.33718 12.0227 8.7909 12.1381 8.15998 12.1381Z\" fill=\"white\"/>" +
				  "							       </svg>"+
                  "                                <\/div>"+
                  "                                <div class=\"bar-title\">Critical -<\/div>"+
                  "                                <div class=\"bar-count\" id=\"bar-count-critical\"><\/div>"+
                  "                            <\/div>"+
                  "                        <\/li>"+
                  ""  : " ";
				
              div.innerHTML =

                  "  <div class=\"report-title\">"+
                  "        <div class=\"cx-report-title\">Checkmarx Report<\/div>"+
                  "    <\/div>"+
                  ""+
                  ""+
                  "    <div id=\"onSastError\" class=\"error-msg\">"+
                  "        <div id=\"scanErrorMessage\" class=\"aui-message error\">"+
                  "            <span class=\"aui-icon icon-error\"><\/span>"+
                  "            <p>There are no Checkmarx scan results available for this project.<br><br>" +
                  "For generating Checkmarx results:<br> 1. Add Checkmarx rules to the project active quality profiles.<br>"+
                  "2. Configure Checkmarx at SonarQube's Project > Administration > Checkmarx (available for SonarQube admin only).<br>"+
                  "3. Run Checkmarx scan.<br>"+
                  "4. Run SonarQube scan.<br><br>" +
                  ""         +"If you performed all of the above and still cannot see Checkmarx results, please see SonarQube scan log for error information."+
                  "<\/p>"+
                  //  "            <strong>Currently scan results are not available. Please check the scan logs for more information<\/strong>"+
                  "        <\/div>"+
                  "    <\/div>"+
                  ""+
                  "    <div id=\"results-report\" class=\"results-report\">"+
                  ""+
                  ""+
                  "        <table class=\"summary-section\">"+
                  "             <tr class=\"summary-report-diagram-section\">"+
                        "<div class=\"summary-table-row cxsast-full\">"+
                  ""+   "<div class=\"title-column\">"+
                  "                    <div class=\"summary-title\">"+
                  "                        <div class=\"sum1\">CxSAST<\/div>"+
                  "                        <div class=\"sum1\">Vulnerabilities<\/div>"+
                  "                        <div class=\"sum1\">Status<\/div>"+
                  "                    <\/div>"+
                  "                    <div class=\"summary-title-links\">"+
                  "                        <a class=\"html-report\" id=\"sast-summary-html-link\">"+
                  "                            <div class=\"results-link summary-link\">"+
                  "                                <div class=\"results-link-icon link-icon\">"+
                  "                                    <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" width=\"12\" height=\"14\" viewBox=\"0 0 12 14\">"+
                  "                                        <g fill=\"none\" fill-rule=\"evenodd\">"+
                  "                                            <circle stroke=\"#4A90E2\" stroke-width=\"2\" cx=\"5\" cy=\"5\" r=\"4\"><\/circle>"+
                  "                                            <path fill=\"#4A90E2\" d=\"M6.366 8.366l1.732-1 3.268 5.66-1.732 1z\"><\/path>"+
                  "                                        <\/g>"+
                  "                                    <\/svg>"+
                  "                                <\/div>"+
                  "                                <div class=\"summary-link-text\">Analyze Results<\/div>"+
                  "                            <\/div>"+
                  "                        <\/a>"+
                  "                    <\/div>"+
                        "<\/div>"+

                  ""+
                  "            <div class=\"sast-summary\" id=\"sast-summary\">"+
                  "                <div class=\"summary-report-title sast\">"+
                  "                    <div class=\"summary-title-text sast\">CxSAST Vulnerabilities Status<\/div>"+
                  ""+
                  ""+
                  "                <\/div>"+
                  "                <div class=\"summary-chart\">"+
                  "                    <div class=\"threshold-exceeded-compliance\" id=\"threshold-exceeded-compliance\"><\/div>"+
                  "                    <ul class=\"chart\">"+
                  ""+
                  criticalsection +
                  
                  "                        <!--high-->"+
                  "                        <li>"+
                  "                                <span class=\"bar-1\" id=\"bar-high\">"+
                  "                                    <div id=\"tooltip-high\"><\/div>"+
                  "                                <\/span>"+
                  "                            <div class=\"bar-title-container\">"+
                  "                                <div class=\"bar-title-icon\">"+
                  "                                    <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\""+
                  "                                         width=\"16px\" height=\"19px\" viewBox=\"0 0 16 19\" version=\"1.1\">"+
                  "                                        <!-- Generator: Sketch 43.2 (39069) - http:\/\/www.bohemiancoding.com\/sketch -->"+
                  "                                        <title>Med<\/title>"+
                  "                                        <desc>Created with Sketch.<\/desc>"+
                  "                                        <defs>"+
                  "                                            <path d=\"M1,1 L8,0 L15,1 C15,1 16,4.01515152 16,7 C16,13.0151515 10.6766131,18.2701936 10.6766131,18.2701936 C10.30293,18.6732545 9.55664682,19 8.9906311,19 L7.0093689,19 C6.45190985,19 5.70245907,18.6673641 5.33497024,18.2411641 C5.33497024,18.2411641 3.70193273e-12,12.5151515 3.63797881e-12,8 C7.03437308e-13,4.82765152 1,1 1,1 Z\""+
                  "                                                  id=\"path-1\"\/>"+
                  "                                            <path d=\"M1,1 L8,0 L15,1 C15,1 16,4.01515152 16,7 C16,13.0151515 10.6766131,18.2701936 10.6766131,18.2701936 C10.30293,18.6732545 9.55664682,19 8.9906311,19 L7.0093689,19 C6.45190985,19 5.70245907,18.6673641 5.33497024,18.2411641 C5.33497024,18.2411641 3.70193273e-12,12.5151515 3.63797881e-12,8 C7.03437308e-13,4.82765152 1,1 1,1 Z\""+
                  "                                                  id=\"path-3\"\/>"+
                  "                                        <\/defs>"+
                  "                                        <g id=\"Page-1\" stroke=\"none\" stroke-width=\"1\" fill=\"none\" fill-rule=\"evenodd\">"+
                  "                                            <g id=\"Icons\" transform=\"translate(-47.000000, -88.000000)\">"+
                  "                                                <g id=\"High\" transform=\"translate(47.000000, 88.000000)\">"+
                  "                                                    <g id=\"Vonerability-High\">"+
                  "                                                        <mask id=\"mask-2\" fill=\"white\">"+
                  "                                                            <use xlink:href=\"#path-1\"\/>"+
                  "                                                        <\/mask>"+
                  "                                                        <g id=\"Rectangle-10\">"+
                  "                                                            <use fill=\"#D82D49\" fill-rule=\"evenodd\""+
                  "                                                                 xlink:href=\"#path-1\"\/>"+
                  "                                                            <path stroke=\"#BB1A34\" stroke-width=\"1\""+
                  "                                                                  d=\"M1.4041953,1.44733409 L8,0.505076272 L14.6160396,1.45022478 C14.6341112,1.51124347 14.6539641,1.5795116 14.6753578,1.65465958 C14.7899552,2.05719756 14.9047222,2.50600605 15.0118679,2.98897331 C15.3098751,4.33226343 15.4915175,5.67204692 15.4997158,6.91419406 C15.4999523,6.95710967 15.4999523,6.95710967 15.5,7 C15.5,9.52090451 14.5340777,12.111589 12.9179883,14.6199787 C12.3484584,15.5039663 11.7377754,16.313821 11.1275564,17.0311249 C10.9144997,17.2815702 10.7170402,17.5022391 10.5403911,17.6908777 C10.4358029,17.8025645 10.3623853,17.8778048 10.3253512,17.9143634 C10.0291161,18.2331673 9.41484636,18.5 8.9906311,18.5 L7.0093689,18.5 C6.59080843,18.5 5.98194778,18.2258269 5.71364227,17.9146561 C5.66213668,17.8588317 5.58703389,17.7761053 5.4807125,17.6555634 C5.30200204,17.4529504 5.10247221,17.2193106 4.88735491,16.9580823 C4.27213719,16.2109907 3.656779,15.394289 3.08320773,14.5359605 C2.09721248,13.0604546 1.34127053,11.6205479 0.906388115,10.2835472 C0.639104683,9.46181216 0.5,8.69692293 0.5,8 C0.5,7.56658708 0.519280284,7.10494686 0.556403808,6.61890492 C0.63408435,5.60186781 0.786470164,4.51217341 0.991682584,3.40118912 C1.09968656,2.81647439 1.21542088,2.26333889 1.3310756,1.7595034 C1.35796875,1.64234673 1.3824953,1.53794489 1.4041953,1.44733409 Z\"\/>"+
                  "                                                        <\/g>"+
                  "                                                        <rect id=\"Rectangle-22\" fill=\"#BB1A34\" mask=\"url(#mask-2)\" x=\"8\""+
                  "                                                              y=\"0\" width=\"8\" height=\"20\"\/>"+
                  "                                                        <mask id=\"mask-4\" fill=\"white\">"+
                  "                                                            <use xlink:href=\"#path-3\"\/>"+
                  "                                                        <\/mask>"+
                  "                                                        <path stroke=\"#BB1A34\""+
                  "                                                              d=\"M1.4041953,1.44733409 L8,0.505076272 L14.6160396,1.45022478 C14.6341112,1.51124347 14.6539641,1.5795116 14.6753578,1.65465958 C14.7899552,2.05719756 14.9047222,2.50600605 15.0118679,2.98897331 C15.3098751,4.33226343 15.4915175,5.67204692 15.4997158,6.91419406 C15.4999523,6.95710967 15.4999523,6.95710967 15.5,7 C15.5,9.52090451 14.5340777,12.111589 12.9179883,14.6199787 C12.3484584,15.5039663 11.7377754,16.313821 11.1275564,17.0311249 C10.9144997,17.2815702 10.7170402,17.5022391 10.5403911,17.6908777 C10.4358029,17.8025645 10.3623853,17.8778048 10.3253512,17.9143634 C10.0291161,18.2331673 9.41484636,18.5 8.9906311,18.5 L7.0093689,18.5 C6.59080843,18.5 5.98194778,18.2258269 5.71364227,17.9146561 C5.66213668,17.8588317 5.58703389,17.7761053 5.4807125,17.6555634 C5.30200204,17.4529504 5.10247221,17.2193106 4.88735491,16.9580823 C4.27213719,16.2109907 3.656779,15.394289 3.08320773,14.5359605 C2.09721248,13.0604546 1.34127053,11.6205479 0.906388115,10.2835472 C0.639104683,9.46181216 0.5,8.69692293 0.5,8 C0.5,7.56658708 0.519280284,7.10494686 0.556403808,6.61890492 C0.63408435,5.60186781 0.786470164,4.51217341 0.991682584,3.40118912 C1.09968656,2.81647439 1.21542088,2.26333889 1.3310756,1.7595034 C1.35796875,1.64234673 1.3824953,1.53794489 1.4041953,1.44733409 Z\"\/>"+
                  "                                                        <polygon id=\"H\" fill=\"#FFFFFF\" mask=\"url(#mask-4)\""+
                  "                                                                 points=\"5 12 7 12 7 9.5 9 9.5 9 12 11 12 11 5 9 5 9 7.5 7 7.5 7 5 5 5\"\/>"+
                  "                                                    <\/g>"+
                  "                                                <\/g>"+
                  "                                            <\/g>"+
                  "                                        <\/g>"+
                  "                                    <\/svg>"+
                  "                                <\/div>"+
                  "                                <div class=\"bar-title\">High -<\/div>"+
                  "                                <div class=\"bar-count\" id=\"bar-count-high\"><\/div>"+
                  "                            <\/div>"+
                  "                        <\/li>"+
                  ""+                  
                  "                        <!--medium-->"+
                  "                        <li>"+
                  "                                <span class=\"bar-2\" id=\"bar-med\">"+
                  "                                    <div id=\"tooltip-med\"><\/div>"+
                  "                                <\/span>"+
                  "                            <div class=\"bar-title-container\">"+
                  "                                <div class=\"bar-title-icon\">"+
                  "                                    <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\""+
                  "                                         width=\"16\" height=\"20\" viewBox=\"0 0 16 20\"><title>Low<\/title>"+
                  "                                        <defs>"+
                  "                                            <path d=\"M1 1.053L8 0l7 1.053s1 3.173 1 6.315c0 6.332-5.346 11.89-5.346 11.89-.36.41-1.097.742-1.663.742H7.01c-.558 0-1.3-.34-1.652-.77 0 0-5.358-6.056-5.358-10.81 0-3.338 1-7.367 1-7.367z\""+
                  "                                                  id=\"a\"\/>"+
                  "                                            <path d=\"M1 1.053L8 0l7 1.053s1 3.173 1 6.315c0 6.332-5.346 11.89-5.346 11.89-.36.41-1.097.742-1.663.742H7.01c-.558 0-1.3-.34-1.652-.77 0 0-5.358-6.056-5.358-10.81 0-3.338 1-7.367 1-7.367z\""+
                  "                                                  id=\"c\"\/>"+
                  "                                        <\/defs>"+
                  "                                        <g fill=\"none\" fill-rule=\"evenodd\">"+
                  "                                            <mask id=\"b\" fill=\"#fff\">"+
                  "                                                <use xlink:href=\"#a\"\/>"+
                  "                                            <\/mask>"+
                  "                                            <use fill=\"#FFAC00\" xlink:href=\"#a\"\/>"+
                  "                                            <path stroke=\"#E49B16\""+
                  "                                                  d=\"M1.41 1.497L8 .507l6.61.993c.02.067.04.144.064.228.114.425.23.898.337 1.407.3 1.418.48 2.83.49 4.143v.09c0 2.665-.973 5.404-2.6 8.06-.572.934-1.186 1.79-1.8 2.55-.214.264-.413.498-.59.698-.106.118-.18.198-.217.237-.282.32-.882.587-1.302.587H7.01c-.414 0-1.01-.277-1.266-.587-.05-.06-.126-.146-.233-.274-.18-.215-.38-.463-.595-.74-.62-.79-1.237-1.653-1.814-2.56C2.12 13.79 1.363 12.28.923 10.877.644 9.994.5 9.17.5 8.42c0-.457.02-.944.057-1.457.077-1.072.23-2.22.435-3.392.11-.615.224-1.198.34-1.73l.077-.343z\"\/>"+
                  "                                            <path fill=\"#D79201\" mask=\"url(#b)\" d=\"M8 0h8v20H8z\"\/>"+
                  "                                            <mask id=\"d\" fill=\"#fff\">"+
                  "                                                <use xlink:href=\"#c\"\/>"+
                  "                                            <\/mask>"+
                  "                                            <path stroke=\"#D49100\""+
                  "                                                  d=\"M1.41 1.497L8 .507l6.61.993c.02.067.04.144.064.228.114.425.23.898.337 1.407.3 1.418.48 2.83.49 4.143v.09c0 2.665-.973 5.404-2.6 8.06-.572.934-1.186 1.79-1.8 2.55-.214.264-.413.498-.59.698-.106.118-.18.198-.217.237-.282.32-.882.587-1.302.587H7.01c-.414 0-1.01-.277-1.266-.587-.05-.06-.126-.146-.233-.274-.18-.215-.38-.463-.595-.74-.62-.79-1.237-1.653-1.814-2.56C2.12 13.79 1.363 12.28.923 10.877.644 9.994.5 9.17.5 8.42c0-.457.02-.944.057-1.457.077-1.072.23-2.22.435-3.392.11-.615.224-1.198.34-1.73l.077-.343z\"\/>"+
                  "                                            <path fill=\"#472F00\" mask=\"url(#d)\""+
                  "                                                  d=\"M4.28 12.632h1.9v-4.21l1.78 2.862H8L9.79 8.4v4.232h1.93v-7.37H9.67L8 8.117 6.33 5.263H4.28\"\/>"+
                  "                                        <\/g>"+
                  "                                    <\/svg>"+
                  "                                <\/div>"+
                  "                                <div class=\"bar-title\">Medium -<\/div>"+
                  "                                <div class=\"bar-count\" id=\"bar-count-med\"><\/div>"+
                  "                            <\/div>"+
                  "                        <\/li>"+
                  ""+
                  "                        <!--low-->"+
                  "                        <li>"+
                  "                                <span class=\"bar-3\" id=\"bar-low\">"+
                  "                                    <div id=\"tooltip-low\"><\/div>"+
                  "                                <\/span>"+
                  "                            <div class=\"bar-title-container\">"+
                  "                                <div class=\"bar-title-icon\">"+
                  "                                    <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\""+
                  "                                         width=\"16\" height=\"19\" viewBox=\"0 0 16 19\"><title>Low<\/title>"+
                  "                                        <defs>"+
                  "                                            <path d=\"M1 1l7-1 7 1s1 3.015 1 6c0 6.015-6 12-6 12H6S0 12.515 0 8c0-3.172 1-7 1-7z\""+
                  "                                                  id=\"a\"\/>"+
                  "                                            <path d=\"M1 1l7-1 7 1s1 3.015 1 6c0 6.015-6 12-6 12H6S0 12.515 0 8c0-3.172 1-7 1-7z\""+
                  "                                                  id=\"c\"\/>"+
                  "                                        <\/defs>"+
                  "                                        <g fill=\"none\" fill-rule=\"evenodd\">"+
                  "                                            <path d=\"M7.96 17.32L8 .015l-6.5 1s-.96 4.5-.96 8.75c1.272 4.602 5.968 9.25 5.968 9.25h.163l1.29-1.695z\""+
                  "                                                  fill=\"#EDEFF5\"\/>"+
                  "                                            <mask id=\"b\" fill=\"#fff\">"+
                  "                                                <use xlink:href=\"#a\"\/>"+
                  "                                            <\/mask>"+
                  "                                            <use fill=\"#FFEB3B\" xlink:href=\"#a\"\/>"+
                  "                                            <path stroke=\"#E4D200\""+
                  "                                                  d=\"M1.404 1.447L8 .505l6.616.945.06.205c.114.402.23.85.336 1.334.298 1.342.48 2.682.488 3.924V7c0 2.515-1.09 5.243-2.916 7.978-.644.966-1.335 1.863-2.026 2.667-.24.28-.465.53-.665.745-.04.04-.074.077-.105.11H6.222l-.105-.118c-.202-.23-.427-.492-.67-.785-.694-.837-1.388-1.744-2.035-2.687-.89-1.298-1.62-2.56-2.128-3.738C.772 9.982.5 8.912.5 8c0-.433.02-.895.056-1.38C.634 5.6.786 4.51.992 3.4c.108-.584.223-1.137.34-1.64.026-.118.05-.222.072-.313z\"\/>"+
                  "                                            <path fill=\"#DDCE00\" mask=\"url(#b)\" d=\"M8-8h10v32H8z\"\/>"+
                  "                                            <mask id=\"d\" fill=\"#fff\">"+
                  "                                                <use xlink:href=\"#c\"\/>"+
                  "                                            <\/mask>"+
                  "                                            <path stroke=\"#E4D200\""+
                  "                                                  d=\"M1.404 1.447L8 .505l6.616.945.06.205c.114.402.23.85.336 1.334.298 1.342.48 2.682.488 3.924V7c0 2.515-1.09 5.243-2.916 7.978-.644.966-1.335 1.863-2.026 2.667-.24.28-.465.53-.665.745-.04.04-.074.077-.105.11H6.222l-.105-.118c-.202-.23-.427-.492-.67-.785-.694-.837-1.388-1.744-2.035-2.687-.89-1.298-1.62-2.56-2.128-3.738C.772 9.982.5 8.912.5 8c0-.433.02-.895.056-1.38C.634 5.6.786 4.51.992 3.4c.108-.584.223-1.137.34-1.64.026-.118.05-.222.072-.313z\"\/>"+
                  "                                            <path fill=\"#605900\" mask=\"url(#d)\" d=\"M5.54 12h5.33v-1.7H7.48V5H5.54\"\/>"+
                  "                                        <\/g>"+
                  "                                    <\/svg>"+
                  "                                <\/div>"+
                  "                                <div class=\"bar-title\">Low -<\/div>"+
                  "                                <div class=\"bar-count\" id=\"bar-count-low\"><\/div>"+
                  "                            <\/div>"+
                  "                        <\/li>"+
                  "                    <\/ul>"+
                  "                <\/div>"+
                  "                <\/div>"+
                  "            <\/tr>"+
                  ""+

                  /* "            <div class=\"osa-summary\" id=\"osa-summary\">"+
                   "                <div class=\"summary-report-title osa\">"+
                   "                    <div class=\"summary-title-text osa\">CxOSA Vulnerabilities & Libraries<\/div>"+
                   "                    <div class=\"summary-title-links\">"+
                   "                        <a class=\"html-report\" id=\"osa-summary-html-link\">"+
                   "                            <div class=\"results-link summary-link\">"+
                   "                                <div class=\"results-link-icon link-icon\">"+
                   "                                    <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" width=\"12\" height=\"14\" viewBox=\"0 0 12 14\">"+
                   "                                        <title>analize<\/title>"+
                   "                                        <g fill=\"none\" fill-rule=\"evenodd\">"+
                   "                                            <circle stroke=\"#4A90E2\" stroke-width=\"2\" cx=\"5\" cy=\"5\" r=\"4\"\/>"+
                   "                                            <path fill=\"#4A90E2\" d=\"M6.366 8.366l1.732-1 3.268 5.66-1.732 1z\"\/>"+
                   "                                        <\/g>"+
                   "                                    <\/svg>"+
                   "                                <\/div>"+
                   "                                <div class=\"summary-link-text\">Results<\/div>"+
                   "                            <\/div>"+
                   "                        <\/a>"+
                   "                    <\/div>"+
                   "                <\/div>"+*/
                  /* "                <div class=\"osa-results\">"+
                   "                    <div class=\"osa-libraries\">"+
                   "                        <div class=\"osa-libraries-title\">Libraries:<\/div>"+
                   "                        <div class=\"libraries-vulnerable\">"+
                   "                            <div class=\"libraries-icon-number\">"+
                   "                                <div class=\"libraries-vulnerable-icon\">"+
                   "                                    <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\""+
                   "                                         height=\"31px\" version=\"1.1\" viewBox=\"0 0 47 31\" width=\"47px\">"+
                   "                                        <title>lib"+
                   "                                            Vulnerabilities Icon<\/title>"+
                   "                                        <desc>Created with Sketch.<\/desc>"+
                   "                                        <defs>"+
                   "                                            <path id=\"path-14\""+
                   "                                                  d=\"M25,31 L4,31 C1.94360167,31 0,29.0245324 0,27 L0,8 L0,3 C0,1.48550257 1.46424259,0 3,0 L9,0 C9.88514832,0 11.1635669,0.937415809 12,2 L12,4 L34,4 C36.0604107,4.42857143 38,6.41548071 38,9 L38,11\"\/>"+
                   "                                            <mask height=\"31\" maskUnits=\"objectBoundingBox\" id=\"mask-14\" width=\"38\""+
                   "                                                  maskContentUnits=\"userSpaceOnUse\" fill=\"white\" x=\"0\" y=\"0\">"+
                   "                                                <use xlink:href=\"#path-14\"\/>"+
                   "                                            <\/mask>"+
                   "                                        <\/defs>"+
                   "                                        <g stroke-width=\"1\" fill-rule=\"evenodd\" id=\"Page-1\" stroke=\"none\" fill=\"none\">"+
                   "                                            <g transform=\"translate(-518.000000, -646.000000)\" id=\"Jenkins\">"+
                   "                                                <g transform=\"translate(270.000000, 646.000000)\" id=\"OSA\">"+
                   "                                                    <g transform=\"translate(248.000000, 0.000000)\""+
                   "                                                       id=\"Lib-Vulnerabilities\">"+
                   "                                                        <g id=\"lib-Vulnerabilities-Icon\">"+
                   "                                                            <use mask=\"url(#mask-14)\" stroke-width=\"4\""+
                   "                                                                 id=\"Combined-Shape\""+
                   "                                                                 stroke=\"#362F53\" xlink:href=\"#path-14\"\/>"+
                   "                                                            <g transform=\"translate(26.600000, 14.233021)\" id=\"Alert\">"+
                   "                                                                <path id=\"Page-1\""+
                   "                                                                      d=\"M9.71486676,1.21470909 C10.3018963,0.274949219 11.2197722,0.29932009 11.7612462,1.26246584 L19.4943093,15.0176364 C20.037464,15.9837716 19.5847058,16.7669789 18.4769973,16.7669789 L2.0007805,16.7669789 C0.895779941,16.7669789 0.477014275,16.0033396 1.06291102,15.0653932 L9.71486676,1.21470909 Z\""+
                   "                                                                      fill=\"#DA2945\"\/>"+
                   "                                                                <rect height=\"5\" id=\"Rectangle-5\" width=\"2\""+
                   "                                                                      fill=\"#FFFFFF\""+
                   "                                                                      x=\"9.4\" y=\"5.76697892\"\/>"+
                   "                                                                <rect height=\"2\" id=\"Rectangle-6\" width=\"2\""+
                   "                                                                      fill=\"#FFFFFF\""+
                   "                                                                      x=\"9.4\" y=\"11.7669789\"\/>"+
                   "                                                            <\/g>"+
                   "                                                        <\/g>"+
                   "                                                    <\/g>"+
                   "                                                <\/g>"+
                   "                                            <\/g>"+
                   "                                        <\/g>"+
                   "                                    <\/svg>"+
                   "                                <\/div>"+
                   "                                <div class=\"libraries-vulnerable-number\" id=\"vulnerable-libraries\"><\/div>"+
                   "                            <\/div>"+
                   "                            <div class=\"libraries-vulnerable-text\">"+
                   "                                Vulnerable and Outdated Libraries"+
                   "                            <\/div>"+
                   "                        <\/div>"+
                   "                        <div class=\"libraries-ok\">"+
                   "                            <div class=\"libraries-icon-number\">"+
                   "                                <div class=\"libraries-ok-icon\">"+
                   "                                    <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\""+
                   "                                         height=\"31px\" version=\"1.1\" viewBox=\"0 0 47 31\" width=\"47px\">"+
                   "                                        <title>"+
                   "                                            Icon<\/title>"+
                   "                                        <desc>Created with Sketch.<\/desc>"+
                   "                                        <defs>"+
                   "                                            <path id=\"path-5\""+
                   "                                                  d=\"M28,31 L4,31 C1.99474908,31 0,29.0245324 0,27 L0,8 L0,3 C0,1.48550257 1.50277529,0 3,0 L9,0 C10.1452838,0 11.457345,0.937415809 12,2 L13,4 L35,4 C37.0093689,4.42857143 39,6.41548071 39,9 L39,11\"\/>"+
                   "                                            <mask height=\"31\" maskUnits=\"objectBoundingBox\" id=\"mask-5\" width=\"39\""+
                   "                                                  maskContentUnits=\"userSpaceOnUse\" fill=\"white\" x=\"0\" y=\"0\">"+
                   "                                                <use xlink:href=\"#path-5\"\/>"+
                   "                                            <\/mask>"+
                   "                                        <\/defs>"+
                   "                                        <g stroke-width=\"1\" fill-rule=\"evenodd\" id=\"Page-1\" stroke=\"none\" fill=\"none\">"+
                   "                                            <g transform=\"translate(-848.000000, -651.000000)\" id=\"Jenkins\">"+
                   "                                                <g transform=\"translate(270.000000, 646.000000)\" id=\"OSA\">"+
                   "                                                    <g transform=\"translate(578.000000, 5.000000)\" id=\"Lib-OK\">"+
                   "                                                        <g id=\"Icon\">"+
                   "                                                            <use mask=\"url(#mask-5)\" stroke-width=\"4\""+
                   "                                                                 id=\"Combined-Shape-Copy\""+
                   "                                                                 stroke=\"#362F53\" xlink:href=\"#path-5\"\/>"+
                   "                                                            <path id=\"Combined-Shape\""+
                   "                                                                  d=\"M46.4529784,18.9030304 C46.8068562,19.8686359 47,20.9117624 47,22 C47,26.9705627 42.9705627,31 38,31 C33.0294373,31 29,26.9705627 29,22 C29,17.0294373 33.0294373,13 38,13 C40.393622,13 42.5689975,13.934425 44.1812437,15.4583924 L37.6904269,21.8965709 L35.079173,19.3040452 L32.1948583,22.1475069 L37.6899611,27.6031981 L46.4529784,18.9030304 Z\""+
                   "                                                                  fill=\"#8EBE15\"\/>"+
                   "                                                        <\/g>"+
                   "                                                    <\/g>"+
                   "                                                <\/g>"+
                   "                                            <\/g>"+
                   "                                        <\/g>"+
                   "                                    <\/svg>"+
                   "                                <\/div>"+
                   "                                <div class=\"libraries-vulnerable-number\" id=\"ok-libraries\"><\/div>"+
                   "                            <\/div>"+
                   "                            <div class=\"libraries-ok-text\">"+
                   "                                No Known Vulnerability Libraries"+
                   "                            <\/div>"+
                   "                        <\/div>"+
                   "                    <\/div>"+
                   "                    <div class=\"osa-chart\">"+
                   "                        <div class=\"threshold-exceeded-compliance\" id=\"osa-threshold-exceeded-compliance\"><\/div>"+
                   "                        <ul class=\"osa-chart chart\">"+
                   "                            <li>"+
                   "                                    <span class=\"bar-1\" id=\"osa-bar-high\">"+
                   "                                        <div id=\"osa-tooltip-high\"><\/div>"+
                   "                                    <\/span>"+
                   "                                <div class=\"bar-title-container\">"+
                   "                                    <div class=\"bar-title-icon\">"+
                   "                                        <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\""+
                   "                                             xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\" width=\"16px\" height=\"19px\""+
                   "                                             viewBox=\"0 0 16 19\""+
                   "                                             version=\"1.1\">"+
                   "                                            <!-- Generator: Sketch 43.2 (39069) - http:\/\/www.bohemiancoding.com\/sketch -->"+
                   "                                            <title>Med<\/title>"+
                   "                                            <desc>Created with Sketch.<\/desc>"+
                   "                                            <defs>"+
                   "                                                <path d=\"M1,1 L8,0 L15,1 C15,1 16,4.01515152 16,7 C16,13.0151515 10.6766131,18.2701936 10.6766131,18.2701936 C10.30293,18.6732545 9.55664682,19 8.9906311,19 L7.0093689,19 C6.45190985,19 5.70245907,18.6673641 5.33497024,18.2411641 C5.33497024,18.2411641 3.70193273e-12,12.5151515 3.63797881e-12,8 C7.03437308e-13,4.82765152 1,1 1,1 Z\""+
                   "                                                      id=\"path-1\"\/>"+
                   "                                                <path d=\"M1,1 L8,0 L15,1 C15,1 16,4.01515152 16,7 C16,13.0151515 10.6766131,18.2701936 10.6766131,18.2701936 C10.30293,18.6732545 9.55664682,19 8.9906311,19 L7.0093689,19 C6.45190985,19 5.70245907,18.6673641 5.33497024,18.2411641 C5.33497024,18.2411641 3.70193273e-12,12.5151515 3.63797881e-12,8 C7.03437308e-13,4.82765152 1,1 1,1 Z\""+
                   "                                                      id=\"path-3\"\/>"+
                   "                                            <\/defs>"+
                   "                                            <g id=\"Page-1\" stroke=\"none\" stroke-width=\"1\" fill=\"none\""+
                   "                                               fill-rule=\"evenodd\">"+
                   "                                                <g id=\"Icons\" transform=\"translate(-47.000000, -88.000000)\">"+
                   "                                                    <g id=\"High\" transform=\"translate(47.000000, 88.000000)\">"+
                   "                                                        <g id=\"Vonerability-High\">"+
                   "                                                            <mask id=\"mask-2\" fill=\"white\">"+
                   "                                                                <use xlink:href=\"#path-1\"\/>"+
                   "                                                            <\/mask>"+
                   "                                                            <g id=\"Rectangle-10\">"+
                   "                                                                <use fill=\"#D82D49\" fill-rule=\"evenodd\""+
                   "                                                                     xlink:href=\"#path-1\"\/>"+
                   "                                                                <path stroke=\"#BB1A34\" stroke-width=\"1\""+
                   "                                                                      d=\"M1.4041953,1.44733409 L8,0.505076272 L14.6160396,1.45022478 C14.6341112,1.51124347 14.6539641,1.5795116 14.6753578,1.65465958 C14.7899552,2.05719756 14.9047222,2.50600605 15.0118679,2.98897331 C15.3098751,4.33226343 15.4915175,5.67204692 15.4997158,6.91419406 C15.4999523,6.95710967 15.4999523,6.95710967 15.5,7 C15.5,9.52090451 14.5340777,12.111589 12.9179883,14.6199787 C12.3484584,15.5039663 11.7377754,16.313821 11.1275564,17.0311249 C10.9144997,17.2815702 10.7170402,17.5022391 10.5403911,17.6908777 C10.4358029,17.8025645 10.3623853,17.8778048 10.3253512,17.9143634 C10.0291161,18.2331673 9.41484636,18.5 8.9906311,18.5 L7.0093689,18.5 C6.59080843,18.5 5.98194778,18.2258269 5.71364227,17.9146561 C5.66213668,17.8588317 5.58703389,17.7761053 5.4807125,17.6555634 C5.30200204,17.4529504 5.10247221,17.2193106 4.88735491,16.9580823 C4.27213719,16.2109907 3.656779,15.394289 3.08320773,14.5359605 C2.09721248,13.0604546 1.34127053,11.6205479 0.906388115,10.2835472 C0.639104683,9.46181216 0.5,8.69692293 0.5,8 C0.5,7.56658708 0.519280284,7.10494686 0.556403808,6.61890492 C0.63408435,5.60186781 0.786470164,4.51217341 0.991682584,3.40118912 C1.09968656,2.81647439 1.21542088,2.26333889 1.3310756,1.7595034 C1.35796875,1.64234673 1.3824953,1.53794489 1.4041953,1.44733409 Z\"\/>"+
                   "                                                            <\/g>"+
                   "                                                            <rect id=\"Rectangle-22\" fill=\"#BB1A34\" mask=\"url(#mask-2)\""+
                   "                                                                  x=\"8\" y=\"0\" width=\"8\" height=\"20\"\/>"+
                   "                                                            <mask id=\"mask-4\" fill=\"white\">"+
                   "                                                                <use xlink:href=\"#path-3\"\/>"+
                   "                                                            <\/mask>"+
                   "                                                            <path stroke=\"#BB1A34\""+
                   "                                                                  d=\"M1.4041953,1.44733409 L8,0.505076272 L14.6160396,1.45022478 C14.6341112,1.51124347 14.6539641,1.5795116 14.6753578,1.65465958 C14.7899552,2.05719756 14.9047222,2.50600605 15.0118679,2.98897331 C15.3098751,4.33226343 15.4915175,5.67204692 15.4997158,6.91419406 C15.4999523,6.95710967 15.4999523,6.95710967 15.5,7 C15.5,9.52090451 14.5340777,12.111589 12.9179883,14.6199787 C12.3484584,15.5039663 11.7377754,16.313821 11.1275564,17.0311249 C10.9144997,17.2815702 10.7170402,17.5022391 10.5403911,17.6908777 C10.4358029,17.8025645 10.3623853,17.8778048 10.3253512,17.9143634 C10.0291161,18.2331673 9.41484636,18.5 8.9906311,18.5 L7.0093689,18.5 C6.59080843,18.5 5.98194778,18.2258269 5.71364227,17.9146561 C5.66213668,17.8588317 5.58703389,17.7761053 5.4807125,17.6555634 C5.30200204,17.4529504 5.10247221,17.2193106 4.88735491,16.9580823 C4.27213719,16.2109907 3.656779,15.394289 3.08320773,14.5359605 C2.09721248,13.0604546 1.34127053,11.6205479 0.906388115,10.2835472 C0.639104683,9.46181216 0.5,8.69692293 0.5,8 C0.5,7.56658708 0.519280284,7.10494686 0.556403808,6.61890492 C0.63408435,5.60186781 0.786470164,4.51217341 0.991682584,3.40118912 C1.09968656,2.81647439 1.21542088,2.26333889 1.3310756,1.7595034 C1.35796875,1.64234673 1.3824953,1.53794489 1.4041953,1.44733409 Z\"\/>"+
                   "                                                            <polygon id=\"H\" fill=\"#FFFFFF\" mask=\"url(#mask-4)\""+
                   "                                                                     points=\"5 12 7 12 7 9.5 9 9.5 9 12 11 12 11 5 9 5 9 7.5 7 7.5 7 5 5 5\"\/>"+
                   "                                                        <\/g>"+
                   "                                                    <\/g>"+
                   "                                                <\/g>"+
                   "                                            <\/g>"+
                   "                                        <\/svg>"+
                   "                                    <\/div>"+
                   "                                    <div class=\"bar-title\">High -<\/div>"+
                   "                                    <div class=\"bar-count\" id=\"osa-bar-count-high\"><\/div>"+
                   "                                <\/div>"+
                   "                            <\/li>"+
                   ""+
                   "                            <!--osa medium-->"+
                   "                            <li>"+
                   "                                    <span class=\"bar-2\" id=\"osa-bar-med\">"+
                   "                                        <div id=\"osa-tooltip-med\"><\/div>"+
                   "                                    <\/span>"+
                   "                                <div class=\"bar-title-container\">"+
                   "                                    <div class=\"bar-title-icon\">"+
                   "                                        <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\""+
                   "                                             xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\" width=\"16\" height=\"20\""+
                   "                                             viewBox=\"0 0 16 20\"><title>"+
                   "                                            Low<\/title>"+
                   "                                            <defs>"+
                   "                                                <path d=\"M1 1.053L8 0l7 1.053s1 3.173 1 6.315c0 6.332-5.346 11.89-5.346 11.89-.36.41-1.097.742-1.663.742H7.01c-.558 0-1.3-.34-1.652-.77 0 0-5.358-6.056-5.358-10.81 0-3.338 1-7.367 1-7.367z\""+
                   "                                                      id=\"a\"\/>"+
                   "                                                <path d=\"M1 1.053L8 0l7 1.053s1 3.173 1 6.315c0 6.332-5.346 11.89-5.346 11.89-.36.41-1.097.742-1.663.742H7.01c-.558 0-1.3-.34-1.652-.77 0 0-5.358-6.056-5.358-10.81 0-3.338 1-7.367 1-7.367z\""+
                   "                                                      id=\"c\"\/>"+
                   "                                            <\/defs>"+
                   "                                            <g fill=\"none\" fill-rule=\"evenodd\">"+
                   "                                                <mask id=\"b\" fill=\"#fff\">"+
                   "                                                    <use xlink:href=\"#a\"\/>"+
                   "                                                <\/mask>"+
                   "                                                <use fill=\"#FFAC00\" xlink:href=\"#a\"\/>"+
                   "                                                <path stroke=\"#E49B16\""+
                   "                                                      d=\"M1.41 1.497L8 .507l6.61.993c.02.067.04.144.064.228.114.425.23.898.337 1.407.3 1.418.48 2.83.49 4.143v.09c0 2.665-.972 5.404-2.6 8.06-.57.934-1.185 1.79-1.8 2.55-.213.264-.412.498-.59.698-.105.118-.18.198-.216.237-.282.32-.882.587-1.302.587H7.01c-.414 0-1.01-.277-1.266-.587-.05-.06-.126-.146-.233-.274-.18-.216-.38-.464-.594-.74-.62-.79-1.237-1.654-1.814-2.56-.982-1.55-1.74-3.06-2.18-4.463C.645 9.994.5 9.17.5 8.42c0-.457.02-.944.057-1.457.077-1.072.23-2.22.435-3.392.11-.614.224-1.197.34-1.73L1.41 1.5z\"\/>"+
                   "                                                <path fill=\"#D79201\" mask=\"url(#b)\" d=\"M8 0h8v20H8z\"\/>"+
                   "                                                <mask id=\"d\" fill=\"#fff\">"+
                   "                                                    <use xlink:href=\"#c\"\/>"+
                   "                                                <\/mask>"+
                   "                                                <path stroke=\"#D49100\""+
                   "                                                      d=\"M1.41 1.497L8 .507l6.61.993c.02.067.04.144.064.228.114.425.23.898.337 1.407.3 1.418.48 2.83.49 4.143v.09c0 2.665-.972 5.404-2.6 8.06-.57.934-1.185 1.79-1.8 2.55-.213.264-.412.498-.59.698-.105.118-.18.198-.216.237-.282.32-.882.587-1.302.587H7.01c-.414 0-1.01-.277-1.266-.587-.05-.06-.126-.146-.233-.274-.18-.216-.38-.464-.594-.74-.62-.79-1.237-1.654-1.814-2.56-.982-1.55-1.74-3.06-2.18-4.463C.645 9.994.5 9.17.5 8.42c0-.457.02-.944.057-1.457.077-1.072.23-2.22.435-3.392.11-.614.224-1.197.34-1.73L1.41 1.5z\"\/>"+
                   "                                                <path fill=\"#472F00\" mask=\"url(#d)\""+
                   "                                                      d=\"M4.28 12.632h1.9v-4.21l1.78 2.862H8L9.79 8.4v4.232h1.93v-7.37H9.67L8 8.117 6.33 5.263H4.28\"\/>"+
                   "                                            <\/g>"+
                   "                                        <\/svg>"+
                   "                                    <\/div>"+
                   "                                    <div class=\"bar-title\">Medium -<\/div>"+
                   "                                    <div class=\"bar-count\" id=\"osa-bar-count-med\"><\/div>"+
                   "                                <\/div>"+
                   "                            <\/li>"+
                   ""+
                   "                            <!--osa low-->"+
                   "                            <li>"+
                   "                                    <span class=\"bar-3\" id=\"osa-bar-low\">"+
                   "                                        <div id=\"osa-tooltip-low\"><\/div>"+
                   "                                    <\/span>"+
                   "                                <div class=\"bar-title-container\">"+
                   "                                    <div class=\"bar-title-icon\">"+
                   "                                        <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\""+
                   "                                             xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\" width=\"16\" height=\"19\""+
                   "                                             viewBox=\"0 0 16 19\"><title>"+
                   "                                            Low<\/title>"+
                   "                                            <defs>"+
                   "                                                <path d=\"M1 1l7-1 7 1s1 3.015 1 6c0 6.015-6 12-6 12H6S0 12.515 0 8c0-3.172 1-7 1-7z\""+
                   "                                                      id=\"a\"\/>"+
                   "                                                <path d=\"M1 1l7-1 7 1s1 3.015 1 6c0 6.015-6 12-6 12H6S0 12.515 0 8c0-3.172 1-7 1-7z\""+
                   "                                                      id=\"c\"\/>"+
                   "                                            <\/defs>"+
                   "                                            <g fill=\"none\" fill-rule=\"evenodd\">"+
                   "                                                <path d=\"M7.96 17.32L8 .015l-6.5 1s-.96 4.5-.96 8.75c1.272 4.602 5.968 9.25 5.968 9.25h.163l1.29-1.695z\""+
                   "                                                      fill=\"#EDEFF5\"\/>"+
                   "                                                <mask id=\"b\" fill=\"#fff\">"+
                   "                                                    <use xlink:href=\"#a\"\/>"+
                   "                                                <\/mask>"+
                   "                                                <use fill=\"#FFEB3B\" xlink:href=\"#a\"\/>"+
                   "                                                <path stroke=\"#E4D200\""+
                   "                                                      d=\"M1.404 1.447L8 .505l6.616.945.06.205c.114.402.23.85.336 1.334.298 1.34.48 2.68.488 3.923V7c0 2.515-1.09 5.243-2.916 7.978-.644.966-1.335 1.863-2.026 2.667-.24.28-.465.53-.665.745-.04.04-.074.077-.105.11H6.222l-.105-.118c-.202-.23-.427-.492-.67-.785-.694-.837-1.388-1.744-2.035-2.687-.89-1.298-1.62-2.56-2.128-3.738C.772 9.982.5 8.912.5 8c0-.433.02-.895.056-1.38.078-1.02.23-2.11.436-3.22.108-.584.223-1.137.34-1.64.026-.118.05-.222.072-.313z\"\/>"+
                   "                                                <path fill=\"#DDCE00\" mask=\"url(#b)\" d=\"M8-8h10v32H8z\"\/>"+
                   "                                                <mask id=\"d\" fill=\"#fff\">"+
                   "                                                    <use xlink:href=\"#c\"\/>"+
                   "                                                <\/mask>"+
                   "                                                <path stroke=\"#E4D200\""+
                   "                                                      d=\"M1.404 1.447L8 .505l6.616.945.06.205c.114.402.23.85.336 1.334.298 1.34.48 2.68.488 3.923V7c0 2.515-1.09 5.243-2.916 7.978-.644.966-1.335 1.863-2.026 2.667-.24.28-.465.53-.665.745-.04.04-.074.077-.105.11H6.222l-.105-.118c-.202-.23-.427-.492-.67-.785-.694-.837-1.388-1.744-2.035-2.687-.89-1.298-1.62-2.56-2.128-3.738C.772 9.982.5 8.912.5 8c0-.433.02-.895.056-1.38.078-1.02.23-2.11.436-3.22.108-.584.223-1.137.34-1.64.026-.118.05-.222.072-.313z\"\/>"+
                   "                                                <path fill=\"#605900\" mask=\"url(#d)\" d=\"M5.54 12h5.33v-1.7H7.48V5H5.54\"\/>"+
                   "                                            <\/g>"+
                   "                                        <\/svg>"+
                   "                                    <\/div>"+
                   "                                    <div class=\"bar-title\">Low -<\/div>"+
                   "                                    <div class=\"bar-count\" id=\"osa-bar-count-low\"><\/div>"+
                   "                                <\/div>"+
                   "                            <\/li>"+
                   "                        <\/ul>"+
                   "                    <\/div>"+
                   "                <\/div>"+
                   "            <\/div>"+
                   "        <\/div>"+
                   ""+*/
                  ""+
                  "        <tr id=\"sast-full\" class=\"sast-full full-results-section\">"+
                  "                <hr class = separator>" +
                  "            <div class=\"summary-table-row cxsast-full\">"+
                  "<div class=\"title-column\">"+
                  "                    <div class=\"summary-title\">"+
                  "                        <div class=\"sum1\">CxSAST<\/div>"+
                  "                        <div class=\"sum1\">Full Report<\/div>"+
                  "                    <\/div>"+
                  "                    <div class=\"detailed-report\">"+
                  "                        <div class=\"sast-downloads\">"+
                  "                            <!--html-->"+
                  "                            <div class=\"report-link\">"+
                  "                                <a class=\"pdf-report\" id=\"sast-code-viewer-link\">"+
                  "                                    <div class=\"summary-title-links\">"+
                  "                                        <div class=\"results-link summary-link\">"+
                  "                                            <div class=\"results-link-icon link-icon\">"+
                  "                                                <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" width=\"12\" height=\"14\""+
                  "                                                     viewBox=\"0 0 12 14\"><title>analize<\/title>"+
                  "                                                    <g fill=\"none\" fill-rule=\"evenodd\">"+
                  "                                                        <circle stroke=\"#4A90E2\" stroke-width=\"2\" cx=\"5\" cy=\"5\" r=\"4\"\/>"+
                  "                                                        <path fill=\"#4A90E2\""+
                  "                                                              d=\"M6.366 8.366l1.732-1 3.268 5.66-1.732 1z\"\/>"+
                  "                                                    <\/g>"+
                  "                                                <\/svg>"+
                  "                                            <\/div>"+
                  "                                            <div class=\"summary-link-text\">Analyze Results<\/div>"+
                  "                                        <\/div>"+
                  "                                    <\/div>"+
                  "                                <\/a>"+
                  "                            <\/div>"+
                  "                        <\/div>"+
                  "                    <\/div>"+
                  "                <\/div>"+
                  "                <div class=\"main-column\">"+
                  "                    <div class=\"full-start-end\">"+
                  ""+
                  "                        <!--start-->"+
                  "                        <div class=\"full-start\">"+
                  "                            <div class=\"full-start-end-icon\">"+
                  "                                <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\""+
                  "                                     height=\"26px\" version=\"1.1\" viewBox=\"0 0 23 26\" width=\"23px\">"+
                  "                                    <title>"+
                  "                                        Icon<\/title>"+
                  "                                    <desc>Created with Sketch.<\/desc>"+
                  "                                    <defs>"+
                  "                                        <rect height=\"23\" rx=\"1.6\" id=\"full-start-path\" width=\"23\" x=\"0\" y=\"2\"\/>"+
                  "                                        <mask height=\"23\" maskUnits=\"objectBoundingBox\" id=\"full-start-mask\" width=\"23\""+
                  "                                              maskContentUnits=\"userSpaceOnUse\" fill=\"white\" x=\"0\""+
                  "                                              y=\"0\">"+
                  "                                            <use xlink:href=\"#full-start-path\"\/>"+
                  "                                        <\/mask>"+
                  "                                    <\/defs>"+
                  "                                    <g stroke-width=\"1\" fill-rule=\"evenodd\" id=\"Page-1\" stroke=\"none\" fill=\"none\">"+
                  "                                        <g transform=\"translate(-684.000000, -708.000000)\" id=\"Jenkins\""+
                  "                                           stroke=\"#373050\">"+
                  "                                            <g transform=\"translate(273.000000, 695.000000)\" id=\"CxSAST\">"+
                  "                                                <g transform=\"translate(411.000000, 9.000000)\" id=\"Group-2-Copy\">"+
                  "                                                    <g transform=\"translate(0.000000, 5.000000)\" id=\"Icon\">"+
                  "                                                        <use mask=\"url(#full-start-mask)\" stroke-width=\"4\""+
                  "                                                             id=\"Rectangle-22\" xlink:href=\"#full-start-path\"\/>"+
                  "                                                        <path stroke-width=\"2\" id=\"Line\" d=\"M5,0 L5,2.99971994\""+
                  "                                                              stroke-linecap=\"square\"\/>"+
                  "                                                        <path stroke-width=\"2\" id=\"Line-Copy\" d=\"M18,0 L18,2.99971994\""+
                  "                                                              stroke-linecap=\"square\"\/>"+
                  "                                                    <\/g>"+
                  "                                                <\/g>"+
                  "                                            <\/g>"+
                  "                                        <\/g>"+
                  "                                    <\/g>"+
                  "                                <\/svg>"+
                  "                            <\/div>"+
                  "                            <div class=\"full-start-end-text-date\">"+
                  "                                <div class=\"full-start-end-text\">"+
                  "                                    Start:"+
                  "                                <\/div>"+
                  "                                <div class=\"full-start-end-date\" id=\"sast-full-start-date\">"+
                  ""+
                  "                                <\/div>"+
                  "                            <\/div>"+
                  "                        <\/div>"+
                  ""+
                  "                        <!--end-->"+
                  "                        <div class=\"full-end\">"+
                  "                            <div class=\"full-start-end-icon\">"+
                  "                                <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\""+
                  "                                     height=\"26px\" version=\"1.1\" viewBox=\"0 0 23 26\" width=\"23px\">"+
                  "                                    <title>"+
                  "                                        Icon<\/title>"+
                  "                                    <desc>Created with Sketch.<\/desc>"+
                  "                                    <defs>"+
                  "                                        <rect height=\"23\" rx=\"1.6\" id=\"full-start-path\" width=\"23\" x=\"0\" y=\"2\"\/>"+
                  "                                        <mask height=\"23\" maskUnits=\"objectBoundingBox\" id=\"full-start-mask\" width=\"23\""+
                  "                                              maskContentUnits=\"userSpaceOnUse\" fill=\"white\" x=\"0\""+
                  "                                              y=\"0\">"+
                  "                                            <use xlink:href=\"#full-start-path\"\/>"+
                  "                                        <\/mask>"+
                  "                                    <\/defs>"+
                  "                                    <g stroke-width=\"1\" fill-rule=\"evenodd\" id=\"Page-1\" stroke=\"none\" fill=\"none\">"+
                  "                                        <g transform=\"translate(-684.000000, -708.000000)\" id=\"Jenkins\""+
                  "                                           stroke=\"#373050\">"+
                  "                                            <g transform=\"translate(273.000000, 695.000000)\" id=\"CxSAST\">"+
                  "                                                <g transform=\"translate(411.000000, 9.000000)\" id=\"Group-2-Copy\">"+
                  "                                                    <g transform=\"translate(0.000000, 5.000000)\" id=\"Icon\">"+
                  "                                                        <use mask=\"url(#full-start-mask)\" stroke-width=\"4\""+
                  "                                                             id=\"Rectangle-22\" xlink:href=\"#full-start-path\"\/>"+
                  "                                                        <path stroke-width=\"2\" id=\"Line\" d=\"M5,0 L5,2.99971994\""+
                  "                                                              stroke-linecap=\"square\"\/>"+
                  "                                                        <path stroke-width=\"2\" id=\"Line-Copy\" d=\"M18,0 L18,2.99971994\""+
                  "                                                              stroke-linecap=\"square\"\/>"+
                  "                                                    <\/g>"+
                  "                                                <\/g>"+
                  "                                            <\/g>"+
                  "                                        <\/g>"+
                  "                                    <\/g>"+
                  "                                <\/svg>"+
                  "                            <\/div>"+
                  "                            <div class=\"full-start-end-text-date\">"+
                  "                                <div class=\"full-start-end-text\">"+
                  "                                    End:"+
                  "                                <\/div>"+
                  "                                <div class=\"full-start-end-date\" id=\"sast-full-end-date\">"+
                  ""+
                  "                                <\/div>"+
                  "                            <\/div>"+
                  "                        <\/div>"+
                  ""+
                  "                        <!--sast files-->"+
                  "                        <div class=\"full-files\">"+
                  "                            <div class=\"full-start-end-icon files-icon\">"+
                  "                                <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\""+
                  "                                     height=\"26px\" version=\"1.1\" viewBox=\"0 0 21 26\" width=\"21px\">"+
                  "                                    <title>"+
                  "                                        file<\/title>"+
                  "                                    <desc>Created with Sketch.<\/desc>"+
                  "                                    <defs>"+
                  "                                        <path id=\"files-path\""+
                  "                                              d=\"M15.5147186,0 L1.99456145,0 C0.90234375,0 0,0.89408944 0,1.99700466 L0,24.0029953 C0,25.1050211 0.892995579,26 1.99456145,26 L19.0054385,26 C20.0976562,26 21,25.1059106 21,24.0029953 L21,5.43446766 L20.9745931,5.45987452 L15.5147186,5.55111512e-16 Z\"\/>"+
                  "                                        <mask height=\"26\" maskUnits=\"objectBoundingBox\" id=\"files-mask\" width=\"21\""+
                  "                                              maskContentUnits=\"userSpaceOnUse\" fill=\"white\" x=\"0\" y=\"0\">"+
                  "                                            <use xlink:href=\"#files-path\"\/>"+
                  "                                        <\/mask>"+
                  "                                    <\/defs>"+
                  "                                    <g stroke-width=\"1\" fill-rule=\"evenodd\" id=\"Page-1\" stroke=\"none\" fill=\"none\">"+
                  "                                        <g transform=\"translate(-847.000000, -709.000000)\" id=\"Jenkins\">"+
                  "                                            <g transform=\"translate(273.000000, 695.000000)\" id=\"CxSAST\">"+
                  "                                                <g transform=\"translate(574.000000, 9.000000)\" id=\"Group-3\">"+
                  "                                                    <g transform=\"translate(0.000000, 5.000000)\" id=\"file\">"+
                  "                                                        <use mask=\"url(#files-mask)\" stroke-width=\"4\""+
                  "                                                             id=\"Combined-Shape\" stroke=\"#373050\""+
                  "                                                             xlink:href=\"#files-path\"\/>"+
                  "                                                        <path id=\"Combined-Shape\""+
                  "                                                              d=\"M13.8888889,0 L14.7777778,0 L21,7 L21,7.5 L21,8 L13,8 L13,0 L13.8888889,0 Z\""+
                  "                                                              fill=\"#373050\"\/>"+
                  "                                                    <\/g>"+
                  "                                                <\/g>"+
                  "                                            <\/g>"+
                  "                                        <\/g>"+
                  "                                    <\/g>"+
                  "                                <\/svg>"+
                  "                            <\/div>"+
                  "                            <div class=\"full-start-end-text-date\">"+
                  "                                <div class=\"full-start-end-text\">"+
                  "                                    Files:"+
                  "                                <\/div>"+
                  "                                <div class=\"full-start-end-date\" id=\"sast-full-files\">"+
                  ""+
                  "                                <\/div>"+
                  "                            <\/div>"+
                  "                        <\/div>"+
                  ""+
                  "                        <!--sast loc-->"+
                  "                        <div class=\"full-loc\">"+
                  "                            <div class=\"full-start-end-icon loc-icon\">"+
                  "                                <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:svgjs=\"http:\/\/www.w3.org\/2000\/svg\""+
                  "                                     xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\" height=\"29\""+
                  "                                     id=\"SvgjsSvg1018\""+
                  "                                     version=\"1.1\" viewBox=\"0 0 29 29\" width=\"29\"><title>Icon<\/title>"+
                  "                                    <desc>Created with Avocode.<\/desc>"+
                  "                                    <defs id=\"SvgjsDefs1019\"\/>"+
                  "                                    <path stroke-miterlimit=\"50\" transform=\"matrix(1,0,0,1,-1012,-1365)\""+
                  "                                          stroke-width=\"2\" id=\"SvgjsPath1020\" fill-opacity=\"0\""+
                  "                                          stroke-dasharray=\"0\""+
                  "                                          d=\"M1032 1368L1039.95 1378.76L1032 1389.51 \" stroke-opacity=\"1\" fill=\"#ffffff\""+
                  "                                          stroke=\"#373050\" stroke-linecap=\"round\""+
                  "                                          stroke-linejoin=\"round\"\/>"+
                  "                                    <path stroke-miterlimit=\"50\" transform=\"matrix(1,0,0,1,-1012,-1365)\""+
                  "                                          stroke-width=\"2\" id=\"SvgjsPath1021\" fill-opacity=\"0\""+
                  "                                          stroke-dasharray=\"0\""+
                  "                                          d=\"M1020.95 1368L1013 1378.76L1020.95 1389.51 \" stroke-opacity=\"1\""+
                  "                                          fill=\"#ffffff\" stroke=\"#373050\" stroke-linecap=\"round\""+
                  "                                          stroke-linejoin=\"round\"\/>"+
                  "                                    <path stroke-miterlimit=\"50\" transform=\"matrix(1,0,0,1,-1012,-1365)\""+
                  "                                          stroke-width=\"2\" id=\"SvgjsPath1022\" fill-opacity=\"0\""+
                  "                                          stroke-dasharray=\"0\""+
                  "                                          d=\"M1028.86 1366L1022.9999999999999 1392.54 \" stroke-opacity=\"1\""+
                  "                                          fill=\"#ffffff\" stroke=\"#373050\" stroke-linecap=\"round\""+
                  "                                          stroke-linejoin=\"round\"\/>"+
                  "                                <\/svg>"+
                  "                            <\/div>"+
                  "                            <div class=\"full-start-end-text-date\">"+
                  "                                <div class=\"full-start-end-text\">"+
                  "                                    Code Lines:"+
                  "                                <\/div>"+
                  "                                <div class=\"full-start-end-date\" id=\"sast-full-loc\">"+
                  ""+
                  "                                <\/div>"+
                  "                            <\/div>"+
                  "                        <\/div>"+
                  "                    <\/div>"+
                  "                    <div id=\"sast-cve-table-critical-container\">"+
                  ""+
                  "                    <\/div>"+                  
                  "                    <div id=\"sast-cve-table-high-container\">"+
                  ""+
                  "                    <\/div>"+
                  "                    <div id=\"sast-cve-table-med-container\">"+
                  ""+
                  "                    <\/div>"+
                  "                    <div id=\"sast-cve-table-low-container\">"+
                  ""+
                  "                    <\/div>"+
                  "            <\/tr>"+
                  ""+
                  "        <\/table>"+
                  "                <\/div>"+
                  "                <hr class = separator>" +
                  "";
              /*+
               ""+
               "        <div class=\"osa-full full-results-section\">"+
               "            <div class=\"summary-table-row cxosa-full\" id=\"osa-full\">"+
               "                <div class=\"title-column\">"+
               "                    <div class=\"summary-title\">"+
               "                        <div class=\"sum1\">CxOSA<\/div>"+
               "                        <div class=\"sum1\">Full Report<\/div>"+
               "                    <\/div>"+
               "                    <div class=\"detailed-report\">"+
               "                        <div class=\"sast-downloads osa-downloads\">"+
               "                            <div class=\"report-link\">"+
               "                                <a class=\"html-report\" id=\"osa-html-link\">"+
               "                                    <div class=\"summary-title-links\">"+
               "                                        <div class=\"results-link summary-link\">"+
               "                                            <div class=\"results-link-icon link-icon\">"+
               "                                                <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" width=\"12\" height=\"14\""+
               "                                                     viewBox=\"0 0 12 14\"><title>analize<\/title>"+
               "                                                    <g fill=\"none\" fill-rule=\"evenodd\">"+
               "                                                        <circle stroke=\"#4A90E2\" stroke-width=\"2\" cx=\"5\" cy=\"5\" r=\"4\"\/>"+
               "                                                        <path fill=\"#4A90E2\""+
               "                                                              d=\"M6.366 8.366l1.732-1 3.268 5.66-1.732 1z\"\/>"+
               "                                                    <\/g>"+
               "                                                <\/svg>"+
               "                                            <\/div>"+
               "                                            <div class=\"summary-link-text\">Analyze Results<\/div>"+
               "                                        <\/div>"+
               "                                    <\/div>"+
               "                                <\/a>"+
               "                            <\/div>"+
               "                        <\/div>"+
               "                    <\/div>"+
               "                <\/div>"+
               "                <div class=\"main-column\">"+
               "                    <div class=\"full-start-end\">"+
               ""+
               "                        <!--osa start-->"+
               "                        <div class=\"full-start\">"+
               "                            <div class=\"full-start-end-icon\">"+
               "                                <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\""+
               "                                     height=\"26px\" version=\"1.1\" viewBox=\"0 0 23 26\" width=\"23px\">"+
               "                                    <title>"+
               "                                        Icon<\/title>"+
               "                                    <desc>Created with Sketch.<\/desc>"+
               "                                    <defs>"+
               "                                        <rect height=\"23\" rx=\"1.6\" id=\"full-start-path\" width=\"23\" x=\"0\" y=\"2\"\/>"+
               "                                        <mask height=\"23\" maskUnits=\"objectBoundingBox\" id=\"full-start-mask\" width=\"23\""+
               "                                              maskContentUnits=\"userSpaceOnUse\" fill=\"white\" x=\"0\""+
               "                                              y=\"0\">"+
               "                                            <use xlink:href=\"#full-start-path\"\/>"+
               "                                        <\/mask>"+
               "                                    <\/defs>"+
               "                                    <g stroke-width=\"1\" fill-rule=\"evenodd\" id=\"Page-1\" stroke=\"none\" fill=\"none\">"+
               "                                        <g transform=\"translate(-684.000000, -708.000000)\" id=\"Jenkins\""+
               "                                           stroke=\"#373050\">"+
               "                                            <g transform=\"translate(273.000000, 695.000000)\" id=\"CxSAST\">"+
               "                                                <g transform=\"translate(411.000000, 9.000000)\" id=\"Group-2-Copy\">"+
               "                                                    <g transform=\"translate(0.000000, 5.000000)\" id=\"Icon\">"+
               "                                                        <use mask=\"url(#full-start-mask)\" stroke-width=\"4\""+
               "                                                             id=\"Rectangle-22\" xlink:href=\"#full-start-path\"\/>"+
               "                                                        <path stroke-width=\"2\" id=\"Line\" d=\"M5,0 L5,2.99971994\""+
               "                                                              stroke-linecap=\"square\"\/>"+
               "                                                        <path stroke-width=\"2\" id=\"Line-Copy\" d=\"M18,0 L18,2.99971994\""+
               "                                                              stroke-linecap=\"square\"\/>"+
               "                                                    <\/g>"+
               "                                                <\/g>"+
               "                                            <\/g>"+
               "                                        <\/g>"+
               "                                    <\/g>"+
               "                                <\/svg>"+
               "                            <\/div>"+
               "                            <div class=\"full-start-end-text-date\">"+
               "                                <div class=\"full-start-end-text\">"+
               "                                    Start:"+
               "                                <\/div>"+
               "                                <div class=\"full-start-end-date\" id=\"osa-full-start-date\">"+
               ""+
               "                                <\/div>"+
               "                            <\/div>"+
               "                        <\/div>"+
               ""+
               "                        <!--osa end-->"+
               "                        <div class=\"full-end\">"+
               "                            <div class=\"full-start-end-icon\">"+
               "                                <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\""+
               "                                     height=\"26px\" version=\"1.1\" viewBox=\"0 0 23 26\" width=\"23px\">"+
               "                                    <title>"+
               "                                        Icon<\/title>"+
               "                                    <desc>Created with Sketch.<\/desc>"+
               "                                    <defs>"+
               "                                        <rect height=\"23\" rx=\"1.6\" id=\"full-start-path\" width=\"23\" x=\"0\" y=\"2\"\/>"+
               "                                        <mask height=\"23\" maskUnits=\"objectBoundingBox\" id=\"full-start-mask\" width=\"23\""+
               "                                              maskContentUnits=\"userSpaceOnUse\" fill=\"white\" x=\"0\""+
               "                                              y=\"0\">"+
               "                                            <use xlink:href=\"#full-start-path\"\/>"+
               "                                        <\/mask>"+
               "                                    <\/defs>"+
               "                                    <g stroke-width=\"1\" fill-rule=\"evenodd\" id=\"Page-1\" stroke=\"none\" fill=\"none\">"+
               "                                        <g transform=\"translate(-684.000000, -708.000000)\" id=\"Jenkins\""+
               "                                           stroke=\"#373050\">"+
               "                                            <g transform=\"translate(273.000000, 695.000000)\" id=\"CxSAST\">"+
               "                                                <g transform=\"translate(411.000000, 9.000000)\" id=\"Group-2-Copy\">"+
               "                                                    <g transform=\"translate(0.000000, 5.000000)\" id=\"Icon\">"+
               "                                                        <use mask=\"url(#full-start-mask)\" stroke-width=\"4\""+
               "                                                             id=\"Rectangle-22\" xlink:href=\"#full-start-path\"\/>"+
               "                                                        <path stroke-width=\"2\" id=\"Line\" d=\"M5,0 L5,2.99971994\""+
               "                                                              stroke-linecap=\"square\"\/>"+
               "                                                        <path stroke-width=\"2\" id=\"Line-Copy\" d=\"M18,0 L18,2.99971994\""+
               "                                                              stroke-linecap=\"square\"\/>"+
               "                                                    <\/g>"+
               "                                                <\/g>"+
               "                                            <\/g>"+
               "                                        <\/g>"+
               "                                    <\/g>"+
               "                                <\/svg>"+
               "                            <\/div>"+
               "                            <div class=\"full-start-end-text-date\">"+
               "                                <div class=\"full-start-end-text\">"+
               "                                    End:"+
               "                                <\/div>"+
               "                                <div class=\"full-start-end-date\" id=\"osa-full-end-date\">"+
               ""+
               "                                <\/div>"+
               "                            <\/div>"+
               "                        <\/div>"+
               ""+
               "                        <!--osa files-->"+
               "                        <div class=\"full-files\">"+
               "                            <div class=\"full-start-end-icon\">"+
               "                                <svg xmlns=\"http:\/\/www.w3.org\/2000\/svg\" xmlns:svgjs=\"http:\/\/svgjs.com\/svgjs\""+
               "                                     xmlns:xlink=\"http:\/\/www.w3.org\/1999\/xlink\" height=\"27\""+
               "                                     id=\"SvgjsSvg1029\""+
               "                                     version=\"1.1\" viewBox=\"0 0 32 27\" width=\"32\"><title>Combined Shape<\/title>"+
               "                                    <desc>Created with Avocode.<\/desc>"+
               "                                    <defs id=\"SvgjsDefs1030\">"+
               "                                        <clipPath id=\"SvgjsClipPath1033\">"+
               "                                            <path id=\"SvgjsPath1032\""+
               "                                                  d=\"M848 2095C848 2094.82964 848.0142 2094.6626 848.04148 2094.5C848.0142 2094.3374 848 2094.17036 848 2094V2091C848 2089.34315 849.34315 2088 851 2088H857C858.65685 2088 860.29137 2089.31116 860.65079 2090.92856L860.8888900000001 2092H877.0000000000001C878.6568500000001 2092 880.0000000000001 2093.34315 880.0000000000001 2095V2112C880.0000000000001 2113.65685 878.6568500000001 2115 877.0000000000001 2115H851.0000000000001C849.3431500000002 2115 848.0000000000001 2113.65685 848.0000000000001 2112Z \""+
               "                                                  fill=\"#ffffff\"\/>"+
               "                                        <\/clipPath>"+
               "                                    <\/defs>"+
               "                                    <path stroke-dasharray=\"0\""+
               "                                          d=\"M848 2095C848 2094.82964 848.0142 2094.6626 848.04148 2094.5C848.0142 2094.3374 848 2094.17036 848 2094V2091C848 2089.34315 849.34315 2088 851 2088H857C858.65685 2088 860.29137 2089.31116 860.65079 2090.92856L860.8888900000001 2092H877.0000000000001C878.6568500000001 2092 880.0000000000001 2093.34315 880.0000000000001 2095V2112C880.0000000000001 2113.65685 878.6568500000001 2115 877.0000000000001 2115H851.0000000000001C849.3431500000002 2115 848.0000000000001 2113.65685 848.0000000000001 2112Z \""+
               "                                          stroke-opacity=\"1\" stroke=\"#373050\" stroke-linecap=\"butt\""+
               "                                          stroke-linejoin=\"miter\" stroke-miterlimit=\"50\""+
               "                                          transform=\"matrix(1,0,0,1,-848,-2088)\""+
               "                                          stroke-width=\"4\" id=\"SvgjsPath1031\" fill-opacity=\"0\" fill=\"#ffffff\""+
               "                                          clip-path=\"url(&quot;#SvgjsClipPath1033&quot;)\"\/>"+
               "                                <\/svg>"+
               "                            <\/div>"+
               "                            <div class=\"full-start-end-text-date\">"+
               "                                <div class=\"full-start-end-text\">"+
               "                                    Libraries:"+
               "                                <\/div>"+
               "                                <div class=\"full-start-end-date\" id=\"osa-full-files\">"+
               ""+
               "                                <\/div>"+
               "                            <\/div>"+
               "                        <\/div>"+
               "                    <\/div>"+
               "                    <div id=\"osa-cve-table-high-container\">"+
               ""+
               "                    <\/div>"+
               "                    <div id=\"osa-cve-table-med-container\">"+
               ""+
               "                    <\/div>"+
               "                    <div id=\"osa-cve-table-low-container\">"+
               ""+
               "                    <\/div>"+
               "                <\/div>"+
               "            <\/div>"+
               "        <\/div>"+
               ""+
               "    <\/div>"+*/

                options.el.appendChild(div);
          }



          return function () {
		//This is to reset value of analysisDate and reload the component and other pages will keep on refreshing as expected
		if(options.component.analysisDate === 'tempAnalysisDate')
        {
			options.component.analysisDate = undefined;
    		location.reload();
		}

    // we unset the `isDisplayed` flag to ignore to Web API calls finished after the static is closed
    isDisplayed = false;
  };


});