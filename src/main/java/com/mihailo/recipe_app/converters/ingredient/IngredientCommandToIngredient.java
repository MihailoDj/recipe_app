package com.mihailo.recipe_app.converters.ingredient;

import com.mihailo.recipe_app.commands.IngredientCommand;
import com.mihailo.recipe_app.converters.unit_of_measurement.UnitOfMeasurementCommandToUnitOfMeasurement;
import com.mihailo.recipe_app.model.Ingredient;
import com.mihailo.recipe_app.model.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasurementCommandToUnitOfMeasurement uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasurementCommandToUnitOfMeasurement uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());

        if(source.getRecipeId() != null){
            Recipe recipe = new Recipe();
            recipe.setId(source.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredient(ingredient);
        }

        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUnitOfMeasurement(uomConverter.convert(source.getUnitOfMeasurement()));
        return ingredient;
    }
}
