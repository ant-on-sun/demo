package com.example.demo.errorhandlers;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String msg) {
        super(msg);
    }
    public UserAlreadyExistException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
