package com.company.jwt_token_2.controller;

import com.company.jwt_token_2.models.dtos.IncomeDto;
import com.company.jwt_token_2.services.IncomeService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users/income")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody IncomeDto income) {
        try {
            return new ResponseEntity<>(incomeService.save(income), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


    @GetMapping("/find/by/id")
    @ApiOperation("Поиск дохода по id")
    ResponseEntity<?> findById(@RequestParam Long id) {

        return new ResponseEntity<>(incomeService.findById(id), HttpStatus.FOUND);

    }


    @GetMapping("/find/all")
    @ApiOperation("Вывод всех записей по доходам")
    ResponseEntity<List<IncomeDto>> findAll() {
        return ResponseEntity.ok(incomeService.findAll());
    }
}
