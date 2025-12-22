package com.example.usermanagement.config;

import java.util.Map;

public class ValidationErrorResponse {
    private int code;
    private String message;
    private Map<String, String> errors;

    public ValidationErrorResponse(int code, String message, Map<String, String> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
