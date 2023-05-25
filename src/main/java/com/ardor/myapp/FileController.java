package com.ardor.myapp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ardor.model.FileDTO;
import com.ardor.service.FileService;
import com.ardor.service.UtilityService;

@Controller
public class FileController {

	@Autowired FileService fileService;
	@Autowired UtilityService utilService;
	
	
	// 파일업로드 및 주소가져오기
	@PostMapping("/member/profilePhoto")
	public ResponseEntity<Object> insertFileToDB(@RequestParam("memberPhoto") MultipartFile memberPhoto){
		
		System.out.println("진입성공!");
		
		
		// 파일 업로드 및 성공메세지
		boolean successMessage = fileService.uploadFile(memberPhoto);
		
		
		// 이미지 URL생성 및 가져오기
		
		
		
		Map<String, Object> response = new HashMap<>();
		response.put("OK","컨트롤러 연결성공!");
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
}
