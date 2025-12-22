package com.example.usermanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(1, "OK", data);
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<T>(1, "OK", null);
    }

    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<T>(code, message, null);
    }
}
