package com.example.demo.dto;

import java.util.Objects;

public class LessonDto {

    private Long id;

    private String title;

    private String text;

    private Long courseId;

    public LessonDto() {
    }

    public LessonDto(Long courseId) {
        this.courseId = courseId;
    }

    public LessonDto(String title, String text, Long courseId) {
        this.title = title;
        this.text = text;
        this.courseId = courseId;
    }

    public LessonDto(Long id, String title, Long courseId) {
        this.id = id;
        this.title = title;
        this.courseId = courseId;
    }

    public LessonDto(Long id, String title, String text, Long courseId) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        LessonDto lessonDto = (LessonDto) o;
        return id.equals(lessonDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
