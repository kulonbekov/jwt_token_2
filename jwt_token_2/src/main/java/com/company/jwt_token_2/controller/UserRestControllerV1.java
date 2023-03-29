package com.company.jwt_token_2.controller;

import com.company.jwt_token_2.mappers.securityMapper.impl.UserMapper;
import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.securityDto.UserUserDto;
import com.company.jwt_token_2.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserRestControllerV1 {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserUserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        UserUserDto result = userMapper.toDto(user);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
