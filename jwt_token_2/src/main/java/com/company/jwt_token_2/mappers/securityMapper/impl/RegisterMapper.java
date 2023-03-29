package com.company.jwt_token_2.mappers.securityMapper.impl;

import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.securityDto.RegisterRequestDto;
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
