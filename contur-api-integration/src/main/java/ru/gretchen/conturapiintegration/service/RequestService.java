package ru.gretchen.conturapiintegration.service;

import ru.gretchen.conturapiintegration.model.RequestEntity;

public interface RequestService {

    RequestEntity getRequestById(Long id);

    RequestEntity saveInn(String inn);
}
