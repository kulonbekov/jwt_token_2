package com.company.jwt_token_2.models.dtos.securityDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponseDto {
    String username;
    String token;
}
