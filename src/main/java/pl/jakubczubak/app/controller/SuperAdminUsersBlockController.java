package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.repository.AdminRepository;

import java.util.List;

@Controller
public class SuperAdminUsersBlockController {
    AdminRepository adminRepository;
    public SuperAdminUsersBlockController(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }
    @GetMapping("/app/admin/{id}")
    public String getSuperAdminUsersPage(Model model){

        return "/dashboard";
    }
}
