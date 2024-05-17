package org.memoscan.acme.security.jwt;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

public class GenerateToken {

    public static void main(String[] args) {
        String token =
                Jwt.issuer("https://example.com/issuer")
                        .audience("https://example.com/issuer")
                        .expiresIn(Duration.ofDays(1000000))
                        .upn("jdoe@quarkus.io")
                        .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                        .claim(Claims.birthdate.name(), "2001-07-13")
                        .sign();
        System.out.println(token);
    }
}
