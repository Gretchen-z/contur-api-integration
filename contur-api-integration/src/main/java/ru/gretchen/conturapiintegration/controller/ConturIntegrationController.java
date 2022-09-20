package ru.gretchen.conturapiintegration.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gretchen.conturapiintegration.model.briefreport.BriefReportRequestEntity;
import ru.gretchen.conturapiintegration.model.briefreport.BriefReportResponseEntity;
import ru.gretchen.conturapiintegration.service.BriefReportRequestService;
import ru.gretchen.conturapiintegration.service.BriefReportResponseService;
import ru.gretchen.conturapiintegration.service.ConturIntegratorService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/brief-reports")
@Tag(name = "BriefReport", description = "Getting a brief report from the Contur Focus service")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Request not found")
public class ConturIntegrationController {

    private final BriefReportRequestService requestService;
    private final BriefReportResponseService responseService;
    private final ConturIntegratorService conturIntegratorService;

    @ApiOperation(value = "Save brief report request",
            response = BriefReportRequestEntity.class)
    @ApiResponse(responseCode = "200", description = "Brief report request saved")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BriefReportRequestEntity saveBriefReportRequest(@RequestParam String inn) {
        return requestService.saveInn(inn);
    }

    @ApiOperation(value = "Get brief report from Contur Focus",
            response = BriefReportResponseEntity.class)
    @ApiResponse(responseCode = "200", description = "Brief report received")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public BriefReportResponseEntity getBriefReportFromConturFocus(@RequestParam Long id) {
        String inn = requestService.getRequestById(id).getInn();
        BriefReportResponseEntity responseEntity = conturIntegratorService.getBriefReport(inn);
        responseService.saveResponse(responseEntity);
        return responseEntity;
    }
}
