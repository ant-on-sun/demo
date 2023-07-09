package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(CourseRatingId.class)
@Table(name = "courses_rating")
public class CourseRating {
    @Id
    @Column(name = "user_id")
    private Long userId;
    @Id
    @Column(name = "course_id")
    private Long courseId;
    @Column
    private int rating; //rating of the course from the user
    @Column
    private int grade; //summary points/marks of the user in the course from the teacher

    public CourseRating() {}

    public CourseRating(Long userId, Long courseId, int rating) {
        this.userId = userId;
        this.courseId = courseId;
        this.rating = rating;
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
        CourseRating that = (CourseRating) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getCourseId(), that.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getCourseId());
    }
}
