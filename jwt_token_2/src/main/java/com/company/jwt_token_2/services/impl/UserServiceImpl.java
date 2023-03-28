package com.company.jwt_token_2.services.impl;

import com.company.jwt_token_2.mappers.RegisterMapper;
import com.company.jwt_token_2.models.Role;
import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.RegisterRequestDto;
import com.company.jwt_token_2.models.enums.Status;
import com.company.jwt_token_2.repository.RoleRep;
import com.company.jwt_token_2.repository.UserRep;
import com.company.jwt_token_2.security.secretKey.Encryption;
import com.company.jwt_token_2.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRep userRep;
    private final RoleRep roleRep;
    private final Encryption encryption;
    private final PasswordEncoder passwordEncoder;
    RegisterMapper registerMapper = RegisterMapper.INSTANCE;

    @Override
    public RegisterRequestDto register(RegisterRequestDto requestDto) {
        Role roleUser = roleRep.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        String secretKey = encryption.encrypt(requestDto.getPassword());
        User user = new User();
        user.setUsername(requestDto.getUsername());
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        user.setSecretKey(secretKey);

        User registeredUser = userRep.save(user);

        //log.info("IN register - user {} successfully registered", registeredUser.getUsername());

        return registerMapper.toDto(registeredUser);
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRep.findAll();
        log.info("In getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRep.findByUsername(username);
        //log.info("IN findByUsername - user {} found by username: {}", result.getUsername(),username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRep.findById(id).orElse(null);

        if ( result == null){
            log.warn("IN findById - no user found y id: {}", id);
        }
        //log.info("IN findById - user {} found by id: {}", result.getUsername());
        return result;
    }

    @Override
    public void delete(Long id) {
        userRep.deleteById(id);
        //log.info("IN delete - user with id: {} successfully deleted");
    }
}
