package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipesController {
    @GetMapping("/recipes")
    public String getRecipePage(){
        return "recipes";
    }
}
