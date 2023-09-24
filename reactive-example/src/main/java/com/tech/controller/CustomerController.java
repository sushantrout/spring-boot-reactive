package com.tech.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Customer;
import com.tech.service.CustomerService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/api/customer")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping
	public List<Customer> getALlCustomers() {
		return customerService.getALlCustomers();
	}
	
	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getALlCustomersStream() {
		return customerService.getALlCustomersStream();
	}
}
