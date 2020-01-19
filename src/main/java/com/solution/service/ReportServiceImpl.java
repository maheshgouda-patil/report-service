package com.solution.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solution.bo.ProfitBO;
import com.solution.bo.RevenueBO;
import com.solution.bo.SalesBO;
import com.solution.dao.ReportDao;
import com.solution.exception.SolutionException;

@Service
public class ReportServiceImpl implements ReportService {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  ReportDao reportDao;

  @Override
  public Set<SalesBO> fetchSalesReport(int companyId) throws SolutionException {
	  return reportDao.fetchSalesReport(companyId);
  }

@Override
public RevenueBO fetchRevenueReport(int companyId) throws SolutionException {
	return reportDao.fetchRevenueReport(companyId);
}

@Override
public ProfitBO fetchProfiltReport(int companyId) throws SolutionException {
	 return reportDao.fetchProfitReport(companyId); 
}

}
