package ru.gretchen.conturapiintegration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gretchen.conturapiintegration.model.RequestEntity;
import ru.gretchen.conturapiintegration.model.briefreport.BriefReportResponseEntity;
import ru.gretchen.conturapiintegration.model.req.BasicDetailsResponseEntity;
import ru.gretchen.conturapiintegration.model.req.ULEntity;
import ru.gretchen.conturapiintegration.repository.ULRepository;
import ru.gretchen.conturapiintegration.service.BasicDetailsResponseService;
import ru.gretchen.conturapiintegration.service.RequestService;
import ru.gretchen.conturapiintegration.service.ConturIntegratorService;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/requests")
@Tag(name = "BriefReport", description = "Getting a brief report from the Contur Focus service")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Request not found")
public class ConturIntegrationController {

    private final RequestService requestService;
    private final ConturIntegratorService conturIntegratorService;
    private final BasicDetailsResponseService basicDetailsResponseService;
    private final ULRepository ulRepository;

    @ApiOperation(value = "Save brief report request",
            response = RequestEntity.class)
    @ApiResponse(responseCode = "200", description = "Brief report request saved")
    @PostMapping(path = "/request")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> saveRequest(@RequestParam String inn) {
        return requestService.saveInn(inn);
    }

    @ApiOperation(value = "Get brief report from Contur Focus",
            response = BriefReportResponseEntity.class)
    @ApiResponse(responseCode = "200", description = "Brief report received")
    @GetMapping(path = "/brief-reports")
    @ResponseStatus(HttpStatus.OK)
    public BriefReportResponseEntity getBriefReportFromConturFocus(@RequestParam Long id) {
        return conturIntegratorService.getBriefReport(id);
    }

    @ApiOperation(value = "Get basic details report from Contur Focus",
            response = BasicDetailsResponseEntity.class)
    @ApiResponse(responseCode = "200", description = "Basic details report received")
    @GetMapping(path = "/basic-details")
    @ResponseStatus(HttpStatus.OK)
    public BasicDetailsResponseEntity getBasicDetailsReportContrFocus(@RequestParam Long id) {
        return conturIntegratorService.getBasicDetailsReport(id);
    }

    // for check parsing JSON
    @PostMapping(path = "/check-save")
    public BasicDetailsResponseEntity postBasicDetailsReport(
            @RequestBody BasicDetailsResponseEntity responseEntity) {
        return basicDetailsResponseService.saveBasicDetailsResponse(responseEntity);
    }
}
