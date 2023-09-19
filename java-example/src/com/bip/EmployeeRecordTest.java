package com.bip;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRecordTest {
    public static void main(String[] args) {
        var records = new ArrayList<>();
        var tenActualEmployees = EmployeeProvider.getTenActualEmployees();
        tenActualEmployees.stream().forEach(e -> {
            records.add(new EmployeeR(e.getId(), e.getfName(), e.getlName(), e.getSalary(), e.getGender()));
        });

        records.forEach(System.out::println);
    }
}
