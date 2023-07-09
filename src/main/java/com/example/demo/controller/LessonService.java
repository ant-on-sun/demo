package com.example.demo.controller;

import com.example.demo.dto.LessonDto;
import com.example.demo.model.Lesson;
import java.util.List;

public interface LessonService {

    List<LessonDto> findAll(Long courseId);

    LessonDto findById(Long id);

    List<LessonDto> findByTitleWithPrefix(String prefix);

    LessonDto save(LessonDto lessonDto);

    void deleteById(Long id);

}
