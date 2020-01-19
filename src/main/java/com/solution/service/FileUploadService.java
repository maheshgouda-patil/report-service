package com.solution.service;

import org.springframework.web.multipart.MultipartFile;

import com.solution.exception.SolutionException;

public interface FileUploadService {

  String uploadFile(MultipartFile[] multipartFiles, String fileType)
      throws SolutionException;
}
