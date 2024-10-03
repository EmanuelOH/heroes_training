package com.riwi.hero_training.controllers.interfaces;

import com.riwi.hero_training.application.dtos.requests.SkillRequestDto;
import com.riwi.hero_training.application.dtos.responses.SkillResponseDto;
import com.riwi.hero_training.controllers.generic.*;
import com.riwi.hero_training.domain.entities.Skill;

public interface ISkillController extends
        CreateController<SkillRequestDto, Skill>,
        UpdateController<SkillRequestDto, Skill, Long>,
        ReadAllController<SkillResponseDto>,
        ReadByIdController<SkillResponseDto, Long>,
        DeleteController<Long> {
}
