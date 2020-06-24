package com.darc.recipeapp.bootstrap;

import com.darc.recipeapp.domain.*;
import com.darc.recipeapp.repositories.CategoryRepository;
import com.darc.recipeapp.repositories.RecipeRepository;
import com.darc.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if (!tablespoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if (!teaspoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if (!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure>pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if (!pintUomOptional.isPresent()) {
            throw new RuntimeException("Expected Uom not found");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if (!cupUomOptional.isPresent()) {
            throw new RuntimeException("Expected Uom not found");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tablespoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaspoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();

        //get categories
        Optional<Category> americanOptional = categoryRepository.findByDescription("American");

        if (!americanOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> mexicanOptional = categoryRepository.findByDescription("Mexican");

        if (!mexicanOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Category americanCat = americanOptional.get();
        Category mexicanCat = mexicanOptional.get();

        //Yummy Guac
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("");

        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(5), teaSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("fresh lime juice", new BigDecimal(2), tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("mined red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("serano chillies, stems and seeds removed, minced", new BigDecimal(2), eachUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Cilantro", new BigDecimal(2), tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(5), eachUom, guacRecipe));

        guacRecipe.getCategories().add(americanCat);
        guacRecipe.getCategories().add(mexicanCat);

        //add to return list
        recipes.add(guacRecipe);

        //Yummy Tacos
        Recipe tacoRecipe = new Recipe();
        tacoRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacoRecipe.setCookTime(9);
        tacoRecipe.setPrepTime(20);
        tacoRecipe.setDifficulty(Difficulty.MODERATE);

        tacoRecipe.setDirections("");

        Notes tacoNotes = new Notes();

        tacoNotes.setRecipeNotes("");

        tacoNotes.setRecipe(tacoRecipe);
        tacoRecipe.setNotes(tacoNotes);


        tacoRecipe.getIngredients().add(new Ingredient("Ancho chilli pepper", new BigDecimal(2), tableSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("Dried Oregano", new BigDecimal(1), teaSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("Dried Cumin", new BigDecimal(1), teaSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("Sugar", new BigDecimal(1), teaSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("Salt", new BigDecimal(5), tableSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("Clove of garlic, chopped", new BigDecimal(1), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("finely grated orange zestr", new BigDecimal(1), tableSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("fresh squeezed orange juice", new BigDecimal(3), tableSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("Olive", new BigDecimal(2), tableSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("Boneless chicken thighs", new BigDecimal(4), tableSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("small corn tortillas", new BigDecimal(8), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("packed baby arugula", new BigDecimal(3), cupUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("medium ripe avocado, sliced", new BigDecimal(2), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("cherry tomatoes, halved", new BigDecimal(5), pintUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("red onion thinly sliced", new BigDecimal(25), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("roughly chopped cilantro", new BigDecimal(4), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cupUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("lime, cut into wedges", new BigDecimal(4), eachUom, tacoRecipe));

        tacoRecipe.getCategories().add(americanCat);
        tacoRecipe.getCategories().add(mexicanCat);

        recipes.add(tacoRecipe);
        return recipes;
    }

}
