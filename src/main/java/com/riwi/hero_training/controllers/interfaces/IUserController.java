package com.riwi.hero_training.controllers.interfaces;

import com.riwi.hero_training.application.dtos.requests.UserRequestDto;
import com.riwi.hero_training.application.dtos.responses.AuthUserResponseDto;
import com.riwi.hero_training.application.dtos.responses.UserResponseDto;
import com.riwi.hero_training.controllers.generic.DeleteController;
import com.riwi.hero_training.controllers.generic.ReadAllController;
import com.riwi.hero_training.controllers.generic.ReadByIdController;
import com.riwi.hero_training.controllers.generic.UpdateController;
import com.riwi.hero_training.domain.entities.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IUserController extends
        UpdateController<UserRequestDto, UserEntity, Long>,
        ReadAllController<UserResponseDto>,
        ReadByIdController<UserResponseDto, Long>,
        DeleteController<Long> {
    public ResponseEntity<AuthUserResponseDto> registerAdmin(UserRequestDto requestDto);
    public ResponseEntity<AuthUserResponseDto> registerTeacher(UserRequestDto requestDto);

    public ResponseEntity<AuthUserResponseDto> registerStudent(UserRequestDto requestDto);
}
