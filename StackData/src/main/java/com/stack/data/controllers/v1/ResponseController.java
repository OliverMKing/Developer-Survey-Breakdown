package com.stack.data.controllers.v1;

import com.stack.data.api.v1.models.ResponseListDTO;
import com.stack.data.services.ResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseListDTO getAllResponses() {
        return new ResponseListDTO(responseService.getAllResponses());
    }
}
