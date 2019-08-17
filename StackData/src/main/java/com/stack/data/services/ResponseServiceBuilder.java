package com.stack.data.services;

import com.stack.data.api.v1.mappers.ResponseMapper;
import com.stack.data.api.v1.models.ResponseDTO;
import com.stack.data.domain.Response;
import com.stack.data.repositories.ResponseRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResponseServiceBuilder {

    private final ResponseRepository responseRepository;
    private final ResponseMapper responseMapper;

    private Stream<Response> stream;

    public ResponseServiceBuilder(ResponseRepository responseRepository, ResponseMapper responseMapper) {
        this.responseRepository = responseRepository;
        this.responseMapper = responseMapper;
        this.stream = this.responseRepository.findAll().stream();
    }

    public ResponseServiceBuilder country(String country) {
        this.stream = this.stream.filter(response -> Objects.equals(response.getCountry(), country));
        return this;
    }

    public ResponseServiceBuilder formalEducation(String formalEducation) {
        this.stream = this.stream.filter(response -> Objects.equals(response.getFormalEducation(), formalEducation));
        return this;
    }

    public ResponseServiceBuilder devType(String devType) {
        this.stream = this.stream.filter(response -> (response.getDevType() != null) ? response.getDevType().contains(devType) : false);
        return this;
    }

    public ResponseServiceBuilder yearsCoding(String yearsCoding) {
        this.stream = this.stream.filter(response -> Objects.equals(response.getYearsCoding(), yearsCoding));
        return this;
    }

    public ResponseServiceBuilder jobSatisfaction(String jobSatisfaction) {
        this.stream = this.stream.filter(response -> Objects.equals(response.getJobSatisfaction(), jobSatisfaction));
        return this;
    }

    public ResponseServiceBuilder salary(Double salary) {
        this.stream = this.stream.filter(response -> Objects.equals(response.getSalary(), salary));
        return this;
    }

    public List<ResponseDTO> build() {
        return this.stream.map(response -> {
            ResponseDTO responseDTO = responseMapper.responseToResponseDTO(response);
            return responseDTO;
        }).collect(Collectors.toList());
    }
}
