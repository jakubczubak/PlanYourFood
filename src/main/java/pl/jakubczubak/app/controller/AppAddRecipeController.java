package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppAddRecipeController {
    @GetMapping("/app/recipe/add")
    public String addRecipe(){
        return "app-add-recipe";
    }
}
