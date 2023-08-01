package com.example.demo.service;

import com.example.demo.dto.TopicDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicService {

    List<TopicDto> findAll();
    TopicDto findById(Long id);
    TopicDto findByTitle(String title);
    TopicDto save(TopicDto topicDto);
    TopicDto createTopic(TopicDto topicDto);
    void deleteById(Long id);
}
