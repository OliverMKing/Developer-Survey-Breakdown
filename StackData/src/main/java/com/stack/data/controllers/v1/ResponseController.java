package com.stack.data.controllers.v1;

import com.stack.data.api.v1.models.ResponseListDTO;
import com.stack.data.services.ResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ResponseController.BASE_URL)
public class ResponseController {

    public static final String BASE_URL = "/api/v1/responses";

    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseListDTO getResponses(@RequestParam(name = "country", required = false) String country,
                                        @RequestParam(name = "formalEducation", required = false) String formalEducation,
                                        @RequestParam(name = "devType", required = false) String devType,
                                        @RequestParam(name = "yearsCoding", required = false) Integer yearsCoding,
                                        @RequestParam(name = "jobSatisfaction", required = false) String jobSatisfaction,
                                        @RequestParam(name = "salary", required = false) Double salary,
                                        @RequestParam(name = "languages", required = false) List<String> languagesList,
                                        @RequestParam(name = "frameworks", required = false) List<String> frameworksList
                                        ) {
        return new ResponseListDTO(responseService.getAllResponses());
    }
}
