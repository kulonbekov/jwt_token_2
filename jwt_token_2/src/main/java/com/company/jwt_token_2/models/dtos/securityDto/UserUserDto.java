package com.company.jwt_token_2.models.dtos.securityDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUserDto {

    Long id;
    String username;
    String firstName;
    String lastName;
    String email;
}
