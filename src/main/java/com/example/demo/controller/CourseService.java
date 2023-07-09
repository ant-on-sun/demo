package com.example.demo.controller;

import com.example.demo.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAll();

    Course findById(Long id);

    List<Course> findByTitleWithPrefix(String prefix);

    Course save(Course course);

    void deleteById(Long id);

    Course assignUser(Long courseId, Long userId);

    Course unassignUser(Long courseId, Long userId);
}
