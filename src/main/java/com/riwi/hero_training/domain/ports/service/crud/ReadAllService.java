package com.riwi.hero_training.domain.ports.service.crud;

import java.util.List;

public interface ReadAllService<Entity>{
    public List<Entity> readAll();
}
