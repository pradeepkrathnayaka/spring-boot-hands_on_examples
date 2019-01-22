package com.rmpksoft.clr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CLRunnerMain {
	public static void main(String[] args) {
		System.out.println("Start!");
		SpringApplication.run(CLRunnerMain.class, args);
		System.out.println("End!");
	}
}
