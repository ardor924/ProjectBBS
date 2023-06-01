package com.ardor.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardor.mapper.BoardMapper;
import com.ardor.model.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired BoardMapper boardMapper;
	@Autowired UtilityService utilService;
	
	
	// 게시판 등록
	@Override
	public boolean regBoards(BoardDTO boardDTO) {

		// 게시판 등록일
		Date boardCreateDate =  utilService.getNowDate();
		boardDTO.setBbsCreateDate(boardCreateDate);
		
		return boardMapper.insertBoardInfoToDB(boardDTO);
	}
	
	
	// 게시판 전체 목록 가져오기
	@Override
	public List<BoardDTO> getAllBoardList() {
		return boardMapper.getAllBoardListFromDB();
	}
	
}
