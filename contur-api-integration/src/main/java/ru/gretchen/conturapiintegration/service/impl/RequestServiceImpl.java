package ru.gretchen.conturapiintegration.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gretchen.conturapiintegration.exception.InnIsNotValidException;
import ru.gretchen.conturapiintegration.exception.RequestNotExistException;
import ru.gretchen.conturapiintegration.exception.RequestNotSaveException;
import ru.gretchen.conturapiintegration.model.RequestEntity;
import ru.gretchen.conturapiintegration.repository.RequestRepository;
import ru.gretchen.conturapiintegration.service.InnValidatorService;
import ru.gretchen.conturapiintegration.service.RequestService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RequestServiceImpl implements RequestService {

    private final RequestRepository repository;
    private final InnValidatorService validatorService;

    @Override
    public RequestEntity getRequestById(Long id) {
            return repository.findById(id)
                    .orElseThrow(() -> new RequestNotExistException(id));
    }

    @Override
    @Transactional
    public ResponseEntity<Long> saveInn(String inn) {
        if(!validatorService.isValid(inn)) {
            throw new InnIsNotValidException(inn);
        }
        try {
            RequestEntity entity = new RequestEntity();
            entity.setInn(inn);
            repository.save(entity);
            return new ResponseEntity<>(entity.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RequestNotSaveException(inn, e.getMessage());
        }
    }
}
