package com.riwi.hero_training.application.mappers;

import com.riwi.hero_training.application.dtos.requests.SkillRequestDto;
import com.riwi.hero_training.application.dtos.responses.SkillResponseDto;
import com.riwi.hero_training.domain.entities.Skill;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-03T10:55:17-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
public class SkillMapperImpl implements SkillMapper {

    @Override
    public Skill toEntity(SkillRequestDto skillRequestDto) {
        if ( skillRequestDto == null ) {
            return null;
        }

        Skill.SkillBuilder skill = Skill.builder();

        return skill.build();
    }

    @Override
    public SkillResponseDto toResponseDto(Skill skill) {
        if ( skill == null ) {
            return null;
        }

        SkillResponseDto.SkillResponseDtoBuilder skillResponseDto = SkillResponseDto.builder();

        skillResponseDto.id( skill.getId() );

        return skillResponseDto.build();
    }
}
