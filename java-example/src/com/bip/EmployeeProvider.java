package com.bip;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProvider {
    public static List<Employee> getTenActualEmployees() {
        List<Employee> employeeList = new ArrayList<>();

        // Simulating 10 actual employee records (replace with database access)
        employeeList.add(new Employee(1L, "John", "Doe", 60000.0, "Male"));
        employeeList.add(new Employee(2L, "Jane", "Smith", 55000.0, "Female"));
        employeeList.add(new Employee(3L, "Alice", "Johnson", 62000.0, "Female"));
        employeeList.add(new Employee(4L, "Bob", "Brown", 58000.0, "Male"));
        employeeList.add(new Employee(5L, "Eve", "Williams", 63000.0, "Female"));
        employeeList.add(new Employee(6L, "Charlie", "Davis", 57000.0, "Male"));
        employeeList.add(new Employee(7L, "Grace", "Wilson", 61000.0, "Female"));
        employeeList.add(new Employee(8L, "David", "Lee", 59000.0, "Male"));
        employeeList.add(new Employee(9L, "Olivia", "Clark", 64000.0, "Female"));
        employeeList.add(new Employee(10L, "Sophia", "Johnson", 60000.0, "Female"));

        return employeeList;
    }
}
