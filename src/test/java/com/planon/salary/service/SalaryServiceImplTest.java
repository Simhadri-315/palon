package com.planon.salary.service;

import com.planon.salary.model.SalaryReuestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SalaryServiceImplTest {

    @InjectMocks
    SalaryServiceImpl salaryService;

    List<SalaryReuestDto> salaryReuestDtoList = new ArrayList<>();

    @BeforeEach
    void setup(){
        salaryReuestDtoList = Arrays.asList(SalaryReuestDto.builder().name("Joey").department("Sales").salary(480000.00).build(),
                SalaryReuestDto.builder().name("Ross").department("Operations").salary(550000.00).build(),
                SalaryReuestDto.builder().name("Monica").department("Manager").salary(450000.00).build(),
                SalaryReuestDto.builder().name("Phoebe").department("Sales").salary(600000.00).build(),
                SalaryReuestDto.builder().name("Chandler").department("Developer").salary(530000.00).build(),
                SalaryReuestDto.builder().name("Rachel").department("Operations").salary(580000.00).build());
    }

    @Test
    void testIncrementalSalary(){

        assertEquals(660000, salaryService.getIncrementalSalary(salaryReuestDtoList).get(0).getSalary());
    }

    @Test
    void testIncrementalSalaryWithEmptyRequest(){

        assertEquals(0, salaryService.getIncrementalSalary(new ArrayList<>()).size());
    }
}
