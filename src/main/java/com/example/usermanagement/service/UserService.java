package com.example.usermanagement.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.example.usermanagement.dto.PageResponse;
import com.example.usermanagement.dto.UserRequest;
import com.example.usermanagement.dto.UserResponse;

public interface UserService {
    UserResponse create(UserRequest userRequest);

    UserResponse getById(Long id);

    UserResponse update(Long id, UserRequest userRequest);

    void delete(Long id);

    PageResponse<UserResponse> getAll(Pageable pageable);
}
