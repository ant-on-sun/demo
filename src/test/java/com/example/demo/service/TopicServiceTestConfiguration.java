package com.example.demo.service;

import com.example.demo.repository.TopicRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TopicServiceTestConfiguration {
    @Bean
    public TopicService topicService(TopicRepository topicRepository) {
        return new TopicServiceImp(topicRepository);
    }
}
