package com.rmpksoft.helloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Value("${message}")
	private String message;

	@RequestMapping("/")
	public String helloWorld() {
		return message;
	}

}
