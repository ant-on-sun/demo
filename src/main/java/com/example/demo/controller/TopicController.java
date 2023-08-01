package com.example.demo.controller;

import com.example.demo.dto.TopicDto;
import com.example.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("")
    public List<TopicDto> getAllTopics() {
        return topicService.findAll();
    }

    @GetMapping("/{id}")
    public TopicDto getTopic(@PathVariable("id") Long id) {
        return topicService.findById(id);
    }

    @PutMapping("/{id}")
    public TopicDto updateTopic(@PathVariable("id") Long id,
                                @Valid @RequestBody TopicRequestToUpdate request) {
        TopicDto topicDto = topicService.findById(id);
        topicDto.setTitle(request.getTitle());
        topicDto.setDateAuthorUpdate(request.getAuthor());
        return topicService.save(topicDto);
    }

    @PostMapping
    public TopicDto createTopic(@Valid @RequestBody TopicRequestToCreate request) {
        TopicDto topicDto = new TopicDto();
        topicDto.setTitle(request.getTitle());
        topicDto.setDateAuthorUpdate(request.getAuthor());
        return topicService.createTopic(topicDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteById(id);
    }
}
