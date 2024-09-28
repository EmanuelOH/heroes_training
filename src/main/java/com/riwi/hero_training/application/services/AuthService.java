package com.riwi.hero_training.application.services;

import com.riwi.hero_training.application.dtos.requests.AuthUserRequestDto;
import com.riwi.hero_training.application.dtos.responses.AuthUserResponseDto;
import com.riwi.hero_training.domain.entities.UserEntity;
import com.riwi.hero_training.domain.ports.service.interfaces.IAuthService;
import com.riwi.hero_training.infrastructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public AuthUserResponseDto login(AuthUserRequestDto request) {

        return null;
    }
}
