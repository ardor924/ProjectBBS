package com.ardor.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ardor.model.FileDTO.EntityType;

public interface FileService {
	
	//======================= 등록 =======================
	
	// [Temp] 파일업로드
	public Map<String, Object> uploadTempFiles(EntityType entityType, MultipartFile file);
	
	
	// [실제폴더] 파일 업로드
	public boolean uploadFiles(EntityType entityType,String fileIdentifier,int entityPK);
	
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
	//======================= 삭제 =======================
	
	// [1개] 파일삭제
	public boolean deleteFileByFileNo(int fileNo); // (fileNo사용)
	
	// [특정엔티티] 파일삭제
	public boolean deleteFilesByEntityType(EntityType entityType); // (entityType사용)
	
	// [특정엔티티] 파일삭제
	public boolean deleteFilesByEntityPK(int entityPK); // (entityPK사용)
	
	// [Temp] 파일삭제 (DB삭제)
	public boolean deleteAllTempFilesFromDB();
	
	// [Temp] 파일삭제 (실제폴더)
	public boolean deleteAllTempFiles();
	
	// [업데이트] 파일삭제 (Temp파일)
	public boolean deleteUnmodifiedFiles(List<String> fileNames,int entityPK);
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

	
	
	
	
	//======================= 유틸 =======================
	
	// [엔티티타입]	폴더이름 세팅
	public String setFolderName(EntityType entityType);
	
	// [엔티티타입]	이미지폴더 경로 세팅
	public String setImagePath(String entityType, String date,String fileName);
	
	// [회원프사] URL생성 및 가져오기
	public String getMemberProfileImgUrlByMemberID(String memberID);
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
}
