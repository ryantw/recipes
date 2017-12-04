package io.lker.recipes.repositories;

import io.lker.recipes.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// Long for the id that we used
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
