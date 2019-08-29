window.registerExtension('checkmarx/project_configuration', function (options) {

    // let's create a flag telling if the static is still displayed
    var isDisplayed = true;

    var credentials;
    var isCxConnectionSuccessful;
    var projectsIn;
    var projectListNoServerConnectionMsg = "Unable to connect to server. Make sure URL and Credentials are valid to see project list.";
    var selectedProjectInSonarDb;
    var securityRemediationEffortInSonarDb;

    var staticUrl = window.baseUrl + '/static/checkmarx';

    var js1 = document.createElement("script");
    var js2 = document.createElement("script");
    var js3 = document.createElement("script");
    var js4 = document.createElement("script");

    js1.type = "text/javascript";
    js2.type = "text/javascript";
    js3.type = "text/javascript";
    js4.type = "text/javascript";

    js1.src = getContextPath() + '/static/checkmarx/encryption/jquery-3.3.1.min.js';
    js2.src = getContextPath() + '/static/checkmarx/encryption/aes.js';
    js3.src = getContextPath() + '/static/checkmarx/encryption/pbkdf2.js';
    js4.src = getContextPath() + '/static/checkmarx/encryption/AesUtil.js'

    document.body.appendChild(js1);
    document.body.appendChild(js2);
    document.body.appendChild(js3);
    document.body.appendChild(js4);

    var configurationPage;

    var iv = "F27D5C9927726BCEFE7510B1BDD3D137";
    var salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
    var keySize = 128;
    var iterationCount = 10000;
    var passPhrase = "checkmarx.server.credentials.secured";


    if (isDisplayed) {
        loadCssFile();
        //clear page in case where the page was loaded, redirected and then redirected back
        options.el.textContent = '';

        var spanSpinner = getConnectingSpinner();
        options.el.appendChild(spanSpinner);

        getCxProjectFromSonarResponse().then(function (res1) {
            return getCxRemediationEffortFromSonarResponse(res1);
        }).then(function (res2) {
            return getCxCredentialsResponse(res2);
        }).then(function (res3) {
            return connectAndGetResponse(res3);
        }).then(function (res4) {
            return getCxProjectsFromServerResponse(res4);
        }).catch(function (err) {
            console.log(err.message);
            options.el.removeChild(spanSpinner);
            return loadUI();
        }).then(function (res5) {
            try {
                projectsIn = JSON.parse(res5.projects);
            } catch (err) {
                projectsIn = "";
            }
            cleanConnection();
            options.el.removeChild(spanSpinner);
            return loadUI();
        }).catch(function (err) {
            console.log(err.message);
            try {
                options.el.removeChild(spanSpinner);
            } catch (ignored) {
            }
            return loadUI();
        });
    }

    /*********************pre loading page************************************************/

    function loadCssFile() {
        var fileRef = document.createElement("link");
        fileRef.id = "perojectConfigCss";
        fileRef.rel = "stylesheet";
        fileRef.type = "text/css";
        fileRef.href = staticUrl + '/project_config_style.css';
        document.getElementsByTagName("head")[0].appendChild(fileRef)
    }

    function getConnectingSpinner() {
        var span = document.createElement('span');
        var h1 = document.createElement('h1');
        h1.textContent = "Connecting...";
        h1.id = "h1Connecting";
        span.appendChild(h1);
        var spinner = document.createElement('div');
        spinner.className = "spinner";
        spinner.id = "loadingSpinner";
        span.appendChild(spinner);
        return span;
    }

    /******************************************Build UI ****************************************************/

    function loadUI() {
        return new Promise(function () {
            var div = document.createElement('div');
            div.className = "configurationDiv";
            div.id = "configurationDivId";
            configurationPage = div;
            options.el.appendChild(configurationPage);
            createHeadline();
            createCredentialsForms();
            createTestConnectionButton();
            creatLineSeparator();
            createProjectOptionsForm();
            createRemediationEffort();
            createSaveButton();
        })
    }

    /*********************Headline****************************/

    function createHeadline() {
        var div = document.createElement('div');
        div.className = "header";
        var img = document.createElement('img');
        img.src = staticUrl + '/CxIcon48x48.png';
        div.appendChild(img);
        var h1 = document.createElement('h1');
        h1.textContent = "Checkmarx Configuration";
        div.appendChild(h1);
        var br = document.createElement("br");
        div.appendChild(br);
        configurationPage.appendChild(div);
    }

    /*********************Inputs*******************/

    function createCredentialsForms() {
        if (credentials != "" && credentials != null) {
            var tempCred;
            if (!credentials.includes("cxUsername")) {
                var aesUtil = new AesUtil(keySize, iterationCount);
                tempCred = aesUtil.decrypt(salt, iv, passPhrase, credentials);
                tempCred = tempCred.toString(CryptoJS.enc.Utf8);
            } else {
                tempCred = credentials;
            }

            //support domain user
            var temp = tempCred.substring(tempCred.indexOf("cxUsername") + 13);
            var usernameOrig = temp.substring(1, temp.indexOf("\","));
            var usernameTemp = "aaa";
            tempCred = tempCred.replace(usernameOrig, usernameTemp);

            // support special characters in pass
            var passToken = tempCred.substring(tempCred.indexOf("cxPassword\": \"") + "cxPassword\": \"".length, tempCred.indexOf("\"}"));
            tempCred = tempCred.replace(passToken, 'XXX');

            var credentialsJson = JSON.parse(tempCred);

            credentialsJson.cxUsername = usernameOrig
            credentialsJson.cxPassword = passToken;

            createInput('Server Url', 'text', 'serverUrl', credentialsJson.cxServerUrl);
            createInput('Username', 'text', 'username', credentialsJson.cxUsername);
            createInput('Password', 'password', 'password', "*****");
            credentialsJson.cxPassword = "*****"
        } else {
            createInput('Server Url', 'text', 'serverUrl', "");
            createInput('Username', 'text', 'username', "");
            createInput('Password', 'password', 'password', "");
        }
        createUrlDescription();
    }

    function createRemediationEffort() {
        createRemediationEffortInput("Remediation Effort (In Minutes) Per Checkmarx Vulnerability:", 'number', 'remedEffort', securityRemediationEffortInSonarDb);
    }

    function createInput(labelText, inputType, id, value) {
        var paragraph = document.createElement("p");
        paragraph.id = id + 'P';
        var label = createLabel(labelText, id);
        paragraph.appendChild(label);
        var input = createAnyInput(inputType, id, value);
        var errSpan = createErrSpan(id);
        paragraph.appendChild(input);
        paragraph.appendChild(errSpan);
        configurationPage.appendChild(paragraph);
    }

    function createRemediationEffortInput(labelText, inputType, id, value) {
        var paragraph = document.createElement("p");
        paragraph.id = id + 'P';
        var label = createLabel(labelText, id);
        paragraph.appendChild(label);
        var input = createAnyInput(inputType, id, value);
        input.min = 0;
        input.max = 180;
        var br = document.createElement("br");
        var errSpan = createErrSpan(id);
        paragraph.appendChild(input);
        paragraph.appendChild(br);
        paragraph.appendChild(errSpan);
        configurationPage.appendChild(paragraph);
    }

    function createAnyInput(inputType, id, value) {
        var input = document.createElement("INPUT");
        input.name = id;
        input.type = inputType;
        input.value = value;
        input.id = id;
        return input;
    }

    function createUrlDescription() {
        var urlParagraph = document.getElementById('serverUrlP');
        var div = document.createElement('div');
        div.className = 'cxDescription';
        div.textContent = 'Syntax: http(s)://server-name or server-ip(:port)';
        urlParagraph.appendChild(div);
    }

    /***************Test Connection**********************/

    function createTestConnectionButton() {
        var paragraph = document.createElement("p");
        paragraph.id = 'testConParagraph';
        var btn = document.createElement("BUTTON");// Create a <button> element
        btn.id = 'testConBtn';
        var t = document.createTextNode("Test Connection");       // Create a text node
        btn.appendChild(t);// Append the text to <button>
        btn.onclick = function () {
            testConnection()
        };
        var spanSpinner = createSpan(btn.id);
        var spanErr = createErrSpan(btn.id);
        var spanSuccess = createSuccessSpan(btn.id);
        paragraph.appendChild(btn);
        paragraph.appendChild(spanSpinner);
        paragraph.appendChild(spanErr);
        paragraph.appendChild(spanSuccess);
        configurationPage.appendChild(paragraph);
    }

    function testConnection() {
        clearButtonsAndProjectListMsgs();
        createSpanSpinner('testConBtn');

        try {
            var credentialsToSend = getInputCredentialsAndValidateValues();
            if (credentialsToSend != "") {
                connectWithInputCredentialsAndGetResponse(credentialsToSend)
                    .then(function (res2) {
                        return getCxProjectsFromServerResponse(res2)
                            .then(function (res3) {
                                deleteSpanSpinner('testConBtn');
                                return cleanUpAndUpdateUI(res3);
                            }).catch(function (err) {
                                console.log(err.message);
                                terminateFailedTestConnection();
                            });
                    }).catch(function (err) {
                    console.log(err.message);
                    terminateFailedTestConnection();
                });
            } else {//err msg already appears in projects form
                deleteSpanSpinner('testConBtn');
            }
        } catch (err) {
            console.log(err.message);
            terminateFailedTestConnection();
        }
    }


    function terminateFailedTestConnection() {
        try {
            projectsIn = "";
            var select = document.getElementById('projectSelect');
            select.innerHTML = createOptions();
        } catch (ignored) {
        }
        try {
            deleteSpanSpinner('testConBtn');
        } catch (ignored) {
        }
        try {
            createFailureMsg('testConBtn', 'Connection Failed');
        } catch (ignored) {
        }
    }

    function cleanUpAndUpdateUI(response) {
        try {
            projectsIn = JSON.parse(response.projects);
            if (response.isSuccessful) {
                createSuccessMsg('testConBtn', 'Connection Successful');
            } else {
                createFailureMsg('testConBtn', 'Connection Failed');
            }
        } catch (err) {
            projectsIn = "";
            createFailureMsg('testConBtn', 'Connection Failed');
        }
        return new Promise(function () {
            //Session id is no longer necessary
            cleanConnection();

            var select = document.getElementById('projectSelect');
            select.innerHTML = createOptions();
        })
    }

    function creatLineSeparator() {
        var hr = document.createElement('hr');
        hr.id = 'separator';
        configurationPage.appendChild(hr);
    }

    /**********Projects Drop Down List*******************************/

    function createProjectOptionsForm() {
        var paragraph = document.createElement("p");
        var form = document.createElement("FORM");
        form.id = 'projectForm';
        var label = createLabel('Checkmarx Project');
        form.appendChild(label);
        var select = document.createElement("SELECT");
        select.id = 'projectSelect';
        select.innerHTML = createOptions();
        form.appendChild(select);
        var errSpan = createErrSpan(form.id);
        paragraph.appendChild(form);
        paragraph.appendChild(errSpan);
        configurationPage.appendChild(paragraph);
    }

    function createOptions() {
        if (isCxConnectionSuccessful == false || projectsIn == "" || projectsIn == null) {
            return '<option value=\"">' + projectListNoServerConnectionMsg + '</option>';
        }

        var trueSelected = getAndValidateSelectedProjectToPresent();
        var options = '<option value=\"' + trueSelected[0] + '\">' + trueSelected[1] + '</option>';
        for (i = 0; i < projectsIn.length; ++i) {
            if (projectsIn[i] != trueSelected[0])
                options = options + '<option value=\"' + projectsIn[i] + '\">' + projectsIn[i] + '</option>';
        }
        return options;
    }

    //will return the project to be presented as selected the project option list
    function getAndValidateSelectedProjectToPresent() {
        var selectedProjectInUi = getSelectedProjectInUI();
        if (selectedProjectInUi != "" && projectsIn.includes(selectedProjectInUi)) {
            return [selectedProjectInUi, selectedProjectInUi];
        } else if (selectedProjectInSonarDb != "" && projectsIn.includes(selectedProjectInSonarDb)) {
            return [selectedProjectInSonarDb, selectedProjectInSonarDb];
        } else {
            return ["", "- Select -"];
        }
    }

    /********************************Save***************************/

    function createSaveButton() {
        var paragraph = document.createElement("p");
        var btn = document.createElement("BUTTON");// Create a <button> element
        btn.id = 'saveBtn';
        var t = document.createTextNode("Save");       // Create a text node
        btn.appendChild(t);// Append the text to <button>
        btn.onclick = function () {
            save()
        };
        var spanSpinner = createSpan(btn.id);
        var spanErr = createErrSpan(btn.id);
        var spanSuccess = createSuccessSpan(btn.id);
        paragraph.appendChild(btn);
        paragraph.appendChild(spanSpinner);
        paragraph.appendChild(spanErr);
        paragraph.appendChild(spanSuccess);
        configurationPage.appendChild(paragraph);
    }

    function save() {
        clearButtonsAndProjectListMsgs();
        createSpanSpinner('saveBtn');

        var credentialsToSave = getInputCredentialsAndValidateValues();
        var projectToSave = getAndValidateProjectToSave();
        var remediationEffortToSave = getAndValidateRemediationEffortSave();

        if (credentialsToSave != "" && projectToSave != "" && remediationEffortToSave != "") {
            saveCxProject(projectToSave).then(function () {
                selectedProjectInSonarDb = projectToSave;
                return saveCxCredentials(credentialsToSave);
            }).then(function () {
                securityRemediationEffortInSonarDb = remediationEffortToSave.trim();
                return saveCxRemediationEffort(remediationEffortToSave);
            }).then(function () {
                try {
                    deleteSpanSpinner('saveBtn');
                } catch (err) {
                }
                createSuccessMsg('saveBtn', 'Saved Successfully')
            }).catch(function (error) {
                try {
                    deleteSpanSpinner('saveBtn');
                } catch (err) {
                }
                var msg = "Save failed due to SonarQube error " + error.response.statusText;
                createFailureMsg('saveBtn', msg);
            });
        } else {//err msg already appears in projects form
            deleteSpanSpinner('saveBtn');
        }
    }

    /*********************Create\Delete Sub Elements*****************************************************************/

    function createLabel(labelText, id) {
        var label = document.createElement("label");
        label.textContent = labelText;
        label.id = id + 'Label';
        return label;
    }

    function createSpan(id) {
        var span = document.createElement('span');
        span.id = id + 'Span';
        return span;
    }

    function createSpanSpinner(id) {
        var spinner = document.createElement('div');
        spinner.className = "spinner";
        spinner.id = id + 'Span' + 'Spinner';
        var spanId = id + 'Span';
        var span = document.getElementById(spanId);
        span.appendChild(spinner);
    }

    function deleteSpanSpinner(id) {
        var spinnerId = id + 'Span' + 'Spinner';
        var spinner = document.getElementById(spinnerId);
        var spanId = id + 'Span';
        var span = document.getElementById(spanId);
        span.removeChild(spinner);
    }

    function createErrSpan(id) {
        var errSpan = document.createElement("span");
        errSpan.id = id + 'Err';
        return errSpan;
    }

    function createSuccessSpan(id) {
        var errSpan = document.createElement("span");
        errSpan.id = id + 'Success';
        return errSpan;
    }

    function eraseFailureMsg(id) {
        var errSpan = document.getElementById(id + 'Err');
        errSpan.textContent = "";
    }

    function createFailureMsg(id, msg) {
        var errSpan = document.getElementById(id + 'Err');
        errSpan.textContent = msg;
    }

    function eraseSuccessMsg(id) {
        var successSpan = document.getElementById(id + 'Success');
        successSpan.textContent = "";
    }

    function createSuccessMsg(id, msg) {
        var successSpan = document.getElementById(id + 'Success');
        successSpan.textContent = msg;
    }

    function clearButtonsAndProjectListMsgs() {
        try {
            //delete unnecessary spinner the user press test connection multiple times
            deleteSpanSpinner('testConBtn');
        } catch (err) {
        }
        eraseSuccessMsg('testConBtn');
        eraseFailureMsg('testConBtn');

        try {
            //delete unnecessary spinner the user press save multiple times
            deleteSpanSpinner('saveBtn');
        } catch (err) {
        }
        eraseFailureMsg('saveBtn');
        eraseSuccessMsg('saveBtn');

        eraseFailureMsg('projectForm');
    }

    /************************Validations and Retrievals*****************************************************************/

    //returns empty string if credentials are not valid
    function getInputCredentialsAndValidateValues() {
        var server = document.getElementById('serverUrl');
        var serverValue = server.value.trim();
        var isServerValid = validateUrl('serverUrl', serverValue);
        var username = document.getElementById('username');
        var usernameValue = username.value.trim();
        var isUsernameInput = validateInputHasValue('username', usernameValue);
        var password = document.getElementById('password');
        var passwordValue = password.value;
        var isPasswordInput = validateInputHasValue('password', passwordValue);
        if (isServerValid && isUsernameInput && isPasswordInput) {
            return parseCredentials(serverValue, usernameValue, passwordValue);
        } else {
            return "";
        }
    }

    function validateUrl(id, inputValue) {
        var isInput = validateInputHasValue(id, inputValue);
        if (isInput) {
            var isUrl = isURL(inputValue);
            if (isUrl) {
                return true;
            }
            var errSpan = document.getElementById(id + 'Err');
            errSpan.textContent = 'Invalid URL';
        }
        return false;
    }

    //returns empty String if there is no valid project to save
    function getAndValidateProjectToSave() {
        try {
            var projectSelect = document.getElementById('projectSelect');
            var selectedIdx = projectSelect.selectedIndex;
            var content = projectSelect.options[selectedIdx].textContent;
            if (content == projectListNoServerConnectionMsg) {
                validateInputCostumeErrMsg('projectForm', "", 'Please Connect to Checkmarx server');
                return "";
            }
        } catch (ignored) {
        }

        var selectedItem = getSelectedProjectInUI();
        var isValidProject = validateInputCostumeErrMsg('projectForm', selectedItem, 'Please choose a project from the list');
        if (isValidProject) {
            return selectedItem;
        }
        return "";
    }

    function getAndValidateRemediationEffortSave() {
        var insertedValue = document.getElementById('remedEffort').value;
        var isInputHasValue = validateInputCostumeErrMsg('remedEffort', insertedValue, 'Content must be a number between 0 to 1800');
        if (isInputHasValue) {
            var errSpan = document.getElementById('remedEffortErr');
            if (insertedValue > 1800 || insertedValue < 0) {
                errSpan.textContent = "Remediation effort must be between 0 to 1800 minutes";
                return "";
            }
            errSpan.textContent = "";
        }
        return insertedValue;
    }

    function validateInputHasValue(id, inputValue) {
        return validateInputCostumeErrMsg(id, inputValue, 'content must not be empty');
    }

    function getSelectedProjectInUI() {
        try {
            var projectSelect = document.getElementById('projectSelect');
            var selectedIdx = projectSelect.selectedIndex;
            return projectSelect.options[selectedIdx].value;
        } catch (err) {
            return "";
        }
    }

    function validateInputCostumeErrMsg(id, inputValue, msg) {
        var errSpan = document.getElementById(id + 'Err');
        if (inputValue == "") {
            errSpan.textContent = msg;
            return false;
        }
        errSpan.textContent = "";
        return true;
    }

    /****************************Helper Functions****************************************************************/

    function parseCredentials(cxServerUrl, cxUsername, cxPassword) {
        if (cxPassword == "*****") {
            return credentials;
            //var credentialsJsonTemp = JSON.parse(credentials);
            //return "{\"cxServerUrl\":\"" + cxServerUrl + "\", \"cxUsername\": \"" + cxUsername + "\", \"cxPassword\": \"" + credentialsJsonTemp.cxPassword + "\"}";
        } else {
            try {
                var aesUtil = new AesUtil(keySize, iterationCount);
                cxCredentialsTemp = "{\"cxServerUrl\":\"" + cxServerUrl + "\", \"cxUsername\": \"" + cxUsername + "\", \"cxPassword\": \"" + cxPassword + "\"}";
                cxCredentialsEncrypted = aesUtil.encrypt(salt, iv, passPhrase, cxCredentialsTemp);
                return cxCredentialsEncrypted;
            } catch (err) {
                // not encrypted
                return credentials;
            }
        }
    }

    function getContextPath() {
        let ctxPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
        if (!ctxPath || 0 === ctxPath.length || ctxPath === "/static" || ctxPath === "/project") {
            return "";
        }
        return ctxPath;
    }

    function isURL(str) {
        //test protocol
        if (!/^(f|ht)tps?:\/\//i.test(str)) {
            return false;
        }

        //test entire string form
        var pattern = new RegExp('^(https?:\\/\\/)?' + // protocol
            '((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.?)+[a-z]{2,}|' + // domain name
            '((\\d{1,3}\\.){3}\\d{1,3}))' + // OR ip (v4) address
            '(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*' + // port and path
            '(\\?[;&a-z\\d%_.~+=-]*)?' + // query string
            '(\\#[-a-z\\d_]*)?$', 'i'); // fragment locator
        return pattern.test(str);
    }

    /*************************************************REST Requests****************************************************/

    /*****************Checkmarx server***************/

    function connectAndGetResponse(response) {
        try {
            credentials = response[0].value;
        } catch (err) {
            credentials = "";
            throw new Error("Error retrieving Checkmarx credentials from SonarQube (credentials might not have been set).");
        }
        return connectToCxWithCredentials();
    }

    function connectWithInputCredentialsAndGetResponse(inserted) {
        credentials = inserted;
        return connectToCxWithCredentials();
    }

    function connectToCxWithCredentials() {
        return window.SonarRequest.postJSON('/api/checkmarx/connect', {
            resolved: false,
            component: options.component.key,
            credentials: credentials
        })
    }

    function getCxProjectsFromServerResponse(response) {
        try {
            isCxConnectionSuccessful = response.isSuccessful;
        } catch (err) {
            isCxConnectionSuccessful = 'false';
        }
        if (!isCxConnectionSuccessful) {
            throw new Error("Failed to connect to checkmarx server.")
        }
        return window.SonarRequest.postJSON('/api/checkmarx/projects', {
            resolved: false,
            key: "checkmarx.server.credentials.secured"
        })
    }

    function cleanConnection() {
        window.SonarRequest.postJSON('/api/checkmarx/clean_connection', {
            resolved: false,
            //identify current project
            component: options.component.key
        });
    }

    /***********sonar DB***************/

    function getCxProjectFromSonarResponse() {
        return getSonarSettingResponse("checkmarx.server.project_name.secured")
    }

    function getCxRemediationEffortFromSonarResponse(response) {
        try {
            selectedProjectInSonarDb = response[0].value;
        } catch (err) {
            selectedProjectInSonarDb = "";
        }
        return getCxRemediationEffortResponse()
    }

    function getCxCredentialsResponse(response) {
        try {
            securityRemediationEffortInSonarDb = response[0].value;
        } catch (err) {
            securityRemediationEffortInSonarDb = 0;
        }
        return getSonarSettingResponse("checkmarx.server.credentials.secured")
    }

    function getCxRemediationEffortResponse() {
        return getSonarSettingResponse("checkmarx.server.remediation")
    }

    function getSonarSettingResponse(key) {
        return window.SonarRequest.getJSON('/api/properties', {
            id: key,
            resource: options.component.key
        })
    }

    function saveCxProject(cxProject) {
        return window.SonarRequest.post('/api/properties', {
            id: "checkmarx.server.project_name.secured",
            value: cxProject,
            resource: options.component.key
        })
    }

    function saveCxRemediationEffort(remediation) {
        return window.SonarRequest.post('/api/properties', {
            id: "checkmarx.server.remediation",
            value: remediation,
            resource: options.component.key
        })
    }

    function saveCxCredentials(cxCredentials) {

        //if not encrypted
        if (credentials.includes("cxPassword")) {
            //cxCredentialsEncrypted = sjcl.encrypt("checkmarx.server.credentials.secured",cxCredentials) ;
            var aesUtil = new AesUtil(keySize, iterationCount);
            cxCredentialsEncrypted = aesUtil.encrypt(salt, iv, passPhrase, cxCredentials);
        } else {
            cxCredentialsEncrypted = credentials;
        }

        return window.SonarRequest.post('/api/properties', {
            id: "checkmarx.server.credentials.secured",
            value: cxCredentialsEncrypted,
            resource: options.component.key
        })
    }

    /*****************************************************************************************************************/

    //Sonar documentation says this runs when the page closes, but as of 6.3 this has no effect
    return function () {
        isDisplayed = false;
    };

});