package com.foro.alura.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.foro.alura.dto.*;
import com.foro.alura.entities.TopicEntity;
import com.foro.alura.repositories.TopicRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/topicos")
public class TopicosController {
	@Autowired
	TopicRepository topicRepository;

	@PostMapping
	public ResponseEntity<ResponseTopicDTO> registerNewTopic(@RequestBody @Valid SaveTopicDTO payload,
			UriComponentsBuilder uriComponentsBuilder) {
		TopicEntity topic = topicRepository.save(new TopicEntity(payload));
		ResponseTopicDTO responseTopic = new ResponseTopicDTO(topic.getId(), topic.getTitle(), topic.getMessage(),
				topic.getCreationDate(), topic.isStatus(), topic.getAuthor(), topic.getCourse());
		URI url = uriComponentsBuilder.path("api/topicos/{id}").buildAndExpand(topic.getId()).toUri();
		return ResponseEntity.created(url).body(responseTopic);
	}

	@GetMapping
	public ResponseEntity<List<GetTopicDTO>> getListTopics() {
		return ResponseEntity.ok(topicRepository.findAll().stream().map(GetTopicDTO::new).toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseTopicDTO> getTopic(@PathVariable Integer id) {
		TopicEntity topicEntity = topicRepository.getReferenceById(id);
		return ResponseEntity.ok(new ResponseTopicDTO(topicEntity.getId(), topicEntity.getTitle(),
				topicEntity.getMessage(), topicEntity.getCreationDate(), topicEntity.isStatus(),
				topicEntity.getAuthor(), topicEntity.getCourse()));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ResponseTopicDTO> updateTopic(@PathVariable Integer id, @RequestBody SaveTopicDTO payload) {
		TopicEntity topicEntity = topicRepository.getReferenceById(id);
		topicEntity.updateTopicDdata(payload);
		return ResponseEntity.ok(new ResponseTopicDTO(topicEntity.getId(), topicEntity.getTitle(),
				topicEntity.getMessage(), topicEntity.getCreationDate(), topicEntity.isStatus(),
				topicEntity.getAuthor(), topicEntity.getCourse()));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ResponseTopicDTO> deteteTopic(@PathVariable Integer id) {
		TopicEntity topicEntity = topicRepository.getReferenceById(id);
		topicEntity.delete();
		return ResponseEntity.noContent().build();
	}
}