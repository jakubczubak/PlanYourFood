package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppDetailsSchedulesController {
    @GetMapping("/app/schedule/details")
    public String getAppDetailsSchedulePage(){
        return "app-details-schedules";
    }
}
