package ru.gretchen.conturapiintegration.service.impl;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gretchen.conturapiintegration.exception.UriException;
import ru.gretchen.conturapiintegration.exception.SendingRequestToConturApiException;
import ru.gretchen.conturapiintegration.model.briefreport.BriefReportResponseEntity;
import ru.gretchen.conturapiintegration.service.ConturIntegratorService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

@Service
@RequiredArgsConstructor
public class ConturIntegratorServiceImpl implements ConturIntegratorService {

    @Override
    public HttpResponse<String> getReport(String inn, String uri, String key) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .timeout(Duration.of(10, SECONDS))
                    .header("Content-Type", "application/json")
                    .headers("inn", inn, "key", key)
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            throw new UriException(uri, e.getMessage());
        }

        HttpResponse<String> response = null;
        try {
            return response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new SendingRequestToConturApiException(e.getMessage());
        }
    }


}
