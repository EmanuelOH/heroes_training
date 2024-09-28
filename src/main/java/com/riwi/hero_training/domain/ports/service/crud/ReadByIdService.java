package com.riwi.hero_training.domain.ports.service.crud;

public interface ReadByIdService <Entity, ID>{
    public Entity readById(ID id);
}
