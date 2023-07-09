package com.example.demo.controller;

import com.example.demo.dto.LessonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course/{course_id}/lesson")
public class LessonController {
    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("")
    public List<LessonDto> lessonTable(@PathVariable("course_id") Long courseId) {
        return lessonService.findAll(courseId);
    }

    @GetMapping("/{id}")
    public LessonDto getLesson(@PathVariable("id") Long id) {
        return lessonService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateLesson(@PathVariable("id") Long id,
                             @Valid @RequestBody LessonRequestToUpdate request) {
        LessonDto lessonDto = lessonService.findById(id);
        lessonDto.setTitle(request.getTitle());
        lessonDto.setText(request.getText());
        lessonService.save(lessonDto);
    }

    @PostMapping
    public LessonDto createLesson(@PathVariable("course_id") Long courseId,
                                  @RequestBody LessonRequestToCreate request) {
        LessonDto lessonDto = new LessonDto(request.getTitle(), request.getText(), courseId);
        return lessonService.save(lessonDto);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        lessonService.deleteById(id);
    }

}
