package com.ardor.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardor.mapper.PostingMapper;
import com.ardor.model.BoardPagingDTO;
import com.ardor.model.PostingDTO;
import com.ardor.model.PostingDTO.SearchTarget;
import com.ardor.model.PostingDTO.SortOrder;

@Service
public class PostingServiceImpl implements PostingService{
	
	@Autowired PostingMapper postingMapper;
	@Autowired UtilityService utilService;
	@Autowired BoardService boardService;
		
	// 게시글 PK값 가져오기 
	@Override
	public int getPostNo(int bbsNo, int bbsPostNo) {

		PostingDTO postingDTO = new PostingDTO();
		postingDTO.setBbsNo(bbsNo);
		postingDTO.setBbsPostNo(bbsPostNo);
		
		return postingMapper.getPostNo(postingDTO);
	}
	
	
	
	
	
	
	// 게시글 등록
	@Override
	public boolean regPosting(PostingDTO postingDTO) {
		return postingMapper.insertPostingToDB(postingDTO);
	}
	
	
	// 게시글 1개 조회
	@Override
	public PostingDTO getPosting(int postNo) {
		return postingMapper.getPostingByPostNo(postNo);
	}
	
	
	
	
	
	
	
	
	// 게시글 전체 조회(특정게시판 PK값 이용)
	@Override
	public List<PostingDTO> getBoardPostings(PostingDTO postingDTO ,BoardPagingDTO bp) {
				
		
		int pageRows = bp.getPageRows();
		int pageStartRowNum =  bp.getPageStartRowNum(); 
		
		postingDTO.setPageRows(pageRows);
		postingDTO.setPageStartRowNum(pageStartRowNum);
		
		System.out.println("postingDTO-orderBy : "+ postingDTO.getOrderBy().toString());
		System.out.println("postingDTO-searchTarget : "+ postingDTO.getSearchTarget().toString());
		System.out.println("postingDTO-keyWord : "+ postingDTO.getKeyWord().toString());
		
		
		return postingMapper.getBoardPostingsByDTO(postingDTO);
	}
	
	
	
	
	
	
	
	
	
	
	// (Total)모든 게시판의 게시글 조회
	@Override
	public List<PostingDTO> getGlobalPostings(PostingDTO postingDTO , BoardPagingDTO bp) {
		
		int pageRows = bp.getPageRows();
		int pageStartRowNum =  bp.getPageStartRowNum(); 
		
		postingDTO.setPageRows(pageRows);
		postingDTO.setPageStartRowNum(pageStartRowNum);
		
		System.out.println("postingDTO-orderBy : "+ postingDTO.getOrderBy().toString());
		System.out.println("postingDTO-searchTarget : "+ postingDTO.getSearchTarget().toString());
		System.out.println("postingDTO-keyWord : "+ postingDTO.getKeyWord().toString());
		
		return postingMapper.getGlobalPostingsFromDB(postingDTO);
	}
	
	
	
	
	// 게시글 삭제
	@Override
	public boolean deletePostingByPostNo(int postNo) {
		return postingMapper.deletePostingByPostNo(postNo);
	}
	

	
	
	// 게시글 수정
	@Override
	public boolean updatePostingByPostingDTO(PostingDTO postingDTO) {
		return postingMapper.updatePostingByPostingDTO(postingDTO);
	}
	
	
	
	
	
	// 게시판 페이지네이션
	@Override
	public BoardPagingDTO setBoardPaging(int totalRows, int pageRows, int currentPage) {

		
		BoardPagingDTO bp = new BoardPagingDTO(totalRows, pageRows, currentPage);
	
		System.out.println("totalRows : "+totalRows);
		System.out.println("pageRows : "+pageRows);
		System.out.println("currentPage : "+currentPage);
		System.out.println("------------------------ : ");

		return bp;
	}
	

	
	// 특정 게시판의 게시글수 가져오기
	@Override
	public int getTotalPostingCntByPostingDTO(PostingDTO postingDTO) {
		return postingMapper.getPostingCountByPostingDTO(postingDTO);
	}
	
	
	
	
	
	
	
	
	// 게시판이름 파라미터 비교
	//(제거할예정)
//	@Override
//	public boolean isBbsNameMatch(String bbsNameSelect, String bbsName) {	
//		
//		// 같은값이면 true리턴
//		return bbsNameSelect.trim().equals(bbsName.trim());	// (JSP에서 파라미터로 넘어온 게시판의 bbsNameSelect와 bbsName 의 이름이 같은지 비교)
//		
//	}
	
	
	
	
	
	
	
