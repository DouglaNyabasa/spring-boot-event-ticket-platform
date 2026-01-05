package com.doug.eventticketplatform.controller;

import com.doug.eventticketplatform.dto.ErrorDto;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleConstraintViolation(ConstraintViolationException exception) {
        log.error("caught handleConstraintViolation", exception);
        ErrorDto errorDto = new ErrorDto();
       String errorMessage = exception.getConstraintViolations().stream().findFirst().map(
                violation -> violation.getPropertyPath() + ": " + violation.getMessage()
        ).orElse("Constraint Violation Exception Occurred");
        errorDto.setError(errorMessage);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception ex) {
        log.error("caught exception", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("Unknown Error Occurred");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
