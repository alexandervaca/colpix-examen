package org.colpix.rest.dto;

import lombok.Data;

@Data
public class UserDTO {
    public String username;
    public String passwordHash;

}
