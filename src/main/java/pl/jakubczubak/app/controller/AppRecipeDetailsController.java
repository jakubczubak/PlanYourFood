package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.jakubczubak.app.model.Recipe;
import pl.jakubczubak.app.repository.RecipeRepository;
import pl.jakubczubak.app.repository.RecipeRepositoryCustomImpl;

@Controller
public class AppRecipeDetailsController {
    private RecipeRepositoryCustomImpl recipeRepositoryCustomImpl;

    public AppRecipeDetailsController(RecipeRepositoryCustomImpl recipeRepositoryCustomImpl) {
        this.recipeRepositoryCustomImpl = recipeRepositoryCustomImpl;
    }

    @GetMapping("/app/recipe/details/{id}")
    public String getAppRecipeDetailsPage(@PathVariable Long id, Model model) {
        Recipe recipe = recipeRepositoryCustomImpl.myCustomfindById(id);
        model.addAttribute("recipe", recipe);
        return "app-recipe-details";
    }
}
