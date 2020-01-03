package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppEditUserController {

    @GetMapping("/app/user/edit")
    public String editUser(){
        return "app-edit-user-data";
    }
}
