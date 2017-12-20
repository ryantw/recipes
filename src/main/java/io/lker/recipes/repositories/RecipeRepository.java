package io.lker.recipes.repositories;

import io.lker.recipes.model.Recipe;
import org.springframework.data.repository.CrudRepository;
// CrudRepository implemented through Spring Data JPA
public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
