package com.ardor.service;

import java.util.Date;
import java.util.Map;

import com.ardor.model.MemberDTO;
import com.ardor.model.MemberDTO.AgreementStatus;
import com.ardor.model.MemberDTO.MemberGrant;

/*import com.ardor.model.MemberDTO.AgreementStatus;
import com.ardor.model.MemberDTO.MemberGrant;*/

// 편의기능 제공 비지니스로직 수행 서비스
public interface UtilityService {
	
	
	// 현재 시간 가져오기
	public Date getNowDate();
	
	// 문자열 날짜 변환	
	public Date stringToDate(String strDate);
	
	// 폴더용 날짜 포맷
	public String getFolderDate();
	
	// 생일로 나이구하기 메서드
	public Integer calculateAgeFromBirth(Date memberBirth);
	
	
	// 최초회원 관리자 권한 부여
	public MemberGrant setAdminPermission();
	 	

	// 동의정책 체크상태 저장
	 public AgreementStatus convertToAgreementStatus(String value);
	 	
	// 파라미터 조합 및 선택사항파라미터 미입력시 처리
	//생년월일 조합
	public Date mergeBirth(String year, String month , String day);
	// 이메일 조합
	public String mergeEmails(String email_1, String email_2);
	// 휴대전화 조합
	public String mergeTelephones(String tel_1, String tel_2,String tel_3);
	
	// 디버깅용 memberParam 출력
	public void showMemberParams(MemberDTO memberDTO);
	
	 
	
	// 스트링값을 객체로 변환
	public Map<String, Object> parseStringToObject(String value);
	 
	
} // UtilityService 클래스 : END
