package com.riwi.hero_training.controllers.interfaces;

import com.riwi.hero_training.application.dtos.requests.MissionRequestDto;
import com.riwi.hero_training.application.dtos.responses.MissionResponseDto;
import com.riwi.hero_training.controllers.generic.*;
import com.riwi.hero_training.domain.entities.Mission;

public interface IMissionController extends
        CreateController<MissionRequestDto, Mission>,
        UpdateController<MissionRequestDto, Mission, Long>,
        ReadAllController<MissionResponseDto>,
        ReadByIdController<MissionResponseDto, Long>,
        DeleteController<Long> {
}
