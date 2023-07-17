package com.example.demo.service;

import com.example.demo.dto.CourseRatingDto;
import com.example.demo.model.CourseRating;
import com.example.demo.model.CourseRatingId;
import com.example.demo.repository.CourseRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class CourseRatingServiceImp implements CourseRatingService {

    private final CourseRatingRepository courseRatingRepository;

    @Autowired
    public CourseRatingServiceImp(CourseRatingRepository courseRatingRepository) {
        this.courseRatingRepository = courseRatingRepository;
    }

    @Override
    public List<CourseRatingDto> findAllRatingsOfCourse(Long courseId) {
        List<CourseRatingDto> ratingsOfCourse = courseRatingRepository.findByCourseRatingId_courseId(courseId)
                .stream().map(c -> new CourseRatingDto(c.getCourseRatingId().getUserId(),
                        c.getCourseRatingId().getCourseId(), c.getRating(), c.getGrade())).collect(Collectors.toList());
        return ratingsOfCourse;
    }

    @Override
    public List<CourseRatingDto> findAllGradesOfUser(Long userId) {
        List<CourseRatingDto> gradesOfUser = courseRatingRepository.findByCourseRatingId_userId(userId)
                .stream().map(c -> new CourseRatingDto(c.getCourseRatingId().getUserId(),
                        c.getCourseRatingId().getCourseId(), c.getRating(), c.getGrade())).collect(Collectors.toList());
        return gradesOfUser;
    }

    @Override
    public CourseRatingDto findById(Long userId, Long courseId) {
        CourseRatingId courseRatingId = new CourseRatingId(userId, courseId);
        CourseRating courseRating = courseRatingRepository.findByCourseRatingId(courseRatingId);
        return new CourseRatingDto(userId, courseId, courseRating.getRating(), courseRating.getGrade());
    }

    @Override
    public CourseRatingDto save(@NotNull CourseRatingDto courseRatingDto) {
        CourseRating courseRating;
        CourseRatingId courseRatingId = new CourseRatingId(courseRatingDto.getUserId(),
                courseRatingDto.getCourseId());
        courseRating = new CourseRating(courseRatingId, courseRatingDto.getRating(), courseRatingDto.getGrade());
        courseRatingRepository.save(courseRating);
        return courseRatingDto;
    }

    @Override
    public void deleteById(Long userId, Long courseId) {
        CourseRatingId courseRatingId = new CourseRatingId(userId, courseId);
        courseRatingRepository.deleteByCourseRatingId(courseRatingId);
    }


}
