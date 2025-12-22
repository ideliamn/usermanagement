package com.example.usermanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank
    @Email
    private String name;

    @NotBlank
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
