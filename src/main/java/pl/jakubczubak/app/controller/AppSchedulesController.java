package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppSchedulesController {
    @GetMapping("/app/plan/list")
    public String getAppRecipesPage () {
            return "app-schedules";
        }

    }
