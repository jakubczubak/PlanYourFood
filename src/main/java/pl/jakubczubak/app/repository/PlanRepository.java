package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Admin;
import pl.jakubczubak.app.model.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    Plan findByName(String name);

    Plan findTopByOrderByCreatedDesc();

    List<Plan> findAllByAdmin_Email(String email);

    Plan findFirstByAdmin_EmailOrderByCreatedDesc(String email);

}
