package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Recipe_Plan;

public interface Recipe_PlanRepository extends JpaRepository<Recipe_Plan,Long> {
}
