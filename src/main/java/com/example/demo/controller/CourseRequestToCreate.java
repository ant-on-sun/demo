package com.example.demo.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CourseRequestToCreate {
    @NotBlank(message = "Course author has to be filled")
    private String author;
    @NotBlank(message = "Course title has to be filled")
    @Pattern(regexp = "")
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
