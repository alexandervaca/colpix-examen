package org.colpix.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.colpix.repository.entity.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@ApplicationScoped
public class UserRepository {//implements PanacheRepository<UserEntity> {
/*
    public List<UserEntity> filter(String name, String email, String role) {
        StringBuilder query = new StringBuilder("1=1");
        Map<String, Object> params = new HashMap<>();

        if (name != null && !name.isEmpty()) {
            query.append(" AND LOWER(name) LIKE LOWER(CONCAT('%', :name, '%'))");
            params.put("name", name);
        }

        if (email != null && !email.isEmpty()) {
            query.append(" AND LOWER(email) LIKE LOWER(CONCAT('%', :email, '%'))");
            params.put("email", email);
        }

        if (role != null && !role.isEmpty()) {
            query.append(" AND role = :role");
            params.put("role", role);
        }

        return find(query.toString(), params).list();
    }

    public boolean deleteByIdIfExists(Long id) {
        return deleteById(id);
    }
*/
}
