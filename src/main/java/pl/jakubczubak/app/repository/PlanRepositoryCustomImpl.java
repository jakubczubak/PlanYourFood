package pl.jakubczubak.app.repository;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.jakubczubak.app.model.Plan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PlanRepositoryCustomImpl implements PlanRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Plan myCustomFindById(Long id) {
        Plan plan = entityManager.find(Plan.class,id);
        Hibernate.initialize(plan);
        return plan;
    }
}
