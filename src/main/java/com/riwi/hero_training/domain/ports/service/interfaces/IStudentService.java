package com.riwi.hero_training.domain.ports.service.interfaces;

import com.riwi.hero_training.application.dtos.requests.StudentRequestDto;
import com.riwi.hero_training.application.dtos.responses.StudentResponseDto;
import com.riwi.hero_training.domain.entities.StudentEntity;
import com.riwi.hero_training.domain.ports.service.crud.*;

public interface IStudentService extends
        CreateService<StudentRequestDto, StudentEntity>,
        UpdateService<StudentRequestDto, StudentEntity, Long>,
        ReadAllService<StudentResponseDto>,
        ReadByIdService<StudentResponseDto, Long>,
        DeleteService<Long> {
}