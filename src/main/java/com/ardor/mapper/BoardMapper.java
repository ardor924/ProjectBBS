package com.ardor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ardor.model.BoardDTO;

@Mapper
public interface BoardMapper {

	// 게시판 등록(DB등록)
	public boolean insertBoardInfoToDB(BoardDTO boardDTO);
	
	// 게시판 전체 목록 가져오기
	public List<BoardDTO> getAllBoardListFromDB();
	
	
}
