package com.airpatagonia.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.airpatagonia.backend.exceptions.ResourceAlreadyExistsException;
import com.airpatagonia.backend.exceptions.ResourceNotFoundException;
import com.airpatagonia.backend.models.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionController {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionController.class);
    
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {

        logger.error("Error: {}",ex.getMessage(), ex);

        ErrorResponse errorResponse = new ErrorResponse(
            ex.getMessage(),
            409,
            "ResourceAlreadyExistsException");
        return ResponseEntity.status(409).body(errorResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {

        logger.error("Error: {}",ex.getMessage(), ex);

        ErrorResponse errorResponse = new ErrorResponse(
            ex.getMessage(),
            404,
            "ResourceNotFoundException");
        return ResponseEntity.status(404).body(errorResponse);
    }
}
