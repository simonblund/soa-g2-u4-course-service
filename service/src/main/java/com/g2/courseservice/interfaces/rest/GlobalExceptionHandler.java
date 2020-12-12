package com.g2.courseservice.interfaces.rest;

import com.g2.courseservice.api.rest.ErrorResponse;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandler{

    public ResponseEntity<ErrorResponse> handle(Exception e){
        ErrorResponse error = ErrorResponse.builder().code(500).message(e.getMessage()).build();

        return ResponseEntity.status(500).body(error);
    }
}
