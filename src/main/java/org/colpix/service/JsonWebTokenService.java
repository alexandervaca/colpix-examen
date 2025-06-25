package org.colpix.service;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//@Singleton
public class JsonWebTokenService {
/*
    public String generateJwt() {
        Set<String> roles = new HashSet<>(Arrays.asList("admin", "client"));

        return Jwt.issuer("colpix-jwt")
                .subject("colpix-exam")
                .groups(roles)
                .expiresAt(System.currentTimeMillis() + 3600)
                .sign();
    }*/
}