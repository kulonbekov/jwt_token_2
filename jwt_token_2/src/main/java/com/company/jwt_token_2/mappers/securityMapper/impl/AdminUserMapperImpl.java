package com.company.jwt_token_2.mappers.securityMapper.impl;

import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.securityDto.AdminUserDto;
import com.company.jwt_token_2.models.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminUserMapperImpl implements AdminUserMapper {
    @Override
    public AdminUserDto toDto(User user) {
        AdminUserDto userDto = new AdminUserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setStatus(user.getStatus().name());
        return userDto;
    }

    @Override
    public List<AdminUserDto> toDtos(List<User> users) {
        List<AdminUserDto> result = users.stream()
                .map(item -> toDto(item))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public User toEntity(AdminUserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setStatus(Status.valueOf(userDto.getStatus()));
        return user;
    }

    @Override
    public List<User> toEntities(List<AdminUserDto> adminUserDtos) {
        List<User> result = adminUserDtos.stream()
                .map(item ->toEntity(item))
                .collect(Collectors.toList());
        return result;
    }
}
