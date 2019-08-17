package com.stack.data.services;

import com.stack.data.api.v1.mappers.ResponseMapper;
import com.stack.data.api.v1.models.ResponseDTO;
import com.stack.data.domain.Response;
import com.stack.data.repositories.ResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponseServiceImpl implements ResponseService {

    private final ResponseMapper responseMapper;
    private final ResponseRepository responseRepository;

    public ResponseServiceImpl(ResponseMapper responseMapper, ResponseRepository responseRepository) {
        this.responseMapper = responseMapper;
        this.responseRepository = responseRepository;
    }

    @Override
    public List<ResponseDTO> getAllResponses() {
        return responseRepository
                .findAll()
                .stream()
                .map(response -> {
                    ResponseDTO responseDTO = responseMapper.responseToResponseDTO(response);
                    return responseDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public ResponseDTO createNewResponse(ResponseDTO responseDTO) {
        return saveAndReturnDTO(responseMapper.responseDtoToResponse(responseDTO));
    }

    @Override
    public ResponseDTO saveAndReturnDTO(Response response) {
        Response savedResponse = responseRepository.save(response);
        ResponseDTO returnedResponseDTO = responseMapper.responseToResponseDTO(savedResponse);
        return returnedResponseDTO;
    }

    @Override
    public ResponseDTO saveResponseByDTO(Long id, ResponseDTO responseDTO) {
        Response response = responseMapper.responseDtoToResponse(responseDTO);
        response.setId(id);
        return saveAndReturnDTO(response);
    }

    @Override
    public List<ResponseDTO> findAllByCountry(String country) {
        return responseRepository
                .findAllByCountry(country)
                .stream()
                .map(response -> {
                    ResponseDTO responseDTO = responseMapper.responseToResponseDTO(response);
                    return responseDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ResponseDTO> findAllByFormalEducation(String formalEducation) {
        return responseRepository
                .findAllByFormalEducation(formalEducation)
                .stream()
                .map(response -> {
                    ResponseDTO responseDTO = responseMapper.responseToResponseDTO(response);
                    return responseDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ResponseDTO> findAllByDevType(String devType) {
        return responseRepository
                .findAllByDevType(devType)
                .stream()
                .map(response -> {
                    ResponseDTO responseDTO = responseMapper.responseToResponseDTO(response);
                    return responseDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ResponseDTO> findAllByYearsCoding(Integer yearsCoding) {
        return responseRepository
                .findAllByYearsCoding(yearsCoding)
                .stream()
                .map(response -> {
                    ResponseDTO responseDTO = responseMapper.responseToResponseDTO(response);
                    return responseDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ResponseDTO> findAllByJobSatisfaction(String jobSatisfaction) {
        return responseRepository
                .findAllByJobSatisfaction(jobSatisfaction)
                .stream()
                .map(response -> {
                    ResponseDTO responseDTO = responseMapper.responseToResponseDTO(response);
                    return responseDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ResponseDTO> findAllBySalary(String salary) {
        return responseRepository
                .findAllBySalary(salary)
                .stream()
                .map(response -> {
                    ResponseDTO responseDTO = responseMapper.responseToResponseDTO(response);
                    return responseDTO;
                }).collect(Collectors.toList());
    }
}
