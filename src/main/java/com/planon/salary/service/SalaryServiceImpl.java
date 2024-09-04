package com.planon.salary.service;

import com.planon.salary.Constants;
import com.planon.salary.model.SalaryReuestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SalaryServiceImpl implements SalaryService{
    @Override
    public List<SalaryReuestDto> getIncrementalSalary(List<SalaryReuestDto> employeeSalaryList) {

        if(CollectionUtils.isEmpty(employeeSalaryList)){
            return employeeSalaryList;
        }
        try {
            List<SalaryReuestDto> resultList = new ArrayList<>();
            employeeSalaryList.stream().map(e -> {
                resultList.add(calculateSalary(e));
                return resultList;
            }).collect(Collectors.toList());
            return resultList.stream().sorted(Comparator.comparingDouble(SalaryReuestDto::getSalary).reversed()).collect(Collectors.toList());
        }catch (Exception ex){
            log.error("Received exception during salary calculation", ex.getStackTrace());
        }
        return employeeSalaryList;
    }

    private SalaryReuestDto calculateSalary(SalaryReuestDto salaryReuestDto) {
        Double percentageIncrement = Constants.getSalaryMap().get(salaryReuestDto.getDepartment())/100;
        salaryReuestDto.setSalary(salaryReuestDto.getSalary() + (salaryReuestDto.getSalary() * percentageIncrement));
        return salaryReuestDto;
    }

}
