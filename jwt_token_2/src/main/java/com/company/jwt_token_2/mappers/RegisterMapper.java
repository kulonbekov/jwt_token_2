package com.company.jwt_token_2.mappers;

import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.RegisterRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RegisterMapper {

    RegisterMapper INSTANCE = Mappers.getMapper(RegisterMapper.class);

    RegisterRequestDto toDto (User user);
    List<RegisterRequestDto> toDtos(List<User> users);
    User toEntity(RegisterRequestDto requestDto);
    List<User> toEntities(List<RegisterRequestDto> registerRequestDtos);

}
