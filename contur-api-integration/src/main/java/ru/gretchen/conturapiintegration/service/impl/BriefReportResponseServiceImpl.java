package ru.gretchen.conturapiintegration.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gretchen.conturapiintegration.exception.BriefReportResponseNotSaveException;
import ru.gretchen.conturapiintegration.model.BriefReportResponseEntity;
import ru.gretchen.conturapiintegration.repository.BriefReportResponseRepository;
import ru.gretchen.conturapiintegration.service.BriefReportResponseService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BriefReportResponseServiceImpl implements BriefReportResponseService {

    private final BriefReportResponseRepository repository;

    @Override
    @Transactional
    public BriefReportResponseEntity saveResponse(BriefReportResponseEntity response) {
        try {
            return repository.save(response);
        } catch (Exception e) {
            throw new BriefReportResponseNotSaveException(e.getMessage());
        }
    }
}
