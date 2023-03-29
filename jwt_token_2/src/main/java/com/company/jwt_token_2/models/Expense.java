package com.company.jwt_token_2.models;

import com.company.jwt_token_2.models.enums.PurposeExpense;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_expense")
public class Expense extends BaseEntity{

    @Column(name = "purpose_expense")
    @Enumerated(EnumType.STRING)
    PurposeExpense purposeExpense;
    @Column(name = "sum")
    double sum;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    Bill bill;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
