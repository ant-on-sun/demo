package com.example.demo.service;

import com.example.demo.dto.LessonDto;
import java.util.List;

public interface LessonService {

    List<LessonDto> findAll(Long courseId);

    LessonDto findById(Long id);

    List<LessonDto> findByTitleWithPrefix(String prefix);

    LessonDto save(LessonDto lessonDto);

    void deleteById(Long id);

}
