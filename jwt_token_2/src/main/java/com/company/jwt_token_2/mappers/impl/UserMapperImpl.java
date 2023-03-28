package com.company.jwt_token_2.mappers.impl;

import com.company.jwt_token_2.mappers.UserMapper;
import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.UserDto;
import com.company.jwt_token_2.repository.UserRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapperImpl implements UserMapper {



    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    @Override
    public List<UserDto> toDtos(List<User> users) {
        List<UserDto> result = users.stream()
                .map(item -> toDto(item))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        return user;
    }

    @Override
    public List<User> toEntities(List<UserDto> userDtos) {
        List<User> result = userDtos.stream()
                .map(item ->toEntity(item))
                .collect(Collectors.toList());
        return result;
    }
}
