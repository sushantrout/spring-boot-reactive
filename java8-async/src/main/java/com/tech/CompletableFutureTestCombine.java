package com.tech;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTestCombine {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> "Hello -> ");
		CompletableFuture<String> thenCompose = supplyAsync.thenCompose((s) -> CompletableFuture.supplyAsync(() -> s + "World -> "));
		System.out.println(thenCompose.get());
		
		supplyAsync = CompletableFuture.supplyAsync(() -> "Hello");
		thenCompose = CompletableFuture.supplyAsync(() ->"World ");
		String string = supplyAsync.thenCombine(thenCompose, (s1, s2) -> s1 + s2).get();
		System.out.println(string);
		
		supplyAsync.thenAcceptBoth(thenCompose, (s1, s2) -> System.out.print(s1 +" <-> " + s2)).get();
		System.exit(0);
	}
}
