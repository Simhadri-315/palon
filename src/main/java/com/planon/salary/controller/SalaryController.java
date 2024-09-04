package com.planon.salary.controller;

import com.planon.salary.model.SalaryReuestDto;
import com.planon.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @PostMapping("/getSalary")
    public ResponseEntity<List<SalaryReuestDto>> getIncrementalSalary(@RequestBody List<SalaryReuestDto> employeeSalaryList){

        return ResponseEntity.ok(salaryService.getIncrementalSalary(employeeSalaryList));
    }
}
