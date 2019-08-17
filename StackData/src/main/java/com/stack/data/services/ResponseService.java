package com.stack.data.services;

import com.stack.data.api.v1.models.ResponseDTO;
import com.stack.data.domain.Response;

import java.util.List;

public interface ResponseService {

    List<ResponseDTO> getAllResponses();
    ResponseDTO createNewResponse(ResponseDTO responseDTO);
    ResponseDTO saveAndReturnDTO(Response response);
    ResponseDTO saveResponseByDTO(Long id, ResponseDTO responseDTO);
}
