package com.diginamic.species.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.diginamic.species.dto.ErrorDTO;
import com.diginamic.species.exception.EntityRequestException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

    private ErrorDTO createDTO(String message, WebRequest request,
        HttpStatus status) {
        return new ErrorDTO(
            status.value(),
            LocalDateTime.now(),
            message,
            request.getDescription(false)
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorDTO handleExceptionEntityNotFound(Exception exception, WebRequest request) {
		exception.printStackTrace();
		return createDTO(exception.getMessage(), request, HttpStatus.NOT_FOUND);
	}

    @ExceptionHandler(EntityRequestException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDTO handleExceptionEntity(Exception exception, WebRequest request) {
		exception.printStackTrace();
		return createDTO(exception.getMessage(), request, HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDTO handleValidationException(BindException exception, WebRequest request) {
        BindingResult bindingResult = exception.getBindingResult();
        List<String> errs = bindingResult.getFieldErrors().stream()
            .map((err) -> String.format("%s : %s", err.getField(), err.getDefaultMessage()))
            .toList();

		exception.printStackTrace();
        return createDTO(String.join(";", errs), request, HttpStatus.BAD_REQUEST);
    }

}
