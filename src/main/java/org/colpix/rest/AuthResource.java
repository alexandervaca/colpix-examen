package org.colpix.rest;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.colpix.repository.UserRepository;
import org.colpix.repository.entity.UserEntity;
import org.colpix.rest.dto.LoginRequest;
import org.colpix.rest.dto.TokenResponse;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Set;

/*@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j*/
public class AuthResource {
/*
    @Inject
    UserRepository userRepository;

    @Inject
    @ConfigProperty(name = "jwt.duration", defaultValue = "300")
    Long duration;

    @Inject
    @ConfigProperty(name = "jwt.issuer", defaultValue = "colpix-api")
    String jwtIssuer;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> login(LoginRequest request) {
        log.info("Login attempt: {}", request.getUsername());

        return userRepository.findByUsernameReactive(request.getUsername())
                .onItem().transformToUni(userOpt -> processLogin(request, userOpt))
                .onFailure().invoke(e -> log.error("login - Error: {}", e.getMessage(), e))
                .onFailure().recoverWithItem(
                        Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                                .entity("Internal server error").build()
                );
    }

    private Uni<Response> processLogin(LoginRequest request, Optional<UserEntity> userOpt) {
        if (userOpt.isEmpty() || !userOpt.get().getPassword().equals(request.getPassword())) {
            log.warn("Invalid login for user: {}", request.getUsername());
            return Uni.createFrom().item(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity("Invalid username or password")
                            .build()
            );
        }

        Instant now = Instant.now();
        Instant expiresAt = now.plus(duration, ChronoUnit.SECONDS);

        // Generación del JWT
        String token = Jwt.issuer(jwtIssuer) // Usamos el emisor configurable
                .subject(userOpt.get().getUsername()) // El sujeto del token es el nombre de usuario
                .groups(Set.of("user")) // Roles/grupos del usuario. Esto deberia venir de la BDD.
                .issuedAt(now) // Tiempo de emision
                .expiresAt(expiresAt) // Tiempo de expiracion
                .jws()
                .sign(); // Firma el token

        return Uni.createFrom().item(Response.ok(new TokenResponse(token, expiresAt.getEpochSecond())).build());
    }*/
}
