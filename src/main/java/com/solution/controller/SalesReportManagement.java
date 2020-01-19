package com.solution.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solution.bo.ResponseBo;
import com.solution.exception.SolutionException;
import com.solution.service.ReportService;

@RestController
@RequestMapping(com.solution.constants.UrlConstants.SALES)
public class SalesReportManagement {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  ReportService reportService;

  @RequestMapping(
      value = com.solution.constants.UrlConstants.COMPANY_ID,
      method = RequestMethod.GET)
  public ResponseEntity<ResponseBo> fetchReport(@PathVariable("companyId") int companyId) throws SolutionException {
	  com.solution.bo.ResponseBo responseBo = new com.solution.bo.ResponseBo();
	  responseBo.setResponse(reportService.fetchSalesReport(companyId));
	  return new ResponseEntity<>(responseBo, HttpStatus.OK);
  }
  
}
