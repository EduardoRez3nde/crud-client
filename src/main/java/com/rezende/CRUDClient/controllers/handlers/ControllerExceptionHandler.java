package com.rezende.CRUDClient.controllers.handlers;

import com.rezende.CRUDClient.dto.ExceptionDto.ExceptionError;
import com.rezende.CRUDClient.services.exceptions.ExceptionNotFound;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ExceptionNotFound.class)
    public ResponseEntity<ExceptionError> exceptionError(ExceptionNotFound e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionError err = new ExceptionError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
