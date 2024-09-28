package com.riwi.hero_training.domain.ports.service.crud;

public interface CreateService<EntityRequest,Entity>{
    public Entity create(EntityRequest request);
}
