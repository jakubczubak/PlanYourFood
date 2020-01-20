package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.model.Recipe;

import java.util.List;

public interface  RecipeRepository extends JpaRepository<Recipe,Long> {
    List<Recipe> findAllByAdmin_Email (String emial);
}
