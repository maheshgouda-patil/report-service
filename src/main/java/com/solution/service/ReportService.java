package com.solution.service;

import java.util.Set;

import com.solution.bo.ProfitBO;
import com.solution.bo.RevenueBO;
import com.solution.bo.SalesBO;
import com.solution.exception.SolutionException;

public interface ReportService {

	Set<SalesBO> fetchSalesReport(int companyName) throws SolutionException;
   RevenueBO fetchRevenueReport(int companyId) throws SolutionException;
   ProfitBO fetchProfiltReport(int companyId) throws SolutionException;
 
}
