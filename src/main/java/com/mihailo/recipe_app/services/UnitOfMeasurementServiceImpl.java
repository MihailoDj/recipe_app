package com.mihailo.recipe_app.services;

import com.mihailo.recipe_app.commands.UnitOfMeasurementCommand;
import com.mihailo.recipe_app.converters.unit_of_measurement.UnitOfMeasurementToUnitOfMeasurementCommand;
import com.mihailo.recipe_app.repositories.UnitOfMeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasurementServiceImpl implements UnitOfMeasurementService {

    private final UnitOfMeasurementRepository unitOfMeasurementRepository;
    private final UnitOfMeasurementToUnitOfMeasurementCommand unitOfMeasurementToUnitOfMeasurementCommand;

    public UnitOfMeasurementServiceImpl(UnitOfMeasurementRepository unitOfMeasurementRepository, UnitOfMeasurementToUnitOfMeasurementCommand unitOfMeasurementToUnitOfMeasurementCommand) {
        this.unitOfMeasurementRepository = unitOfMeasurementRepository;
        this.unitOfMeasurementToUnitOfMeasurementCommand = unitOfMeasurementToUnitOfMeasurementCommand;
    }


    @Override
    public Set<UnitOfMeasurementCommand> listAllUnitsOfMeasurement() {

        return StreamSupport.stream(unitOfMeasurementRepository.findAll().spliterator(), false)
                .map(unitOfMeasurementToUnitOfMeasurementCommand::convert)
                .collect(Collectors.toSet());
    }
}
