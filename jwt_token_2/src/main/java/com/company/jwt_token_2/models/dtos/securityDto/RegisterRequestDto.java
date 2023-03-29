package com.company.jwt_token_2.models.dtos.securityDto;

import com.company.jwt_token_2.models.Role;
import com.company.jwt_token_2.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequestDto {

    Long id;
    Date created;
    Date updated;
    Status status;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String secretKey;
    List<Role> roles;

}
