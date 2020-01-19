package com.solution.bo;

import java.io.Serializable;

public class ProductBO implements Serializable {

	private static final long serialVersionUID = -4404858544470493290L;
	
	String name;
	Integer productId;
	Double buildCost;
	String currency;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Double getBuildCost() {
		return buildCost;
	}
	public void setBuildCost(Double buildCost) {
		this.buildCost = buildCost;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
		
}
