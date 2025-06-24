package org.colpix.rest.json;

import jakarta.validation.constraints.Email;
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
public class UserDTO {

    private Long id;

    @NotBlank(message="Name may not be blank")
    @NotEmpty(message="Name may not be empty")
    private String name;

    @Email(message = "Email not valid")
    private String email;

    @NotBlank(message="Role may not be blank")
    private String role;

}
