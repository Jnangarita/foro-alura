package com.foro.alura.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseTopicDTO {
	private Integer id;
	private String title;
	private String message;
	private Timestamp creationDate;
	private boolean status;
	private String author;
	private String course;
}