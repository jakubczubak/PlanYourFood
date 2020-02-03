package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.model.Role;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);

    List<Admin> findAllByEnabled(int isEnabled);

}
