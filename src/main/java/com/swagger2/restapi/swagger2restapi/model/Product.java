package com.swagger2.restapi.swagger2restapi.model;

import io.swagger.annotations.ApiModelProperty;

/*
 * @ApiModelProperty
 * Add this annotation to add description to the output
 */

public class Product {

	@ApiModelProperty(name = "code",required = true, value = "123", notes = "Código único identificador do produto")
	private String code;
	
	@ApiModelProperty(name = "name",required = true,value = "Exemplo do nome do produto", notes = "Nome do produto")
	private String name;
	
	@ApiModelProperty(name = "description", required = true,value = "Exemplo da descrição do produto", notes = "Descrição do produto")
	private String description;
	
	@ApiModelProperty(name = "price", required = true, value = "23.45", notes = "Preço do produto")
	private double price;
	
	@ApiModelProperty(name = "stock", required = true, value = "12", notes = "Estoque do produto")
	private long stock;

	public Product(String code, String name, String description, double price, long stock) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}
}
