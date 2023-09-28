package com.foro.alura.dto;

import java.sql.Timestamp;

import com.foro.alura.entities.TopicEntity;

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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
}