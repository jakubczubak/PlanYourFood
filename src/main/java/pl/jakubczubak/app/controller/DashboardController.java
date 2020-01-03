package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.repository.PlanRepository;
import pl.jakubczubak.app.repository.RecipeRepository;

import java.security.Principal;

@Controller
@SessionAttributes("email")
public class DashboardController {

    PlanRepository planRepository;
    RecipeRepository recipeRepository;

    public DashboardController(PlanRepository planRepository, RecipeRepository recipeRepository){
        this.planRepository=planRepository;
        this.recipeRepository=recipeRepository;
    }

    @GetMapping("/dashboard")
    public String getDashboardPage(Principal principal,Model model){
        model.addAttribute("email",principal.getName());
        model.addAttribute("recipesCount",recipeRepository.findAll().size());
        model.addAttribute("plansCount",planRepository.findAll().size());
        return "dashboard";
    }
}
