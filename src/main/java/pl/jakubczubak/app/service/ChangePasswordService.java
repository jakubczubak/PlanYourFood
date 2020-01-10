package pl.jakubczubak.app.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.model.Password;
import pl.jakubczubak.app.repository.AdminRepository;

import java.security.Principal;

@Service
public class ChangePasswordService {
    private AdminRepository adminRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public ChangePasswordService(AdminRepository adminRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.adminRepository=adminRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }
    public boolean ChangePassword(Password password, Principal principal){
        Admin currentAdmin = adminRepository.findByEmail(principal.getName());
        if(bCryptPasswordEncoder.matches(password.getOldPassword(),currentAdmin.getPassword())){
            if(password.getPassword().equals(password.getRePassword())){
                String encodePassword = bCryptPasswordEncoder.encode(password.getPassword());
                currentAdmin.setPassword(encodePassword);
                currentAdmin.setRepassword(encodePassword);
                adminRepository.save(currentAdmin);
                return true;
            }
        }
        return false;
    }
}
