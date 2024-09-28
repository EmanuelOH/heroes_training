package com.riwi.hero_training.infrastructure.persistence;

import com.riwi.hero_training.domain.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
