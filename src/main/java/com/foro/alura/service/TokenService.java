package com.foro.alura.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.foro.alura.entities.UserEntity;
import com.foro.alura.exception.OwnRuntimeException;

@Service
public class TokenService {
	@Value("${api.security.secret}")
	private String apiSecret;

	public String generateToken(UserEntity userEntity) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(apiSecret);
			return JWT.create().withIssuer("foro alura").withSubject(userEntity.getUsername())
					.withClaim("id", userEntity.getId()).withExpiresAt(generateTokenExpirationDate()).sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new OwnRuntimeException("Error al generar el Token");
		}
	}

	private Instant generateTokenExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
	}
}