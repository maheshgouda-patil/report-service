package com.solution.bo;

import java.io.Serializable;
import java.util.List;

public class RevenueBO implements Serializable {

	private static final long serialVersionUID = -4906899556716256743L;

	double profit;
	double salesPrice;
	double productCost;
	int month;
	int year;
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "RevenueBO [profit=" + profit
				+ ", month=" + month + ", year=" + year + "]";
	}

	
}
