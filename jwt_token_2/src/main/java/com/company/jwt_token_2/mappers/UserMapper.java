package com.company.jwt_token_2.mappers;

import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.UserDto;

import java.util.List;

public interface UserMapper {


    UserDto toDto (User user);
    List<UserDto> toDtos(List<User> users);
    User toEntity (UserDto userDto);
    List<User> toEntities (List<UserDto> userDtos);


}
