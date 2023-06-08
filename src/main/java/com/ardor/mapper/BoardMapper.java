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
	
	// 게시판 이름으로 게시판PK값 가져오기 
	public int getBbsNoByUrlName(String bbsNameForURL); // (URL이름으로 조회)
	
	// 게시판실제이름 가져오기
	public String getRealNameByUrlName(String bbsNameForURL); // (URL이름 이용)
	
	// 게시판 이름으로 게시판정보 가져오기
	public BoardDTO getBoardInfoByUrlName(String bbsNameForURL);
}
