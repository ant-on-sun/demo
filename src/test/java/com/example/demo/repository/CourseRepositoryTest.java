package com.example.demo.repository;

import com.example.demo.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void cleanDatabase() {
        courseRepository.deleteAll();
    }

    @Test
    void findByTitleLikeTest() {
        Course course1 = new Course(1L, "Author1 somedate", "Java");
        Course course2 = new Course(2L, "Author2 somedate", "Java script");
        Course course3 = new Course(3L, "Author 3 date", "C++");
        Course course4 = new Course(4L, "Author 4 date", "Noodles");
        courseRepository.saveAll(Set.of(course1, course2, course3, course4));
        List<Course> courseList = courseRepository.findByTitleLike("Jav%");
        assertEquals(List.of(course1, course2), courseList);
    }
}