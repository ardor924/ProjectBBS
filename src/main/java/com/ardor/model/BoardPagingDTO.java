package com.ardor.model;

import java.util.Date;

public class BoardPagingDTO {
	
	// 게시글 기본요소
	private int bbsPostNo;
	private String postTitle;
	private String postWriter;
	private String postContents;
	private Date postRegdate;
	private int postHit;
	
	
	
	// 게시글수
	private int totalRows;
	private int pageRows;
	
	// 게시글 번호
	private int pageStartRowNum;
	private int pageEndRowNum;
	
	
	// 페이지
	private int currentPage;
	private int totalPage;
	private int blockStartPage;
	private int blockEndPage;
	private int blockPrevPage;
	private int blockNextPage;
	
	// 블럭
	private int currentBlockLocation;
	private int blockLenth = 10;


	
	
	// 기본생성자
	public BoardPagingDTO() {};
	
	// 인자 생성자
	public BoardPagingDTO(int totalRows,int pageRows,int currentPage) {
		
		this.totalRows = totalRows;
		this.pageRows = pageRows;
		this.currentPage = currentPage;
		
		
		calcValue(totalRows, pageRows);
		
	}
	
	
	// 페이지 계산
	public void calcValue(int totalRows, int pageRows) {
		
		
		// 전체 페이지수 (ex 총 게시글수가 265일때 : 반올림(265/10) = 27페이지)
		totalPage = (int) Math.ceil((double)totalRows/pageRows);
		
		// 페이지당 시작번호 (ex 현재페이지가 24일때 : 24-1*10  = 230번)
		pageStartRowNum = (currentPage-1) * pageRows;		
		
		// 페이지당 끝번호 (ex 현재페이지가 24일때 : 24*10-1  = 239번)
		pageEndRowNum = (currentPage * pageRows)-1;		
		
		// 현재 블럭 위치 (ex 현재페이지가 30 일때 : (30-1)/10 = 2)
		currentBlockLocation = (currentPage-1)/blockLenth;				
		
		// 현재 블럭의 시작페이지 (ex : 현재 블럭이 2일때 : 2*10+1 = 21페이지)
		blockStartPage = (currentBlockLocation * blockLenth) + 1;
				
		// 현재 블럭의 끝페이지 (ex : 현재 블럭이 2일때 : 2+1*10 = 30페이지)
		blockEndPage =  (currentBlockLocation+1) * blockLenth;
		
		// 이전 블럭 페이지 (ex : 현재 블럭의 시작페이지가 21일때 : 21-1 = 20페이지)
		blockPrevPage = blockStartPage-1;
		
		// 다음 블럭 페이지 (ex : 현재 블럭의 끝페이지가 30일때 : 30+1 = 31페이지)
		blockNextPage = blockEndPage+1;
				
		// 블럭 끝페이지 예외 (ex : 전체 페이지수가 27일때 : 블럭의 끝페이지 = 전체 페이지수)
		if(blockEndPage > totalPage) blockEndPage = totalPage;
	
		// 다음 블럭 페이지 예외 (ex : 전체 페이지수가 27일때 : 다음 페이지 = 전체 페이지수)
		if(blockNextPage>totalPage) blockNextPage = totalPage;
		
		
	}
	
	
	
	
	// 게터세터
	public int getBbsPostNo() {
		return bbsPostNo;
	}

	public void setBbsPostNo(int bbsPostNo) {
		this.bbsPostNo = bbsPostNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostWriter() {
		return postWriter;
	}

	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
	}

	public String getPostContents() {
		return postContents;
	}

	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}

	public Date getPostRegdate() {
		return postRegdate;
	}

	public void setPostRegdate(Date postRegdate) {
		this.postRegdate = postRegdate;
	}

	public int getPostHit() {
		return postHit;
	}

	public void setPostHit(int postHit) {
		this.postHit = postHit;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPageRows() {
		return pageRows;
	}

	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}

	public int getPageStartRowNum() {
		return pageStartRowNum;
	}

	public void setPageStartRowNum(int pageStartRowNum) {
		this.pageStartRowNum = pageStartRowNum;
	}

	public int getPageEndRowNum() {
		return pageEndRowNum;
	}

	public void setPageEndRowNum(int pageEndRowNum) {
		this.pageEndRowNum = pageEndRowNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBlockStartPage() {
		return blockStartPage;
	}

	public void setBlockStartPage(int blockStartPage) {
		this.blockStartPage = blockStartPage;
	}

	public int getBlockEndPage() {
		return blockEndPage;
	}

	public void setBlockEndPage(int blockEndPage) {
		this.blockEndPage = blockEndPage;
	}

	public int getBlockPrevPage() {
		return blockPrevPage;
	}

	public void setBlockPrevPage(int blockPrevPage) {
		this.blockPrevPage = blockPrevPage;
	}

	public int getBlockNextPage() {
		return blockNextPage;
	}

	public void setBlockNextPage(int blockNextPage) {
		this.blockNextPage = blockNextPage;
	}

	public int getCurrentBlockLocation() {
		return currentBlockLocation;
	}

	public void setCurrentBlockLocation(int currentBlockLocation) {
		this.currentBlockLocation = currentBlockLocation;
	}

	public int getBlockLenth() {
		return blockLenth;
	}

	public void setBlockLenth(int blockLenth) {
		this.blockLenth = blockLenth;
	}

	@Override
	public String toString() {
		return "BoardPagingDTO [bbsPostNo=" + bbsPostNo + ", postTitle=" + postTitle + ", postWriter=" + postWriter
				+ ", postContents=" + postContents + ", postRegdate=" + postRegdate + ", postHit=" + postHit
				+ ", totalRows=" + totalRows + ", pageRows=" + pageRows + ", pageStartRowNum=" + pageStartRowNum
				+ ", pageEndRowNum=" + pageEndRowNum + ", currentPage=" + currentPage + ", totalPage=" + totalPage
				+ ", blockStartPage=" + blockStartPage + ", blockEndPage=" + blockEndPage + ", blockPrevPage="
				+ blockPrevPage + ", blockNextPage=" + blockNextPage + ", currentBlockLocation=" + currentBlockLocation
				+ ", blockLenth=" + blockLenth + "]";
	}
	
	
	
	
	
	
	

}
