package ru.gretchen.conturapiintegration.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gretchen.conturapiintegration.exception.BasicDetailsResponseNotSaveException;
import ru.gretchen.conturapiintegration.model.req.BasicDetailsResponseEntity;
import ru.gretchen.conturapiintegration.repository.BasicDetailsResponseRepository;
import ru.gretchen.conturapiintegration.service.BasicDetailsResponseService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BasicDetailsResponseServiceImpl implements BasicDetailsResponseService {

    private final BasicDetailsResponseRepository repository;

    @Override
    @Transactional
    public BasicDetailsResponseEntity saveBasicDetailsResponse(BasicDetailsResponseEntity response) {
        try {
            return repository.save(response);
        } catch (Exception e) {
            throw new BasicDetailsResponseNotSaveException(e.getMessage());
        }
    }
}
