package com.darc.recipeapp.converters;

import com.darc.recipeapp.commands.NotesCommand;
import com.darc.recipeapp.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesCommandToNotesTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Notes";
    NotesCommandToNotes converter;

    @BeforeEach
    void setUp() {
        converter = new NotesCommandToNotes();
    }

    @Test
    void testNull() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject(){
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    void convert() {
        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        //when
        Notes notes = converter.convert(notesCommand);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }
}