package com.example.demo.errorhandlers;

public class InternalServerError extends RuntimeException{
    public InternalServerError(String msg) {
        super(msg);
    }
    public InternalServerError(String msg, Throwable cause) {
        super(msg, cause);
    }
}
