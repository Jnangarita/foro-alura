package com.foro.alura.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveTopicDTO {
	private String title;
	private String message;
	private String author;
	private String course;
}