package ru.gretchen.conturapiintegration.controller;

import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gretchen.conturapiintegration.model.RequestEntity;
import ru.gretchen.conturapiintegration.model.briefreport.BriefReportResponseEntity;
import ru.gretchen.conturapiintegration.model.req.BasicDetailsResponseEntity;
import ru.gretchen.conturapiintegration.service.BasicDetailsResponseService;
import ru.gretchen.conturapiintegration.service.RequestService;
import ru.gretchen.conturapiintegration.service.BriefReportResponseService;
import ru.gretchen.conturapiintegration.service.ConturIntegratorService;

import java.net.http.HttpResponse;

@RestController
@RequestMapping(path = "/requests")
@Tag(name = "BriefReport", description = "Getting a brief report from the Contur Focus service")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Request not found")
public class ConturIntegrationController {

    private final RequestService requestService;
    private final BriefReportResponseService briefReportResponseService;
    private final BasicDetailsResponseService basicDetailsResponseService;
    private final ConturIntegratorService conturIntegratorService;
    private final String KEY;
    private final String URI_BRIEF_REPORT;
    private final String URI_BASIC_DETAILS;

    public ConturIntegrationController(RequestService requestService,
                                       BriefReportResponseService briefReportResponseService,
                                       BasicDetailsResponseService basicDetailsResponseService,
                                       ConturIntegratorService conturIntegratorService,
                                       @Value("${conturintegrator.service.key}")String KEY,
                                       @Value("${conturintegrator.service.uri_brief_report}")String URI_BRIEF_REPORT,
                                       @Value("${conturintegrator.service.uri_basic_details}")String URI_BASIC_DETAILS) {
        this.requestService = requestService;
        this.briefReportResponseService = briefReportResponseService;
        this.basicDetailsResponseService = basicDetailsResponseService;
        this.conturIntegratorService = conturIntegratorService;
        this.KEY = KEY;
        this.URI_BRIEF_REPORT = URI_BRIEF_REPORT;
        this.URI_BASIC_DETAILS = URI_BASIC_DETAILS;
    }

    @ApiOperation(value = "Save brief report request",
            response = RequestEntity.class)
    @ApiResponse(responseCode = "200", description = "Brief report request saved")
    @PostMapping(path = "/brief-reports")
    @ResponseStatus(HttpStatus.CREATED)
    public RequestEntity saveBriefReportRequest(@RequestParam String inn) {
        return requestService.saveInn(inn);
    }

    @ApiOperation(value = "Get brief report from Contur Focus",
            response = BriefReportResponseEntity.class)
    @ApiResponse(responseCode = "200", description = "Brief report received")
    @GetMapping(path = "/brief-reports")
    @ResponseStatus(HttpStatus.OK)
    public BriefReportResponseEntity getBriefReportFromConturFocus(@RequestParam Long id) {
        String inn = requestService.getRequestById(id).getInn();
        HttpResponse<String> response = conturIntegratorService.getReport(inn, KEY, URI_BRIEF_REPORT);
        Gson gson = new Gson();
        BriefReportResponseEntity responseEntity = gson.fromJson(response.body(), BriefReportResponseEntity.class);
        briefReportResponseService.saveResponse(responseEntity);
        return responseEntity;
    }

    @ApiOperation(value = "Get basic details report from Contur Focus",
            response = BasicDetailsResponseEntity.class)
    @ApiResponse(responseCode = "200", description = "Basic details report received")
    @GetMapping(path = "/basic-details")
    @ResponseStatus(HttpStatus.OK)
    public BasicDetailsResponseEntity getBasicDetailsReportContrFocus(@RequestParam Long id) {
        String inn = requestService.getRequestById(id).getInn();
        HttpResponse<String> response = conturIntegratorService.getReport(inn, KEY, URI_BASIC_DETAILS);
        Gson gson = new Gson();
        BasicDetailsResponseEntity responseEntity = gson.fromJson(response.body(), BasicDetailsResponseEntity.class);
        basicDetailsResponseService.saveBasicDetailsResponse(responseEntity);
        return responseEntity;
    }
}
