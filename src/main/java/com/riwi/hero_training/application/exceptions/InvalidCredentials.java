package com.riwi.hero_training.application.exceptions;

import com.riwi.hero_training.application.dtos.exceptions.ExceptionBasic;
import com.riwi.hero_training.application.dtos.exceptions.ExceptionResponse;
import com.riwi.hero_training.domain.exceptions.InvalidCredentialException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class InvalidCredentials {
    @ExceptionHandler(InvalidCredentialException.class)
    public ExceptionBasic invalidCredentialException(InvalidCredentialException exception){
        return ExceptionResponse.builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .status(HttpStatus.UNAUTHORIZED.name())
                .message(exception.getMessage())
                .build();
    }
}
