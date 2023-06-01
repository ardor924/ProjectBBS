package com.ardor.service;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardor.mapper.MemberMapper;
import com.ardor.model.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired MemberMapper memberMapper;

	
	// 회원가입
	@Override
	public int joinMembers(MemberDTO memberDTO) {
		return memberMapper.insertMembersToDB(memberDTO);
	}
	
	
	// 아이디 중복검사
	public boolean  checkDuplicateID(Map<String, Object> requestData){
			
		// 전달받은 데이터를 가져와서 null이면 빈문자열로  NullPointerException 에러처리
		Object memberIDValue = requestData.get("memberID");
		String memberID = memberIDValue != null ? memberIDValue.toString() : "";
		
		boolean isDuplicate =  memberMapper.checkDuplicateIdFromDB(memberID);
		
		System.out.println("아이디가 중복되었는가? : "+isDuplicate);

		return isDuplicate;
		}
	

	
	// 회원 아이디로 회원정보 가져오기
	@Override
	public MemberDTO getMemberInfoBymemberID(String memberID) {
		
		return memberMapper.getMemberInfoBymemberID(memberID);
	}
	
	
	

	
}
