package com.stack.data.api.v1.mappers;

import com.stack.data.api.v1.models.ResponseDTO;
import com.stack.data.domain.Response;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponseMapper {

    ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);

    ResponseDTO responseToResponseDTO(Response response);
}
