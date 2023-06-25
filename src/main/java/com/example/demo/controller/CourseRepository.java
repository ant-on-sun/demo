package com.example.demo.controller;

import com.example.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    //List<Course> findAll();

    //Course findById(Long id);
    List<Course> findByTitleLike(String title);

    //List<Course> findByTitleWithPrefix(String prefix);

    //Course save(Course course);

    //void deleteById(Long id);

}
