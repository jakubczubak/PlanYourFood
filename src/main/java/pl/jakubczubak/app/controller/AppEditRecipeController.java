package pl.jakubczubak.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubczubak.app.model.Recipe;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.repository.RecipeRepository;
import pl.jakubczubak.app.repository.RecipeRepositoryCustomImpl;

import java.security.Principal;

@Controller
public class AppEditRecipeController {
    private RecipeRepositoryCustomImpl recipeRepositoryCustomImpl;
    private RecipeRepository recipeRepository;
    private AdminRepository adminRepository;

    public AppEditRecipeController(RecipeRepositoryCustomImpl recipeRepositoryCustomImpl, RecipeRepository recipeRepository, AdminRepository adminRepository) {
        this.recipeRepositoryCustomImpl = recipeRepositoryCustomImpl;
        this.recipeRepository = recipeRepository;
        this.adminRepository = adminRepository;
    }

    @GetMapping("app/recipe/edit/{id}")
    public String getRecipeEditPage(@PathVariable Long id, Model model) {
        Recipe recipe = recipeRepositoryCustomImpl.myCustomfindById(id);
        model.addAttribute("recipe", recipe);

        return "app-edit-recipe";
    }

    @PostMapping("app/recipe/edit")
    public String editRecipe(@ModelAttribute Recipe recipe, Principal principal) {
        recipe.setAdmin(adminRepository.findByEmail(principal.getName()));
        recipeRepository.save(recipe);

        return "redirect:/app/recipe/list/";
    }
}
