package com.riwi.hero_training.infrastructure.persistence;

import com.riwi.hero_training.domain.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
