package com.solution.bo;

import java.io.Serializable;
import java.util.List;

public class ProfitBO implements Serializable {

	private static final long serialVersionUID = -4906899556716256743L;

	double revenue;
	int month;
	int year;
	
	
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
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	
	@Override
	public String toString() {
		return "ProfitBO [revenue=" + revenue + ", month=" + month + ", year=" + year + "]";
	}

}
