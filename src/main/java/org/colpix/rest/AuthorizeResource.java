package org.colpix.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.colpix.service.JsonWebTokenService;

@Path("/jwt")
@ApplicationScoped
public class AuthorizeResource {

    @Inject
    JsonWebTokenService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getJwt() {
        String jwt = service.generateJwt();
        return Response.ok(jwt).build();
    }
}
