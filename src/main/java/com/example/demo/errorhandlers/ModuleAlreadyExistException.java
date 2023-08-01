package com.example.demo.errorhandlers;

public class ModuleAlreadyExistException extends RuntimeException {
    public ModuleAlreadyExistException(String msg) {
        super(msg);
    }
    public ModuleAlreadyExistException(String msg, Throwable cause){
        super(msg, cause);
    }
}
