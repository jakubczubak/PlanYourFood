package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Admin;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
    List<Admin> findAllByEnable (Boolean enable);
}
