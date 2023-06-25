package com.example.demo.controller;

import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Objects.requireNonNullElse;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public List<Course> courseTable() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable("id") Long id) {
        return courseService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable("id") Long id,
                             @Valid @RequestBody CourseRequestToUpdate request) {
        Course course = courseService.findById(id);
        course.setTitle(request.getTitle());
        course.setAuthor(request.getAuthor());
        courseService.save(course);
    }

    @GetMapping("/filter")
    public List<Course> getCoursesByTitlePrefix(@RequestParam(name = "titlePrefix", required = false)
                                                            String titlePrefix) {
        return courseService.findByTitleWithPrefix(requireNonNullElse(titlePrefix, ""));
    }

    @PostMapping
    public Course createCourse(@RequestBody CourseRequestToCreate request) {
        Course course = new Course(request.getAuthor(), request.getTitle());
        return courseService.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }

//    @ExceptionHandler
//    public ResponseEntity<ApiError> noSuchElementExceptionHandler(NoSuchElementException ex) {
//        return new ResponseEntity<ApiError>(new ApiError(ex.getMessage()), HttpStatus.NOT_FOUND);
//    }

}
