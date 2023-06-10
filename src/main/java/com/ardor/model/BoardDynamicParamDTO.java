package com.ardor.model;

import com.ardor.model.PostingDTO.SearchTarget;
import com.ardor.model.PostingDTO.SortOrder;

public class BoardDynamicParamDTO {
	

	private int currentPage;
	private int pageRows;
	private SortOrder orderBy;
	private SearchTarget searchTarget;
	private String keyWord;
	
	
	
	// 기본 생성자
	public BoardDynamicParamDTO() {}



	public BoardDynamicParamDTO(int currentPage, int pageRows, SortOrder orderBy, SearchTarget searchTarget,
			String keyWord) {
		super();
		this.currentPage = currentPage;
		this.pageRows = pageRows;
		this.orderBy = orderBy;
		this.searchTarget = searchTarget;
		this.keyWord = keyWord;
	}



	public int getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public int getPageRows() {
		return pageRows;
	}



	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
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
