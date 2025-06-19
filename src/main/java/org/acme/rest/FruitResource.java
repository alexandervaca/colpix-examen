package org.acme.rest;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.acme.rest.json.Fruit;
import org.acme.rest.json.ResponseBody;
import org.acme.rest.json.Status;
import org.acme.service.FruitService;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Path("/fruits")
@Slf4j
@OpenAPIDefinition(
    info = @Info(title="Example API", version = "1.0.1", license = @License(
    name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")))
public class FruitResource {

    @Inject
    FruitService fruitService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        List<Fruit> fruitList = fruitService.findAll();
        return Response.ok(fruitList).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response list(@PathParam("name") String name) {
        List<Fruit> fruitList = fruitService.findByName(name);

        ResponseBody responseBody = ResponseBody.builder()
                .status(Status.builder()
                        .code(Response.Status.OK.getStatusCode())
                        .description(Response.Status.OK.getReasonPhrase())
                        .build())
                .data(fruitList)
                .date(LocalDateTime.now())
                .build();

        return Response.ok(responseBody).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {
        var fruit = fruitService.findAll().stream().filter(
            existingFruit -> Objects.equals(existingFruit.getId(), id));

        ResponseBody responseBody = ResponseBody.builder()
                .status(Status.builder()
                        .code(Response.Status.OK.getStatusCode())
                        .description(Response.Status.OK.getReasonPhrase())
                        .build())
                .data(fruit)
                .date(LocalDateTime.now())
                .build();

        return Response.ok(responseBody).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid Fruit fruit) {

        log.info("create - init");

        fruitService.create(fruit);

        ResponseBody responseBody = ResponseBody.builder()
                .status(Status.builder()
                        .code(Response.Status.OK.getStatusCode())
                        .description(Response.Status.OK.getReasonPhrase())
                        .build())
                .data(fruit)
                .date(LocalDateTime.now())
                .build();

        log.info("create - end");

        return Response.ok(responseBody).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        var fruits = fruitService.findAll().removeIf(existingFruit -> existingFruit.getId().equals(id));
        return Response.ok(fruits).build();
    }

}
