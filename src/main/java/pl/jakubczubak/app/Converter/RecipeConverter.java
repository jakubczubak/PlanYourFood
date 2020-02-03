package pl.jakubczubak.app.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.jakubczubak.app.model.Day;
import pl.jakubczubak.app.model.Recipe;
import pl.jakubczubak.app.repository.DayRepository;
import pl.jakubczubak.app.repository.RecipeRepository;

public class RecipeConverter implements Converter<String, Recipe> {
    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public Recipe convert(String s) {
        return recipeRepository.findOne(Long.parseLong(s));
    }
}
