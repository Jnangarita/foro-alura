package com.foro.alura.dto;

import java.sql.Timestamp;

import com.foro.alura.entities.TopicEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTopicDTO {
	private String title;
	private String message;
	private Timestamp creationDate;
	private boolean status;
	private String author;
	private String course;

	public GetTopicDTO(TopicEntity topic) {
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.creationDate = topic.getCreationDate();
		this.status = topic.isStatus();
		this.author = topic.getAuthor();
		this.course = topic.getCourse();
	}
}