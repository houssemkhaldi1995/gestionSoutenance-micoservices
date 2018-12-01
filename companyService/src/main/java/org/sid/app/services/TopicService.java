package org.sid.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.app.dao.TopicRepository;
import org.sid.app.dto.TopicDto;
import org.sid.app.entities.Topic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class TopicService {

	private final TopicRepository topicRepository;

	public TopicService(TopicRepository topicRepository) {
		super();
		this.topicRepository = topicRepository;
	}

	public TopicDto add(TopicDto topicDto) {
		log.debug("Request to create a topic");
		return mapToDto(topicRepository.save(mapToEntity(topicDto)));
	}

	public void deleteById(Long topicId) {
		log.debug("Request to delete a topic");
		topicRepository.deleteById(topicId);
	}

	public TopicDto findById(Long topicId) {
		log.debug("Request to get a topic by using id");
		return topicRepository.findById(topicId).map(TopicService::mapToDto).orElse(null);
	}

	public List<TopicDto> findAll() {
		log.debug("Request to get all topics");
		return topicRepository.findAll().stream().map(TopicService::mapToDto).collect(Collectors.toList());
	}

	public static TopicDto mapToDto(Topic topic) {
		if (topic != null) {
			return new TopicDto(topic.getTopicId(), topic.getTitle(), topic.getDomain(), topic.getDuration(),
					CompanyService.mapToDto(topic.getCompany()));
		}
		return null;
	}

	public static Topic mapToEntity(TopicDto topicDto) {
		if (topicDto != null) {
			return new Topic(topicDto.getTopicId(), topicDto.getTitle(), topicDto.getDomain(), topicDto.getDuration(),
					CompanyService.mapToEntity(topicDto.getCompany()));
		}
		return null;
	}
}
