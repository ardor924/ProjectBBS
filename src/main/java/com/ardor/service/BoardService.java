package com.ardor.service;

import java.util.List;

import com.ardor.model.BoardDTO;

public interface BoardService {
	
	
	// 게시판 등록
	public boolean regBoards(BoardDTO boardDTO);
	
	
	// 게시판 전체 목록 가져오기
	public List<BoardDTO> getAllBoardList();
	
}
