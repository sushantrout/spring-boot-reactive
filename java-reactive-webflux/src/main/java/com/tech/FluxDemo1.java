package com.tech;

import java.io.IOException;

public class FluxDemo1 {
	private static DataCenter dataCenter = new DataCenter();

	public static void main(String[] args) throws IOException {
		dataCenter.getNumber().subscribe(e -> System.out.println("MONO: " + e));
		dataCenter.getNumbers().subscribe(e -> System.out.println("Flux" + e));
		System.in.read();
		System.out.println("Done");
	}
}
