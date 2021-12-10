package com.mihailo.recipe_app.converters.unit_of_measurement;

import com.mihailo.recipe_app.commands.UnitOfMeasurementCommand;
import com.mihailo.recipe_app.model.UnitOfMeasurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasurementToUnitOfMeasurementCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    UnitOfMeasurementToUnitOfMeasurementCommand converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasurementToUnitOfMeasurementCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasurement()));
    }

    @Test
    void convert() throws Exception {
        UnitOfMeasurement uom = new UnitOfMeasurement();
        uom.setId(LONG_VALUE);
        uom.setUnitOfMeasurement(DESCRIPTION);

        UnitOfMeasurementCommand uomc = converter.convert(uom);

        assertEquals(LONG_VALUE, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getUnitOfMeasurement());
    }
}