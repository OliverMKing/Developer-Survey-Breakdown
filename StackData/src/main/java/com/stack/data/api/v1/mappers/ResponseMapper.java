package com.stack.data.api.v1.mappers;

import com.stack.data.api.v1.models.ResponseDTO;
import com.stack.data.domain.Response;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponseMapper {

    ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);

    @Mapping(target = "id")
    @Mapping(target = "country")
    @Mapping(target = "formalEducation")
    @Mapping(target = "devType")
    @Mapping(target = "yearsCoding")
    @Mapping(target = "jobSatisfaction")
    @Mapping(target = "salary")
    @Mapping(target = "languages")
    @Mapping(target = "frameworks")
    ResponseDTO responseToResponseDTO(Response response);

    @Mapping(target = "id")
    @Mapping(target = "country")
    @Mapping(target = "formalEducation")
    @Mapping(target = "devType")
    @Mapping(target = "yearsCoding")
    @Mapping(target = "jobSatisfaction")
    @Mapping(target = "salary")
    @Mapping(target = "languages")
    @Mapping(target = "frameworks")
    Response responseDtoToResponse(ResponseDTO responseDTO);
}
