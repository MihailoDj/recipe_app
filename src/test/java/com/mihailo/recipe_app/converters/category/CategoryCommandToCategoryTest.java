package com.mihailo.recipe_app.converters.category;

import com.mihailo.recipe_app.commands.CategoryCommand;
import com.mihailo.recipe_app.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    CategoryCommandToCategory converter;


    @BeforeEach
    void setUp() throws Exception{
        converter = new CategoryCommandToCategory();
    }

    @Test
    void testNullObject() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    void convert() {
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        Category category = converter.convert(categoryCommand);

        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}