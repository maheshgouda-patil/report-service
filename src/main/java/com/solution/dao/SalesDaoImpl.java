package com.solution.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class SalesDaoImpl implements SalesDao {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String loadSalesTable(String fileName, File file) {
		// TODO Auto-generated method stub
		try (Scanner scanner = new Scanner(new File(fileName))) {

			while (scanner.hasNext()){
				logger.info(scanner.nextLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "upload successfull";
	}

}
