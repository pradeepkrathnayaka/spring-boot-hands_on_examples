package com.rmpksoft.clr.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CLRunnerOrder1 implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("The CLRunnerOrder1 start...");	
	}

}
