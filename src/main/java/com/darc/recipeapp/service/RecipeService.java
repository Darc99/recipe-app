package com.darc.recipeapp.service;

import com.darc.recipeapp.commands.RecipeCommand;
import com.darc.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
