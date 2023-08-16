package com.tech;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureTestRunAsync {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture.runAsync(() -> {
			System.out.println("Run Async :)");
		}).get();
		
		CompletableFuture.runAsync(() -> {
			System.out.println("Run Async1 :)");
		}, Executors.newFixedThreadPool(2));
		
		System.exit(0);
	}
}
