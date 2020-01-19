package com.solution.controller;

import com.solution.bo.ResponseBo;
import com.solution.constants.UrlConstants;
import com.solution.exception.*;
import com.solution.service.FileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(UrlConstants.UPLOAD)
public class FileUploadManagement {

  @Autowired
  FileUploadService fileService;

  @RequestMapping(method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<ResponseBo> uploadFileHandler(
      @RequestParam("file") MultipartFile[] multipartFiles,
      @PathVariable("fileType") String fileType)
      throws SolutionException {   
	ResponseBo responseBo = new ResponseBo();
    String message = fileService.uploadFile(multipartFiles,fileType);
    responseBo.setResponse(message);
    return new ResponseEntity<ResponseBo>(responseBo, HttpStatus.OK);

  }
  
}