package com.riwi.hero_training.application.mappers;

import com.riwi.hero_training.application.dtos.requests.MissionRequestDto;
import com.riwi.hero_training.application.dtos.responses.MissionResponseDto;
import com.riwi.hero_training.domain.entities.Mission;
import com.riwi.hero_training.domain.enums.Difficulty;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-03T10:55:17-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
public class MissionMapperImpl implements MissionMapper {

    @Override
    public Mission toEntity(MissionRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Mission.MissionBuilder mission = Mission.builder();

        mission.name( requestDto.getName() );
        mission.description( requestDto.getDescription() );
        if ( requestDto.getDifficulty() != null ) {
            mission.difficulty( Enum.valueOf( Difficulty.class, requestDto.getDifficulty() ) );
        }
        mission.evaluate( requestDto.getEvaluate() );

        return mission.build();
    }

    @Override
    public MissionResponseDto toResponseDto(Mission mission) {
        if ( mission == null ) {
            return null;
        }

        MissionResponseDto.MissionResponseDtoBuilder missionResponseDto = MissionResponseDto.builder();

        missionResponseDto.id( mission.getId() );
        missionResponseDto.description( mission.getDescription() );
        if ( mission.getDifficulty() != null ) {
            missionResponseDto.difficulty( mission.getDifficulty().name() );
        }
        missionResponseDto.evaluate( mission.getEvaluate() );

        return missionResponseDto.build();
    }
}
