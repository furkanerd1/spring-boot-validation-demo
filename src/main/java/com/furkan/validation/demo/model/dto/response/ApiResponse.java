package com.furkan.validation.demo.model.dto.response;

import org.springframework.http.ResponseEntity;

public record ApiResponse<T>(
        boolean success,
        String message,
        T data
){
    public static <T> ApiResponse<T> success(T data , String message){
        return new ApiResponse<>(true,message,data);
    }

    public static <T> ApiResponse<T> error(T data ,String message){
        return new ApiResponse<>(false,message,data);
    }
}
