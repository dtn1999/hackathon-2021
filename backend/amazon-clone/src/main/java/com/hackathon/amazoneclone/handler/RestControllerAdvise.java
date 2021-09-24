package com.hackathon.amazoneclone.handler;

import com.hackathon.amazoneclone.utils.ApiResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

/**
 * @author danyls ngongang
 * @Created 24/09/2021-04:18
 * @Project user-service
 */
@RestControllerAdvice
public class RestControllerAdvise extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {ConstraintViolationException.class, NoSuchElementException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleValidationException(RuntimeException ex, WebRequest request){

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .data(null)
                        .error( ex.getMessage() )
                        .success( false )
                        .build()
        );
    }
}
