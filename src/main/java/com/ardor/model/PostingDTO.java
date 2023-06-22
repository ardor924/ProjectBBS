package com.ardor.model;

import java.util.Date;

public class PostingDTO {
	
	private int postNo;
	
	// 게시판별 게시글번호
	private int bbsPostNo;
	
	private String postWriter;
	private String postTitle;
	private String postContents;
	
	private isNotice postNotice;
	
	private int postHit;
	private Date postRegdate;
	private String fileFullPath;
	
	private int bbsNo;
	
	
	
	// 페이징
	private int pageRows;
	private int pageStartRowNum;
	private int currentPage;
	
	
	// 게시판 정렬
	private SortOrder orderBy; // 게시글 정렬
	
	
	// 게시판 검색
	private SearchTarget searchTarget; // 게시글 검색 대상(검색옵션)
	private String keyWord; // 검색어
	
	
	
	
	
	// 공지사항 체크
	public enum isNotice{
        YES,
        NO
	}

	// 게시글 정렬 (Enum)
    public enum SortOrder {
        IDX_DESC,
        IDX_ASC,
        REGDATE_DESC,
        REGDATE_ASC,
        HIT_DESC,
        HIT_ASC
    }
    
 // 게시글 검색 (Enum)
    public enum SearchTarget {
        WRITER,
        TITLE,
        CONTENTS
    }
	
	
	
	// 기본 생성자
	public PostingDTO() {}
	
	
	// 파라미터 생성자
	public PostingDTO(int bbsNo, SortOrder orderBy, SearchTarget searchTarget, String keyWord) {
		super();
		this.bbsNo = bbsNo;
		this.orderBy = orderBy;
		this.searchTarget = searchTarget;
		this.keyWord = keyWord;
	}
	
	
	// 파라미터 생성자(전체게시판용)
	public PostingDTO(SortOrder orderBy, SearchTarget searchTarget, String keyWord) {
		super();
		this.orderBy = orderBy;
		this.searchTarget = searchTarget;
		this.keyWord = keyWord;
	}


	// 인자 생성자
	public PostingDTO(int postNo, int bbsPostNo, String postWriter, String postTitle, String postContents,
			isNotice postNotice, int postHit, Date postRegdate, String fileFullPath, int bbsNo, int pageRows,
			int pageStartRowNum, int currentPage, SortOrder orderBy, SearchTarget searchTarget, String keyWord) {
		super();
		this.postNo = postNo;
		this.bbsPostNo = bbsPostNo;
		this.postWriter = postWriter;
		this.postTitle = postTitle;
		this.postContents = postContents;
		this.postNotice = postNotice;
		this.postHit = postHit;
		this.postRegdate = postRegdate;
		this.fileFullPath = fileFullPath;
		this.bbsNo = bbsNo;
		this.pageRows = pageRows;
		this.pageStartRowNum = pageStartRowNum;
		this.currentPage = currentPage;
		this.orderBy = orderBy;
		this.searchTarget = searchTarget;
		this.keyWord = keyWord;
	}


	public int getPostNo() {
		return postNo;
	}


	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	public int getBbsPostNo() {
		return bbsPostNo;
	}


	public void setBbsPostNo(int bbsPostNo) {
		this.bbsPostNo = bbsPostNo;
	}


	public String getPostWriter() {
		return postWriter;
	}


	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
	}


	public String getPostTitle() {
		return postTitle;
	}


	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}


	public String getPostContents() {
		return postContents;
	}


	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}


	public isNotice getPostNotice() {
		return postNotice;
	}


	public void setPostNotice(isNotice postNotice) {
		this.postNotice = postNotice;
	}


	public int getPostHit() {
		return postHit;
	}


	public void setPostHit(int postHit) {
		this.postHit = postHit;
	}


	public Date getPostRegdate() {
		return postRegdate;
	}


	public void setPostRegdate(Date postRegdate) {
		this.postRegdate = postRegdate;
	}


	public String getFileFullPath() {
		return fileFullPath;
	}


	public void setFileFullPath(String fileFullPath) {
		this.fileFullPath = fileFullPath;
	}


	public int getBbsNo() {
		return bbsNo;
	}


	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
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


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public SortOrder getOrderBy() {
		return orderBy;
	}


	public void setOrderBy(SortOrder orderBy) {
		this.orderBy = orderBy;
	}


	public SearchTarget getSearchTarget() {
		return searchTarget;
	}


	public void setSearchTarget(SearchTarget searchTarget) {
		this.searchTarget = searchTarget;
	}


	public String getKeyWord() {
		return keyWord;
	}


	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	
	

	

	
}
