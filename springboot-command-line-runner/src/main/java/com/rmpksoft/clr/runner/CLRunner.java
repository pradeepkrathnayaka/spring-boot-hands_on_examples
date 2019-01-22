package com.rmpksoft.clr.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		 System.out.println("The CLRunner start...");
	}
}
