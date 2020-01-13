package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.model.RecipePlan;

import java.util.List;

public interface RecipePlanRepository extends JpaRepository<RecipePlan,Long> {
    RecipePlan findByPlan (Plan plan);
    List<RecipePlan> findAllByPlanName (String planName);
}
