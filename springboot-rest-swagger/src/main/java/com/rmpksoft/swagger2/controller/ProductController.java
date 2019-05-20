package com.rmpksoft.swagger2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
@Api(tags = "title")
public class ProductController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(value = "/{id}", produces = {"application/json"}, method = RequestMethod.GET)
	@ApiOperation(value = "Find product by id", notes = "Returns a product from the catalog")
	public ResponseEntity<Product> findProduct(@ApiParam(value = "Product Id", required = true) @PathVariable("id") long id) {
		System.out.println("Get product info...............");
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
