package com.ardor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ardor.model.FileDTO;
import com.ardor.model.FileDTO.isTEMP;

@Mapper
public interface FileMapper {

	// 파일등록(DB등록)
	public boolean insertFileToDB(FileDTO fileDTO);
	
	//파일 PK로 파일정보 가져오기
	public FileDTO getFileInfoByFileNo(int FileNo);
	
	//파일이름으로 파일정보 가져오기
	public FileDTO getFileInfoFromDB(String fileName);
	
	// 임시 Temp 파일 전부 가져오기
	public List<FileDTO> getAllTempFiles(isTEMP TRUE);	
	
	// postNo에 해당하는 파일 전부 가져오기
	public List<FileDTO> getAllFilesBysomePK(FileDTO fileDTO);
	
	
	//Temp 파일경로 DB수정
	public boolean updateFileInfo(FileDTO fileDTO);
	
	// 파일번호(fileNo)로 파일정보 삭제
	public boolean deleteFileInfoByFileNo(int fileNo);
	
	// temp내의 파일정보 DB에서 삭제
	public boolean deleteTempFileFromDB(isTEMP TRUE);
	
	// 이미지가 posting 인것 모두 가져오기
	public List<FileDTO>getFilesByRef();
	
}
