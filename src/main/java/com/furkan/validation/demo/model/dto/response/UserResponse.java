package com.furkan.validation.demo.model.dto.response;

import java.time.LocalDate;

public record UserResponse (
    Long id,
    String userName,
    String email,
    String phone,
    Integer age,
    LocalDate createdAt
){}
