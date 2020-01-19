package com.solution.dao;

import java.util.Set;

import com.solution.bo.ProfitBO;
import com.solution.bo.RevenueBO;
import com.solution.bo.SalesBO;

public interface ReportDao {

	Set<SalesBO> fetchSalesReport(int companyId);
	RevenueBO fetchRevenueReport(int companyId);
	ProfitBO fetchProfitReport(int companyId);
}
