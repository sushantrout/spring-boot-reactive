package com.tech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.dao.CustomerDAO;
import com.tech.model.Customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
	private final CustomerDAO customerDAO;

	public List<Customer> getALlCustomers() {
		long startTime = System.currentTimeMillis();
		List<Customer> customers = customerDAO.getCustomers().toStream().toList();
		long endTime = System.currentTimeMillis();
		log.error("Time Taken : {}", endTime - startTime);
		return customers;
	}

	public Flux<Customer> getALlCustomersStream() {
		long startTime = System.currentTimeMillis();
		Flux<Customer> customers = customerDAO.getCustomersStream();
		long endTime = System.currentTimeMillis();
		log.error("Time Taken : {}", endTime - startTime);
		return customers;
	}
}
