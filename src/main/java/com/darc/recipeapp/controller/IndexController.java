package com.darc.recipeapp.controller;

import com.darc.recipeapp.domain.Category;
import com.darc.recipeapp.domain.UnitOfMeasure;
import com.darc.recipeapp.repositories.CategoryRepository;
import com.darc.recipeapp.repositories.UnitOfMeasureRepository;
import com.darc.recipeapp.service.RecipeService;
import com.darc.recipeapp.service.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String showIndex(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}