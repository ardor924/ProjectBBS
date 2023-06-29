package com.ardor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ardor.model.FileDTO;
import com.ardor.model.FileDTO.EntityType;
import com.ardor.model.FileDTO.IsTemp;

@Mapper
public interface FileMapper {
	
	//======================= 등록 =======================
	
	// 파일등록
	public boolean insertFileInfoToDB(FileDTO fileDTO);
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
	
	
	//======================= 조회 =======================
	
	// [전체] 파일조회
	public List<FileDTO> getAllFiles();
	
	// [1개] 파일조회 
	public FileDTO getFileByFileNo(int fileNo); // (fileNo사용)
	
	// [특정엔티티] 파일조회 
	public List<FileDTO> getFilesByEntityType(EntityType entityType); // (entityType사용)
	
	// [특정엔티티] 파일조회 
	public List<FileDTO> getFilesByEntityPK(int entityPK); // (entityPK사용)
	
	// [Temp] 파일조회
	public List<FileDTO> getAllTempFiles(); 
	
	// [Temp] 파일조회
	public List<FileDTO> getFilesFromTempBeforeThreeMonths();
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
	
	
	//======================= 수정 =======================
	
	// 파일수정
	public boolean updateFileInfoToDB(FileDTO fileDTO);
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx	
	
	
	
	
	//======================= 삭제 =======================
	
	// [1개] 파일삭제
	public boolean deleteFileByFileNo(int fileNo); // (fileNo사용)
	
	// [특정엔티티] 파일삭제
	public boolean deleteFilesByEntityType(EntityType entityType); // (entityType사용)
	
	// [특정엔티티] 파일삭제
	public boolean deleteFilesByEntityPK(int entityPK); // (entityPK사용)
	
	// [Temp] 파일삭제
	public boolean deleteAllTempFilesFromDB(); 
	
	// [Temp] 파일삭제
	public boolean deleteFilesFromTempBeforeThreeMonths();
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx	

	
	
	
}
