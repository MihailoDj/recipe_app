package com.mihailo.recipe_app.services;

import com.mihailo.recipe_app.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
