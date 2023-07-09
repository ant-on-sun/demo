package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplementation implements CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Autowired
    public CourseServiceImplementation(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        Course course = optionalCourse.orElseThrow();
        return course;
    }

    @Override
    public List<Course> findByTitleWithPrefix(String prefix) {
        return courseRepository.findByTitleLike(prefix + "%");
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course assignUser(Long courseId, Long userId) {
        User user = userRepository.getReferenceById(userId);
        Course course = courseRepository.getReferenceById(courseId);
        user.getCourses().add(course);
        course.getUsers().add(user);
        return courseRepository.save(course);
    }

    @Override
    public Course unassignUser(Long courseId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        user.getCourses().remove(course);
        course.getUsers().remove(user);
        return courseRepository.save(course);
    }


}
