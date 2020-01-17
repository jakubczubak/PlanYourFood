package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.model.Recipe;

public interface  RecipeRepository extends JpaRepository<Recipe,Long> {

}
