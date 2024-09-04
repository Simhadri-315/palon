package com.planon.salary;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final Map<String, Double> getSalaryMap(){
        Map<String, Double> salaryMap = new HashMap<>();
        salaryMap.put("Developer", 15.00);
        salaryMap.put("Manager", 12.00);
        salaryMap.put("Sales", 10.00);
        salaryMap.put("Operations", 8.00);
        return salaryMap;
    }


}
