package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.jakubczubak.app.repository.PlanRepository;

@Controller
public class AppDetailsSchedulesController {
    private PlanRepository planRepository;

    public AppDetailsSchedulesController(PlanRepository planRepository){

        this.planRepository=planRepository;
    }
    @GetMapping("/app/schedule/details/{id}")
    public String getAppDetailsSchedulePage(@PathVariable Long id, Model model){



        return "app-details-schedules";
    }
}
