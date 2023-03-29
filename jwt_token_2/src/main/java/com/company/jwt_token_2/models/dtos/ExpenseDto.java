package com.company.jwt_token_2.models.dtos;

import com.company.jwt_token_2.models.enums.PurposeExpense;
import com.company.jwt_token_2.models.enums.Status;
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
public class ExpenseDto {
    Long id;
    Date created;
    Date updated;
    Status status;
    PurposeExpense purposeExpense;
    double sum;
    BillDto bill;
    UserDto user;
}
