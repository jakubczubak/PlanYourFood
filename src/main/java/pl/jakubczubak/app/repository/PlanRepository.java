package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.model.Plan;

public interface PlanRepository extends JpaRepository<Plan,Long> {
    Plan findByName (String name);
    Plan findTopByOrderByCreatedDesc();

}
