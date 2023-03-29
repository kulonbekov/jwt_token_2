package com.company.jwt_token_2.controller;

import com.company.jwt_token_2.models.dtos.BillDto;
import com.company.jwt_token_2.services.BillService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users/bill")
@RequiredArgsConstructor
public class BillController {
    private final BillService billService;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody BillDto billDto) {
        try {
            return new ResponseEntity<>(billService.save(billDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/find/by/id")
    @ApiOperation("Поиск счета по id")
    ResponseEntity<?> findById(@RequestParam Long id) {

        return new ResponseEntity<>(billService.findById(id), HttpStatus.FOUND);

    }

    @GetMapping("/find/all")
    @ApiOperation("Вывод всех счетов")
    ResponseEntity<List<BillDto>> findAll() {
        return ResponseEntity.ok(billService.findAll());
    }
}
