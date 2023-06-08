package com.ardor.service;

import java.util.List;
import com.ardor.model.BoardDTO;

public interface BoardService {
	
	
	// 게시판 등록
	public boolean regBoards(BoardDTO boardDTO);
	
	
	// 게시판 전체 목록 가져오기
	public List<BoardDTO> getAllBoardList();
	
	
	// 게시판이름 변환 (URLName => RealName)
	public String getRealNameFromUrlName(String bbsNameForURL);
	
	// 게시판 이름으로 게시판정보가져오기 (URL이름으로 조회)
	public BoardDTO getBoardInfoByUrlName(String bbsNameForURL);
	
	// 게시판 이름으로 게시판PK값 가져오기
	public int getBbsNoByUrlName(String bbsNameForURL);
	
}
