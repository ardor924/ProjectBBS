package com.ardor.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class UtilityServiceImpl implements UtilityService{

	
	
	//현재날짜 가져오기
	@Override
	public Date getNowDate() {		
		Date nowDate = new Date();		
		return nowDate;
	}
	
	// 문자열 날짜 변환	
	@Override
	public Date stringToDate(String strDate) {

		// 초기값 세팅
		Date date = null;
		
		try {
			// 포맷터
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			
			// 문자열 -> date
			date = sdf.parse(strDate);
			
		} catch (ParseException e) {
			System.out.println("문자열 변환에서 에러 발생!!");
		}
		
		
		return date;
	} // 문자열 날짜 변환: END
	
	
	
	// 폴더용 날짜포맷
	@Override
	public String getFolderDate() {
		
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(nowDate);
		
		return strDate;
	}
	
	
	
	
	
	
	
	
} // UtilityServiceImpl 클래스 : END
