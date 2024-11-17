package com.furkan.validation.demo.model.dto.request;


import jakarta.validation.constraints.*;

public record UserCreateRequest(
        @NotBlank(message = "username cannot be blank")
        @Size(min = 0 , max = 50 , message = "username must be between 2-50 characters")
        String userName,

        @NotBlank(message = "email cannot be blank")
        @Email(message = "Enter a valid email address")
        String email,

        @Pattern(regexp = "^\\d{10}$", message = "\n" +"Phone number must be 10 digits")
        String phone,

        @Min(value = 18, message = "Age cannot be lower than 18")
        @Max(value = 100, message = "Age cannot be higher than 100")
        Integer age
) {}
