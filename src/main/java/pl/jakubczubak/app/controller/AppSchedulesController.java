package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.repository.PlanRepository;

import java.util.List;

@Controller
public class AppSchedulesController {
    private PlanRepository planRepository;
    public AppSchedulesController(PlanRepository planRepository){
        this.planRepository=planRepository;
    }
    @GetMapping("/app/plan/list")
    public String getAppRecipesPage (Model model) {
        List<Plan> planList = planRepository.findAll();
        model.addAttribute("planList", planList);
            return "app-schedules";
        }

    }
