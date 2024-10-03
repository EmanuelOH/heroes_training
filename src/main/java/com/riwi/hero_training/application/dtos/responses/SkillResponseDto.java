package com.riwi.hero_training.application.dtos.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkillResponseDto {
    private Long id;
    private String skill;
}
