package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppEditRecipeController {
    @GetMapping("app/recipe/edit")
    public String getRecipeEditPage(){
        return "app-edit-recipe";
    }
}
