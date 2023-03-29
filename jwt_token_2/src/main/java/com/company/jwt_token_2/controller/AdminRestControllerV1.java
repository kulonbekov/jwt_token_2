package com.company.jwt_token_2.controller;

import com.company.jwt_token_2.mappers.securityMapper.impl.AdminUserMapper;
import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.securityDto.AdminUserDto;
import com.company.jwt_token_2.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/admin")
@RequiredArgsConstructor
public class AdminRestControllerV1 {

    private final UserService userService;
    private final AdminUserMapper adminUserMapper;

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        AdminUserDto result = adminUserMapper.toDto(user);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
