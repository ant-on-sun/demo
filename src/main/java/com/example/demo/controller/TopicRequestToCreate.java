package com.example.demo.controller;

import javax.validation.constraints.NotBlank;

public class TopicRequestToCreate {
    @NotBlank(message = "Title has to be filled")
    private String title;
    @NotBlank(message = "Author field has to be filled")
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
