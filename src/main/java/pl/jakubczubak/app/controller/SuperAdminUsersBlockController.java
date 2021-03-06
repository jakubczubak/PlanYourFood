package pl.jakubczubak.app.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.repository.AdminRepositoryCustomImpl;

import java.util.List;

@Controller
@Secured("ADMIN")
public class SuperAdminUsersBlockController {
    AdminRepository adminRepository;
    AdminRepositoryCustomImpl adminRepositoryCustomImpl;

    public SuperAdminUsersBlockController(AdminRepository adminRepository, AdminRepositoryCustomImpl adminRepositoryCustomImpl) {
        this.adminRepository = adminRepository;
        this.adminRepositoryCustomImpl = adminRepositoryCustomImpl;
    }

    @GetMapping("/app/admin/{id}")
    public String getSuperAdminUsersPage(@PathVariable Long id) {
        Admin admin = adminRepositoryCustomImpl.findById(id);
        admin.setEnabled(0);
        adminRepository.save(admin);

        return "redirect:/app/admin";
    }

    @GetMapping("/app/admin/blocked")
    public String getBlockedUsersList(Model model) {
        List<Admin> adminList = adminRepository.findAllByEnabled(0);
        model.addAttribute("users", adminList);
        return "blockedusers";
    }

    @GetMapping("/app/admin/blocked/{id}")
    public String unBanUser(@PathVariable Long id) {
        Admin admin = adminRepositoryCustomImpl.findById(id);
        admin.setEnabled(1);
        adminRepository.save(admin);
        return "redirect:/app/admin/blocked";
    }
}
