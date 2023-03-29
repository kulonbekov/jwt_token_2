package com.company.jwt_token_2.models.dtos.securityDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {

    Long id;
    String username;
    String firstName;
    String lastName;
    String email;
    String status;
}
