package com.foro.alura.entities;

import java.sql.Date;

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
@Table(name = "usuarios")
@Entity(name = "UserEntity")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre_usuario")
	private String userName;

	@Column(name = "contrasena")
	private String password;

	@Column(name = "fecha_creacion")
	private Date creationDate;

	@Column(name = "usuario_activo")
	private boolean activeUser;
}