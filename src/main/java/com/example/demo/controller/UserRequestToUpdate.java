package com.example.demo.controller;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class UserRequestToUpdate {
    @NotBlank(message = "Username has to be filled")
    private String username;
    @NotBlank(message = "Author field has to be filled")
    private String author;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthor() {
        Date date = new Date();
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
