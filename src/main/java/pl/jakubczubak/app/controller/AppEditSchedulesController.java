package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.repository.PlanRepository;
import pl.jakubczubak.app.repository.PlanRepositoryCustomImpl;

import java.security.Principal;

@Controller
public class AppEditSchedulesController {
    private PlanRepositoryCustomImpl planRepositoryCustomImpl;
    private PlanRepository planRepository;
    private AdminRepository adminRepository;
    public AppEditSchedulesController(PlanRepositoryCustomImpl planRepositoryCustomImpl, PlanRepository planRepository, AdminRepository adminRepository){
        this.planRepositoryCustomImpl=planRepositoryCustomImpl;
        this.planRepository=planRepository;
        this.adminRepository=adminRepository;
    }
    @GetMapping("/app/schedule/edit/{id}")
    public String getAppEditSchedulePage(@PathVariable Long id, Model model){
        Plan plan = planRepositoryCustomImpl.myCustomFindById(id);
        model.addAttribute("plan", plan);
        return "app-edit-schedules";
    }

    @PostMapping("/app/schedule/edit")
    public String editPlan(@ModelAttribute Plan plan, Principal principal){
        Plan existPlan = planRepository.findOne(plan.getId());
        plan.setAdmin(existPlan.getAdmin());
        plan.setDay(existPlan.getDay());
        plan.setRecipe(existPlan.getRecipe());
        planRepository.save(plan);
        return "redirect:/app/plan/list";

    }
}
