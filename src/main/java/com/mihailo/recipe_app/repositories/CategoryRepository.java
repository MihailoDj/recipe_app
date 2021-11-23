package com.mihailo.recipe_app.repositories;

import com.mihailo.recipe_app.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
