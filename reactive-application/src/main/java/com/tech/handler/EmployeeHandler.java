package com.tech.handler;

import com.tech.dto.EmployeeDTO;
import com.tech.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeHandler {
    private final EmployeeService employeeService;

    public Mono<ServerResponse> getEmployee(ServerRequest serverRequest) {
        Flux<EmployeeDTO> employeeDTOFlux = Flux.fromIterable(employeeService.findAll());
        Mono<ServerResponse> body = ServerResponse.ok().body(employeeDTOFlux,  EmployeeDTO.class);
        return body;
    }
}
