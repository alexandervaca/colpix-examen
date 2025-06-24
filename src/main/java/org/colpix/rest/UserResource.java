package org.colpix.rest;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.colpix.rest.dto.ResponseBody;
import org.colpix.rest.dto.Status;
import org.colpix.rest.dto.UserDTO;
import org.colpix.service.UserService;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameters;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/*@Path("/users")
@Slf4j
@OpenAPIDefinition(
    info = @Info(title="Example API", version = "1.0.1", license = @License(
    name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")))*/
public class UserResource {
/*
    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Filter users by name, email, or role",
            description = "Returns a list of users filtered by optional parameters: name, email, and/or role."
    )
    @Parameters({
            @Parameter(
                    name = "name",
                    description = "Filter by name (optional)",
                    example = "jperez"
            ),
            @Parameter(
                    name = "email",
                    description = "Filter by email (optional)",
                    example = "juan.perez@example.com"
            ),
            @Parameter(
                    name = "role",
                    description = "Filter by role (optional)",
                    example = "ADMIN"
            )
    })
    public Response filter(@QueryParam("name") String name,
                           @QueryParam("email") String email,
                           @QueryParam("role") String role) {
        log.info("filter - name: {}, email: {}, role: {}", name, email, role);

        List<UserDTO> userDTOList = userService.filter(name, email, role);

        ResponseBody responseBody = ResponseBody.builder()
                .status(Status.builder()
                        .code(Response.Status.OK.getStatusCode())
                        .description(Response.Status.OK.getReasonPhrase())
                        .build())
                .data(userDTOList)
                .date(LocalDateTime.now())
                .build();

        return Response.ok(responseBody).build();

    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {
        log.info("get - Received request for user id: {}", id);

        Optional<UserDTO> userOpt = userService.findById(id);

        if (userOpt.isEmpty()) {
            log.warn("get - User not found for id: {}", id);
            return buildErrorResponse(Response.Status.NOT_FOUND, "User not found with id: " + id);
        }

        log.info("get - User found for id: {}", id);
        return buildOkResponse(userOpt.get());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Create new user")
    @RequestBody(content = @Content(
            mediaType = MediaType.APPLICATION_JSON,
            examples = @ExampleObject(
                    name = "NewUser",
                    value = "{ \"name\": \"jperez\", \"email\": \"juan.perez@example.com\", \"role\": \"ADMIN\" }"
            )
    ))
    public Response create(@Valid UserDTO userDTO) {
        log.info("create - init with user: {}", userDTO);

        var userResponse = userService.create(userDTO);

        log.info("create - end. Created user with id: {}", userResponse.getId());

        return buildOkResponse(userResponse);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update user")
    @RequestBody(content = @Content(
            mediaType = MediaType.APPLICATION_JSON,
            examples = @ExampleObject(
                    name = "UpdateUser",
                    value = "{ \"name\": \"jperez\", \"email\": \"juan.perez@example.com\", \"role\": \"CLIENT\" }"
            )
    ))
    public Response update(@PathParam("id") Long id, @Valid UserDTO dto) {
        log.info("update - init for user id: {}", id);

        Optional<UserDTO> updatedOpt = userService.update(id, dto);

        if (updatedOpt.isEmpty()) {
            log.warn("update - user not found with id: {}", id);

            return buildErrorResponse(Response.Status.NOT_FOUND, "User not found with id: " + id);
        }

        log.info("update - success for user id: {}", id);
        return buildOkResponse(updatedOpt.get());
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        log.info("delete - Received request to delete user with id: {}", id);

        boolean deleted = userService.deleteById(id);

        if (!deleted) {
            return buildErrorResponse(Response.Status.NOT_FOUND, "User not found with id: " + id);
        }

        return buildOkResponse("User with id " + id + " deleted successfully");
    }

    // Helpers
    private Response buildOkResponse(Object data) {
        return buildOkResponse(data, Response.Status.OK);
    }

    private Response buildOkResponse(Object data, Response.Status status) {
        ResponseBody body = ResponseBody.builder()
                .status(Status.builder()
                        .code(status.getStatusCode())
                        .description(status.getReasonPhrase())
                        .build())
                .data(data)
                .date(LocalDateTime.now())
                .build();

        return Response.status(status).entity(body).build();
    }

    private Response buildErrorResponse(Response.Status status, String message) {
        ResponseBody body = ResponseBody.builder()
                .status(Status.builder()
                        .code(status.getStatusCode())
                        .description(message)
                        .build())
                .date(LocalDateTime.now())
                .build();

        return Response.status(status).entity(body).build();
    }*/
}
