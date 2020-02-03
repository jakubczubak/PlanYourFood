package pl.jakubczubak.app.repository;

import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakubczubak.app.model.Admin;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AdminRepositoryCustomImpl implements AdminRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Admin findById(Long id) {
        Admin admin = entityManager.find(Admin.class, id);
        Hibernate.initialize(admin);
        return admin;
    }
}
