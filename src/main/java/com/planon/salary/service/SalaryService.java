package com.planon.salary.service;

import com.planon.salary.model.SalaryReuestDto;

import java.util.List;

public interface SalaryService {

    List<SalaryReuestDto> getIncrementalSalary(List<SalaryReuestDto> employeeSalaryList);
}
