package com.company.jwt_token_2.models;

import com.company.jwt_token_2.models.enums.TypeOfIncome;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_income")
public class Income extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_income")
    TypeOfIncome typeOfIncome;
    @Column(name = "sum")
    double sum;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    Bill bill;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
