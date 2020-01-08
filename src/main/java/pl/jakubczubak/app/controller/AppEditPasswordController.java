package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.service.AdminService;

import java.security.Principal;

@Controller
public class AppEditPasswordController {
    private AdminRepository adminRepository;
    private AdminService adminService;
    public AppEditPasswordController(AdminRepository adminRepository, AdminService adminService){
        this.adminRepository=adminRepository;
        this.adminService=adminService;
    }
    @GetMapping("/app/password/edit")
    public String getAppEditPasswordPage(Model model, Principal principal){
        Admin currentAdmin = adminRepository.findByEmail(principal.getName());

        model.addAttribute("currentAdmin",currentAdmin);
        return "app-edit-password";
    }
    @PostMapping("/app/password/edit")
    public String getAppEditPasswordPage(@ModelAttribute Admin admin, Principal principal){
        Admin currentAdmin = adminRepository.findByEmail(principal.getName());
        admin.setEnable(currentAdmin.isEnable());
        admin.setId(currentAdmin.getId());
        admin.setEmail(currentAdmin.getEmail());
        admin.setFirstName(currentAdmin.getFirstName());
        admin.setLastName(currentAdmin.getLastName());
        adminService.saveUser(admin);

        return "redirect:/app/password/edit";
    }
}
