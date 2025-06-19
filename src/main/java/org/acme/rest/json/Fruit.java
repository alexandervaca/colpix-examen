package org.acme.rest.json;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fruit {

    private Long id;

    @NotBlank(message="Name may not be blank")
    @NotEmpty(message="Name may not be empty")
    private String name;

    @NotBlank(message="Description may not be blank")
    private String description;

}
