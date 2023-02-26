package bsuir.labs.controllers;

import bsuir.labs.exceptions.SingleErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> response(MethodArgumentNotValidException e) {
        logger.error("validation error");
        return ResponseEntity.status(400).body(new SingleErrorResponse("err",
                "divisor - " + e.getFieldError().getDefaultMessage()));
    }
}
