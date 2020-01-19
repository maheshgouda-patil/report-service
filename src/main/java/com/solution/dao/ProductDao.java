package com.solution.dao;


import java.io.File;

public interface ProductDao {

	String loadProductTable(String fileName, File file) throws Exception; 

}
