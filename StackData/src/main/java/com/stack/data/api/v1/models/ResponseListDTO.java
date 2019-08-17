package com.stack.data.api.v1.models;

import java.util.List;

public class ResponseListDTO {

    List<ResponseDTO> responseDTOS;

    public ResponseListDTO() {
    }

    public ResponseListDTO(List<ResponseDTO> responseDTOS) {
        this.responseDTOS = responseDTOS;
    }

    public List<ResponseDTO> getResponseDTOS() {
        return responseDTOS;
    }

    public void setResponseDTOS(List<ResponseDTO> responseDTOS) {
        this.responseDTOS = responseDTOS;
    }
}
