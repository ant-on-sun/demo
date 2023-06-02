package com.example.demo.controller;

import java.time.OffsetDateTime;

public class ApiError {
    private OffsetDateTime dateOccurred;
    private String errorMessage;

    public ApiError(OffsetDateTime dateOccurred, String errorMessage) {
        this.dateOccurred = dateOccurred;
        this.errorMessage = errorMessage;
    }

}
