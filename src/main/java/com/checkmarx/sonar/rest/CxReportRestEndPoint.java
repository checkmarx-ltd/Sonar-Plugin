package com.checkmarx.sonar.rest;

import org.sonar.api.server.ws.Request;
import org.sonar.api.server.ws.RequestHandler;
import org.sonar.api.server.ws.Response;
import org.sonar.api.server.ws.WebService;

/**
 * Created by: zoharby.
 * Date: 12/04/2017.
 */

public class CxReportRestEndPoint implements WebService {

    //// TODO: 20/04/2017  USE CREDENTIALS FROM HANDLER

    //todo credentials property handler here
    //todo report\result properties handler here

    @Override
   public void define(Context context) {
         NewController controller = context.createController("api/hello");
         controller.setDescription("Web service example");

       /* controller.createAction("show")
                .setDescription("Entry point")
                .setInternal(true)
                .setHandler(new CxRequestHandler());*/

         // create the URL /api/hello/show
         controller.createAction("show")
                   .setDescription("Entry point")
                    .setInternal(true)
                   .setHandler(new RequestHandler() {
                 @Override
                 public void handle(Request request, Response response) {
                       // read request parameters and generates response output
                       response.newJsonWriter()
                                 .beginObject()
                                 //.prop("hello", request.mandatoryParam("key"))
                               .prop("hello", "world")
                               .endObject()
                                 .close();
                     }
              });
                 // .createParam("key").setDescription("Example key").setRequired(false);


        //should be on a different servlet - it doesn't use soap service and it's properties manager (report)
        // should be separate as well
        //TODO GET report\results (has not been established yest if json will be separated or one)

        //todo dont forget to log out
        // important to apply changes
        controller.done();
       }
}
