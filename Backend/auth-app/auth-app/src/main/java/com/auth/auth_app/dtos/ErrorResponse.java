package com.auth.auth_app.dtos;

import org.springframework.http.HttpStatus;

public record ErrorResponse(

    String message,
    int StatusCode,
    HttpStatus status
){
}
