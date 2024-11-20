package com.furkan.validation.demo.controller;

import com.furkan.validation.demo.model.dto.request.UserCreateRequest;
import com.furkan.validation.demo.model.dto.response.ApiResponse;
import com.furkan.validation.demo.model.dto.response.UserResponse;
import com.furkan.validation.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<?>> getAllUsers() {
        List<UserResponse> responseList = userService.getAllUsers();
        return ResponseEntity.ok(ApiResponse.success( responseList,"All Users" ));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<?>> createUser(@Valid @RequestBody  UserCreateRequest request){
        UserResponse response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(response, "Created User"));
    }


}
