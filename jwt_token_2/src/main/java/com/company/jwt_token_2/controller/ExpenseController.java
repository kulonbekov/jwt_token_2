package com.company.jwt_token_2.controller;

import com.company.jwt_token_2.models.dtos.ExpenseDto;
import com.company.jwt_token_2.services.ExpenseService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody ExpenseDto expense) {
        try {
            return new ResponseEntity<>(expenseService.save(expense), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


    @GetMapping("/find/by/id")
    @ApiOperation("Поиск расхода по id")
    ResponseEntity<?> findById(@RequestParam Long id) {

        return new ResponseEntity<>(expenseService.findById(id), HttpStatus.FOUND);

    }


    @GetMapping("/find/all")
    @ApiOperation("Вывод всех записей по расходам")
    ResponseEntity<List<ExpenseDto>> findAll() {
        return ResponseEntity.ok(expenseService.findAll());
    }
}
