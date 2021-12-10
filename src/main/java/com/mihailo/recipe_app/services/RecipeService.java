package com.mihailo.recipe_app.services;

import com.mihailo.recipe_app.commands.RecipeCommand;
import com.mihailo.recipe_app.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
