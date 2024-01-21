package com.foro.alura.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTtokenDTO {
	String token;

	public JWTtokenDTO(String jWTtoken) {
		this.token = jWTtoken;
	}
}