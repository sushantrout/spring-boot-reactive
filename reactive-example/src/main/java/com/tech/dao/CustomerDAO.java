package com.tech.dao;

import java.time.Duration;

import org.springframework.stereotype.Component;

import com.tech.model.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDAO {
	private static void sleepExcetion(long i) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}

	public Flux<Customer> getCustomers() {
		return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
                .map(i -> new Customer(Long.valueOf(i), "customer" + i));
	}

	public Flux<Customer> getCustomersStream() {
		return Flux.range(1, 50).delayElements(Duration.ofMillis(1))
				.map(i -> new Customer(Long.valueOf(i), "customer" + i));
	}
}
