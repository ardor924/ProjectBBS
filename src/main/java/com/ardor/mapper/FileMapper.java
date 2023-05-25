package com.ardor.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ardor.model.FileDTO;

@Mapper
public interface FileMapper {

	// 파일등록(DB등록)
	public int insertFileToDB(FileDTO fileDTO);
	
	//파일이름으로 파일정보 가져오기
	public FileDTO getFileInfoFromDB(String fileName);
	
}
