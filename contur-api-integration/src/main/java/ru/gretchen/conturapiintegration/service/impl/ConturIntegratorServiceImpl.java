package ru.gretchen.conturapiintegration.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gretchen.conturapiintegration.exception.UriException;
import ru.gretchen.conturapiintegration.exception.SendingRequestToConturApiException;
import ru.gretchen.conturapiintegration.model.briefreport.BriefReportResponseEntity;
import ru.gretchen.conturapiintegration.model.req.BasicDetailsResponseEntity;
import ru.gretchen.conturapiintegration.service.BasicDetailsResponseService;
import ru.gretchen.conturapiintegration.service.BriefReportResponseService;
import ru.gretchen.conturapiintegration.service.ConturIntegratorService;
import ru.gretchen.conturapiintegration.service.RequestService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

@Service
public class ConturIntegratorServiceImpl implements ConturIntegratorService {

    private final RequestService requestService;
    private final BriefReportResponseService briefReportResponseService;
    private final BasicDetailsResponseService basicDetailsResponseService;
    private final String KEY;
    private final String URI_BRIEF_REPORT;
    private final String URI_BASIC_DETAILS;

    public ConturIntegratorServiceImpl(RequestService requestService,
                                       BriefReportResponseService briefReportResponseService,
                                       BasicDetailsResponseService basicDetailsResponseService,
                                       @Value("${conturintegrator.service.key}")String KEY,
                                       @Value("${conturintegrator.service.uri_brief_report}")String URI_BRIEF_REPORT,
                                       @Value("${conturintegrator.service.uri_basic_details}")String URI_BASIC_DETAILS) {
        this.requestService = requestService;
        this.briefReportResponseService = briefReportResponseService;
        this.basicDetailsResponseService = basicDetailsResponseService;
        this.KEY = KEY;
        this.URI_BRIEF_REPORT = URI_BRIEF_REPORT;
        this.URI_BASIC_DETAILS = URI_BASIC_DETAILS;
    }

    @Override
    public BriefReportResponseEntity getBriefReport(Long id) {
        String inn = requestService.getRequestById(id).getInn();
        HttpResponse<String> response = getReport(inn, URI_BRIEF_REPORT, KEY);

        BriefReportResponseEntity responseEntity = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            responseEntity = mapper.readValue(response.body(),
                    BriefReportResponseEntity[].class)[0];

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        briefReportResponseService.saveResponse(responseEntity);
        return responseEntity;
    }

    @Override
    public BasicDetailsResponseEntity getBasicDetailsReport(Long id) {
        String inn = requestService.getRequestById(id).getInn();
        HttpResponse<String> response = getReport(inn, URI_BASIC_DETAILS, KEY);

        BasicDetailsResponseEntity responseEntity = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            responseEntity = mapper.readValue(response.body(),
                    BasicDetailsResponseEntity[].class)[0];

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        basicDetailsResponseService.saveBasicDetailsResponse(responseEntity);
        return responseEntity;
    }

    @Override
    public HttpResponse<String> getReport(String inn, String uri, String key) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(uri + "?key=" + key + "&inn=" + inn))
                    .timeout(Duration.of(10, SECONDS))
                    .header("Content-Type", "application/json")
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
