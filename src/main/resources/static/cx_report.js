window.registerExtension('checkmarx/cx_report', function (options) {
 
  // let's create a flag telling if the static is still displayed
  var isDisplayed = true;
 
  // then do a Web API call to the /api/issues/search to get the number of issues
  // we pass `resolved: false` to request only unresolved issues
  // and `componentKeys: options.component.key` to request issues of the given project
  /*window.SonarRequest.getJSON('/api/hello/show', {
    resolved: false,
    componentKeys: options.component.key
  }).then(function (response) {*/
 
    // once the request is done, and the static is still displayed (not closed already)
    if (isDisplayed) {
 
      // let's create an `h2` tag and place the text inside
   //   var header = document.createElement('h2');
     // header.textContent = 'The project has ' + response.hello + ' issues';
 
      // append just created element to the container
     // options.el.appendChild(header);
      //var div = document.innerHTML.createElement("div");
      //div.setAttribute('src',"file.html");
      //options.el.appendChild(div);
      //var d = document.createElement('div');
      //d.id = 'divident';
      //document.getElementById('divident').innerHTML = '<ol><li>html data</li></ol>';
      //options.el.appendChild(d);

      /*var link = document.createElement('link');
      link.id = 'linkdent';
      //document.getElementById('divident').innerHTML = '<ol><li>html data</li></ol>';
      link.setAttribute('rel',"import");
      link.setAttribute('type',"html");
      link.setAttribute('href',"file.html");
      link.isDisplayed = true;
      options.el.appendChild(link);*/


      var s = '<li>text</li>'; // HTML string
      var div = document.createElement('div');
      div.id = 'dividi';
      div.innerHTML = s;
      options.el.appendChild(div);


      //var form = '<form id = "formidi" method="post" action="submit()">FORMMMM</form>'

      //var form = '<div id="div-test"><div id="div-test2"></div></div>';
       var form = '<form> <select name=\"cars\"> <option value=\"volvo\">Volvo</option> <option value=\"saab\">Saab</option> <option value=\"fiat\" selected>Fiat</option> <option value=\"audi\">Audi</option> </select> <br><br> <input type=\"text\"> </form>';

      /*form.id = 'formidi';
      form.id = "myform";
      form.textContent = "FORMMMM";
      form.setAttribute('method',"post");
      form.setAttribute('action','submit()');*/

      var div2 = document.createElement('div');
      div2.id = 'dividi2';
      div2.innerHTML = form;
      options.el.appendChild(div2);

    }
  /*});*/
 
  // return a function, which is called when the static is being closed
  return function () {
 
    // we unset the `isDisplayed` flag to ignore to Web API calls finished after the static is closed
    isDisplayed = false;
  };

  /* json sast report be like :
   {"scanStart":"14/06/17 11:56","scanFinish":"14/06/17 11:57","numOfFiles":18,"numOfCodeLines":422,
   "queryDataList":[{"name":"CGI_Reflected_XSS_All_Clients","severity":2,"numberOfOccurrences":1},{"name":"Unnormalize_Input_String","severity":2,"numberOfOccurrences":2},{"name":"Blind_SQL_Injections","severity":1,"numberOfOccurrences":1},{"name":"CGI_Stored_XSS","severity":2,"numberOfOccurrences":1},{"name":"Improper_Resource_Access_Authorization","severity":1,"numberOfOccurrences":2},{"name":"SQL_Injection","severity":3,"numberOfOccurrences":1},{"name":"Parameter_Tampering","severity":2,"numberOfOccurrences":1},{"name":"Resource_Injection","severity":3,"numberOfOccurrences":1},{"name":"SSRF","severity":2,"numberOfOccurrences":1},{"name":"Connection_String_Injection","severity":3,"numberOfOccurrences":1},{"name":"Heap_Inspection","severity":2,"numberOfOccurrences":1},{"name":"Stored_XSS","severity":3,"numberOfOccurrences":1},{"name":"Information_Exposure_Through_an_Error_Message","severity":1,"numberOfOccurrences":3},{"name":"Absolute_Path_Traversal","severity":2,"numberOfOccurrences":2},{"name":"XPath_Injection","severity":3,"numberOfOccurrences":1},{"name":"Improper_Resource_Shutdown_or_Release","severity":1,"numberOfOccurrences":1}]}
   */

/*{"startAnalyzeTime":"19/01/17 11:36","endAnalyzeTime":"19/01/17 11:36","files":666,"highVulnerabilityCves":[{"id":"4027877656A88627D31B7DC856778D8EC6A44F45","cveName":"CVE-2014-0107","score":7.5,"severity":{"id":2,"name":"High"},"publishDate":"15-04-2014","url":"https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2014-0107","description":"The TransformerFactory in Apache Xalan-Java before 2.7.2 does not properly restrict access to certain properties when FEATURE_SECURE_PROCESSING is enabled, which allows remote attackers to bypass expected restrictions and load arbitrary classes or access external resources via a crafted (1) xalan:content-header, (2) xalan:entities, (3) xslt:content-header, or (4) xslt:entities property, or a Java property that is bound to the XSLT 1.0 system-property function.","recommendations":"Upgrade to version 2.7.2 or greater","sourceFileName":null,"libraryId":"FAED9EFA7874EA17F496075F692331D99D385C20","libraryName":"xalan-2.7.1.jar"},{"id":"583AF7511A1417A014E7DE543BC28B50A6B4B8FE","cveName":"CVE-2015-4852","score":7.5,"severity":{"id":2,"name":"High"},"publishDate":"18-11-2015","url":"https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2015-4852","description":"The WLS Security component in Oracle WebLogic Server 10.3.6.0, 12.1.2.0, 12.1.3.0, and 12.2.1.0 allows remote attackers to execute arbitrary commands via a crafted serialized Java object in T3 protocol traffic to TCP port 7001, related to oracle_common/modules/com.bea.core.apache.commons.collections.jar. NOTE: the scope of this CVE is limited to the WebLogic Server product.","recommendations":null,"sourceFileName":null,"libraryId":"FCC9A3C19B229A43835426681870F2DAE1E07B00","libraryName":"commons-collections-3.1.jar"},{"id":"BF608C372FF71DDBB4BBDE979E97C9AB76413EFF","cveName":"CVE-2015-6420","score":7.5,"severity":{"id":2,"name":"High"},"publishDate":"15-12-2015","url":"https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2015-6420","description":"Serialized-object interfaces in certain Cisco Collaboration and Social Media; Endpoint Clients and Client Software; Network Application, Service, and Acceleration; Network and Content Security Devices; Network Management and Provisioning; Routing and Switching - Enterprise and Service Provider; Unified Computing; Voice and Unified Communications Devices; Video, Streaming, TelePresence, and Transcoding Devices; Wireless; and Cisco Hosted Services products allow remote attackers to execute arbitrary commands via a crafted serialized Java object, related to the Apache Commons Collections (ACC) library.","recommendations":null,"sourceFileName":null,"libraryId":"FCC9A3C19B229A43835426681870F2DAE1E07B00","libraryName":"commons-collections-3.1.jar"},{"id":"5B3A42D27CAB6C4DB8E8232E103FF28FC8DDF93F","cveName":"CVE-2015-7501","score":7.3,"severity":{"id":2,"name":"High"},"publishDate":"09-11-2015","url":"https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2015-7501","description":"It was found that the Apache commons-collections library permitted code execution when deserializing objects involving a specially constructed chain of classes. A remote attacker could use this flaw to execute arbitrary code with the permissions of the application using the commons-collections library.","recommendations":"Upgrade to version apache-commons-collections 4.1, apache-commons-collections 3.2.2 or greater","sourceFileName":null,"libraryId":"FCC9A3C19B229A43835426681870F2DAE1E07B00","libraryName":"commons-collections-3.1.jar"}],"mediumVulnerabilityCves":[{"id":"EEF32F7918195859F364573A94A2DED56C56C6AD","cveName":"CVE-2015-7577","score":5.0,"severity":{"id":1,"name":"Medium"},"publishDate":"15-02-2016","url":"https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2015-7577","description":"activerecord/lib/active_record/nested_attributes.rb in Active Record in Ruby on Rails 3.1.x and 3.2.x before 3.2.22.1, 4.0.x and 4.1.x before 4.1.14.1, 4.2.x before 4.2.5.1, and 5.x before 5.0.0.beta1.1 does not properly implement a certain destroy option, which allows remote attackers to bypass intended change restrictions by leveraging use of the nested attributes feature.","recommendations":null,"sourceFileName":null,"libraryId":"DE0CFFDBF862F2BCB53FC761AE1B087280D35B37","libraryName":"activerecord-4.1.7.gem"}],"lowVulnerabilityCves":[{"id":"E9EA3D04B57F59D10A193892E156A63725C320E3","cveName":"CVE-2013-2217","score":1.2,"severity":{"id":0,"name":"Low"},"publishDate":"23-09-2013","url":"https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2013-2217","description":"cache.py in Suds 0.4, when tempdir is set to None, allows local users to redirect SOAP queries and possibly have other unspecified impact via a symlink attack on a cache file with a predictable name in /tmp/suds/.","recommendations":null,"sourceFileName":null,"libraryId":"1699533BB06189B7154CE004DB2629D13707BEF1","libraryName":"suds-0.4-py2.6.egg"}]}*/

});