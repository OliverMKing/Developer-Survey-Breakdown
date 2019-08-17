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
}
