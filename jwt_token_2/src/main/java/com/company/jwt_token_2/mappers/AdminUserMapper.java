package com.company.jwt_token_2.mappers;

import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.AdminUserDto;
import com.company.jwt_token_2.models.dtos.UserDto;

import java.util.List;

public interface AdminUserMapper {

    AdminUserDto toDto (User user);
    List<AdminUserDto> toDtos(List<User> users);
    User toEntity (AdminUserDto adminUserDto);
    List<User> toEntities (List<AdminUserDto> adminUserDtos);
}
