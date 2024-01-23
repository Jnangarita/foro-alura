package com.foro.alura.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTtokenDTO {
	String jwtToken;

	public JWTtokenDTO(String jWTtoken) {
		this.jwtToken = jWTtoken;
	}
}