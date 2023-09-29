package com.foro.alura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.alura.dto.GetTopicDTO;
import com.foro.alura.dto.SaveTopicDTO;
import com.foro.alura.entities.TopicEntity;
import com.foro.alura.repositories.TopicRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/topicos")
public class TopicosController {
	@Autowired
	TopicRepository topicRepository;

	@PostMapping
	public void registerNewTopic(@RequestBody SaveTopicDTO payload) {
		topicRepository.save(new TopicEntity(payload));
	}

	@GetMapping
	public List<GetTopicDTO> getListTopics() {
		return topicRepository.findAll().stream().map(GetTopicDTO::new).toList();
	}

	@GetMapping("/{id}")
	public GetTopicDTO getTopic(@PathVariable Integer id) {
		TopicEntity topicEntity = topicRepository.getReferenceById(id);
		return new GetTopicDTO(topicEntity);
	}

	@PutMapping("/{id}")
	@Transactional
	public void updateTopic(@PathVariable Integer id, @RequestBody SaveTopicDTO payload) {
		TopicEntity topicEntity = topicRepository.getReferenceById(id);
		topicEntity.updateTopicDdata(payload);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void deteteTopic(@PathVariable Integer id) {
		TopicEntity topicEntity = topicRepository.getReferenceById(id);
		topicEntity.delete();
	}
}