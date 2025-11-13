package com.easybudget.easybudget_api.adapters.in.web;

import com.easybudget.easybudget_api.domain.exception.EmailAlreadyExistsException;
import com.easybudget.easybudget_api.domain.exception.IncorretPasswordException;
import com.easybudget.easybudget_api.domain.exception.UserDoesNotExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final String genericLoginError = "Invalid email or password";

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailExists(EmailAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(UserDoesNotExistsException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFound(UserDoesNotExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", genericLoginError));
    }

    @ExceptionHandler(IncorretPasswordException.class)
    public ResponseEntity<Map<String, String>> handleIncorrectPassword(IncorretPasswordException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", genericLoginError));
    }
}