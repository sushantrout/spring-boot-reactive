package com.bip;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeeingExampl {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeProvider.getTenActualEmployees();

        Map<String, Long> ageCountMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        ageCountMap.forEach((k, v) -> {
            System.out.println(k +"=>" + v);
        });

        Double collect = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.teeing(
                        Collectors.summingDouble(e -> e),
                        Collectors.counting(),
                        (s, c) -> s / c
                ));

        System.out.println(collect);

        String highestPaidEmployeeName = employees.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), // Find max salary employee
                        employeeOpt -> employeeOpt.map(Employee::getfName).orElse("No employee found") // Extract the name or provide a default
                ));

        System.out.println("Employee with Highest Salary: " + highestPaidEmployeeName);
    }
}
