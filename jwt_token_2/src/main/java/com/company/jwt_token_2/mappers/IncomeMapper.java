package com.company.jwt_token_2.mappers;


import com.company.jwt_token_2.models.Income;
import com.company.jwt_token_2.models.dtos.IncomeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IncomeMapper extends BaseMapper<Income, IncomeDto>{
    IncomeMapper INSTANCE= Mappers.getMapper(IncomeMapper.class);
}
