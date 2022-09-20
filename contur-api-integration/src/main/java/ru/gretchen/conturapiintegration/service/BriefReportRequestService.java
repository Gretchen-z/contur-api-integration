package ru.gretchen.conturapiintegration.service;

import ru.gretchen.conturapiintegration.model.BriefReportRequestEntity;

public interface BriefReportRequestService {

    BriefReportRequestEntity getRequestById(Long id);

    BriefReportRequestEntity saveInn(String inn);
}
