package com.foro.alura.dto;

import org.springframework.validation.FieldError;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
	String field;
	String error;

	public ErrorDTO(FieldError error) {
		this.field = error.getField();
		this.error = error.getDefaultMessage();
	}
}