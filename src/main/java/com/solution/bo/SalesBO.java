package com.solution.bo;

import java.io.Serializable;
import java.util.List;

public class SalesBO implements Serializable {

	private static final long serialVersionUID = -4906899556716256743L;

	String companyName;
	String orderDate;
	int orderNumber;
	int qty;
	List<ProductBO> productList;

	public List<ProductBO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductBO> productList) {
		this.productList = productList;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
