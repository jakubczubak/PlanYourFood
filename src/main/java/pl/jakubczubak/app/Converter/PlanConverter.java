package pl.jakubczubak.app.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.jakubczubak.app.model.Plan;
import pl.jakubczubak.app.model.Recipe;
import pl.jakubczubak.app.repository.PlanRepository;
import pl.jakubczubak.app.repository.RecipeRepository;

public class PlanConverter implements Converter<String, Plan> {
    @Autowired
    PlanRepository planRepository;

    @Override
    public Plan convert(String s) {
        return planRepository.findOne(Long.parseLong(s));
    }
}
