package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}