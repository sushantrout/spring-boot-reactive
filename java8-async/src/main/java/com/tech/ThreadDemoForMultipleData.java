package com.tech;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemoForMultipleData {
	public static void main(String[] args) throws InterruptedException {
		CopyOnWriteArrayList<Integer> arrayList = new CopyOnWriteArrayList<>();
		AtomicInteger integer = new AtomicInteger();
		List<Runnable> allRe = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Runnable r = () -> {
				try {
					int incrementAndGet = integer.incrementAndGet();
					arrayList.add(incrementAndGet);
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
			allRe.add(r);
		}

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		allRe.forEach(executorService::submit);

		executorService.shutdown();
		executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // Wait for tasks to complete

		arrayList.stream().sorted().forEach(System.out::println);

	}
}
