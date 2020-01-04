package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppAddScheduleController {
    @GetMapping("/app/schedule/add")
    public String addRecipe(){
        return "app-add-schedules";
    }
}
