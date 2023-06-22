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
	public List<PostingDTO> getGlobalPostingsFromDB(PostingDTO postingDTO);
	
	// 게시글의 갯수 리턴(특정 게시판 PK이용)
	public int getPostingCountBybbsNo(int bbsNo);
	
	// 게시글의 갯수 리턴(특정 게시판 PK이용 + 검색요소와 정렬순서 필터링)
	public int getPostingCountByPostingDTO(PostingDTO postingDTO);
	
	
	
	// 게시글 조회수 증가
	public void addHitUp(PostingDTO postingDTO);
	
	
	
	
	
	
	// 
	public int getAllPostingCnt(PostingDTO postingDTO);
	
	
	
	
	// 전체게시글 샘플 가져오기
	public List<PostingDTO> getGlobalPostingSample();
	
	
	// 게시글 삭제
	public boolean deletePostingByPostNo(int postNo);
	
	// 게시글 수정
	public boolean updatePostingByPostingDTO(PostingDTO postingDTO);
	
	// bbsPostNo로 게시글 중복확인
	public int isBbsPostNoDuplicate(PostingDTO postingDTO);
	
	// bbsPostNo 마지막 번호 가져오기
	public int getLastBbsPostNo(PostingDTO postingDTO);
	
}
