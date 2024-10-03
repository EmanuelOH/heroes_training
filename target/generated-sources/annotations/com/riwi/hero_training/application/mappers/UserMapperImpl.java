package com.riwi.hero_training.application.mappers;

import com.riwi.hero_training.application.dtos.requests.UserRequestDto;
import com.riwi.hero_training.application.dtos.responses.UserResponseDto;
import com.riwi.hero_training.domain.entities.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-03T10:55:17-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.email( userRequestDto.getEmail() );
        userEntity.password( userRequestDto.getPassword() );

        return userEntity.build();
    }

    @Override
    public UserResponseDto toResponseDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponseDto.UserResponseDtoBuilder<?, ?> userResponseDto = UserResponseDto.builder();

        userResponseDto.id( userEntity.getId() );
        userResponseDto.email( userEntity.getEmail() );
        if ( userEntity.getRole() != null ) {
            userResponseDto.role( userEntity.getRole().name() );
        }

        return userResponseDto.build();
    }
}
