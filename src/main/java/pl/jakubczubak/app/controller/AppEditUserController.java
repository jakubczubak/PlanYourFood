package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.repository.AdminRepository;

import java.security.Principal;

@Controller
public class AppEditUserController {

    private AdminRepository adminRepository;
    public AppEditUserController(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }
    @GetMapping("/app/user/edit")
    public String editUser(Model model, Principal principal){
        Admin currentAdmin = adminRepository.findByEmail(principal.getName());
        System.out.println(principal.getName());
        model.addAttribute("admin", currentAdmin);
        return "app-edit-user-data";
    }

    @PostMapping("/app/user/edit")
    public String editUser(@ModelAttribute Admin admin, Principal principal){
        Admin currentAdmin = adminRepository.findByEmail(principal.getName());
        admin.setRepassword(currentAdmin.getRepassword());
        admin.setPassword(currentAdmin.getPassword());
        admin.setId(currentAdmin.getId());
        admin.setRole(currentAdmin.getRole());
        adminRepository.save(admin);
        return "redirect:/app/user/edit";
    }
}
