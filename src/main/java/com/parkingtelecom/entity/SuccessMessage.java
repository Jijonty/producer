package com.parkingtelecom.entity;

public class SuccessMessage {
    private String status = "SUCESS";
    private String message = "Done!";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
