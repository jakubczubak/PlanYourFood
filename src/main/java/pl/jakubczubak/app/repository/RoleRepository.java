package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Recipe;
import pl.jakubczubak.app.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String role);
}
