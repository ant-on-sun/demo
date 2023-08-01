package com.example.demo.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class HandleErrorService {

    @ExceptionHandler
    public ResponseEntity<ApiError> noSuchElementExceptionHandler(NoSuchElementException ex) {
        return new ResponseEntity<>(new ApiError(OffsetDateTime.now(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> userNotFoundExceptionHandler(UsernameNotFoundException ex) {
        return new ResponseEntity<>(new ApiError(OffsetDateTime.now(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> authenticationExceptionHandler(AuthenticationException ex) {
        return new ResponseEntity<>(new ApiError(OffsetDateTime.now(), ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> accessDeniedExceptionHandler(AccessDeniedException ex) {
        return new ResponseEntity<>(new ApiError(OffsetDateTime.now(), ex.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> badRequestUserExceptionHandler(UserAlreadyExistException ex) {
        return new ResponseEntity<>(new ApiError(OffsetDateTime.now(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> badRequestModuleExceptionHandler(ModuleAlreadyExistException ex) {
        return new ResponseEntity<>(new ApiError(OffsetDateTime.now(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
