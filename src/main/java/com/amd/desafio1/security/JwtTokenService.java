package com.amd.desafio1.security;

import com.amd.desafio1.entities.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class JwtTokenService {

    private static final String SECRET_KEY = "secretKey";
    private static final String ISSUER = "sea-api";

    public String generateToken(UserDetailsImpl usr) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        try {
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withIssuedAt(ZonedDateTime.now().toInstant())
                    .withExpiresAt(ZonedDateTime.now().plusHours(4).toInstant())
                    .withSubject(usr.getUsername())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSubjectFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            throw new JWTVerificationException("Token invalido", e);
        }
    }

}
