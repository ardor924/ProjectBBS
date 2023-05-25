package com.ardor.service;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ardor.mapper.FileMapper;
import com.ardor.model.FileDTO;

@Service
public class FileServiceImpl implements FileService{

	
	@Autowired UtilityService utilService;
	@Autowired FileMapper fileMapper;
	
	
	// 파일 업로드
	@Override
	public String uploadFile(MultipartFile file) {
		
		
        String errorMessage = "이미지 업로드 중 오류가 발생했습니다.";

		
		// 이미지 업로드 로직 수행
		try {
			// 필수 파라미터 생성
			String fileRoot = "C:\\file_repo\\";
			Date fileRegdate = utilService.getNowDate();
			String fileStrRegdate = utilService.getFolderDate();
			String uuid = UUID.randomUUID().toString();
			String filePath = fileRoot + fileStrRegdate + "\\";
			
			// 폴더생성
	        File folderGenerator = new File(fileRoot + fileStrRegdate);
	        if (!folderGenerator.exists()) {
	            folderGenerator.mkdirs(); // mkdir 가아닌 mkdirs여야 폴더가 생성됨
	        } else {
	            System.out.println("폴더가 이미 존재합니다!");
	        }
			
	        // 물리 폴더에 파일 저장
	        File saveFile = new File(filePath, uuid+file.getOriginalFilename());
	        file.transferTo(saveFile);
	        
	        
	        // 파일정보를 DB에 등록
	        String fileName = uuid+file.getOriginalFilename();
	        String fileRealName = file.getOriginalFilename();
	        
	        FileDTO fileDTO = new FileDTO();      
	        fileDTO.setFileName(fileName);
	        fileDTO.setFileRealName(fileRealName);
	        fileDTO.setFilePath(filePath);
	        fileDTO.setFileRegdate(fileRegdate);
	        
	        System.out.println(fileDTO.toString());
	        
	        
	        int success = fileMapper.insertFileToDB(fileDTO);
	                
	        if(success == 0) {
	        		System.out.println("DB등록 실패");
	        }
	        
	        	System.out.println("DB등록 성공");
	        // 이미지 업로드 성공 응답 데이터 생성
	        String responseMessage = "이미지가 업로드되었습니다.";
	        
	        
	        String imageUrl = "http://localhost:8080/myapp/member/profilePhoto/" + fileRegdate + "/" + fileName;
	        
	        
	        
			
	        return imageUrl;
	        
		} catch (Exception e) {
			return errorMessage;
		}
		
		
		
		
	}
	
	
	

	
}
