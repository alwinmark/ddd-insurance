package ch.over.limits.united.rest;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApplication extends Application {

    @Path("/foo")
    public String hello() {
        return "Hello";
    }


}