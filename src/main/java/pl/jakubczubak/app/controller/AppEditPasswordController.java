package pl.jakubczubak.app.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.model.Password;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.service.AdminService;
import pl.jakubczubak.app.service.ChangePasswordService;

import java.security.Principal;

@Controller
public class AppEditPasswordController {
   private ChangePasswordService changePasswordService;
   public AppEditPasswordController(ChangePasswordService changePasswordService){
       this.changePasswordService=changePasswordService;
   }

    @GetMapping("/app/password/edit")
    public String getAppEditPasswordPage(Model model, Principal principal){
        Password password = new Password();
        model.addAttribute("password",password);
        return "app-edit-password";
    }
    @PostMapping("/app/password/edit")

    public String getAppEditPasswordPage(@ModelAttribute Password password, Principal principal){
       if(changePasswordService.ChangePassword(password,principal)){
           return "redirect:/app/password/edit?success";
       }else {
           return "redirect:/app/password/edit?error";
       }




    }
}
