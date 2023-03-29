package com.company.jwt_token_2.mappers.securityMapper.impl;

import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.securityDto.UserUserDto;

import java.util.List;

public interface UserMapper {


    UserUserDto toDto (User user);
    List<UserUserDto> toDtos(List<User> users);
    User toEntity (UserUserDto userUserDto);
    List<User> toEntities (List<UserUserDto> userUserDtos);


}
