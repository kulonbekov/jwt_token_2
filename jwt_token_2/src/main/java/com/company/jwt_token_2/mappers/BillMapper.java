package com.company.jwt_token_2.mappers;

import com.company.jwt_token_2.models.Bill;
import com.company.jwt_token_2.models.dtos.BillDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillMapper extends BaseMapper<Bill, BillDto> {
    BillMapper INSTANCE = Mappers.getMapper(BillMapper.class);
}
