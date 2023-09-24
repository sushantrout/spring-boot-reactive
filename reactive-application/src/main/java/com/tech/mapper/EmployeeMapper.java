package com.tech.mapper;

import com.tech.dto.EmployeeDTO;
import com.tech.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements RMapper<EmployeeDTO, Employee>{
    @Override
    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(), employee.getName(), employee.getAge(), employee.getGender(), employee.getSalary());
        return employeeDTO;
    }

    @Override
    public Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.id());
        employee.setAge(dto.age());
        employee.setGender(dto.gender());
        employee.setName(dto.name());
        employee.setSalary(dto.salary());
        return employee;
    }
}
