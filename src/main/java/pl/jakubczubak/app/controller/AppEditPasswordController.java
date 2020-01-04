package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppEditPasswordController {
    @GetMapping("/app/password/edit")
    public String getAppEditPasswordPage(){
        return "app-edit-password";
    }
}
