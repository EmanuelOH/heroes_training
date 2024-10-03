package com.riwi.hero_training.infrastructure.persistence;

import com.riwi.hero_training.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsernameOrEmail(String name, String email);
}
