package pl.jakubczubak.app.repository;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.jakubczubak.app.model.Recipe;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class RecipeRepositoryCustomImpl implements RecipeRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Recipe myCustomfindById(Long id) {
        Recipe recipe = entityManager.find(Recipe.class,id);
        Hibernate.initialize(recipe.getAdmin());
        return recipe;
    }
}
