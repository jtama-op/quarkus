package io.quarkus.resteasy.reactive.server.test.duplicate;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-resteasy")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloGet() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String helloGetXML() {
        return "Hello XML";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String helloPost(String yo) {
        return "Hello RESTEasy";
    }

}
