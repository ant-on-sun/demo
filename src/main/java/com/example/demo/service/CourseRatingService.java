package com.example.demo.service;

import com.example.demo.dto.CourseRatingDto;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface CourseRatingService {
    List<CourseRatingDto> findAllRatingsOfCourse(Long courseId);
    List<CourseRatingDto> findAllGradesOfUser(Long userId);
    CourseRatingDto findById(Long userId, Long courseId);
    CourseRatingDto save(@NotNull CourseRatingDto courseRatingDto);
    void deleteById(Long userId, Long courseId);
}
