package com.stack.data.services;

import com.stack.data.api.v1.mappers.ResponseMapper;
import com.stack.data.api.v1.models.ResponseDTO;
import com.stack.data.domain.Response;
import com.stack.data.repositories.ResponseRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResponseServiceBuilder {

    private final ResponseRepository responseRepository;
    private final ResponseMapper responseMapper;

    private Stream<Response> stream;

    public ResponseServiceBuilder(ResponseRepository responseRepository, ResponseMapper responseMapper) {
        this.responseRepository = responseRepository;
        this.stream = responseRepository.findAll().stream();
        this.responseMapper = responseMapper;
    }

    public ResponseServiceBuilder country(String country) {
        this.stream = stream.filter(response -> response.getCountry().equals(country));
        return this;
    }

    public ResponseServiceBuilder formalEducation(String formalEducation) {
        this.stream = stream.filter(response -> response.getFormalEducation().equals(formalEducation));
        return this;
    }

    public ResponseServiceBuilder devType(String devType) {
        this.stream = stream.filter(response -> response.getDevType().equals(devType));
        return this;
    }

    public ResponseServiceBuilder yearsCoding(Integer yearsCoding) {
        this.stream = stream.filter(response -> response.getYearsCoding().equals(yearsCoding));
        return this;
    }

    public List<ResponseDTO> build() {
        return this.stream.map(response -> {
            ResponseDTO responseDTO = responseMapper.responseToResponseDTO(response);
            return responseDTO;
        }).collect(Collectors.toList());
    }
}
