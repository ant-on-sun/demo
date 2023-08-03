package com.example.demo.controller;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class UserRequestToUpdate {
    @NotBlank(message = "Username has to be filled")
    private String username;
    @NotBlank(message = "Author field has to be filled")
    private String author;

    private String newUsername;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }
}
