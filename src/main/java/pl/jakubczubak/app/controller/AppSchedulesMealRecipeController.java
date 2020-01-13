package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubczubak.app.model.Day;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.model.Recipe;
import pl.jakubczubak.app.model.RecipePlan;
import pl.jakubczubak.app.repository.*;

import java.util.List;

@Controller
public class AppSchedulesMealRecipeController {
    private DayRepository dayRepository;
    private RecipeRepository recipeRepository;
    private PlanRepository planRepository;
    private RecipePlanRepository recipePlanRepository;



    public AppSchedulesMealRecipeController(DayRepository dayRepository, RecipeRepository recipeRepository, PlanRepository planRepository,RecipePlanRepository recipePlanRepository){
        this.dayRepository=dayRepository;
        this.recipeRepository=recipeRepository;
        this.planRepository=planRepository;
        this.recipePlanRepository=recipePlanRepository;

    }
    @GetMapping("/app/schedulesmealrecipe/add")
    public String getAppSchedulesMealRecipePage(Model model){
        List<Day> dayList = dayRepository.findAll();
        List<Recipe> recipeList = recipeRepository.findAll();
        List<Plan> planList = planRepository.findAll();
        model.addAttribute("dayList", dayList);
        model.addAttribute("recipeList",recipeList);
        model.addAttribute("planList",planList);
        model.addAttribute("RecipePlan", new RecipePlan());
        return "app-schedules-meal-recipe";
    }

    @PostMapping("/app/schedulesmealrecipe/add")
    public String processAppScheduleMealRecipePage(@ModelAttribute RecipePlan recipePlan){
        recipePlanRepository.save(recipePlan);
        return "redirect:/app/plan/list";
    }
}
