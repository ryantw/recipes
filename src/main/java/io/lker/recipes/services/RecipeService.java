package io.lker.recipes.services;

import io.lker.recipes.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
