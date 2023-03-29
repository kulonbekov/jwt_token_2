package com.company.jwt_token_2.mappers;

import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto> {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
}
