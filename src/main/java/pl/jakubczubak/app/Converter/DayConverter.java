package pl.jakubczubak.app.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.jakubczubak.app.model.Day;
import pl.jakubczubak.app.repository.DayRepository;

public class DayConverter implements Converter<String, Day> {
    @Autowired
    DayRepository dayRepository;

    @Override
    public Day convert(String s) {
        return dayRepository.findOne(Long.parseLong(s));
    }
}
