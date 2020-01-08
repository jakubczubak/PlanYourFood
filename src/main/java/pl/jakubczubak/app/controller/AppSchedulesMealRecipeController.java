package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.jakubczubak.app.model.Day;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.model.Recipe;
import pl.jakubczubak.app.model.Recipe_Plan;
import pl.jakubczubak.app.repository.DayRepository;
import pl.jakubczubak.app.repository.PlanRepository;
import pl.jakubczubak.app.repository.RecipeRepository;
import pl.jakubczubak.app.repository.Recipe_PlanRepository;

import java.util.List;

@Controller
public class AppSchedulesMealRecipeController {
    private DayRepository dayRepository;
    private RecipeRepository recipeRepository;
    private PlanRepository planRepository;
    private Recipe_PlanRepository recipe_planRepository;


    public AppSchedulesMealRecipeController(DayRepository dayRepository, RecipeRepository recipeRepository, PlanRepository planRepository, Recipe_PlanRepository recipe_planRepository){
        this.dayRepository=dayRepository;
        this.recipeRepository=recipeRepository;
        this.planRepository=planRepository;
        this.recipe_planRepository=recipe_planRepository;
    }
    @GetMapping("/app/schedulesmealrecipe/add")
    public String getAppSchedulesMealRecipePage(Model model){
        List<Day> dayList = dayRepository.findAll();
        List<Recipe> recipeList = recipeRepository.findAll();
        List<Plan> planList = planRepository.findAll();
        model.addAttribute("dayList", dayList);
        model.addAttribute("recipeList",recipeList);
        model.addAttribute("planList",planList);
        model.addAttribute("scheduleRecipe", new Recipe_Plan());
        return "app-schedules-meal-recipe";
    }

    @PostMapping("/app/schedulesmealrecipe/add")
    public String processAppScheduleMealRecipePage(@ModelAttribute Recipe_Plan recipe_plan){
        recipe_planRepository.save(recipe_plan);
        return "redirect:/app/schedulesmealrecipe/add";
    }
}
