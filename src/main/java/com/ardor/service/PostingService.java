package com.ardor.service;

import java.util.List;

import com.ardor.model.BoardDynamicParamDTO;
import com.ardor.model.BoardPagingDTO;
import com.ardor.model.PostingDTO;
import com.ardor.model.PostingDTO.SearchTarget;
import com.ardor.model.PostingDTO.SortOrder;

public interface PostingService {
	
	// 게시글 PK값 가져오기 
	public int getPostNo(int bbsNo,int bbsPostNo); // (게시판번호,개별 게시글번호 이용)
	


	
	// 게시글 등록
	public boolean regPosting(PostingDTO posting);
	
	
	// 게시글 1개 조회
	public PostingDTO getPosting(int postNo);
	
	// 게시글 전체 조회
	public List<PostingDTO> getBoardPostings(PostingDTO postingDTO , BoardPagingDTO bp); // (조회하려는 게시판DTO정보 이용)
	

	// (Total)모든 게시판의 게시글 조회
	public List<PostingDTO> getGlobalPostings();
	
	// 게시판 페이지네이션
	public BoardPagingDTO setBoardPaging(int totalRows, int pageRows,int currentPage);
	

	// (total bbs)모든 게시판의 게시글수 가져오기

	
	
	
	
	
	
	
	// 특정 게시판의 게시글수 가져오기
	public int getTotalPostingCntBybbsNo(int bbsNo); 
	
	// 게시판이름 파라미터 비교
	public boolean isBbsNameMatch(String bbsNameSelect, String bbsName);
	
	
	// 게시글번호 생성 및 추가(게시판마다 별도로생성)
	public int addBbsPostNo(int bbsNo);
	

	// 게시판등록 날짜가 오늘날짜라면 true 리턴 
	// public boolean hasTodayPostings(int bbsNo);
	
	// 게시글 조회수 증가
	public void addHitUp(PostingDTO postingDTO);

}
