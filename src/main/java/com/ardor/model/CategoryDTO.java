package com.ardor.model;

public class CategoryDTO {

	private int catNo;
	private String catCode;
	private String catName;
	private String catDescription;
	
	
	//  기본생성자
	public CategoryDTO() {}

	// 생성자
	public CategoryDTO(int catNo, String catCode, String catName, String catDescription) {
		super();
		this.catNo = catNo;
		this.catCode = catCode;
		this.catName = catName;
		this.catDescription = catDescription;
	}

	// 게터 세터
	public int getCatNo() {
		return catNo;
	}


	public void setCatNo(int catNo) {
		this.catNo = catNo;
	}


	public String getCatCode() {
		return catCode;
	}


	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}


	public String getCatName() {
		return catName;
	}


	public void setCatName(String catName) {
		this.catName = catName;
	}


	public String getCatDescription() {
		return catDescription;
	}


	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	};
	
	
	
	
	
}
