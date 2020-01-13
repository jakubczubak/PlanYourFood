package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.jakubczubak.app.model.Recipe;
import pl.jakubczubak.app.repository.RecipeRepository;
import pl.jakubczubak.app.repository.RecipeRepositoryCustomImpl;

@Controller
public class RecipeDetailsController {
    private RecipeRepository recipeRepository;
    private RecipeRepositoryCustomImpl recipeRepositoryCustomImpl;
    public RecipeDetailsController(RecipeRepository recipeRepository, RecipeRepositoryCustomImpl recipeRepositoryCustomImpl){
        this.recipeRepository=recipeRepository;
        this.recipeRepositoryCustomImpl=recipeRepositoryCustomImpl;
    }
    @GetMapping("/recipe/details/{id}")
    public String getRecipeDetailsPage(@PathVariable Long id, Model model){
        Recipe recipe = recipeRepositoryCustomImpl.myCustomfindById(id);
        model.addAttribute("recipe",recipe);
        return "recipe-details";
    }
}
