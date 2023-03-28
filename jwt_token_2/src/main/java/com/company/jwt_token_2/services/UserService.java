package com.company.jwt_token_2.services;

import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.RegisterRequestDto;

import java.util.List;

public interface UserService {

    RegisterRequestDto register(RegisterRequestDto requestDto);
    List<User> getAll();
    User findByUsername(String username);
    User findById(Long id);
    void delete(Long id);
}
