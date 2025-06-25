package org.colpix.rest;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.colpix.repository.UserRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Set;

@Path("/auth")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class AuthResourceV2 {

    public static final String ROLES = "user";
    @Inject
    UserRepository userRepository;

    @Inject
    @ConfigProperty(name = "jwt.duration", defaultValue = "300")
    Long jwtDuration;

    @Inject
    @ConfigProperty(name = "mp.jwt.verify.issuer", defaultValue = "auth-server")
    String jwtIssuer;

    @POST
    @Path("/login")
    @PermitAll
    public Uni<Response> login(Credentials credentials) {
        log.info("Login attempt: {}", credentials.username);

        return userRepository.findByUsername(credentials.username)
                .onItem().transform(optUser -> {
                    if (optUser.isEmpty() || !BCrypt.checkpw(credentials.password, optUser.get().passwordHash)) {
                        return Response.status(Response.Status.UNAUTHORIZED).build();
                    }

                    String jwt = generateToken(optUser.get().username);
                    return Response.ok(new TokenResponse(jwt)).build();
                });
    }

    private String generateToken(String username) {
        long now = System.currentTimeMillis();
        return Jwt.issuer(jwtIssuer)
                .subject(username)
                .groups(Set.of(ROLES))
                .expiresAt(now + jwtDuration)
                .sign();
    }

    public static class Credentials {
        public String username;
        public String password;
    }

    public static class TokenResponse {
        public String token;
        public TokenResponse(String token) {
            this.token = token;
        }
    }
}
