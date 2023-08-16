package com.tech;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTestThenApply {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> "Hello");
		
		String string = supplyAsync.thenApply((s) -> s + " World :)").get();
		System.out.println(string);
		System.exit(0);
	}
}
