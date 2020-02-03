package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.model.RecipePlan;
import pl.jakubczubak.app.model.Role;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.repository.PlanRepository;
import pl.jakubczubak.app.repository.RecipePlanRepository;
import pl.jakubczubak.app.repository.RecipeRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("email")
public class DashboardController {

    PlanRepository planRepository;
    RecipeRepository recipeRepository;
    RecipePlanRepository recipePlanRepository;


    public DashboardController(PlanRepository planRepository, RecipeRepository recipeRepository, RecipePlanRepository recipePlanRepository) {
        this.planRepository = planRepository;
        this.recipeRepository = recipeRepository;
        this.recipePlanRepository = recipePlanRepository;
    }

    @GetMapping("/dashboard")
    public String getDashboardPage(Principal principal, Model model) {
        model.addAttribute("email", principal.getName());
        model.addAttribute("recipesCount", recipeRepository.findAllByAdmin_Email(principal.getName()).size());
        model.addAttribute("plansCount", planRepository.findAllByAdmin_Email(principal.getName()).size());

//        Plan lastPlan = planRepository.findTopByOrderByCreatedDesc();
        Plan lastPlan = planRepository.findFirstByAdmin_EmailOrderByCreatedDesc(principal.getName());

        if (lastPlan != null) {
            model.addAttribute("lastPlan", lastPlan);
            String lastPlanName = lastPlan.getName();
            List<RecipePlan> recipePlanList = recipePlanRepository.findAllByPlanName(lastPlanName);
            List<RecipePlan> mondayList = new ArrayList<>();
            List<RecipePlan> tuesdayList = new ArrayList<>();
            List<RecipePlan> wednesdayList = new ArrayList<>();
            List<RecipePlan> thursdayList = new ArrayList<>();
            List<RecipePlan> fridayList = new ArrayList<>();
            List<RecipePlan> saturdayList = new ArrayList<>();
            List<RecipePlan> sundayList = new ArrayList<>();

            for (RecipePlan recipePlan : recipePlanList) {
                if (recipePlan.getDay().getName().equals("Poniedzialek")) {
                    mondayList.add(recipePlan);
                } else if (recipePlan.getDay().getName().equals("Wtorek")) {
                    tuesdayList.add(recipePlan);
                } else if (recipePlan.getDay().getName().equals("Sroda")) {
                    wednesdayList.add(recipePlan);
                } else if (recipePlan.getDay().getName().equals("Czwartek")) {
                    thursdayList.add(recipePlan);
                } else if (recipePlan.getDay().getName().equals("Piatek")) {
                    fridayList.add(recipePlan);
                } else if (recipePlan.getDay().getName().equals("Sobota")) {
                    saturdayList.add(recipePlan);
                } else if (recipePlan.getDay().getName().equals("Niedziela")) {
                    sundayList.add(recipePlan);
                }

            }

            model.addAttribute("monday", mondayList);
            model.addAttribute("tuesday", tuesdayList);
            model.addAttribute("wednesday", wednesdayList);
            model.addAttribute("thursday", thursdayList);
            model.addAttribute("friday", fridayList);
            model.addAttribute("saturday", saturdayList);
            model.addAttribute("sunday", sundayList);
        }


        return "dashboard";
    }
}
