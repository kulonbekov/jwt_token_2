package com.company.jwt_token_2.services.impl;

import com.company.jwt_token_2.mappers.BillMapper;
import com.company.jwt_token_2.models.Bill;
import com.company.jwt_token_2.models.dtos.BillDto;
import com.company.jwt_token_2.models.enums.Status;
import com.company.jwt_token_2.repository.BillRep;
import com.company.jwt_token_2.services.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {
    BillMapper billMapper = BillMapper.INSTANCE;
    private final BillRep billRep;
    @Override
    public BillDto save(BillDto billDto) {
        return billMapper.toDto(billRep.save(billMapper.toEntity(billDto)));
    }

    @Override
    public BillDto findById(Long id) {
        return billMapper.toDto(billRep.findById(id).orElseThrow(()->new RuntimeException("Bill not found")));
    }

    @Override
    public List<BillDto> findAll() {
        return billMapper.toDtos(billRep.findAll());
    }

    @Override
    public BillDto delete(Long id) {
        BillDto billDto = billMapper.toDto(billRep.findById(id).orElseThrow(()->new RuntimeException("Bill not found")));
        billDto.setStatus(Status.DELETED);
        return save(billDto);
    }
}
