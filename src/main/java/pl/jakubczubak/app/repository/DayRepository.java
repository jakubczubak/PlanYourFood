package pl.jakubczubak.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakubczubak.app.model.Day;

public interface DayRepository extends JpaRepository<Day,Long> {
}
