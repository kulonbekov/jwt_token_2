package com.company.jwt_token_2.services.impl;

import com.company.jwt_token_2.mappers.IncomeMapper;
import com.company.jwt_token_2.models.dtos.IncomeDto;
import com.company.jwt_token_2.models.enums.Status;
import com.company.jwt_token_2.repository.ExpenseRep;
import com.company.jwt_token_2.repository.IncomeRep;
import com.company.jwt_token_2.services.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    IncomeMapper incomeMapper = IncomeMapper.INSTANCE;
    private final IncomeRep incomeRep;
    private final ExpenseRep expenseRep;

    @Override
    public IncomeDto save(IncomeDto incomeDto) {
        return incomeMapper.toDto(incomeRep.save(incomeMapper.toEntity(incomeDto)));
    }

    @Override
    public IncomeDto findById(Long id) {
        return incomeMapper.toDto(incomeRep.findById(id).orElseThrow(() -> new RuntimeException("Income is not found")));
    }

    @Override
    public List<IncomeDto> findAll() {
        return incomeMapper.toDtos(incomeRep.findAll());
    }

    @Override
    public IncomeDto delete(Long id) {
        IncomeDto incomeDto = incomeMapper.toDto(incomeRep.findById(id).orElseThrow(() -> new RuntimeException("Income is not found")));
        incomeDto.setStatus(Status.DELETED);
        return save(incomeDto);
    }
}
