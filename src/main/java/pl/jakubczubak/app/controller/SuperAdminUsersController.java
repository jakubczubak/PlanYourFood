package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuperAdminUsersController {
    @GetMapping("/app/admin")
    public String getSuperAdminUsersPage(){
        return "super-admin-users";
    }
}
