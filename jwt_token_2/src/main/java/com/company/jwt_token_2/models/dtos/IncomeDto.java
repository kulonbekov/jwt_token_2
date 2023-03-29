package com.company.jwt_token_2.models.dtos;

import com.company.jwt_token_2.models.dtos.securityDto.RegisterRequestDto;
import com.company.jwt_token_2.models.enums.Status;
import com.company.jwt_token_2.models.enums.TypeOfIncome;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IncomeDto {

    Long id;
    Date created;
    Date updated;
    Status status;
    TypeOfIncome typeOfIncome;
    double sum;
    BillDto bill;
    UserDto user;
}
