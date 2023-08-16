package com.tech;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureTest {
	public static void main(String[] args) {
		CompletableFuture<String> completableFuture = callAsunc();
		try {
			String string = completableFuture.get(); //not block
			System.out.println(string);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	private static CompletableFuture<String> callAsunc() {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		
		List<String> asList = Arrays.asList("A", "B", "C", "D");
		
		Executors.newCachedThreadPool().submit(() -> {
			try {
				Thread.sleep(2000);
				completableFuture.complete(String.join(",", asList));
			} catch (InterruptedException e) {
			}
		});
		return completableFuture;
	}
}
