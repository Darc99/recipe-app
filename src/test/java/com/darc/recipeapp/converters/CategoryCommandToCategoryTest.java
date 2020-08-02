package com.darc.recipeapp.converters;

import com.darc.recipeapp.commands.CategoryCommand;
import com.darc.recipeapp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";
    CategoryCommandToCategory ctcc;

    @BeforeEach
    void setUp() {
        ctcc = new CategoryCommandToCategory();
    }

    @Test
    void testNullObject() {
        assertNull(ctcc.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(ctcc.convert(new CategoryCommand()));
    }

    @Test
    void convert() {

        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = ctcc
                .convert(categoryCommand);

        //then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}