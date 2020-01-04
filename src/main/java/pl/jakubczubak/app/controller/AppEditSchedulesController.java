package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppEditSchedulesController {
    @GetMapping("/app/schedule/edit")
    public String getAppEditSchedulePage(){
        return "app-edit-schedules";
    }
}
