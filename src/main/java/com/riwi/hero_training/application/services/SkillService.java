package com.riwi.hero_training.application.services;

import com.riwi.hero_training.application.dtos.requests.SkillRequestDto;
import com.riwi.hero_training.application.dtos.responses.SkillResponseDto;
import com.riwi.hero_training.application.mappers.SkillMapper;
import com.riwi.hero_training.domain.entities.Skill;
import com.riwi.hero_training.domain.ports.service.interfaces.ISkillService;
import com.riwi.hero_training.infrastructure.persistence.SkillRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillService implements ISkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillMapper skillMapper;

    @Override
    public Skill create(SkillRequestDto request) {
        Skill skill = skillMapper.toEntity(request);
        return skillRepository.save(skill);
    }

    @Override
    public Skill update(SkillRequestDto request, Long id) {
        Optional<Skill> existingSkill = skillRepository.findById(id);
        if (existingSkill.isPresent()) {
            Skill skill = existingSkill.get();
            skill.setSkill(request.getName());
            return skillRepository.save(skill);
        }
        throw new EntityNotFoundException("Skill not found with id: " + id);
    }

    @Override
    public List<SkillResponseDto> readAll() {
        List<Skill> skills = skillRepository.findAll();

        return skills.stream()
                .map(skillMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public SkillResponseDto readById(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Skill not found with id: " + id));
        return skillMapper.toResponseDto(skill);
    }

    @Override
    public void delete(Long id) {
        if (!skillRepository.existsById(id)) {
            throw new EntityNotFoundException("Skill not found with id: " + id);
        }
        skillRepository.deleteById(id);
    }
}
