package com.ardor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ardor.model.PostingDTO;

@Mapper
public interface PostingMapper {
	
	// 게시글 PK값 가져오기
	public int getPostNo(PostingDTO postingDTO);
	

	
	
	
	// 게시글 등록
	public boolean insertPostingToDB(PostingDTO postingDTO);
	
	// 게시글 1개 조회
	public PostingDTO getPostingByPostNo(int postNo);
	
	
	// 게시글 전체 조회(특정게시판 PK값 이용)
	public List<PostingDTO> getBoardPostingsByDTO(PostingDTO postingDTO);
	
	
	
	// (Total)모든 게시판의 게시글 조회
	public List<PostingDTO> getGlobalPostingsFromDB();
	
	
	// 게시글의 갯수 리턴(특정 게시판 PK이용)
	public int getPostingCountBybbsNo(int bbsNo);
	
	
	// 게시글 조회수 증가
	public void addHitUp(PostingDTO postingDTO);
	
}
