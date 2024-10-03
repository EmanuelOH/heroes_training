package com.riwi.hero_training.domain.ports.service.interfaces;

import com.riwi.hero_training.application.dtos.requests.MissionRequestDto;
import com.riwi.hero_training.application.dtos.responses.MissionResponseDto;
import com.riwi.hero_training.domain.entities.Mission;
import com.riwi.hero_training.domain.ports.service.crud.*;

public interface IMissionService extends
        CreateService<MissionRequestDto, Mission>,
        UpdateService<MissionRequestDto, Mission, Long>,
        ReadAllService<MissionResponseDto>,
        ReadByIdService<MissionResponseDto, Long>,
        DeleteService<Long> {

    public Mission evaluateMission(MissionRequestDto request, Long id);
}
