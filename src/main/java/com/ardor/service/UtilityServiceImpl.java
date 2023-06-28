package com.ardor.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardor.mapper.MemberMapper;
import com.ardor.mapper.PostingMapper;
import com.ardor.model.MemberDTO;
import com.ardor.model.PostingDTO;
import com.ardor.model.MemberDTO.AgreementStatus;
import com.ardor.model.MemberDTO.MemberGrant;
import com.ardor.model.PostingDTO.isNotice;

/*import com.ardor.model.MemberDTO.AgreementStatus;
import com.ardor.model.MemberDTO.MemberGrant;
*/
@Service
public class UtilityServiceImpl implements UtilityService{

	
	@Autowired MemberMapper memberMapper;
	@Autowired PostingMapper postingMapper;

	// URL맵핑시 깨지는 문자열을 인코딩해서 보내기
	@Override
	public String encodeStringToUTF8(String urlName) {
		try 
		{
			String encodedBbsName = URLEncoder.encode(urlName, StandardCharsets.UTF_8);
			return encodedBbsName;
		} 
		
		catch (Exception e) 
		{			
			return "fail to encoding url";
		}

	}
	
	
	//현재날짜 가져오기 메서드
	@Override
	public Date getNowDate() {		
		Date nowDate = new Date();		
		return nowDate;
	}
	
	// 문자열 날짜 변환	메서드
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
	
	
	
	// 폴더용 날짜포맷 메서드
	@Override
	public String getFolderDate() {
		
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(nowDate);
		
		return strDate;
	}
	
	
	// 날짜를 문자열로 변환
	@Override
	public String getStrDateFromDate(Date inputDate) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(inputDate);		
			
