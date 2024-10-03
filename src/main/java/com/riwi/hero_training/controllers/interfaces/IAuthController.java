package com.riwi.hero_training.controllers.interfaces;

import com.riwi.hero_training.application.dtos.requests.AuthUserRequestDto;
import com.riwi.hero_training.application.dtos.responses.AuthUserResponseDto;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public interface IAuthController {
    public ResponseEntity<AuthUserResponseDto> login(AuthUserRequestDto requestDto);
}
