package com.company.jwt_token_2.mappers;


import com.company.jwt_token_2.models.Expense;
import com.company.jwt_token_2.models.dtos.ExpenseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseMapper extends BaseMapper<Expense, ExpenseDto>{
    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);
}
