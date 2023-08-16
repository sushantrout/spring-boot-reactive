package com.tech;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureTestAllOf {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
			System.out.println("Run Async :)");
		});
		
		CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
			System.out.println("Run Async1 :)");
		}, Executors.newFixedThreadPool(2));
		
		boolean done = CompletableFuture.allOf(f1, f2).isDone();
		System.out.println(done);
		System.exit(0);
	}
}
