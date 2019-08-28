package com.rmpksoft.helloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmpksoft.helloworld.service.HelloWorldService;

@RestController
@RequestMapping("greetings")
public class HelloWorldController {

	@Value("${message}")
	private String message;
	
	private HelloWorldService helloWorldService;

	@RequestMapping("/{msg}")
	public String helloWorld( @PathVariable("msg") String msg) {
		System.out.println("Path Variable message : " + msg);
		return message;
	}

}
