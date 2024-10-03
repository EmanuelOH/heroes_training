package com.riwi.hero_training.controllers.generic;

import org.springframework.http.ResponseEntity;

public interface ReadByIdController <Entity, ID>{
    public ResponseEntity<Entity> readById(ID id);
}
