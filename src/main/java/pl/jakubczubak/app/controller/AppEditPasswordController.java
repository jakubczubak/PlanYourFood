package pl.jakubczubak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubczubak.app.model.PasswordDTO;
import pl.jakubczubak.app.service.ChangePasswordService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AppEditPasswordController {
   private ChangePasswordService changePasswordService;
   public AppEditPasswordController(ChangePasswordService changePasswordService){
       this.changePasswordService=changePasswordService;
   }

    @GetMapping("/app/password/edit")
    public String getAppEditPasswordPage(Model model, Principal principal){
        PasswordDTO password = new PasswordDTO();
        model.addAttribute("password",password);
        return "app-edit-password";
    }
    @PostMapping("/app/password/edit")

    public String getAppEditPasswordPage(@Valid @ModelAttribute PasswordDTO password, BindingResult result, Principal principal){
       if(changePasswordService.ChangePassword(password,principal)){
           return "redirect:/app/password/edit?success";
       }else {
           return "redirect:/app/password/edit?error";
       }




    }
}
