package com.darc.recipeapp.converters;

import com.darc.recipeapp.commands.CategoryCommand;
import com.darc.recipeapp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "descript";
    CategoryToCategoryCommand ctcc;

    @BeforeEach
    void setUp() {
        ctcc = new CategoryToCategoryCommand();
    }

    @Test
    void testNullObject() {
        assertNull(ctcc.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(ctcc.convert(new Category()));
    }

    @Test
    void convert() {

        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = ctcc.convert(category);

        //then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());

    }
}