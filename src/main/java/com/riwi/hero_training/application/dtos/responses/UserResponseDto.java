package com.riwi.hero_training.application.dtos.responses;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String role;
}
