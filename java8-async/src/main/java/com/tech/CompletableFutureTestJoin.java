package com.tech;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTestJoin {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "1");
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return "2";
		});
		CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "3");

		String collect = Stream.of(f1, f2, f3).map(e -> {
				return e.join();
		}).collect(Collectors.joining(","));
		System.out.println(collect);
	}
}
