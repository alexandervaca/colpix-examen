package org.acme.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "fruit")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FruitEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
}
