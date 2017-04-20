window.registerExtension('checkmarx/project_configuration', function (options) {

    // let's create a flag telling if the static is still displayed
    var isDisplayed = true;

    var counter = 0;
    // then do a Web API call to the /api/issues/search to get the number of issues
    // we pass `resolved: false` to request only unresolved issues
    // and `componentKeys: options.component.key` to request issues of the given project
    window.SonarRequest.getJSON('/api/hello/show', {
        resolved: false,
        componentKeys: options.component.key
    }).then(function (response) {

        // once the request is done, and the static is still displayed (not closed already)
        if (isDisplayed) {

            var form = document.createElement('form');
            form.id = "myform";
            form.textContent = "FORMMMM";
            form.setAttribute('method',"post");
            form.setAttribute('action','submit()');
            options.el.appendChild(form);

            // let's create an `h2` tag and place the text inside
            var header = document.createElement('h2');
            header.textContent = 'The project has ' + response.hello + ' issues';

            // append just created element to the container
            options.el.appendChild(header);


            var head2 = document.createElement('h2');
            head2.id = "head2";
            head2.textContent = 'sould be replaced on test connection';
            options.el.appendChild(head2);

            var btn = document.createElement("BUTTON");// Create a <button> element
            //btn.onclick(myFunction());
            var t = document.createTextNode("Test Connection");       // Create a text node
            btn.appendChild(t);// Append the text to <button>
            btn.onclick =  function() {testConncetion()};
            options.el.appendChild(btn);// Append <button> to <body>
            
        }
    });


    function testConncetion() {

        window.SonarRequest.getJSON('/api/hello/show', {
            resolved: false,
            componentKeys: options.component.key
        }).then(function (response) {
            // once the request is done, and the static is still displayed (not closed already)
            if (isDisplayed) {

                //options.el.getElementById("myspan").textContent = "test connection was pressed";
                // let's create an `h2` tag and place the text inside
                var header = document.createElement('h2');
                header.textContent = 'The project is the ' + response.hello + ' issue';
                options.el.appendChild(header);

                counter += 1;
                document.getElementById("head2").textContent = counter.toString();
            }
        });
    }
    // return a function, which is called when the static is being closed
    return function () {

        // we unset the `isDisplayed` flag to ignore to Web API calls finished after the static is closed
        isDisplayed = false;
    };


    // let's create a flag telling if the static is still displayed
    //var isDisplayed = true;


    /*  window.SonarRequest.getJSON('/api/hello/show', {
     resolved: false,
     componentKeys: options.component.key
     }).then(function (response) {

     // once the request is done, and the static is still displayed (not closed already)
     if (isDisplayed) {

     // let's create an `h2` tag and place the text inside
     var header = document.createElement('h2');
     header.textContent = 'The project has ' + response.hello + ' issues';

     // append just created element to the container
     options.el.appendChild(header);
     }
     });*/

    // then do a Web API call to the /api/issues/search to get the number of issues
    // we pass `resolved: false` to request only unresolved issues
    // and `componentKeys: options.component.key` to request issues of the given project
    /*window.SonarRequest.getJSON('api/hello/show', {
     resolved: false,
     componentKeys: options.component.key
     }).then(function (response) {

     // once the request is done, and the static is still displayed (not closed already)
     if (isDisplayed) {

     // let's create an `h2` tag and place the text inside
     var header = document.createElement('h2');
     header.textContent = 'The hello property is :';// + response.hello +'.';

     // append just created element to the container
     options.el.appendChild(header);
     }
     });

     //return a function, which is called when the static is being closed
     return function () {

     // we unset the `isDisplayed` flag to ignore to Web API calls finished after the static is closed
     isDisplayed = false;
     };*/
    /*if (isDisplayed){
        foo(myCallback);
    }

    function foo(callback) {
    var result;

    $.ajax({
      url: 'https://localhost:9000/api/hello/show',
      type: 'GET',
      data: null,
      success:callback
    });

    return result;
    }

    function myCallback(result) {
      options.el.textContent = result;
    }


  //return a function, which is called when the static is being closed
  return function () {

    // we unset the `isDisplayed` flag to ignore to Web API calls finished after the static is closed
    isDisplayed = false;
  };*/


});