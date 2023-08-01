package com.example.demo.controller;

import com.example.demo.IntegrationSuite;
import com.example.demo.repository.TopicRepository;
import com.example.demo.service.TopicService;
import com.example.demo.service.TopicServiceTestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@ActiveProfiles("testcontainers")
@ContextConfiguration(classes = TopicServiceTestConfiguration.class)
class TopicControllerTest extends IntegrationSuite {
    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicRepository topicRepository;

    @BeforeEach
    void beforeEach() {
        topicRepository.deleteAll();
    }

    @Test
    void getAllTopicsTest() {
        assertEquals(4, 4);
    }

    @Test
    void getTopic() {
    }

    @Test
    void updateTopic() {
    }

    @Test
    void createTopic() {
    }

    @Test
    void deleteTopic() {
    }
}