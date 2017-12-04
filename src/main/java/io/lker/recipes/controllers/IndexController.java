package io.lker.recipes.controllers;

import io.lker.recipes.model.Category;
import io.lker.recipes.model.UnitOfMeasure;
import io.lker.recipes.repositories.CategoryRepository;
import io.lker.recipes.repositories.UnitOfMeasureRepository;
import io.lker.recipes.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

}
