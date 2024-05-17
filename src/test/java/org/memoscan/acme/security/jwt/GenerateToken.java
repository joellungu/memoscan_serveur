package org.memoscan.acme.security.jwt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

public class GenerateToken {

    public static void main(String[] args) {
        ////issuedAt(currentTimeInSecs).
        ////expiresAt(currentTimeInSecs + duration)
        int currentTimeInSecs = currentTimeInSecs();
        String string_date = "12-December-2032";
        long milliseconds = 0L;
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            Date d = f.parse(string_date);
            milliseconds = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //
        String token =
                Jwt.issuer("https://example.com/issuer")
                        .audience("https://example.com/issuer")
                        .issuedAt(currentTimeInSecs)
                        .expiresIn(1815940159)
                        //.expiresAt(1815940159)
                        .upn("jdoe@quarkus.io")
                        .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                        .claim(Claims.birthdate.name(), "2001-07-13")
                        .sign();
        System.out.println(token);
    }

    public static int currentTimeInSecs() {
        long currentTimeMS = System.currentTimeMillis();
        return (int) (currentTimeMS / 1000);
    }
}
