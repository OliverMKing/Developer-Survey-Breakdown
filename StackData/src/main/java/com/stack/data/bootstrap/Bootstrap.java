package com.stack.data.bootstrap;

import com.stack.data.api.v1.models.ResponseDTO;
import com.stack.data.services.ResponseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

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
        Set<String> languages = new HashSet<>();
        languages.add("Java");
        languages.add("Python");
        responseDTO.setLanguages(languages);
        Set<String> frameworks = new HashSet<>();
        frameworks.add("Spring");
        frameworks.add("Rails");
        responseDTO.setFrameworks(frameworks);
        responseService.createNewResponse(responseDTO);

        ResponseDTO responseDTO2 = new ResponseDTO();
        responseDTO2.setCountry("CA");
        responseDTO2.setDevType("New grad");
        Set<String> languages2 = new HashSet<>();
        languages2.add("Java");
        languages2.add("C++");
        responseDTO2.setLanguages(languages2);
        Set<String> frameworks2 = new HashSet<>();
        frameworks2.add("Spring");
        frameworks2.add("React");
        responseDTO2.setFrameworks(frameworks2);
        responseService.createNewResponse(responseDTO2);

        ResponseDTO responseDTO3 = new ResponseDTO();
        responseDTO3.setCountry("CA");
        responseDTO3.setDevType("5 Years Experience");
        responseDTO3.setFrameworks(frameworks2);
        responseService.createNewResponse(responseDTO3);
    }
}
