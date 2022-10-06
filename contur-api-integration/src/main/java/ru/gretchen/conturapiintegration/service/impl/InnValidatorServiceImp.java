package ru.gretchen.conturapiintegration.service.impl;

import org.springframework.stereotype.Service;
import ru.gretchen.conturapiintegration.service.InnValidatorService;

@Service
public class InnValidatorServiceImp implements InnValidatorService {
    @Override
    public boolean isValid(String inn) {
        String innRegex = "\\d{10}|\\d{12}";
        return inn.matches(innRegex);
    }
}
