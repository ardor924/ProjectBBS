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
	public Map<String, Object> uploadTempFiles(String photoType,MultipartFile file); 
	
	// 파일 업로드
	public boolean uploadFiles(String photoType,String fileToken,int pkNo);
	
	
	// 파일정보 수정
	public boolean updateFiles(FileDTO fileDTO);
	
	
	// 파일 삭제 (게시글 컨텐츠 이미지 파일삭제)
	public boolean deleteFiles(int PK,String whatPK);
	
	
	// 임시 Temp파일 전부 가져오기
	public List<FileDTO> getAllTempFiles(isTEMP TEMP);
	
	// postNo에 해당하는 파일 전부 가져오기
	public List<FileDTO> getAllFilesBysomePK(String photoType, int somePK);
	
	
	
	
	// 임시폴더내의 파일 제거
	public void deleteAllTempFiles();
	
	
	// 폴더이름 필터링
	public String getFolderName(String photoType);
	
	
	// 이미지 파일 가져와서 폴더 분류
	public String setImagePath(String photoType, String date, String filename);
	
	
	//  temp내의 파일정보 DB에서 삭제
	public boolean deleteTempFileFromDB(isTEMP TRUE);
	
	
	// ------------------------ 현재 필요없는 메서드 ---------------------------------------------------------------------------------
	// 이미지 다운로드
	public void processProfilePhoto(MemberDTO memberInfo, HttpServletResponse response,HttpServletRequest request) throws IOException;

	// xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

	
}
