package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.service.AdminService;

@Controller
public class RegistrationController {

   AdminService adminService;

    public RegistrationController(AdminService adminService){
        this.adminService=adminService;

    }
    @GetMapping("/registration")
    public String getRegistrationPage(Model model){
        model.addAttribute("admin", new Admin());
        return "registration";
    }
    @PostMapping("/registration")
    public String registerNewUser(@ModelAttribute Admin admin){
        adminService.saveUser(admin);
        return "redirect:/login";
    }
}
