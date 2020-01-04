package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppSchedulesMealRecipeController {
    @GetMapping("/app/schedulesmealrecipe/add")
    public String getAppSchedulesMealRecipePage(){
        return "app-schedules-meal-recipe";
    }
}
