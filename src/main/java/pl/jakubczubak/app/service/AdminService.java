package pl.jakubczubak.app.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.model.Role;
import pl.jakubczubak.app.repository.AdminRepository;
import pl.jakubczubak.app.repository.RoleRepository;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class AdminService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private RoleRepository roleRepository;
    private AdminRepository adminRepository;

    public AdminService(BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository, AdminRepository adminRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
        this.adminRepository = adminRepository;
    }

    public void saveUser(Admin admin) {
        String encodePassword = bCryptPasswordEncoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);
        admin.setRepassword(encodePassword);
        Role userRole = roleRepository.findByRole("USER");
        admin.setRole(new HashSet<Role>(Arrays.asList(userRole)));
        admin.setEnabled(1);
        adminRepository.save(admin);
    }

    public Admin editUserData(Admin admin, Principal principal) {
        Admin currentAdmin = adminRepository.findByEmail(principal.getName());
        admin.setRepassword(currentAdmin.getRepassword());
        admin.setPassword(currentAdmin.getPassword());
        admin.setId(currentAdmin.getId());
        admin.setRole(currentAdmin.getRole());
        return admin;
    }
}
