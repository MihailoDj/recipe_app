package com.mihailo.recipe_app.converters.unit_of_measurement;

import com.mihailo.recipe_app.commands.UnitOfMeasurementCommand;
import com.mihailo.recipe_app.model.UnitOfMeasurement;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasurementToUnitOfMeasurementCommand implements Converter<UnitOfMeasurement, UnitOfMeasurementCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasurementCommand convert(UnitOfMeasurement source) {
        if (source == null)
            return null;

        final UnitOfMeasurementCommand uomCommand = new UnitOfMeasurementCommand();
        uomCommand.setId(source.getId());
        uomCommand.setUnitOfMeasurement(source.getUnitOfMeasurement());
        return uomCommand;
    }
}
