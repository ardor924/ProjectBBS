package com.ardor.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ardor.model.MemberDTO;


@Mapper
public interface MemberMapper {
	
	
	
	//회원가입 정보를 DB에 입력
	public int insertMembersToDB(MemberDTO memberDTO);
	
	

}
