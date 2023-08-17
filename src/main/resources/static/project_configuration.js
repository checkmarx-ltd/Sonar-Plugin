window.registerExtension('checkmarx/project_configuration', function (options) {

    // let's create a flag telling if the static is still displayed
    var isDisplayed = true;

    var isCxConnectionSuccessful;
    var projectsIn;
    var projectListNoServerConnectionMsg = "Unable to connect to server. Make sure URL and Credentials are valid to see project list.";
    var selectedProjectInSonarDb;
    var securityRemediationEffortInSonarDb;

    var cxCredentials = {
        cxServerUrl: null,
        cxUsername: null,
        cxPassword: null    // Becomes non-null only if the user updates the password input.
    };

    var SettingKeys = {
        ServerUrl: 'checkmarx.server.url.secured',
        Username: 'checkmarx.server.username.secured',
        ProjectName: 'checkmarx.server.project_name',
        RemediationEffort: 'checkmarx.server.remediation'
    }

    var ElementIds = {
        PasswordInput: 'password'
    };

    var staticUrl = getContextPath() + '/static/checkmarx';

    var script = document.createElement("script");
    script.type = "text/javascript";
    script.src = staticUrl + '/jquery-3.5.1.min.js';
    // Perform the rest of the init process after jQuery loads.
    script.onload = init;
    document.body.appendChild(script);

    var fstdropdown_script = document.createElement("script");
    fstdropdown_script.type = "text/javascript";
    fstdropdown_script.src = staticUrl + '/fstdropdown.min.js';
    document.body.appendChild(fstdropdown_script);

    var configurationPage;


    /*********************pre loading page************************************************/

    function init() {
        if (isDisplayed) {
            loadCssFile();

            //clear page in case where the page was loaded, redirected and then redirected back
            options.el.textContent = '';

            var spanSpinner = getConnectingSpinner();
            options.el.appendChild(spanSpinner);

            getCxProjectFromSonarResponse()
                .then(getRemediationEffort)
                .then(getCredentials)
                .then(connectToCxWithCredentials)
                .then(getCxProjectsFromServerResponse)
                .catch(function (err) {
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
    }

    function loadCssFile() {
        var fileRef = document.createElement("link");
        fileRef.id = "perojectConfigCss";
        fileRef.rel = "stylesheet";
        fileRef.type = "text/css";
        fileRef.href = staticUrl + '/project_config_style.css';
        document.getElementsByTagName("head")[0].appendChild(fileRef);

        var fstdropdown_css =  document.createElement("link");
        fstdropdown_css.id = "fstdropdownCss";
        fstdropdown_css.rel = "stylesheet";
        fstdropdown_css.type = "text/css";
        fstdropdown_css.href = staticUrl + '/fstdropdown.min.css';
        document.getElementsByTagName("head")[0].appendChild(fstdropdown_css);
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
        createInput('Server Url', 'text', 'serverUrl', cxCredentials.cxServerUrl);
        createInput('Username', 'text', 'username', cxCredentials.cxUsername);
        createPasswordInput();
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

    function createPasswordInput() {
        // The password is never sent from server to client.
        // The password is sometimes sent from client to server: in case the user wants to test
        // connection with a new password or to save the new password.
        createInput('Password', 'password', ElementIds.PasswordInput, '');
        var passwordInput = $('#' + ElementIds.PasswordInput);

        // If we have a saved username, assume that we have a saved password as well.
        var hasSavedPassword = !!cxCredentials.cxUsername;
        if (hasSavedPassword) {
            passwordInput
                .prop('placeholder', '<click to change>')
                .keydown(function () {
                    $(this).data('isDirty', true)
                        .prop('placeholder', '');
                });
        } else {
            // No saved password: this may happen e.g. right after the plugin installation.
            // Make sure an empty password won't pass validation.
            passwordInput.data('isDirty', true)
        }
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
            var credentials = getValidatedCredentials();
            if (credentials != "") {
                connectWithInputCredentialsAndGetResponse(credentials)
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
            setFstDropdown();
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
            setFstDropdown();
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
        var className = "fstdropdown-select";
        if (!select.classList.contains(className)) {
            select.classList.add(className);
        }
        select.innerHTML = createOptions();
        setFstDropdown();
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

        var connnectionConfig = getValidatedCredentials();
        var projectToSave = getAndValidateProjectToSave();
        var remediationEffortToSave = getAndValidateRemediationEffortSave();

        if (connnectionConfig != "" && projectToSave != "" && remediationEffortToSave != "") {
            saveCxProject(projectToSave).then(function () {
                selectedProjectInSonarDb = projectToSave;
                return saveCredentials(connnectionConfig);
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
    function getValidatedCredentials() {
        var server = document.getElementById('serverUrl');
        var serverValue = server.value.trim();
        var isServerValid = validateUrl('serverUrl', serverValue);

        var username = document.getElementById('username');
        var usernameValue = username.value.trim();
        var isUsernameValid = validateInputHasValue('username', usernameValue);

        var password = $('#' + ElementIds.PasswordInput);
        var passwordToSend = null;
        var isPasswordValid = true;
        if (password.data('isDirty')) {
            // Only validate the password if user has entered something into the input.
            passwordToSend = password.val();
            isPasswordValid = validateInputHasValue(ElementIds.PasswordInput, passwordToSend);
        }

        if (isServerValid && isUsernameValid && isPasswordValid) {
            return {
                cxServerUrl: serverValue,
                cxUsername: usernameValue,
                cxPassword: passwordToSend
            }
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

    function getContextPath() {
        let ctxPath = encodeURI(window.location.pathname.substring(0, window.location.pathname.indexOf("/", window.location.pathname.lastIndexOf("project/admin") - 1)));
        if (!ctxPath || 0 === ctxPath.length || ctxPath === "/static" || ctxPath === "/project") {
            return "";
        }
        return ctxPath;
    }

    /*************************************************REST Requests****************************************************/

    /*****************Checkmarx server***************/

    function connectWithInputCredentialsAndGetResponse(inserted) {
        cxCredentials = inserted;
        return connectToCxWithCredentials();
    }

    function connectToCxWithCredentials() {
        return window.SonarRequest.postJSON('/api/checkmarx/connect', {
            component: options.component.key,
            credentials: JSON.stringify(cxCredentials)
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
            resolved: false
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
        return getSonarSettingResponse(SettingKeys.ProjectName)
            .then(function (response) {
                selectedProjectInSonarDb = getSettingValue(response, '');
            });
    }

    function getRemediationEffort() {
        return getSonarSettingResponse(SettingKeys.RemediationEffort)
            .then(function (response) {
                securityRemediationEffortInSonarDb = getSettingValue(response, 0);
            });
    }

    function getSonarSettingResponse(key) {
        return window.SonarRequest.getJSON('/api/settings/values', {
            component: options.component.key,
            keys: key
        })
    }

    function saveCxProject(cxProject) {
        return updateSonarSetting(SettingKeys.ProjectName, cxProject);
    }

    function saveCxRemediationEffort(remediation) {
        return updateSonarSetting(SettingKeys.RemediationEffort, remediation);
    }

    function getCredentials() {
        return window.SonarRequest.getJSON('/api/checkmarx/credentials', {
            component: options.component.key
        })
            .then(function (response) {
                cxCredentials.cxServerUrl = response.cxServerUrl || '';
                cxCredentials.cxUsername = response.cxUsername || '';
            });
    }

    function saveCredentials(credentials) {
        return window.SonarRequest.postJSON('/api/checkmarx/update_credentials', {
            component: options.component.key,
            credentials: JSON.stringify(credentials)
        });
    }

    function updateSonarSetting(id, newValue) {
        return window.SonarRequest.post('/api/settings/set', {
            key: id,
            value: newValue,
            component: options.component.key
        });
    }

    function getSettingValue(response, defaultValue) {
        var result;
        try {
            result = response.settings[0].value;
        } catch (err) {
            result = defaultValue;
        }
        return result;
    }

    /*****************************************************************************************************************/

    //Sonar documentation says this runs when the page closes, but as of 6.3 this has no effect
    return function () {
        isDisplayed = false;
    };

});