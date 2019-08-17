package com.stack.data.bootstrap;

import com.opencsv.CSVReader;
import com.stack.data.api.v1.models.ResponseDTO;
import com.stack.data.services.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    private final ResponseService responseService;
    private final String CSV_URL = "C:\\Users\\Oliver\\Desktop\\survey_results_public.csv";
    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    public Bootstrap(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCSVData();
    }

    private void loadCSVData() {
        logger.info("Loading data from CSV");

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(CSV_URL));
            String[] line = reader.readNext();
            while ((line = reader.readNext()) != null) {
                ResponseDTO responseDTO = new ResponseDTO();
                if (!line[3].equals("NA"))
                    responseDTO.setCountry(line[3]);
                if (!line[6].equals("NA"))
                    responseDTO.setFormalEducation(line[6]);
                if (!line[9].equals("NA"))
                    responseDTO.setDevType(line[9]);
                if (!line[10].equals("NA"))
                    responseDTO.setYearsCoding(line[10]);
                if (!line[12].equals("NA"))
                    responseDTO.setJobSatisfaction(line[12]);
                if (!line[54].equals("NA"))
                    responseDTO.setSalary(Double.valueOf(line[54]));

                responseService.createNewResponse(responseDTO);
            }
            logger.info("Done loading data from CSV");
        } catch (Exception e) {
            logger.error("Error with loading data from CSV");
            e.printStackTrace();
        }

    }
}
