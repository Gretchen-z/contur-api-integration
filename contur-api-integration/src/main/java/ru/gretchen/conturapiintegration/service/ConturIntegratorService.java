package ru.gretchen.conturapiintegration.service;

import ru.gretchen.conturapiintegration.model.briefreport.BriefReportResponseEntity;

public interface ConturIntegratorService {
    BriefReportResponseEntity getBriefReport(String inn);
}
