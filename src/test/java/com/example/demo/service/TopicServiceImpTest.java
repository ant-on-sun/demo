package com.example.demo.service;

import com.example.demo.IntegrationSuite;
import com.example.demo.dto.TopicDto;
import com.example.demo.entities.Topic;
import com.example.demo.errorhandlers.TopicAlreadyExistException;
import com.example.demo.repository.TopicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@ActiveProfiles("testcontainers")
@ContextConfiguration(classes = TopicServiceTestConfiguration.class)
class TopicServiceImpTest extends IntegrationSuite {
    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicRepository topicRepository;

    @BeforeEach
    void beforeEach() {
        topicRepository.deleteAll();
    }

    @Test
    void findAll() {
        Topic topic1 = new Topic();
        Topic topic2 = new Topic();
        Topic topic3 = new Topic();
        topic1.setTitle("Title1");
        topic2.setTitle("Title2");
        topic3.setTitle("Title3");
        topicRepository.saveAll(List.of(topic1, topic2, topic3));

        TopicDto topicDto1 = new TopicDto();
        TopicDto topicDto2 = new TopicDto();
        TopicDto topicDto3 = new TopicDto();
        topicDto1.setTitle("Title1");
        topicDto2.setTitle("Title2");
        topicDto3.setTitle("Title3");
        List<TopicDto> topicDtoListExpected = List.of(topicDto1, topicDto2, topicDto3);

        List<TopicDto> topicDtoListActual = topicService.findAll();

        assertEquals(topicDtoListExpected.get(0).getTitle(), topicDtoListActual.get(0).getTitle());
        assertEquals(topicDtoListExpected.get(1).getTitle(), topicDtoListActual.get(1).getTitle());
        assertEquals(topicDtoListExpected.get(2).getTitle(), topicDtoListActual.get(2).getTitle());

    }

    @Test
    void findById() {
        Topic topic = new Topic();
        topic.setTitle("Title1");
        topicRepository.save(topic);
        Long topicId = topic.getId();
        Topic topicRepo = topicRepository.findByTitle("Title1").orElseThrow();
        Long topicIdRepo = topicRepo.getId();
        String titleRepo = topicRepo.getTitle();
        TopicDto topicDtoRepo = topicService.findById(topicId);

        assertEquals("Title1", topicDtoRepo.getTitle());
    }

    @Test
    void findByTitle() {
        Topic topic = new Topic();
        topic.setTitle("Title1");
        topicRepository.save(topic);
        Long topicId = topic.getId();
        Topic topicRepo = topicRepository.findByTitle("Title1").orElseThrow();
        Long topicIdRepo = topicRepo.getId();
        String titleRepo = topicRepo.getTitle();
        TopicDto topicDtoRepo = topicService.findByTitle("Title1");
        assertEquals("Title1", topicDtoRepo.getTitle());
    }

    @Test
    void save() {
        TopicDto topicDto = new TopicDto();
        topicDto.setTitle("Title1");
        TopicDto topicDtoActual = topicService.save(topicDto);
        assertEquals("Title1", topicDtoActual.getTitle());
    }

    @Test
    void createTopicHappyPath() {
        TopicDto topicDto = new TopicDto();
        topicDto.setTitle("Title1");
        TopicDto topicDtoActual = topicService.createTopic(topicDto);
        assertEquals("Title1", topicDtoActual.getTitle());
    }

    @Test
    void createTopicExceptionExpected() {
        Topic topic = new Topic();
        topic.setTitle("Title1");
        topicRepository.save(topic);
        TopicDto topicDto = new TopicDto();
        topicDto.setTitle("Title1");

        TopicAlreadyExistException ex = assertThrows(TopicAlreadyExistException.class, () -> {
            topicService.createTopic(topicDto);
        }, "Expected TopicAlreadyExistException");
        assertEquals("Topic with such title already exist. Provide another title.", ex.getMessage());
    }

    @Test
    void deleteById() {
        Topic topic = new Topic();
        topic.setTitle("Title1");
        topicRepository.save(topic);
        Long topicId = topic.getId();

        topicService.deleteById(topicId);

        assertThrows(NoSuchElementException.class, () -> {
            topicService.findById(topicId);
        }, "Expected NoSuchElementException");
    }
}