package com.example.demo.repository;

import com.example.demo.model.CourseRating;
import com.example.demo.model.CourseRatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface CourseRatingRepository extends JpaRepository<CourseRating, CourseRatingId> {
//    @Transactional
//    void deleteById(CourseRatingId id);
    CourseRating findByCourseRatingId(CourseRatingId courseRatingId);
    List<CourseRating> findByCourseRatingId_userId(Long userId);
    List<CourseRating> findByCourseRatingId_courseId(Long courseId);
    void deleteByCourseRatingId(CourseRatingId courseRatingId);
}
