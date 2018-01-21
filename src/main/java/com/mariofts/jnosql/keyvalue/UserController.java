package com.mariofts.jnosql.keyvalue;


import java.util.Optional;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserController {

    @Inject
    private UserRepository users;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create (User user){
        users.save(user);
    }

    @GET
    @Path("/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("userName") String userName){
        return users.findById(userName)
                .map(user -> Response.ok(user).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
