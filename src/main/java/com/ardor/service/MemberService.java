package com.ardor.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.ardor.model.MemberDTO;

public interface MemberService {
	
	
	// 회원가입
	public int joinMembers(MemberDTO memberDTO);

	
	// 아이디 중복검사
	public boolean checkDuplicateID(Map<String, Object> requestData);

	// 회원 아이디로 회원정보 가져오기
	public MemberDTO getMemberInfoBymemberID(String memberID);
	
	
	
}
