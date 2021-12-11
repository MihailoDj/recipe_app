package com.mihailo.recipe_app.converters.ingredient;

import com.mihailo.recipe_app.commands.IngredientCommand;
import com.mihailo.recipe_app.converters.unit_of_measurement.UnitOfMeasurementToUnitOfMeasurementCommand;
import com.mihailo.recipe_app.model.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasurementToUnitOfMeasurementCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasurementToUnitOfMeasurementCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null)
            return null;

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setUnitOfMeasurement(uomConverter.convert(source.getUnitOfMeasurement()));

        return ingredientCommand;
    }
}
