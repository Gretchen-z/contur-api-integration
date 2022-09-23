package ru.gretchen.conturapiintegration.service;

import java.net.http.HttpResponse;

public interface ConturIntegratorService {
    HttpResponse<String> getReport(String inn, String uri, String key);
}
