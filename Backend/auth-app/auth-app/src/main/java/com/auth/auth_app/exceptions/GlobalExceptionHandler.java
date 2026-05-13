package com.auth.auth_app.exceptions;


import com.auth.auth_app.dtos.ErrorResponse;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ErrorResponse> handleResorceNotFoundExcetion(ResourceNotFoundException exception){
        ErrorResponse internalServerError = new ErrorResponse(exception.getMessage(),404, HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(internalServerError);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<ErrorResponse> handleIllegalArgumentExcetion(IllegalArgumentException exception){
        ErrorResponse internalServerError = new ErrorResponse(exception.getMessage(),408, HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(internalServerError);
    }
}
