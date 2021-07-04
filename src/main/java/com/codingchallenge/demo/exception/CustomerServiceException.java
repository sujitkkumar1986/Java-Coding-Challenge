package com.codingchallenge.demo.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"stackTrace", "suppressed","localizedMessage"})
public class CustomerServiceException extends RuntimeException {
    private int statusCode;
    private String message;
    private String detailedMessage;

    public CustomerServiceException(Exception ex, int statusCode){
        this.message = ex.getMessage();
        this.statusCode = statusCode;
        this.detailedMessage = ex.toString();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }
}
