package com.ardor.service;

import java.util.Date;

// 편의기능 제공 비지니스로직 수행 서비스
public interface UtilityService {
	
	
	// 현재 시간 가져오기
	public Date getNowDate();
	
	// 문자열 날짜 변환	
	public Date stringToDate(String strDate);
	
	// 폴더용 날짜 포맷
	public String getFolderDate();
	
} // UtilityService 클래스 : END
