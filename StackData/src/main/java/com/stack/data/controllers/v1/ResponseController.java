package com.stack.data.controllers.v1;

import com.stack.data.api.v1.mappers.ResponseMapper;
import com.stack.data.api.v1.models.ResponseListDTO;
import com.stack.data.api.v1.models.ResponseStatsDTO;
import com.stack.data.repositories.ResponseRepository;
import com.stack.data.services.ResponseService;
import com.stack.data.services.ResponseServiceBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ResponseController.BASE_URL)
public class ResponseController {

    public static final String BASE_URL = "/api/v1/responses";

    private final ResponseService responseService;
    private final ResponseRepository responseRepository;
    private final ResponseMapper responseMapper;

    public ResponseController(ResponseService responseService, ResponseRepository responseRepository, ResponseMapper responseMapper) {
        this.responseService = responseService;
        this.responseRepository = responseRepository;
        this.responseMapper = responseMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseListDTO getResponses(@RequestParam(name = "country", required = false) String country,
                                        @RequestParam(name = "formalEducation", required = false) String formalEducation,
                                        @RequestParam(name = "devType", required = false) String devType,
                                        @RequestParam(name = "yearsCoding", required = false) String yearsCoding,
                                        @RequestParam(name = "jobSatisfaction", required = false) String jobSatisfaction,
                                        @RequestParam(name = "salary", required = false) Double salary,
                                        @RequestParam(name = "salaryGreaterThan", required = false) Double salaryGreaterThan,
                                        @RequestParam(name = "salaryLessThan", required = false) Double salaryLessThan
                                        ) {
        ResponseServiceBuilder responseServiceBuilder = new ResponseServiceBuilder(responseRepository, responseMapper);
        if (country != null)
            responseServiceBuilder.country(country);
        if (formalEducation != null)
            responseServiceBuilder.formalEducation(formalEducation);
        if (devType != null)
            responseServiceBuilder.devType(devType);
        if (yearsCoding != null)
            responseServiceBuilder.yearsCoding(yearsCoding);
        if (jobSatisfaction != null)
            responseServiceBuilder.jobSatisfaction(jobSatisfaction);
        if (salary != null)
            responseServiceBuilder.salary(salary);
        if (salaryGreaterThan != null)
            responseServiceBuilder.salaryGreaterThan(salaryGreaterThan);
        if (salaryLessThan != null)
            responseServiceBuilder.salaryLessThan(salaryLessThan);
        return new ResponseListDTO(responseServiceBuilder.build());
    }

    @GetMapping("/stats")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseStatsDTO getResponsesStats(@RequestParam(name = "country", required = false) String country,
                                             @RequestParam(name = "formalEducation", required = false) String formalEducation,
                                             @RequestParam(name = "devType", required = false) String devType,
                                             @RequestParam(name = "yearsCoding", required = false) String yearsCoding,
                                             @RequestParam(name = "jobSatisfaction", required = false) String jobSatisfaction,
                                             @RequestParam(name = "salary", required = false) Double salary,
                                             @RequestParam(name = "salaryGreaterThan", required = false) Double salaryGreaterThan,
                                             @RequestParam(name = "salaryLessThan", required = false) Double salaryLessThan
                                             ) {
        ResponseServiceBuilder responseServiceBuilder = new ResponseServiceBuilder(responseRepository, responseMapper);
        if (country != null)
            responseServiceBuilder.country(country);
        if (formalEducation != null)
            responseServiceBuilder.formalEducation(formalEducation);
        if (devType != null)
            responseServiceBuilder.devType(devType);
        if (yearsCoding != null)
            responseServiceBuilder.yearsCoding(yearsCoding);
        if (jobSatisfaction != null)
            responseServiceBuilder.jobSatisfaction(jobSatisfaction);
        if (salary != null)
            responseServiceBuilder.salary(salary);
        if (salaryGreaterThan != null)
            responseServiceBuilder.salaryGreaterThan(salaryGreaterThan);
        if (salaryLessThan != null)
            responseServiceBuilder.salaryLessThan(salaryLessThan);
        return new ResponseStatsDTO(responseServiceBuilder.build());
    }
}
