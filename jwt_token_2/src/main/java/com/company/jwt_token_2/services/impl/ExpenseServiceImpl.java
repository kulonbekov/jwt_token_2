package com.company.jwt_token_2.services.impl;

import com.company.jwt_token_2.mappers.ExpenseMapper;
import com.company.jwt_token_2.models.dtos.ExpenseDto;
import com.company.jwt_token_2.models.enums.Status;
import com.company.jwt_token_2.repository.ExpenseRep;
import com.company.jwt_token_2.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    ExpenseMapper expenseMapper = ExpenseMapper.INSTANCE;
    private final ExpenseRep expenseRep;
    @Override
    public ExpenseDto save(ExpenseDto expenseDto) {
        return expenseMapper.toDto(expenseRep.save(expenseMapper.toEntity(expenseDto)));
    }

    @Override
    public ExpenseDto findById(Long id) {
        return expenseMapper.toDto(expenseRep.findById(id).orElseThrow(() -> new RuntimeException("Expense is not found")));
    }

    @Override
    public List<ExpenseDto> findAll() {
        return expenseMapper.toDtos(expenseRep.findAll());
    }

    @Override
    public ExpenseDto delete(Long id) {
        ExpenseDto expenseDto = expenseMapper.toDto(expenseRep.findById(id).orElseThrow(() -> new RuntimeException("Expense is not found")));
        expenseDto.setStatus(Status.DELETED);
        return save(expenseDto);
    }
}
