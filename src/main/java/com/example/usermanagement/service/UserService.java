package com.example.usermanagement.service;

import java.util.List;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.example.usermanagement.dto.UserRequest;
import com.example.usermanagement.dto.UserResponse;

public interface UserService {
    UserResponse create(UserRequest userRequest);

    List<UserResponse> getAll();

    UserResponse getById(Long id);

    UserResponse update(Long id, UserRequest userRequest);

    void delete(Long id);

    List<UserResponse> getAll(Pageable pageable);

    Page<UserResponse> getAll(org.springframework.data.domain.Pageable pageable);
}
