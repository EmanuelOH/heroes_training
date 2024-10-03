package com.riwi.hero_training.controllers.generic;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReadAllController <Entity>{
    public ResponseEntity<List<Entity>> readAll();
}
