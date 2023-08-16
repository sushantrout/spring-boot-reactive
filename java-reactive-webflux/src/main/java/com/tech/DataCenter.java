package com.tech;

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DataCenter {
	public Mono<Integer> getNumber() {
		return Mono.just(42).delayElement(Duration.ofSeconds(5));
	}
	
	public Flux<Integer> getNumbers() {
		return Flux.range(1, 10).delayElements(Duration.ofSeconds(1));
	}
}
