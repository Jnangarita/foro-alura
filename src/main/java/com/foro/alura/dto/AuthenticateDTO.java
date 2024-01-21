package com.foro.alura.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticateDTO {
	@NotBlank
	String userName;
	@NotBlank
	String password;
}