	// 게시판 별로 게시글번호생성 및 추가
	@Override
	public int addBbsPostNo(int bbsNo) {
		

		// 특정게시판의 게시글의 갯수 가져오기
		int bbsPostNo = postingMapper.getPostingCountBybbsNo(bbsNo);
		// bbsPostNo가 중복인지 확인
		boolean isBbsPostNoDuplicate = isBbsPostNoDuplicate(bbsNo,bbsPostNo);
				
		// 해당 게시판의 게시글의 총갯수가 0 이라면, 
		if(bbsPostNo == 0)
		{	
			// 게시글번호를 1로설정
			bbsPostNo = 1;
		}
		
		// 해당 게시판의 게시글의 총갯수가 0 이 아니고 번호(bbsPostNo)가 중복이 아니라면, 
		else if(bbsPostNo != 0 && isBbsPostNoDuplicate)
		{	
			PostingDTO postingDTO = new PostingDTO();
			postingDTO.setBbsNo(bbsNo);
			postingDTO.setBbsPostNo(bbsPostNo);
			bbsPostNo = postingMapper.getLastBbsPostNo(postingDTO);
			++bbsPostNo; // 마지막번호에 +1
		}

		
		
		return bbsPostNo;
	}
	
	

	
	// bbsPostNo가 중복인지 확인
	public boolean isBbsPostNoDuplicate(int bbsNo, int bbsPostNo) {
		PostingDTO postingDTO = new PostingDTO();
		postingDTO.setBbsNo(bbsNo);
		postingDTO.setBbsPostNo(bbsPostNo);
		
		int count = postingMapper.isBbsPostNoDuplicate(postingDTO);
		System.out.println("count : "+count);
		return (count <= 1) ? true : false;

		
	}
	
	

//	
//	// 게시판등록 날짜가 오늘날짜라면 true 리턴 
//	@Override
//	public boolean hasTodayPostings(int bbsNo) {
//		
//		BoardPagingDTO bp = new BoardPagingDTO(); // <- 값없는 임시 더미데이터
//	    List<PostingDTO> postList = getBoardPostings(postingDTO,bp);
//	    List<PostingDTO> todayPostList = new ArrayList<>();
//
//	    for (PostingDTO postDTO : postList) {
//	        Date postRegdate = postDTO.getPostRegdate();
//	        boolean regDateIsToday = utilService.compareToRegDateFromNowDate(postRegdate);
//	        System.out.println("regDateIsToday : "+regDateIsToday);
//	        if (regDateIsToday) {
//	            todayPostList.add(postDTO);
//	        }
//	    }
//
//	    return !todayPostList.isEmpty();
//	}
//	
//	
	// 게시글 조회수증가
	@Override
	public void addHitUp(PostingDTO postingDTO) {
		// 필요 파라미터 추출
		int postHit = postingDTO.getPostHit();	
		
		// 조회수 증가식
		int addHit = postHit+1;
		
		// 수정한 파라미터 세팅
		postingDTO.setPostHit(addHit);
		
		// 조회수 증가(DB update)
		postingMapper.addHitUp(postingDTO);
	}
	
	
	
	
	// 전체게시판 게시글수 가져오기 
	@Override
	public int getAllPostingCnt(PostingDTO postingDTO) {
		return postingMapper.getAllPostingCnt(postingDTO);
	}
	
	
	
	// 전체게시글 샘플 가져오기
	@Override
	public List<PostingDTO> getGlobalPostingSample() {
		return postingMapper.getGlobalPostingSample();
	}


}
