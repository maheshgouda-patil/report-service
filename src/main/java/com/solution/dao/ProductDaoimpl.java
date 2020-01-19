package com.solution.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.solution.util.H2JDBCUtils;

@Repository
public class ProductDaoimpl implements ProductDao {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String QUERY = "CREATE TABLE TBL_PRODUCT AS SELECT * FROM CSVREAD('?');";
	//private static final String QUERY1 = "select company_id from TBL_COMPANY where COMPANY_NAME like ?";
	//private static final String QUERY2 = "insert into TBL_COMPANY(COMPANY_NAME) values ( ? )";

	@Override
	public String loadProductTable(String fileName, File file) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * int company_id = 0; try (Connection connection = H2JDBCUtils.getConnection();
		 * 
		 * PreparedStatement preparedStatement = connection.prepareStatement(QUERY1);) {
		 * preparedStatement.setString(1, fileName);
		 * System.out.println(preparedStatement); ResultSet rs =
		 * preparedStatement.executeQuery(); while (rs.next()) { company_id =
		 * rs.getInt("COMPANY_ID"); }
		 * 
		 * } catch (SQLException e) { H2JDBCUtils.printSQLException(e); }
		 * 
		 * 
		 * if(company_id == 0) { try (Connection connection =
		 * H2JDBCUtils.getConnection();
		 * 
		 * // Step 2:Create a statement using connection object PreparedStatement
		 * preparedStatement = connection.prepareStatement(QUERY2);) {
		 * preparedStatement.setString(1, fileName);
		 * System.out.println(preparedStatement); // Step 3: Execute the query or update
		 * query ResultSet rs = preparedStatement.executeQuery();
		 * 
		 * // Step 4: Process the ResultSet object. while (rs.next()) { company_id =
		 * rs.getInt("COMPANY_ID"); }
		 * 
		 * } catch (SQLException e) { H2JDBCUtils.printSQLException(e); } }
		 */
		
		try (Connection connection = H2JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
				preparedStatement.setString(1, fileName);
				preparedStatement.executeQuery();
				
			} catch (SQLException e) {
				H2JDBCUtils.printSQLException(e);
			}
		

		return "File uploaded successfully";

	}

}
