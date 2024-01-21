package com.foro.alura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.foro.alura.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	UserDetails findByUserName(String username);
}