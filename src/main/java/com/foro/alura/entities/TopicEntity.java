package com.foro.alura.entities;

import java.sql.Timestamp;

import com.foro.alura.dto.SaveTopicDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "topicos")
@Entity(name = "Topicos")
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

	public TopicEntity(SaveTopicDTO topic) {
		if(!topic.getTitle().isEmpty()) {
			this.title = topic.getTitle();
		}
		if(!topic.getMessage().isEmpty()) {
			this.message = topic.getMessage();
		}
		this.creationDate = new Timestamp(System.currentTimeMillis());
		this.status = true;
		if(!topic.getAuthor().isEmpty()) {
			this.author = topic.getAuthor();
		}
		if(!topic.getCourse().isEmpty()) {
			this.course = topic.getCourse();
		}
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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