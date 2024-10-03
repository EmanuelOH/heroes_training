package com.riwi.hero_training.controllers.implement;

import com.riwi.hero_training.application.dtos.requests.UserRequestDto;
import com.riwi.hero_training.application.dtos.responses.AuthUserResponseDto;
import com.riwi.hero_training.application.dtos.responses.UserResponseDto;
import com.riwi.hero_training.controllers.interfaces.IUserController;
import com.riwi.hero_training.domain.entities.UserEntity;
import com.riwi.hero_training.domain.enums.Roles;
import com.riwi.hero_training.domain.ports.service.interfaces.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
@Tag(name = "User", description = "Manage user-related request.")
@CrossOrigin("*") // Esto permite peticiones de diferentes orígenes
public class UserControllerImpl implements IUserController {
    @Autowired
    private final IUserService userService;

    @SecurityRequirement(name = "bearerAuth") // Requiere una autentificacion JWT
    @PostMapping("register/admin")
    @Operation(
            summary = "Create an admin", //Describcion breve de la operacion que se hara
            description = "Provides the user data to create it and token to validate the permissions." // Descripcion detallada
    )
    @Override
    public ResponseEntity<AuthUserResponseDto> registerAdmin(@Validated @RequestBody UserRequestDto requestDto) {
        return ResponseEntity.ok(this.userService.register(requestDto, Roles.ADMIN));
    }

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("register/teacher")
    @Operation(
            summary = "Create a teacher.",
            description = "Provides the user data to create a teacher and the token to validate the permissions."
    )
    @Override
    public ResponseEntity<AuthUserResponseDto> registerTeacher(@Validated @RequestBody UserRequestDto requestDto) {
        return ResponseEntity.ok(this.userService.register(requestDto, Roles.TEACHER));
    }

    @PostMapping("register/student")
    @Operation(
            summary = "Create a student.",
            description = "Provides the user data to create a student."
    )
    @Override
    public ResponseEntity<AuthUserResponseDto> registerStudent(@Validated @RequestBody UserRequestDto requestDto) {
        return ResponseEntity.ok(this.userService.register(requestDto, Roles.STUDENT));
    }


    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a user",
            description = "Delete a user by their ID, requiring authentication."
    )
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/readALl")
    @Operation(
            summary = "List all users.",
            description = "Provide the token to validate the permissions and obtain the list of users."
    )
    @Override
    public ResponseEntity<List<UserResponseDto>> readAll() {
        return ResponseEntity.ok(this.userService.readAll());
    }


    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("{id}")
    @Operation(
            summary = "Get user by ID.",
            description = "Retrieve a user's details by their ID, with proper authentication."
    )
    @Override
    public ResponseEntity<UserResponseDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.readById(id));
    }

    @SecurityRequirement(name = "bearerAuth")
    @PutMapping("{id}")
    @Operation(
            summary = "Update user by ID.",
            description = "Update a user's details by their ID, requiring authentication."
    )
    @Override
    public ResponseEntity<UserEntity> update(@Validated @PathVariable UserRequestDto requestDto,
                                             @PathVariable Long id) {
        return ResponseEntity.ok(this.userService.update(requestDto, id));
    }
}
