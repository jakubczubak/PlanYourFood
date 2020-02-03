package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.model.Recipe;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.repository.RecipeRepository;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class AppAddRecipeController {

    RecipeRepository recipeRepository;
    AdminRepository adminRepository;

    public AppAddRecipeController(RecipeRepository recipeRepository, AdminRepository adminRepository) {
        this.recipeRepository = recipeRepository;
        this.adminRepository = adminRepository;
    }

    @GetMapping("/app/recipe/add")
    public String addRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "app-add-recipe";
    }

    @PostMapping("/app/recipe/add")
    public String addRecipe(@Valid @ModelAttribute Recipe recipe, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "app-add-recipe";
        }
        recipe.setAdmin(adminRepository.findByEmail(principal.getName()));
        recipeRepository.save(recipe);
        return "redirect:/app/recipe/list/";
    }
}
