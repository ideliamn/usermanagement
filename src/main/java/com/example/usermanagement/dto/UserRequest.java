package com.example.usermanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank(message = "should not be empty")
    private String name;

    @NotBlank(message = "should not be empty")
    @Email(message = "should be a valid email")
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
