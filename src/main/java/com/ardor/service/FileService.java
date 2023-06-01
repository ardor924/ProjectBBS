package com.ardor.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.ardor.model.MemberDTO;


public interface FileService {
	
	
	// 파일업로드
	public Map<String, Object> uploadFile(MultipartFile file);
	
	// 업로드된 파일 및 URL을 제외한 이전 파일들 삭제
	
	
	
	// 
	public void processProfilePhoto(MemberDTO memberInfo, HttpServletResponse response,HttpServletRequest request) throws IOException;

	
}
