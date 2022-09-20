package ru.gretchen.conturapiintegration.service;

import org.springframework.http.ResponseEntity;
import ru.gretchen.conturapiintegration.model.BriefReportResponseEntity;

public interface ConturIntegratorService {
    BriefReportResponseEntity getBriefReport(String inn);
}
