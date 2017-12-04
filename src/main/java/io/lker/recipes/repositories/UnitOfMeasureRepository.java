package io.lker.recipes.repositories;

import io.lker.recipes.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// Long id;
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
}
