package com.ardor.model;

import java.util.Date;

public class BoardDTO {
	
	
	private int bbsNo;
	private String bbsName;
	private String bbsNameForURL;
	private String bbsDescription;
	private Date bbsCreateDate;
	private int catNo;
	
	
	// 기본 생성자
	public BoardDTO() {}


	public BoardDTO(int bbsNo, String bbsName, String bbsNameForURL, String bbsDescription, Date bbsCreateDate,
			int catNo) {
		super();
		this.bbsNo = bbsNo;
		this.bbsName = bbsName;
		this.bbsNameForURL = bbsNameForURL;
		this.bbsDescription = bbsDescription;
		this.bbsCreateDate = bbsCreateDate;
		this.catNo = catNo;
	}


	public int getBbsNo() {
		return bbsNo;
	}


	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}


	public String getBbsName() {
		return bbsName;
	}


	public void setBbsName(String bbsName) {
		this.bbsName = bbsName;
	}


	public String getBbsNameForURL() {
		return bbsNameForURL;
	}


	public void setBbsNameForURL(String bbsNameForURL) {
		this.bbsNameForURL = bbsNameForURL;
	}


	public String getBbsDescription() {
		return bbsDescription;
	}


	public void setBbsDescription(String bbsDescription) {
		this.bbsDescription = bbsDescription;
	}


	public Date getBbsCreateDate() {
		return bbsCreateDate;
	}


	public void setBbsCreateDate(Date bbsCreateDate) {
		this.bbsCreateDate = bbsCreateDate;
	}


	public int getCatNo() {
		return catNo;
	}


	public void setCatNo(int catNo) {
		this.catNo = catNo;
	}


	
	
	
	

}
