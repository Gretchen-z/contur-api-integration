package ru.gretchen.conturapiintegration.service;

import org.springframework.http.ResponseEntity;
import ru.gretchen.conturapiintegration.model.RequestEntity;

public interface RequestService {

    RequestEntity getRequestById(Long id);

    ResponseEntity<Long> saveInn(String inn);
}
