package com.mihailo.recipe_app.services;

import com.mihailo.recipe_app.commands.UnitOfMeasurementCommand;

import java.util.Set;

public interface UnitOfMeasurementService {
    Set<UnitOfMeasurementCommand> listAllUnitsOfMeasurement();
}
