package com.riwi.hero_training.application.dtos.responses;

import com.riwi.hero_training.application.dtos.requests.UserRequestDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
public class AuthUserResponseDto extends UserResponseDto {
    private String message; // validar y comprbar que los roles funcionen
    private String token;
}
