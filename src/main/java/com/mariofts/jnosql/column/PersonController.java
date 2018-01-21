package com.mariofts.jnosql.column;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mariofts.jnosql.keyvalue.User;
import com.mariofts.jnosql.keyvalue.UserRepository;

@Path("/person")
public class PersonController {


    @Inject
    private PersonRepository people;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Person person) {
        System.out.println(person);
        people.save(person);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("od") Long id) {
        return people.findById(id)
                .map(p -> Response.ok(p).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }


}
