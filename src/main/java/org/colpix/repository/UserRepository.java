package org.colpix.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.Tuple;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.colpix.repository.entity.UserEntity;
import org.colpix.rest.dto.UserDTO;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {

    public Uni<Optional<UserEntity>> findByUsernameReactive(String username) {
        return find("username", username).firstResult()
                .map(user -> Optional.ofNullable((UserEntity) user));
    }

    @Inject
    PgPool client;

    public Uni<Optional<UserDTO>> findByUsername(String username) {
        return client.preparedQuery("SELECT username, password FROM users WHERE username = $1")
                .execute(Tuple.of(username))
                .onItem().transform(pgRowSet -> {
                    if (!pgRowSet.iterator().hasNext()) return Optional.empty();
                    Row row = pgRowSet.iterator().next();
                    UserDTO user = new UserDTO();
                    user.username = row.getString("username");
                    user.passwordHash = row.getString("password");
                    return Optional.of(user);
                });
    }
}
