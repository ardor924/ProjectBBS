package com.ardor.service;

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
	
}
