package com.company.jwt_token_2.models.enums;

public enum TypeOfIncome {
    SALARY("Зарплата"),
    BONUS("Бонус");

    String value;

    TypeOfIncome(String value) {
        this.value = value;
    }
}
