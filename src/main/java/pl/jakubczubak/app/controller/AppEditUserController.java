package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.service.AdminService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AppEditUserController {

    private AdminRepository adminRepository;
    private AdminService adminService;

    public AppEditUserController(AdminRepository adminRepository, AdminService adminService) {
        this.adminRepository = adminRepository;
        this.adminService = adminService;
    }

    @GetMapping("/app/user/edit")
    public String editUser(Model model, Principal principal) {
        Admin currentAdmin = adminRepository.findByEmail(principal.getName());
        model.addAttribute("admin", currentAdmin);
        return "app-edit-user-data";
    }

    @PostMapping("/app/user/edit")
    public String editUser(@Valid @ModelAttribute Admin admin, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "app-edit-user-data";
        }
        adminRepository.save(adminService.editUserData(admin, principal));
        return "redirect:/app/user/edit?success";
    }
}
