package com.foro.alura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foro.alura.entities.TopicEntity;

public interface TopicRepository extends JpaRepository<TopicEntity, Integer> {
}