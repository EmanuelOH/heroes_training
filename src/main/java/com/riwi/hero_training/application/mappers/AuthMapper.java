package com.riwi.hero_training.application.mappers;

import com.riwi.hero_training.application.dtos.requests.AuthUserRequestDto;
import com.riwi.hero_training.application.dtos.responses.AuthUserResponseDto;
import com.riwi.hero_training.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    UserEntity toEntity(AuthUserRequestDto authUserRequestDto);
    AuthUserResponseDto toResponseDto(UserEntity userEntity, String token);
}
