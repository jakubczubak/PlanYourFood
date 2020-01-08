package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Recipe;

public interface RecipeRepositoryCustom  {
    Recipe myCustomfindById(Long id);
}
