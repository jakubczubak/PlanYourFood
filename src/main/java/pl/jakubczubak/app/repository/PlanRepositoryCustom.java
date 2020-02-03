package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Plan;

public interface PlanRepositoryCustom {
    Plan myCustomFindById(Long id);
}
