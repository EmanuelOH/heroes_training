package com.riwi.hero_training.application.dtos.responses;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MissionResponseDto {
    private Long id;
    private String title;
    private String description;
    private String difficulty;
    private Set<Long> requiredSkillIds;
}
