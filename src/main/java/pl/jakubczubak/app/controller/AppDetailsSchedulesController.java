package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.model.RecipePlan;
import pl.jakubczubak.app.repository.DayRepository;
import pl.jakubczubak.app.repository.PlanRepository;
import pl.jakubczubak.app.repository.RecipePlanRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppDetailsSchedulesController {
    private PlanRepository planRepository;
    private RecipePlanRepository recipePlanRepository;
    private DayRepository dayRepository;

    public AppDetailsSchedulesController(PlanRepository planRepository, RecipePlanRepository recipePlanRepository, DayRepository dayRepository){
        this.recipePlanRepository=recipePlanRepository;
        this.planRepository=planRepository;
        this.dayRepository=dayRepository;
    }
    @GetMapping("/app/schedule/details/{id}")
    public String getAppDetailsSchedulePage(@PathVariable Long id, Model model){

        Plan plan = planRepository.findOne(id);
        String existPlanName= plan.getName();
        List<RecipePlan> recipePlanList = recipePlanRepository.findAllByPlanName(existPlanName);

        List<RecipePlan> mondayList = new ArrayList<>();
        List<RecipePlan> tuesdayList = new ArrayList<>();
        List<RecipePlan> wednesdayList = new ArrayList<>();
        List<RecipePlan> thursdayList = new ArrayList<>();
        List<RecipePlan> fridayList = new ArrayList<>();
        List<RecipePlan> saturdayList = new ArrayList<>();
        List<RecipePlan> sundayList = new ArrayList<>();

        for (RecipePlan recipePlan:recipePlanList) {
            if(recipePlan.getDay().getName().equals("Poniedzialek")){
                mondayList.add(recipePlan);
            }
            else if(recipePlan.getDay().getName().equals("Wtorek")){
                tuesdayList.add(recipePlan);
            }
            else if(recipePlan.getDay().getName().equals("Sroda")){
                wednesdayList.add(recipePlan);
            }
            else if(recipePlan.getDay().getName().equals("Czwartek")){
                thursdayList.add(recipePlan);
            }
            else if(recipePlan.getDay().getName().equals("Piatek")){
                fridayList.add(recipePlan);
            }
            else if(recipePlan.getDay().getName().equals("Sobota")){
                saturdayList.add(recipePlan);
            }
            else if(recipePlan.getDay().getName().equals("Niedziela")){
                sundayList.add(recipePlan);
            }

        }
        model.addAttribute("plan", plan);
        model.addAttribute("monday", mondayList);
        model.addAttribute("tuesday", tuesdayList);
        model.addAttribute("wednesday", wednesdayList);
        model.addAttribute("thursday", thursdayList);
        model.addAttribute("friday", fridayList);
        model.addAttribute("saturday", saturdayList);
        model.addAttribute("sunday", sundayList);


        return "app-details-schedules";
    }
}
