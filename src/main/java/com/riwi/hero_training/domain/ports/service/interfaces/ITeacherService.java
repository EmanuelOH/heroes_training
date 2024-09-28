package com.riwi.hero_training.domain.ports.service.interfaces;

import com.riwi.hero_training.application.dtos.requests.TeacherRequestDto;
import com.riwi.hero_training.application.dtos.responses.TeacherResponseDto;
import com.riwi.hero_training.domain.entities.TeacherEntity;
import com.riwi.hero_training.domain.ports.service.crud.*;

public interface ITeacherService extends
        CreateService<TeacherRequestDto, TeacherEntity>,
        UpdateService<TeacherRequestDto, TeacherEntity, Long>,
        ReadAllService<TeacherResponseDto>,
        ReadByIdService<TeacherResponseDto, Long>,
        DeleteService<Long> {
}