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

import com.foro.alura.dto.AuthenticationDataDTO;

@RestController
@RequestMapping("api/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

	@PostMapping
	public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationDataDTO authenticationDataDTO) {
		Authentication token = new UsernamePasswordAuthenticationToken(authenticationDataDTO.getUserName(),
				authenticationDataDTO.getPassword());
		authenticationManager.authenticate(token);
		return ResponseEntity.ok().build();
	}
}