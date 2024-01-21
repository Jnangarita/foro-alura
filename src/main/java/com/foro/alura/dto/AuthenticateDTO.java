package com.foro.alura.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticateDTO {
	String userName;
	String password;
}