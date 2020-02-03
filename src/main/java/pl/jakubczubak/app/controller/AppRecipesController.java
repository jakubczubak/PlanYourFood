package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jakubczubak.app.model.Recipe;
import pl.jakubczubak.app.repository.RecipeRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class AppRecipesController {
    private RecipeRepository recipeRepository;

    public AppRecipesController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/app/recipe/list/")
    public String getAppRecipesPage(Model model, Principal principal) {
        List<Recipe> recipeList = recipeRepository.findAllByAdmin_Email(principal.getName());
        model.addAttribute("recipeList", recipeList);
        return "app-recipes";
    }

    @GetMapping("/app/recipe/list/delete/{id}")
    public String deleteRecipeById(@PathVariable Long id) {
        recipeRepository.delete(id);
        return "redirect:/app/recipe/list/";
    }

}
