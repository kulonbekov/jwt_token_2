package com.company.jwt_token_2.mappers.securityMapper.impl;

import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.securityDto.UserUserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapperImpl implements UserMapper {



    @Override
    public UserUserDto toDto(User user) {
        UserUserDto userUserDto = new UserUserDto();
        userUserDto.setId(user.getId());
        userUserDto.setUsername(user.getUsername());
        userUserDto.setFirstName(user.getFirstName());
        userUserDto.setLastName(user.getLastName());
        userUserDto.setEmail(user.getEmail());
        return userUserDto;
    }

    @Override
    public List<UserUserDto> toDtos(List<User> users) {
        List<UserUserDto> result = users.stream()
                .map(item -> toDto(item))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public User toEntity(UserUserDto userUserDto) {
        User user = new User();
        user.setId(userUserDto.getId());
        user.setUsername(userUserDto.getUsername());
        user.setFirstName(userUserDto.getFirstName());
        user.setLastName(userUserDto.getLastName());
        user.setEmail(userUserDto.getEmail());
        return user;
    }

    @Override
    public List<User> toEntities(List<UserUserDto> userUserDtos) {
        List<User> result = userUserDtos.stream()
                .map(item ->toEntity(item))
                .collect(Collectors.toList());
        return result;
    }
}
