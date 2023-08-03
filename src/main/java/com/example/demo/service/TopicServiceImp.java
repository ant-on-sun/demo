package com.example.demo.service;

import com.example.demo.dto.TopicDto;
import com.example.demo.errorhandlers.TopicAlreadyExistException;
import com.example.demo.entities.Test;
import com.example.demo.entities.Topic;
import com.example.demo.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicServiceImp implements TopicService {
    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImp(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<TopicDto> findAll() {
        List<TopicDto> topicDtoList = topicRepository.findAll().stream()
                .map(t -> topicToTopicDto(t)).collect(Collectors.toList());
        return topicDtoList;
    }

    @Override
    public TopicDto findById(Long id) {
        Topic topic = topicRepository.findById(id).orElseThrow();
        return topicToTopicDto(topic);
    }

    @Override
    public TopicDto findByTitle(String title) {
        Topic topic = topicRepository.findByTitle(title).orElseThrow();
        return topicToTopicDto(topic);
    }

    @Override
    public TopicDto save(TopicDto topicDto) {
        Topic topic;
        Optional<Topic> topicRepo = topicRepository.findByTitle(topicDto.getTitle());
        if (topicRepo.isEmpty()) { //new Topic creation
            topic = topicDtoToEnrichTopic(topicDto, new Topic());
        } else { //update Topic
            topic = topicDtoToEnrichTopic(topicDto, topicRepo.get());
        }
        Topic topicSaved = topicRepository.save(topic);
        return topicToTopicDto(topicSaved);
    }

    @Override
    public TopicDto createTopic(TopicDto topicDto) {
        Optional<Topic> topicRepo = topicRepository.findByTitle(topicDto.getTitle());
        if (topicRepo.isPresent()) {
            throw new TopicAlreadyExistException("Topic with such title already exist. Provide another title.");
        }
        return save(topicDto);
    }

    @Override
    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }

    private TopicDto topicToTopicDto(Topic topic) {
        TopicDto topicDto = new TopicDto();
        topicDto.setId(topic.getId());
        topicDto.setTitle(topic.getTitle());
        topicDto.setDescription(topic.getDescription());
        topicDto.setDateAuthorCreation(topic.getDateAuthorCreation());
        topicDto.setDateAuthorUpdate(topic.getDateAuthorUpdate());
        topicDto.setDateAuthorDeletion(topic.getDateAuthorDeletion());
        topicDto.setContent(topic.getContent());
        if (topic.getModule() != null) {
            topicDto.setModuleId(topic.getModule().getId());
        }
        if (topic.getTests() != null) {
            topicDto.setTestIds(topic.getTests().stream().map(Test::getId).collect(Collectors.toSet()));
        }
        return topicDto;
    }

    private Topic topicDtoToEnrichTopic(TopicDto topicDto, Topic topic) {
        if (topicDto.getTitle() != null && !topicDto.getTitle().isEmpty()) {
            topic.setTitle(topicDto.getTitle());
        }
        if (topicDto.getDescription() != null && !topicDto.getDescription().isEmpty()) {
            topic.setDescription(topicDto.getDescription());
        }
        if (topicDto.getDateAuthorCreation() != null && !topicDto.getDateAuthorCreation().isEmpty()) {
            topic.setDateAuthorCreation(topicDto.getDateAuthorCreation());
        }
        if (topicDto.getDateAuthorUpdate() != null && !topicDto.getDateAuthorUpdate().isEmpty()) {
            topic.setDateAuthorUpdate(topicDto.getDateAuthorUpdate());
        }
        if (topicDto.getDateAuthorDeletion() != null && !topicDto.getDateAuthorDeletion().isEmpty()) {
            topic.setDateAuthorDeletion(topicDto.getDateAuthorDeletion());
        }
        long l = 0;
        try {
            if (topicDto.getContent() != null) {
                l = topicDto.getContent().length();
            }
        } catch (SQLException e) {
            //TO DO logging
            //e.printStackTrace();
        }
        if (l > 0 ) {
            topic.setContent(topicDto.getContent());
        }
        return topic;
    }
}
