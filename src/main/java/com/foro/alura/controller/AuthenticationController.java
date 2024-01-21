package com.foro.alura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.alura.dto.AuthenticateDTO;
import com.foro.alura.dto.JWTtokenDTO;
import com.foro.alura.entities.UserEntity;
import com.foro.alura.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/login")
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<JWTtokenDTO> authenticateUser(@RequestBody @Valid AuthenticateDTO payload) {
		Authentication authToken = new UsernamePasswordAuthenticationToken(payload.getUserName(),
				payload.getPassword());
		var authenticatedUser = authenticationManager.authenticate(authToken);
		var jWTtoken = tokenService.generateToken((UserEntity) authenticatedUser.getPrincipal());
		return ResponseEntity.ok(new JWTtokenDTO(jWTtoken));
	}
}