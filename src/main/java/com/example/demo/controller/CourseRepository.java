package com.example.demo.controller;

import com.example.demo.model.Course;

import java.util.List;

public interface CourseRepository {

    List<Course> findAll();

    Course findById(Long id);

    List<Course> findByTitleWithPrefix(String prefix);

    Course save(Course course);

    void deleteById(Long id);

}
