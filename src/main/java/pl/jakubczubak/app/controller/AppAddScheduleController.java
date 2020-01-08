package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.repository.PlanRepository;

import java.security.Principal;

@Controller
public class AppAddScheduleController {

    private PlanRepository planRepository;
    private AdminRepository adminRepository;

    public AppAddScheduleController(PlanRepository planRepository, AdminRepository adminRepository){
        this.planRepository=planRepository;
        this.adminRepository=adminRepository;
    }
    @GetMapping("/app/schedule/add")
    public String addRecipe(Model model){
        model.addAttribute("schedule", new Plan());
        return "app-add-schedules";
    }


    @PostMapping("/app/schedule/add")
    public String addRecipe(@ModelAttribute Plan plan, Principal principal){
        plan.setAdmin(adminRepository.findByEmail(principal.getName()));
        planRepository.save(plan);
        return "redirect:/dashboard";
    }
}
