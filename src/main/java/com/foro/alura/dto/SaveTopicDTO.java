package com.foro.alura.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveTopicDTO {
	@NotBlank
	private String title;
	@NotBlank
	private String message;
	@NotBlank
	private String author;
	@NotBlank
	private String course;
}