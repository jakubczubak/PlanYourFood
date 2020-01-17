package pl.jakubczubak.app.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.model.Role;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.repository.RoleRepository;

import java.util.List;

@Controller
public class SuperAdminListController {

    @GetMapping("/app/admin/list")
    public String getSuperAdminUsersPage(Model model){

        return "super-admin-list";
    }
}
