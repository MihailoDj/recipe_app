package com.mihailo.recipe_app.repositories;

import com.mihailo.recipe_app.model.UnitOfMeasurement;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasurementRepository extends CrudRepository<UnitOfMeasurement, Long> {
    Optional<UnitOfMeasurement> findByUnitOfMeasurement(String unitOfMeasurement);
}
