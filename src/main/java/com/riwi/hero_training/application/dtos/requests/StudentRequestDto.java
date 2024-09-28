package com.riwi.hero_training.application.dtos.requests;


import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequestDto {
    private Long userId;
    private Set<Long> skillIds;
}
