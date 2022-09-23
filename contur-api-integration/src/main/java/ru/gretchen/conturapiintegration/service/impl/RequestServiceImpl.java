package ru.gretchen.conturapiintegration.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gretchen.conturapiintegration.exception.RequestNotExistException;
import ru.gretchen.conturapiintegration.exception.RequestNotSaveException;
import ru.gretchen.conturapiintegration.model.RequestEntity;
import ru.gretchen.conturapiintegration.repository.RequestRepository;
import ru.gretchen.conturapiintegration.service.RequestService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RequestServiceImpl implements RequestService {

    private final RequestRepository repository;

    @Override
    public RequestEntity getRequestById(Long id) {
            return repository.findById(id)
                    .orElseThrow(() -> new RequestNotExistException(id));
    }

    @Override
    @Transactional
    public RequestEntity saveInn(String inn) {
        try {
            RequestEntity entity = new RequestEntity();
            entity.setInn(inn);
            return repository.save(entity);
        } catch (Exception e) {
            throw new RequestNotSaveException(inn, e.getMessage());
        }
    }
}
