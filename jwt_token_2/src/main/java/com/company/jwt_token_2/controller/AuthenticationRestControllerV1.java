package com.company.jwt_token_2.controller;

import com.company.jwt_token_2.models.User;
import com.company.jwt_token_2.models.dtos.AuthenticationRequestDto;
import com.company.jwt_token_2.models.dtos.AuthenticationResponseDto;
import com.company.jwt_token_2.models.dtos.RegisterRequestDto;
import com.company.jwt_token_2.repository.RoleRep;
import com.company.jwt_token_2.security.jwt.JwtTokenProvider;
import com.company.jwt_token_2.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationRestControllerV1 {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto){
        try{
            String username = requestDto.getUsername();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,requestDto.getPassword()));
            User user = userService.findByUsername(username);

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            AuthenticationResponseDto responseDto = new AuthenticationResponseDto();
            responseDto.setUsername(username);
            responseDto.setToken(token);

            return ResponseEntity.ok(responseDto);
        } catch (AuthenticationException e){
            return new ResponseEntity<>("Invalid username or password", HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDto registerDto){
        try{
            registerDto = userService.register(registerDto);

            String result = "Registration completed successfully " +
                    "\n username: " + registerDto.getUsername() +
                    "\n secret_key: " + registerDto.getSecretKey();

            return ResponseEntity.ok(result);
        }catch (Exception e){
            throw new RuntimeException("Invalid save User: " + registerDto.getUsername());
        }
    }
}
