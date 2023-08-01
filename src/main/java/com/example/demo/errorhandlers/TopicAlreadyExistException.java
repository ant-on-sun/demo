package com.example.demo.errorhandlers;

public class TopicAlreadyExistException extends RuntimeException {
    public TopicAlreadyExistException(String msg) {
        super(msg);
    }
    public TopicAlreadyExistException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
