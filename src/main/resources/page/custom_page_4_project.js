window.registerExtension('example/custom_page_4_project', function (options) {
 
  // let's create a flag telling if the page is still displayed
  var isDisplayed = true;
 
  // then do a Web API call to the /api/issues/search to get the number of issues
  // we pass `resolved: false` to request only unresolved issues
  // and `componentKeys: options.component.key` to request issues of the given project
  /*window.SonarRequest.getJSON('/api/hello/show', {
    resolved: false,
    componentKeys: options.component.key
  }).then(function (response) {*/
 
    // once the request is done, and the page is still displayed (not closed already)
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
 
  // return a function, which is called when the page is being closed
  return function () {
 
    // we unset the `isDisplayed` flag to ignore to Web API calls finished after the page is closed
    isDisplayed = false;
  };
});