		return strDate;
	}
	
	
	
	// 생일로 나이구하기 메서드
	@Override
	public Integer calculateAgeFromBirth(Date memberBirth) {
		
		// 회원의 생일 정보 미기입시 처리
		if(memberBirth == null) {
			return null;
		}
		
		else {
			// Calendar 클래스에서 인스턴스생성
	        Calendar now = Calendar.getInstance();
	        Calendar birth = Calendar.getInstance();
	        
	        // 캘린더의 birth에 회원생일 세팅 
	        birth.setTime(memberBirth);
	        
	        // 나이계산1(연도계산) 올해 - 태어난해 = 나이
	        int age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
	
	        // 나이계산2(월별계산,일별계산)
	        if (	
	        		// 이번달 <= 태어난달 이고
	        		now.get(Calendar.MONTH) < birth.get(Calendar.MONTH) || (now.get(Calendar.MONTH) == birth.get(Calendar.MONTH)
	        		// 오늘 <= 태어난날 이면 
	                && now.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH))
	        	) 
	        	
		        { // 위조건 해당할시 나이를 1빼줌 
		            age--;
		        }
        return age;
		}
	}// ./생일로 나이구하기 메서드 : END
	
	
	
	
	
	  // 관리자 권한 부여 메서드
	  @Override 
	  public MemberGrant setAdminPermission() { 
		  long memberCount = memberMapper.getMemberCount();
		  
		  System.out.println("memberCount : "+memberCount);
	  
	  // 최초회원 관리자 권한 부여 
		  if(memberCount == 0) { // 회원수가 0 이면 관리자권한 부여 
			  return MemberGrant.ADMIN;  
		  }
	 

	    // 관리자 승인 로직 구현
	    // boolean isAdminApproved = checkAdminApproval(); // 관리자 승인 여부 확인하는 메서드
		// 관리자 승인시 관리자 권한 부여
	    // if (isAdminApproved) {
	    //    return MemberGrant.ADMIN;
	    // }
		
	
		 // 해당사항 없을시 '유저' 로 설정 
		  else {	  
			  return MemberGrant.USER;	  
		  }
		  
	  } //./관리자 권한 부여 :END
		 
		
	// 동의정책 체크상태 저장 메서드	  
	@Override 
	public AgreementStatus convertToAgreementStatus(String value) {
	    if (value == null || value== "NO") {
	        return AgreementStatus.NO;
	    } else if (value.equalsIgnoreCase("YES")) {
	        return AgreementStatus.YES;
	    } else {
	        return AgreementStatus.NO;
	    }
	}
		 
	// 공지사항 체크상태 저장 메서드	  
	@Override 
	public isNotice convertToEnumNotice(String value) {
		if (value == null || value== "NO") {
			return isNotice.NO;
		} else if (value.equalsIgnoreCase("YES")) {
			return isNotice.YES;
		} else {
			return isNotice.NO;
		}
	}
	
	
	// 파라미터 조합 및 선택사항파라미터 미입력시 처리 //
	
	// 생년월일 조합
	@Override
	public Date mergeBirth(String year, String month, String day) {
		
		// 파라미터 미입력시 처리
		if (year == null || month == null || day == null) {

			return null;
		}
		// 정상적으로 파라미터가 모두 있을때의 처리
		else {
			String birthStr = year+month+day;
			Date birth = stringToDate(birthStr);
			
		return birth;
		}
	}
	
	// 이메일 조합
	@Override
	public String mergeEmails(String email_1, String email_2) {
		String email = email_1+"@"+email_2;	
		return email;
	}
	
	// 휴대전화 조합
	@Override
	public String mergeTelephones(String tel_1, String tel_2, String tel_3) {

		// 파라미터 미입력시 처리
		if (tel_1 == null || tel_2 == null || tel_3 == null || tel_1.isEmpty() || tel_2.isEmpty() || tel_3.isEmpty()) {
			return null;
		}
		// 정상적으로 파라미터가 모두 있을때의 처리
		else {
			String tel = tel_1 + "-"+ tel_2 + "-" +tel_3;
		
		return tel;
		}
		
	}
	
	
	// DB에 등록한 날짜와 오늘날짜를 비교
	@Override
	public boolean compareToRegDateFromNowDate(Date Regdate) {
		
		Date nowDate = getNowDate();
		
		
	    // 날짜 값 비교
	    if (Regdate.getYear() == nowDate.getYear() &&
	        Regdate.getMonth() == nowDate.getMonth() &&
	        Regdate.getDate() == nowDate.getDate()) {
	        return true;
	    } else {
	        return false;
	    }

	}
	
	
	// 스트링값을 객체로 변환
	@Override
	public Map<String, Object> parseStringToObject(String value){
		Map<String, Object> requestData = new HashMap<>();
		
		requestData.put("memberID", value);
		
		return requestData;
	}
	
	
	
	
	
	
	
	
	
	
	// 더미데이터 생성
	@Override
	public boolean dummy() {
		
		PostingDTO postingDTO = new PostingDTO();
		boolean success = false;

		for(int dummy = 1; dummy <= 264; dummy++) 
		{			
			
		postingDTO.setBbsPostNo(dummy); // 순차적으로 증가시킬 번호
		postingDTO.setPostWriterName("관리자");	
		postingDTO.setPostWriterID("admin");	
		postingDTO.setPostTitle("테스트"+dummy);	
		postingDTO.setPostContents("더미데이터"+dummy);
		
		postingDTO.setPostRegdate(getNowDate());
		postingDTO.setPostHit(0);
		postingDTO.setBbsNo(1);		
		success = postingMapper.insertPostingToDB(postingDTO);
		
		}
		
		return success ? true : false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// 디버깅용 memberParam 출력
	public void showMemberParams(MemberDTO memberDTO) {
		
		// -----------------------------------디버깅용--------------------------------------------------//
		System.out.println("-----------------------------------------------------");
		
		System.out.println("아이디 : "+memberDTO.getMemberID());
		System.out.println("비번 : "+memberDTO.getMemberPW());
		System.out.println("이름 : "+memberDTO.getMemberName());
		System.out.println("나이 : "+memberDTO.getMemberAge());
		System.out.println("이메일 : "+memberDTO.getMemberEmail());
		System.out.println("생일 : " + memberDTO.getMemberBirth()); 
		System.out.println("휴대전화 : "+memberDTO.getMemberTel());
		
		System.out.println("개인정보동의 : "+ memberDTO.getMemberPolicyAgreement());
		System.out.println("이용약관동의 : "+ memberDTO.getMemberTermsAgreement());
		System.out.println("이벤트수신동의 : "+ memberDTO.getMemberEventAgreement());
		
		System.out.println("가입일 : "+memberDTO.getMemberRegdate());
		
		System.out.println("관리자권한 : "+memberDTO.getMemberGrant());
		System.out.println("-----------------------------------------------------");
		
		System.out.println("이벤트정책디버그 : "+memberDTO.getMemberEventAgreement().toString());
		System.out.println("-----------------------------------------------------");
		
		// -----------------------------------디버깅용--------------------------------------------------//
	}
	
	
	
	
	
	
	
	
	
} // UtilityServiceImpl 클래스 : END
