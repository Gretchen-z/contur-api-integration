package ru.gretchen.conturapiintegration.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gretchen.conturapiintegration.exception.BriefReportRequestNotExistException;
import ru.gretchen.conturapiintegration.exception.BriefReportRequestNotSaveException;
import ru.gretchen.conturapiintegration.model.briefreport.BriefReportRequestEntity;
import ru.gretchen.conturapiintegration.repository.BriefReportRequestRepository;
import ru.gretchen.conturapiintegration.service.BriefReportRequestService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BriefReportRequestServiceImpl implements BriefReportRequestService {

    private final BriefReportRequestRepository repository;

    @Override
    public BriefReportRequestEntity getRequestById(Long id) {
            return repository.findById(id)
                    .orElseThrow(() -> new BriefReportRequestNotExistException(id));
    }

    @Override
    @Transactional
    public BriefReportRequestEntity saveInn(String inn) {
        try {
            BriefReportRequestEntity entity = new BriefReportRequestEntity();
            entity.setInn(inn);
            return repository.save(entity);
        } catch (Exception e) {
            throw new BriefReportRequestNotSaveException(inn, e.getMessage());
        }
    }
}
