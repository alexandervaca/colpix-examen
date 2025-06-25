package org.colpix.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class TokenResponse {

    private String token;
    private Instant issuedAt;
    private Instant expiresAt;

}
