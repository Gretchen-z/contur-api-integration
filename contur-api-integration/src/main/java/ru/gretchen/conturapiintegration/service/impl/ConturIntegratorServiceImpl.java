package ru.gretchen.conturapiintegration.service.impl;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.gretchen.conturapiintegration.exception.GetBriefReportException;
import ru.gretchen.conturapiintegration.exception.SendingRequestToConturApiException;
import ru.gretchen.conturapiintegration.model.BriefReportResponseEntity;
import ru.gretchen.conturapiintegration.service.ConturIntegratorService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class ConturIntegratorServiceImpl implements ConturIntegratorService {

    private static final String KEY = "3208d29d15c507395db770d0e65f3711e40374df";
    private static final String URI_BRIEF_REPORT = "https://focus-api.kontur.ru/api3/briefReport";

    @Override
    public BriefReportResponseEntity getBriefReport(String inn) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(URI_BRIEF_REPORT))
                    .header("Content-Type", "application/json")
                    .headers("inn", inn, "key", KEY)
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            throw new GetBriefReportException(URI_BRIEF_REPORT, e.getMessage());
        }

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new SendingRequestToConturApiException(e.getMessage());
        }

        String responseBody = response.body();

        Gson gson = new Gson();
        BriefReportResponseEntity responseEntity = gson.fromJson(responseBody, BriefReportResponseEntity.class);

        return responseEntity;
    }
}
