package com.mariofts.jnosql.hello;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloRest {

    @Inject
    private CalculatorService calculator;

    @GET
    public String hello() {
        return "Hello World!";
    }


    @GET
    @Path("doubleOf/{number}")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer doubleOf(@PathParam("number") int number){
        return calculator.doubleOf(number);
    }
}
