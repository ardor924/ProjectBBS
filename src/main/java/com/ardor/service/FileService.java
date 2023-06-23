package com.ardor.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.ardor.model.FileDTO;
import com.ardor.model.FileDTO.isTEMP;
import com.ardor.model.MemberDTO;

public interface FileService {
	
	// 임시 파일 업로드
	public Map<String, Object> uploadTempFile(String photoType,MultipartFile file); 
	
	// 파일 업로드
	public boolean uploadFile(String photoType,int postNo);
	
	
	
	
	// 파일 삭제 로직 (게시글 컨텐츠 이미지 파일삭제)
	public boolean deleteFiles(int PK,String whatPK);
	
	
	
	
	// temp파일정보 DB수정
	public boolean updateFiles(String photoType,List<FileDTO> files);
	
	// 임시 Temp파일 전부 가져오기
	public List<FileDTO> getAllTempFiles(isTEMP TEMP);
	
	// postNo에 해당하는 파일 전부 가져오기
	public List<FileDTO> getAllFilesByPostNo(int postNo);
	
	
	
	// 이미지 출력용
	public void processProfilePhoto(MemberDTO memberInfo, HttpServletResponse response,HttpServletRequest request) throws IOException;
	
}
