package com.mihailo.recipe_app.repositories;

import com.mihailo.recipe_app.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
