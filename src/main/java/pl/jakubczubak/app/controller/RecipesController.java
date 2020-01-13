package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jakubczubak.app.model.Recipe;
import pl.jakubczubak.app.repository.RecipeRepository;

import java.util.List;

@Controller
public class RecipesController {
    private RecipeRepository recipeRepository;

    public RecipesController(RecipeRepository recipeRepository){
        this.recipeRepository=recipeRepository;
    }
    @GetMapping("/recipes")
    public String getRecipePage(Model model){
        List<Recipe> recipeList = recipeRepository.findAll();
        model.addAttribute("recipeList", recipeList);
        return "recipes";
    }
}
