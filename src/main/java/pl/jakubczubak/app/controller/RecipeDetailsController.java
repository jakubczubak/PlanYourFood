package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeDetailsController {
    @GetMapping("/recipe/details")
    public String getRecipeDetailsPage(){
        return "recipe-details";
    }
}
