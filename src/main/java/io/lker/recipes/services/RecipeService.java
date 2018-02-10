package io.lker.recipes.services;

import io.lker.recipes.commands.RecipeCommand;
import io.lker.recipes.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
