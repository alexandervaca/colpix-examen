package org.colpix.mapper;

import io.quarkus.security.UnauthorizedException;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.colpix.rest.HelpersResponse;

@Provider
@Priority(Priorities.AUTHENTICATION)
@Slf4j
public class UnauthorizedExceptionMapper implements ExceptionMapper<UnauthorizedException> {

    @Override
    public Response toResponse(UnauthorizedException exception) {
        log.warn("No autorizado: {}", exception.toString());

        return HelpersResponse.buildErrorResponse(Response.Status.UNAUTHORIZED, "No autorizado");
    }
}