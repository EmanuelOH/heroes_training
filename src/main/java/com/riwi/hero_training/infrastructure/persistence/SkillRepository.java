package com.riwi.hero_training.infrastructure.persistence;

import com.riwi.hero_training.domain.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
