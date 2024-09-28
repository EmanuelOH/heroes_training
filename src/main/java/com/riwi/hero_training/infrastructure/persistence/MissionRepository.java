package com.riwi.hero_training.infrastructure.persistence;

import com.riwi.hero_training.domain.entities.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
