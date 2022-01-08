package com.mihailo.recipe_app.bootstrap;

import com.mihailo.recipe_app.model.Category;
import com.mihailo.recipe_app.model.UnitOfMeasurement;
import com.mihailo.recipe_app.repositories.CategoryRepository;
import com.mihailo.recipe_app.repositories.UnitOfMeasurementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootstrapMySQL implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasurementRepository unitOfMeasureRepository;

    public BootstrapMySQL(CategoryRepository categoryRepository,
                          UnitOfMeasurementRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (categoryRepository.count() == 0L){
            log.debug("Loading Categories");
            loadCategories();
        }

        if (unitOfMeasureRepository.count() == 0L){
            log.debug("Loading UOMs");
            loadUom();
        }
    }

    private void loadCategories(){
        Category cat1 = new Category();
        cat1.setDescription("American");
        categoryRepository.save(cat1);

        Category cat2 = new Category();
        cat2.setDescription("Italian");
        categoryRepository.save(cat2);

        Category cat3 = new Category();
        cat3.setDescription("Mexican");
        categoryRepository.save(cat3);

        Category cat4 = new Category();
        cat4.setDescription("Fast Food");
        categoryRepository.save(cat4);
    }

    private void loadUom(){
        UnitOfMeasurement uom1 = new UnitOfMeasurement();
        uom1.setUnitOfMeasurement("Teaspoon");
        unitOfMeasureRepository.save(uom1);

        UnitOfMeasurement uom2 = new UnitOfMeasurement();
        uom2.setUnitOfMeasurement("Tablespoon");
        unitOfMeasureRepository.save(uom2);

        UnitOfMeasurement uom3 = new UnitOfMeasurement();
        uom3.setUnitOfMeasurement("Cup");
        unitOfMeasureRepository.save(uom3);

        UnitOfMeasurement uom4 = new UnitOfMeasurement();
        uom4.setUnitOfMeasurement("Pinch");
        unitOfMeasureRepository.save(uom4);

        UnitOfMeasurement uom5 = new UnitOfMeasurement();
        uom5.setUnitOfMeasurement("Ounce");
        unitOfMeasureRepository.save(uom5);

        UnitOfMeasurement uom6 = new UnitOfMeasurement();
        uom6.setUnitOfMeasurement("Each");
        unitOfMeasureRepository.save(uom6);

        UnitOfMeasurement uom7 = new UnitOfMeasurement();
        uom7.setUnitOfMeasurement("Pint");
        unitOfMeasureRepository.save(uom7);

        UnitOfMeasurement uom8 = new UnitOfMeasurement();
        uom8.setUnitOfMeasurement("Dash");
        unitOfMeasureRepository.save(uom8);
    }
}
