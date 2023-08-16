package com.tech;

import java.io.IOException;
import java.util.List;

public class FluxDemo1 {
	private static DataCenter dataCenter = new DataCenter();

	public static void main(String[] args) throws IOException {
		dataCenter.getNumber().subscribe(e -> System.out.println("MONO: " + e));
		dataCenter.getNumbers().subscribe(e -> System.out.println("Flux" + e));
		List<Integer> list = dataCenter.getNumbers().toStream().toList();//blocking
		System.out.println(list);
		System.out.println("Press any key to stop :)");
		System.in.read();
		System.out.println("Done");
	}
}
