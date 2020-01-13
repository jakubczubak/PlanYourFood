package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.model.RecipePlan;
import pl.jakubczubak.app.repository.PlanRepository;
import pl.jakubczubak.app.repository.RecipePlanRepository;

import java.util.List;

@Controller
public class AppDetailsSchedulesController {
    private PlanRepository planRepository;
    private RecipePlanRepository recipePlanRepository;

    public AppDetailsSchedulesController(PlanRepository planRepository, RecipePlanRepository recipePlanRepository){
        this.recipePlanRepository=recipePlanRepository;
        this.planRepository=planRepository;
    }
    @GetMapping("/app/schedule/details/{id}")
    public String getAppDetailsSchedulePage(@PathVariable Long id, Model model){

        Plan plan = planRepository.findOne(id);
        String existPlanName= plan.getName();
        List<RecipePlan> recipePlanList = recipePlanRepository.findAllByPlanName(existPlanName);
        model.addAttribute("plan", plan);
        model.addAttribute("recipePlanList",recipePlanList);

        return "app-details-schedules";
    }
}
