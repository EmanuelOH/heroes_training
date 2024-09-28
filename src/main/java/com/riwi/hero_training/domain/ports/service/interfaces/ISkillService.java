package com.riwi.hero_training.domain.ports.service.interfaces;

import com.riwi.hero_training.application.dtos.requests.SkillRequestDto;
import com.riwi.hero_training.application.dtos.responses.SkillResponseDto;
import com.riwi.hero_training.domain.entities.Skill;
import com.riwi.hero_training.domain.ports.service.crud.*;

public interface ISkillService extends
        CreateService<SkillRequestDto, Skill>,
        UpdateService<SkillRequestDto, Skill, Long>,
        ReadAllService<SkillResponseDto>,
        ReadByIdService<SkillResponseDto, Long>,
        DeleteService<Long> {
}