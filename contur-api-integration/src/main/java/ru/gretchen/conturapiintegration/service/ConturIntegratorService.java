package ru.gretchen.conturapiintegration.service;

import ru.gretchen.conturapiintegration.model.briefreport.BriefReportResponseEntity;
import ru.gretchen.conturapiintegration.model.req.BasicDetailsResponseEntity;

import java.net.http.HttpResponse;

public interface ConturIntegratorService {

    BriefReportResponseEntity getBriefReport(Long id);

    BasicDetailsResponseEntity getBasicDetailsReport(Long id);
    HttpResponse<String> getReport(String inn, String uri, String key);
}
