package com.solution.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.solution.dao.ProductDaoimpl;
import com.solution.dao.SalesDaoImpl;
import com.solution.exception.SolutionException;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String uploadFile(MultipartFile[] multipartFiles, String fileType) throws SolutionException {

		if (multipartFiles.length == 0) {
			throw new SolutionException("Execption occured", "file length zero");
		}

		for (MultipartFile multipartFile : multipartFiles) {

			try {
				File file = convertMultiPartToFile(multipartFile);
				uploadFileToH2Tables(file.getName(), file, fileType);
				file.delete();
			} catch (Exception ex) {
				logger.error("failed to upload file :", ex);
				throw new SolutionException("failed to upload file", "execption happened");
			}
		}
		return "Success : files uploaded successfully";
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	private void uploadFileToH2Tables(String fileName, File file, String fileType) throws Exception {
		
		ProductDaoimpl products= null;
		SalesDaoImpl slaes_orders = null;
		
		if(fileType.toUpperCase().equals("SALES")) {
			slaes_orders = new SalesDaoImpl();
			slaes_orders.loadSalesTable(fileName, file);
		} else {
			products = new ProductDaoimpl();
			products.loadProductTable(fileName, file);
		}
		
		
		
		

	}

}
