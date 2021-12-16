package com.mihailo.recipe_app.services;

import com.mihailo.recipe_app.commands.UnitOfMeasurementCommand;
import com.mihailo.recipe_app.converters.unit_of_measurement.UnitOfMeasurementToUnitOfMeasurementCommand;
import com.mihailo.recipe_app.model.UnitOfMeasurement;
import com.mihailo.recipe_app.repositories.UnitOfMeasurementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UnitOfMeasurementServiceImplTest {

    UnitOfMeasurementToUnitOfMeasurementCommand unitOfMeasureToUnitOfMeasureCommand =
            new UnitOfMeasurementToUnitOfMeasurementCommand();
    UnitOfMeasurementService service;

    @Mock
    UnitOfMeasurementRepository unitOfMeasureRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        service = new UnitOfMeasurementServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUnitsOfMeasurement() throws Exception {

        Set<UnitOfMeasurement> unitOfMeasures = new HashSet<>();
        UnitOfMeasurement uom1 = new UnitOfMeasurement();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);

        UnitOfMeasurement uom2 = new UnitOfMeasurement();
        uom2.setId(2L);
        unitOfMeasures.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        Set<UnitOfMeasurementCommand> commands = service.listAllUnitsOfMeasurement();

        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository, times(1)).findAll();
    }

}