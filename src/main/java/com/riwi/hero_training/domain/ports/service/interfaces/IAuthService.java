package com.riwi.hero_training.domain.ports.service.interfaces;

import com.riwi.hero_training.application.dtos.requests.AuthUserRequestDto;
import com.riwi.hero_training.application.dtos.responses.AuthUserResponseDto;

public interface IAuthService {
    public AuthUserResponseDto login (AuthUserRequestDto request);
}
