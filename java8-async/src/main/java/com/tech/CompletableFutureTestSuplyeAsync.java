package com.tech;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureTestSuplyeAsync {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String string = CompletableFuture.supplyAsync(() -> "Hello World").get();
		System.out.println(string);
		string = CompletableFuture.supplyAsync(() -> "Hello World1", Executors.newCachedThreadPool()).get();
		System.out.println(string);
		System.exit(0);
	}
}
