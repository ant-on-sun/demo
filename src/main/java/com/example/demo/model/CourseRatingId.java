package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class CourseRatingId implements Serializable {
    private Long userId;
    private Long courseId;

    public CourseRatingId() {}
    public CourseRatingId(Long userId, Long courseId) {
        this.userId = userId;
        this.courseId = courseId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseRatingId that = (CourseRatingId) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getCourseId(), that.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getCourseId());
    }

}
