package com.company.jwt_token_2.mappers.securityMapper.impl;

import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.securityDto.AdminUserDto;

import java.util.List;

public interface AdminUserMapper {

    AdminUserDto toDto (User user);
    List<AdminUserDto> toDtos(List<User> users);
    User toEntity (AdminUserDto adminUserDto);
    List<User> toEntities (List<AdminUserDto> adminUserDtos);
}
