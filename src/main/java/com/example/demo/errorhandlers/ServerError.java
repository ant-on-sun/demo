package com.example.demo.errorhandlers;

import java.time.OffsetDateTime;

public class ServerError {
    private OffsetDateTime dateOccurred;
    private String errorMessage;

    public ServerError(OffsetDateTime dateOccurred, String errorMessage) {
        this.dateOccurred = dateOccurred;
        this.errorMessage = errorMessage;
    }
}
