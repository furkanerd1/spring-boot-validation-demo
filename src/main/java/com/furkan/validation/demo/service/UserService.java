package com.furkan.validation.demo.service;

import com.furkan.validation.demo.model.dto.request.UserCreateRequest;
import com.furkan.validation.demo.model.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserCreateRequest userCreateRequest);
    List<UserResponse> getAllUsers();

}
