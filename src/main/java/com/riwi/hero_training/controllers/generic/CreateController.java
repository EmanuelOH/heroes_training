package com.riwi.hero_training.controllers.generic;

import org.springframework.http.ResponseEntity;

public interface CreateController <EntityRequest, Entity>{
    public ResponseEntity<Entity> create (EntityRequest request);
}
