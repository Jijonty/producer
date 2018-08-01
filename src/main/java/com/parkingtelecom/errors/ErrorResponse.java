package com.parkingtelecom.errors;

import java.time.OffsetDateTime;

public class ErrorResponse {
    private String errorMessage;
    private OffsetDateTime dateTime;

    public ErrorResponse() {
    }

    public ErrorResponse(OffsetDateTime error, String message) {
        this.errorMessage = message;
        this.dateTime = error;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
