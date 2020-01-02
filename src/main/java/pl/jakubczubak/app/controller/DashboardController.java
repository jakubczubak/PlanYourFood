package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.repository.AdminRepository;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String getDashboardPage(){
        return "dashboard";
    }
}
