package com.stack.data.api.v1.models;

import java.util.List;

public class ResponseListDTO {

    Integer responseCount;
    List<ResponseDTO> responseDTOS;

    public ResponseListDTO() {
    }

    public ResponseListDTO(List<ResponseDTO> responseDTOS) {

        this.responseDTOS = responseDTOS;
        this.responseCount = responseDTOS.size();
    }

    public Integer getResponses() {
        return responseCount;
    }

    public void setResponses(Integer responses) {
        this.responseCount = responses;
    }

    public List<ResponseDTO> getResponseDTOS() {
        return responseDTOS;
    }

    public void setResponseDTOS(List<ResponseDTO> responseDTOS) {
        this.responseDTOS = responseDTOS;
    }
}
