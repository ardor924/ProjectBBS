package com.ardor.service;

import org.springframework.web.multipart.MultipartFile;

import com.ardor.model.FileDTO;


public interface FileService {
	
	
	// 파일업로드
	public String uploadFile(MultipartFile file);
	

}
