package com.furkan.validation.demo.exception;

import com.furkan.validation.demo.model.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exc) {
        String errorMessage = exc.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + " " + error.getDefaultMessage()).collect(Collectors.joining(","));

        log.error("Validation error occurred: {}", errorMessage);
        return  ResponseEntity.badRequest().body(ApiResponse.error(errorMessage));

    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<?>> handleBusinessException(BusinessException exc) {
        return ResponseEntity.badRequest().body(ApiResponse.error(exc.getMessage()));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception exc) {
        return ResponseEntity.badRequest().body(ApiResponse.error(exc.getMessage()));
    }
}
