package com.furkan.validation.demo.model.dto.response;

public record ApiResponse<T>(
        boolean success,
        String message,
        T data
){
    public static <T> ApiResponse<T> success(T data , String message){
        return new ApiResponse<>(true,message,data);
    }

    public static <T> ApiResponse<T> error(String message){
        return new ApiResponse<>(false,message,null);
    }
}
