package com.riwi.hero_training.application.mappers;

import com.riwi.hero_training.application.dtos.requests.AuthUserRequestDto;
import com.riwi.hero_training.application.dtos.responses.AuthUserResponseDto;
import com.riwi.hero_training.domain.entities.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-03T10:55:17-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
public class AuthMapperImpl implements AuthMapper {

    @Override
    public UserEntity toEntity(AuthUserRequestDto authUserRequestDto) {
        if ( authUserRequestDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.password( authUserRequestDto.getPassword() );

        return userEntity.build();
    }

    @Override
    public AuthUserResponseDto toResponseDto(UserEntity userEntity, String token) {
        if ( userEntity == null && token == null ) {
            return null;
        }

        AuthUserResponseDto.AuthUserResponseDtoBuilder<?, ?> authUserResponseDto = AuthUserResponseDto.builder();

        if ( userEntity != null ) {
            authUserResponseDto.id( userEntity.getId() );
            authUserResponseDto.email( userEntity.getEmail() );
            if ( userEntity.getRole() != null ) {
                authUserResponseDto.role( userEntity.getRole().name() );
            }
        }
        authUserResponseDto.token( token );

        return authUserResponseDto.build();
    }
}
