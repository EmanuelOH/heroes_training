package com.riwi.hero_training.application.exceptions;

import com.riwi.hero_training.application.dtos.exceptions.ExceptionBasic;
import com.riwi.hero_training.application.dtos.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFound {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ExceptionBasic userNotFound(UsernameNotFoundException exception){
        return ExceptionResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }
}
