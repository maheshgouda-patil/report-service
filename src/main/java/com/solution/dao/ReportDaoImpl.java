package com.solution.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.solution.bo.ProductBO;
import com.solution.bo.ProfitBO;
import com.solution.bo.RevenueBO;
import com.solution.bo.SalesBO;
import com.solution.util.CurrencyConversionUtil;
import com.solution.util.H2JDBCUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class ReportDaoImpl implements ReportDao {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String SALES = "select S.ORDER_NUMBER, S.ORDER_DATE, SUM(PRICE), S.PRODUCT_ID, S.CURRENCY from TBL_SALES S, TBL_COMPANY C where C.COMPANY_NAME = S.COMPANY and C.COMPANY_ID = ?  GROUP BY ORDER_NUMBER";
	private static final String REVENUE = "Select month, year, sum(price) from TBL_SALES group by month, year";
	private static final String PROFIT = "Select month, year, sum(price) from TBL_SALES group by month, year";

	public Set<SalesBO> fetchSalesReport(int companyId) {
		// TODO Auto-generated method stub
         Set<SalesBO> sales_list = new TreeSet<SalesBO>();
		try (Connection connection = H2JDBCUtils.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(SALES);) {
	            preparedStatement.setInt(1, companyId);
	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            List<ProductBO> prod_list = new ArrayList<ProductBO>();
	            while (rs.next()) {
	            	SalesBO sales_bo = new SalesBO();
	                sales_bo.setCompanyName(rs.getString("COMPANY"));
	                sales_bo.setOrderDate(rs.getString("ORDER_DATE"));
	                sales_bo.setOrderNumber(rs.getInt("ORDER_NUMBER"));
	                sales_bo.setQty(rs.getInt("QUANTITY"));
	                sales_list.add(sales_bo);
	                ProductBO prod_bo = new ProductBO();
	                prod_bo.setName(rs.getString("PRODUCT_NAME"));
	                prod_bo.setCurrency("EUR");
	                Double exchangePrice = (Double) CurrencyConversionUtil.currencyMap.get(rs.getString("CURRENCY"));
	                Double price = rs.getDouble("PRICE") * exchangePrice * rs.getInt("QUANTITY");
	                prod_bo.setBuildCost(price);
	                prod_list.add(prod_bo);
	                sales_bo.setProductList(prod_list);
	            }
	        } catch (SQLException e) {
	            H2JDBCUtils.printSQLException(e);
	        }
		
		return sales_list;
	}

	@Override
	public RevenueBO fetchRevenueReport(int companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfitBO fetchProfitReport(int companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
