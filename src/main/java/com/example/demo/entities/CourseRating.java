package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "courses_rating")
public class CourseRating {
//    @Id
//    @Column(name = "user_id")
//    private Long userId;
//    @Id
//    @Column(name = "course_id")
//    private Long courseId;
    @EmbeddedId
    private CourseRatingId courseRatingId;
    @Column
    private int rating; //rating of the course from the user
    @Column
    private int grade; //summary points/marks of the user in the course from the teacher

    public CourseRating() {}

    //@Autowired
    public CourseRating(CourseRatingId courseRatingId, int rating, int grade) {
        this.courseRatingId = courseRatingId;
        this.rating = rating;
        this.grade = grade;
    }

    public CourseRatingId getCourseRatingId() {
        return courseRatingId;
    }

    public void setCourseRatingId(CourseRatingId courseRatingId) {
        this.courseRatingId = courseRatingId;
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
        return Objects.equals(courseRatingId.getUserId(), that.courseRatingId.getUserId()) &&
                Objects.equals(courseRatingId.getCourseId(), that.courseRatingId.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseRatingId.getUserId(), courseRatingId.getCourseId());
    }
}
