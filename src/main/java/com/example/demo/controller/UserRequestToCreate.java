package com.example.demo.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserRequestToCreate {
    @NotBlank(message = "Username has to be filled")
    private String username;
    @NotBlank(message = "Password has to be filled")
    private String password;
    @NotBlank(message = "Email has to be filled")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-]" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Email address is not valid")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
