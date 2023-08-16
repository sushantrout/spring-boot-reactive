package com.tech;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTestCompletedFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> completedFuture = CompletableFuture.completedFuture("Hello World");
		System.out.println(completedFuture.get()); //Not Blocked
		
	}
}
