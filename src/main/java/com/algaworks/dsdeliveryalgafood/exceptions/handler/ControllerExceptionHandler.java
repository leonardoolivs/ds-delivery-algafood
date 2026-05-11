package com.algaworks.dsdeliveryalgafood.exceptions.handler;

import com.algaworks.dsdeliveryalgafood.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiError apiError = new ApiError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(apiError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> dataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.CONFLICT;
        ApiError apiError = new ApiError(Instant.now(), status.value(), "Não é possível excluir porque esta sendo utilizado em outro lugar", request.getRequestURI());

        return ResponseEntity.status(status).body(apiError);
    }

}
