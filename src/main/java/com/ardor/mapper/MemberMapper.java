package com.ardor.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ardor.model.MemberDTO;


@Mapper
public interface MemberMapper {
	
	
	
	//회원가입 정보를 DB에 입력
	public int insertMembersToDB(MemberDTO memberDTO);
	
	
	// 회원수 조회
	public int getMemberCount();
	
	
	// 아이디중복체크
	public boolean checkDuplicateIdFromDB(String memberID);
	
		
	
	// 회원 아이디로 회원정보 가져오기
	public MemberDTO getMemberInfoBymemberID(String memberID);
	
}
