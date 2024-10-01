package com.riwi.hero_training.domain.ports.service.interfaces;

import com.riwi.hero_training.application.dtos.requests.UserRequestDto;
import com.riwi.hero_training.application.dtos.responses.AuthUserResponseDto;
import com.riwi.hero_training.application.dtos.responses.UserResponseDto;
import com.riwi.hero_training.domain.entities.UserEntity;
import com.riwi.hero_training.domain.enums.Roles;
import com.riwi.hero_training.domain.ports.service.crud.*;

public interface IUserService extends
        CreateService<UserRequestDto, UserEntity>,
        UpdateService<UserRequestDto, UserEntity, Long>,
        ReadAllService<UserResponseDto>,
        ReadByIdService<UserResponseDto, Long>,
        DeleteService<Long> {
    public AuthUserResponseDto register(UserRequestDto request, Roles role);
}
