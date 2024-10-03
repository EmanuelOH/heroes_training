package com.riwi.hero_training.application.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkillRequestDto {
    @NotBlank(message = "Skill name cannot be blank")
    private String skill;
}
