package com.foro.alura.entities;

import java.sql.Timestamp;

import com.foro.alura.dto.SaveTopicDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "topicos")
@Entity(name = "TopicEntity")
public class TopicEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "titulo")
	private String title;

	@Column(name = "mensaje")
	private String message;

	@Column(name = "fecha_creacion")
	private Timestamp creationDate;

	@Column(name = "estatus")
	private boolean status;

	@Column(name = "autor")
	private String author;

	@Column(name = "curso")
	private String course;

	public TopicEntity() {
	}

	public TopicEntity(SaveTopicDTO topic) {
		if (!topic.getTitle().isEmpty()) {
			this.title = topic.getTitle();
		}
		if (!topic.getMessage().isEmpty()) {
			this.message = topic.getMessage();
		}
		this.creationDate = new Timestamp(System.currentTimeMillis());
		this.status = true;
		if (!topic.getAuthor().isEmpty()) {
			this.author = topic.getAuthor();
		}
		if (!topic.getCourse().isEmpty()) {
			this.course = topic.getCourse();
		}
	}

	public void updateTopicDdata(SaveTopicDTO payload) {
		if (!payload.getTitle().isEmpty()) {
			this.title = payload.getTitle();
		}
		if (!payload.getMessage().isEmpty()) {
			this.message = payload.getMessage();
		}
		if (!payload.getAuthor().isEmpty()) {
			this.author = payload.getAuthor();
		}
		if (!payload.getCourse().isEmpty()) {
			this.course = payload.getCourse();
		}
	}

	public void delete() {
		this.status = false;
	}
}