package com.example.demo.dto;

import com.example.demo.model.CourseRating;

import java.util.Objects;

public class CourseRatingDto {
    private Long userId;
    private Long courseId;
    private int rating;
    private int grade;

    public CourseRatingDto() {
    }

    public CourseRatingDto(Long userId, Long courseId, int rating, int grade) {
        this.userId = userId;
        this.courseId = courseId;
        this.rating = rating;
        this.grade = grade;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseRatingDto that = (CourseRatingDto) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getCourseId(), that.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getCourseId());
    }

}
