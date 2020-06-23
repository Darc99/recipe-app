package com.darc.recipeapp.controller;

import com.darc.recipeapp.domain.Category;
import com.darc.recipeapp.domain.UnitOfMeasure;
import com.darc.recipeapp.repositories.CategoryRepository;
import com.darc.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String showIndex() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");

        System.out.println("The Cat id is " + categoryOptional.get().getId());
        System.out.println("The Uom id is " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}