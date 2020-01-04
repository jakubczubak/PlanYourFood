package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppRecipeDetailsController {
    @GetMapping("/app/recipe/details")
    public String getAppRecipeDetailsPage(){
        return "app-recipe-details";
    }
}
