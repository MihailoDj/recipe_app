package com.mihailo.recipe_app.converters.unit_of_measurement;

import com.mihailo.recipe_app.commands.UnitOfMeasurementCommand;
import com.mihailo.recipe_app.model.UnitOfMeasurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasurementCommandToUnitOfMeasurementTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    UnitOfMeasurementCommandToUnitOfMeasurement converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasurementCommandToUnitOfMeasurement();
    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasurementCommand()));
    }

    @Test
    void convert() throws Exception {
        UnitOfMeasurementCommand command = new UnitOfMeasurementCommand();
        command.setId(LONG_VALUE);
        command.setUnitOfMeasurement(DESCRIPTION);

        UnitOfMeasurement uom = converter.convert(command);

        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getUnitOfMeasurement());
    }
}