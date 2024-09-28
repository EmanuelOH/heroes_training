package com.riwi.hero_training.application.mappers;

import com.riwi.hero_training.application.dtos.requests.MissionRequestDto;
import com.riwi.hero_training.application.dtos.responses.MissionResponseDto;
import com.riwi.hero_training.domain.entities.Mission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MissionMapper {
    MissionMapper INSTANCE = Mappers.getMapper(MissionMapper.class);

    public Mission toEntity(MissionRequestDto requestDto);

    public MissionResponseDto toResponseDto(Mission mission);
}
