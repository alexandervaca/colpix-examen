package org.colpix.repository.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;
import org.colpix.rest.json.UserDTO;

@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends PanacheEntity {

    private String name;
    private String email;
    private String role;

    public UserDTO toUser() {
        return UserDTO.builder().id(this.id).name(name).email(email).role(role).build();
    }
}
