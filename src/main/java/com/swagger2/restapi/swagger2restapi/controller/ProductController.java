package com.swagger2.restapi.swagger2restapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger2.restapi.swagger2restapi.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(value = "ProductController" , tags = {"Product Controller"})
@SwaggerDefinition(tags = {
        @Tag(name = "Product Controller", description = "Write description here")
})
@RestController
@RequestMapping("/v2")
public class ProductController {

	List<Product> products = Arrays.asList(
        new Product("1","G Tech", "G Tech Hard drive", 230.45, 25),
        new Product("2","WD SSD", "WD HDD", 150, 15),
        new Product("3","Samsung SSD", "Samsung Solid State Drive", 100, 12),
        new Product("5","Sandisk Pen Drive", "Sandisk Pen Drive", 12, 200)
    );
	
	@GetMapping("/products/{code}")
	public Product getProduct (@PathVariable("code") String code) {
		return products.stream()
                .filter(p-> p.getCode().equalsIgnoreCase(code))
                .collect(Collectors.toList()).get(0); // we know this can throw NPE but let's keep our example simpl
	}
	
	/*
	 * @ApiOperation and @ApiResponse
	 * To provide the information about the method and response, add these annotations to the methods
	 */
	
	@ApiOperation(value = "List of all products", response = ArrayList.class, tags = "getProducts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "404 error")
    })
	@GetMapping("/products")
    public List<Product> getProducts(){
        return products;
    }
}
