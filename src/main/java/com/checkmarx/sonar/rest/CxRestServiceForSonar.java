package com.checkmarx.sonar.rest;

import org.sonar.api.server.ws.Request;
import org.sonar.api.server.ws.RequestHandler;
import org.sonar.api.server.ws.Response;
import org.sonar.api.server.ws.WebService;

/**
 * Created by: zoharby.
 * Date: 12/04/2017.
 */

public class CxRestServiceForSonar implements WebService {

    //todo voletile seesion id  here

    @Override
   public void define(Context context) {
         NewController controller = context.createController("api/hello");
         controller.setDescription("Web service example");

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

        // TODO: 13/04/2017 test connection

        // TODO: 13/04/2017 get projects

        // TODO: 13/04/2017 here? save config data in propreties
        // important to apply changes
        controller.done();
       }
}
