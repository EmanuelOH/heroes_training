package com.riwi.hero_training.controllers.implement;

import com.riwi.hero_training.application.dtos.requests.SkillRequestDto;
import com.riwi.hero_training.application.dtos.responses.SkillResponseDto;
import com.riwi.hero_training.controllers.interfaces.ISkillController;
import com.riwi.hero_training.domain.entities.Skill;
import com.riwi.hero_training.domain.ports.service.interfaces.ISkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skills")
@AllArgsConstructor
@Tag(name = "Skill", description = "Manages skills-related requests.")
@CrossOrigin("*")
public class SkillControllerImpl implements ISkillController {
    @Autowired
    private final ISkillService skillService;


    @SecurityRequirement(name = "bearerAuth") // Requiere autenticación Bearer
    @PostMapping // Ruta para crear una nueva habilidad
    @Operation(
            summary = "Create a new skill.",
            description = "Provides the skill data to create a new skill."
    )
    @Override
    public ResponseEntity<Skill> create(SkillRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.skillService.create(request));
    }

    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("{id}")
    @Operation(
            summary = "Delete a skill.",
            description = "Deletes a skill with the specified ID."
    )
    @Override
    public ResponseEntity<Void> delete(Long id) {
        this.skillService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping
    @Operation(
            summary = "Get all skills.",
            description = "Returns a list of all skills."
    )
    @Override
    public ResponseEntity<List<SkillResponseDto>> readAll() {
        return ResponseEntity.ok(this.skillService.readAll());
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("{id}")
    @Operation(
            summary = "Get all skills.",
            description = "Returns a list of all skills."
    )
    @Override
    public ResponseEntity<SkillResponseDto> readById(Long id) {
        return ResponseEntity.ok(this.skillService.readById(id));
    }

    @SecurityRequirement(name = "bearerAuth")
    @PatchMapping("{id}")
    @Operation(
            summary = "Update a skill.",
            description = "Updates an existing skill with the specified ID."
    )
    @Override
    public ResponseEntity<Skill> update(SkillRequestDto request, Long id) {
        return ResponseEntity.ok(this.skillService.update(request,id));
    }
}
