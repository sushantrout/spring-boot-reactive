package com.tech.controller;

import com.tech.dto.EmployeeDTO;
import com.tech.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO) {
        employeeDTO = employeeService.save(employeeDTO);
        return employeeDTO;
    }

    @GetMapping
    public List<EmployeeDTO> getEmployees() {
        return employeeService.findAll();
    }
}
