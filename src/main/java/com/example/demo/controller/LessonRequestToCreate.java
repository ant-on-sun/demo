package com.example.demo.controller;

import javax.validation.constraints.NotBlank;

public class LessonRequestToCreate {

    @NotBlank(message = "Lesson title has to be filled")
    private String title;
    @NotBlank(message = "Lesson text has to be filled")
    private String text;

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

}
