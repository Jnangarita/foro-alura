package com.foro.alura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.alura.dto.SaveTopicDTO;
import com.foro.alura.entities.TopicEntity;
import com.foro.alura.repositories.TopicRepository;

@RestController
@RequestMapping("api/topicos")
public class TopicosController {
	@Autowired
	TopicRepository topicRepository;

	@PostMapping
	public void registerNewTopic(@RequestBody SaveTopicDTO topic) {
		topicRepository.save(new TopicEntity(topic));
	}
}