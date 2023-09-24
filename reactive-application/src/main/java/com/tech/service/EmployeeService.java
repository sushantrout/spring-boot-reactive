package com.tech.service;

import com.tech.constant.KafkaConstant;
import com.tech.dto.EmployeeDTO;
import com.tech.mapper.EmployeeMapper;
import com.tech.model.Employee;
import com.tech.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final KafkaTemplate kafkaTemplate;
    ExecutorService service = Executors.newFixedThreadPool(5);

    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        employeeDTO = employeeMapper.toDTO(employeeRepository.save(employee));
        EmployeeDTO finalEmployeeDTO = employeeDTO;
        service.submit(() -> {
            try{
                log.error("Initiated");
                kafkaTemplate.send(KafkaConstant.TOPIC, finalEmployeeDTO.name(), finalEmployeeDTO);
                log.error(finalEmployeeDTO.toString());
            } catch (Throwable t) {
                t.printStackTrace();
            }

        });
        return employeeDTO;
    }

    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDTO).toList();
    }
}
