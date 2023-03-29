package com.company.jwt_token_2.models.enums;

public enum PurposeExpense {
    INVESTMENTS("Инвестиции"),
    PRODUCTS("Продукты"),
    PHONE("Расходы на связь"),
    TAXI("Такси"),
    FOOD_DELIVERY("Доставка еды"),
    REST("Отдых"),
    SHOPPING("Одежда"),
    HEALTH("Здоровье"),
    PUBLIC_UTILITIES("Коммунальные услуги"),
    PETROL("Бензин"),
    SALON("Салон красоты"),
    ANOTHER("Другое");

    String value;

    PurposeExpense(String value) {
        this.value = value;
    }
}
