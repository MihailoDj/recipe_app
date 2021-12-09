package com.mihailo.recipe_app.converters.unit_of_measurement;

import com.mihailo.recipe_app.commands.UnitOfMeasurementCommand;
import com.mihailo.recipe_app.model.UnitOfMeasurement;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasurementCommandToUnitOfMeasurement implements Converter<UnitOfMeasurementCommand, UnitOfMeasurement> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasurement convert(UnitOfMeasurementCommand source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasurement uom = new UnitOfMeasurement();
        uom.setId(source.getId());
        uom.setUnitOfMeasurement(source.getUnitOfMeasurement());
        return uom;
    }
}
