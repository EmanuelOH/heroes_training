package com.riwi.hero_training.controllers.implement;

import com.riwi.hero_training.application.dtos.requests.MissionRequestDto;
import com.riwi.hero_training.application.dtos.responses.MissionResponseDto;
import com.riwi.hero_training.controllers.interfaces.IMissionController;
import com.riwi.hero_training.domain.entities.Mission;
import com.riwi.hero_training.domain.ports.service.interfaces.IMissionService;
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
@RequestMapping("missions")
@AllArgsConstructor
@Tag(name = "Mission", description = "Manages mission-related requests.")
@CrossOrigin("*")
public class MissionControllerImpl implements IMissionController {
    @Autowired
    private final IMissionService missionService;


    @SecurityRequirement(name = "bearerAuth")
    @PostMapping
    @Operation(
            summary = "Create a new mission.",
            description = "Provides the mission data to create a new mission."
    )
    @Override
    public ResponseEntity<Mission> create(MissionRequestDto requestDto) {
        Mission createdMission = missionService.create(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMission);
    }

    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("{id}")
    @Operation(
            summary = "Delete a mission",
            description = "Deletes a mission with the specified ID."
    )
    @Override
    public ResponseEntity<Void> delete(Long id) {
        missionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(
            summary = "Get all missions",
            description = "Returns a list of all missions."
    )
    @Override
    public ResponseEntity<List<MissionResponseDto>> readAll() {
        return ResponseEntity.ok(this.missionService.readAll());
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Get a mission by ID",
            description = "Returns a mission with the specified ID."
    )
    @Override
    public ResponseEntity<MissionResponseDto> readById(Long id) {
        return ResponseEntity.ok(this.missionService.readById(id));
    }


    @PatchMapping("{id}")
    @Operation(
            summary = "Update a mission",
            description = "Updates an existing mission with the specified ID."
    )
    @Override
    public ResponseEntity<Mission> update(MissionRequestDto requestDto, Long id) {
        return ResponseEntity.ok(this.missionService.evaluateMission(requestDto, id));
    }
}
