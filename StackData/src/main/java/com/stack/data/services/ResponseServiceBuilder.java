package com.stack.data.services;

import com.stack.data.domain.Response;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceBuilder {

    private final ResponseService responseService;

    public ResponseServiceBuilder(ResponseService responseService) {
        this.responseService = responseService;
    }


}
