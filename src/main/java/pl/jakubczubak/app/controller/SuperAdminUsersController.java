package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.repository.AdminRepository;

import java.util.List;

@Controller
public class SuperAdminUsersController {
    AdminRepository adminRepository;
    public SuperAdminUsersController(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }
    @GetMapping("/app/admin")
    public String getSuperAdminUsersPage(Model model){
        List<Admin> adminList = adminRepository.findAll();
        model.addAttribute("users", adminList);
        return "super-admin-users";
    }
}
