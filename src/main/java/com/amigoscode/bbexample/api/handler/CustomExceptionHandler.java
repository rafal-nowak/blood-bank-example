package com.amigoscode.bbexample.api.handler;


import com.amigoscode.bbexample.api.response.ErrorResponse;
import com.amigoscode.bbexample.domain.provider.ProviderAlreadyExistsException;
import com.amigoscode.bbexample.domain.provider.ProviderNotFoundException;
import com.amigoscode.bbexample.domain.user.UserAlreadyExistsException;
import com.amigoscode.bbexample.domain.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        return buildResponse(ex,  HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public final ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return buildResponse(ex, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ProviderNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleProviderNotFoundException(ProviderNotFoundException ex) {
        return buildResponse(ex,  HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProviderAlreadyExistsException.class)
    public final ResponseEntity<ErrorResponse> handleProviderAlreadyExistsException(ProviderAlreadyExistsException ex) {
        return buildResponse(ex, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IOException.class)
    public final ResponseEntity<ErrorResponse> handleCommandNotSupportedException(IOException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ex.getMessage()));
    }

    private <E extends RuntimeException> ResponseEntity<ErrorResponse> buildResponse(E exception, HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(new ErrorResponse(exception.getMessage()));
    }

}