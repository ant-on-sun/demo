package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<CourseDto> findAll();

    CourseDto findById(Long id);

    List<CourseDto> findByTitleWithPrefix(String prefix);

    CourseDto save(CourseDto courseDto);

    void deleteById(Long id);

    CourseDto assignUser(Long courseId, Long userId);

    CourseDto unassignUser(Long courseId, Long userId);
}
