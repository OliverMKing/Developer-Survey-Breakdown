package com.stack.data.bootstrap;

import com.stack.data.api.v1.models.ResponseDTO;
import com.stack.data.services.ResponseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final ResponseService responseService;

    public Bootstrap(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Override
    public void run(String... args) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCountry("US");
        responseDTO.setDevType("New grad");
        responseService.createNewResponse(responseDTO);

        ResponseDTO responseDTO2 = new ResponseDTO();
        responseDTO2.setCountry("CA");
        responseDTO2.setDevType("New grad");
        responseService.createNewResponse(responseDTO2);

        ResponseDTO responseDTO3 = new ResponseDTO();
        responseDTO3.setCountry("CA");
        responseDTO3.setDevType("5 Years Experience");
        responseService.createNewResponse(responseDTO3);
    }
}
