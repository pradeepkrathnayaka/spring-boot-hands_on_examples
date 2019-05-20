package com.rmpksoft.interceptor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@GetMapping("/test")
	public String hello() {
		return "Test Message";
	}

	@GetMapping("")
	public ResponseEntity<List<Post>> getAllPosts() {
		List<Post> list = new ArrayList<>();
		list.add(new Post("Post1", "Post1"));
		list.add(new Post("Post2", "Post2"));
		list.add(new Post("Post3", "Post3"));
		list.add(new Post("Post4", "Post4"));
		ResponseEntity<List<Post>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		// ResponseEntity.ok().build()
		return responseEntity;
	}

	@PostMapping("")
	public ResponseEntity<Void> createPost(RequestEntity<Post> requestEntity) {
		System.out.println("request body : " + requestEntity.getBody());
		HttpHeaders headers = requestEntity.getHeaders();
		System.out.println("request headers : " + headers);
		HttpMethod method = requestEntity.getMethod();
		System.out.println("request method : " + method);
		System.out.println("request url: " + requestEntity.getUrl());

		Post post = requestEntity.getBody();

		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updatePost(RequestEntity<Post> requestEntity, @PathVariable("id") String id) {

		System.out.println("request body : " + requestEntity.getBody());
		HttpHeaders headers = requestEntity.getHeaders();
		System.out.println("request headers : " + headers);
		HttpMethod method = requestEntity.getMethod();
		System.out.println("request method : " + method);
		System.out.println("request url: " + requestEntity.getUrl());

		System.out.println("Id : " + id);
		Post post = requestEntity.getBody();

		return ResponseEntity.ok().build();
	}

	// @DeleteMapping("/{id}")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePost(RequestEntity<?> requestEntity, @PathVariable("id") String id) {

		System.out.println("request body : " + requestEntity.getBody());
		HttpHeaders headers = requestEntity.getHeaders();
		System.out.println("request headers : " + headers);
		HttpMethod method = requestEntity.getMethod();
		System.out.println("request method : " + method);
		System.out.println("request url: " + requestEntity.getUrl());

		System.out.println("Id : " + id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
