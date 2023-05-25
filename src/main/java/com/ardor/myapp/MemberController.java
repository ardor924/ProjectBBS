package com.ardor.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ardor.model.MemberDTO;
import com.ardor.service.MemberService;
import com.ardor.service.UtilityService;

@Controller
public class MemberController {

	@Autowired MemberService memberService;
	@Autowired UtilityService utilService;
	
	
	
	// 회원가입 페이지 이동
	@GetMapping("/member/join")
	public String joinPage() {
		return "member/join";
	}
	
	// 회원가입(DB에정보등록)
	@PostMapping("/member/join")
	public String insertMembersToDB(MemberDTO memberDTO) {
		
		
		
		
		
		
		return "test";
	}
	
	
	
	
	
	
	// 로그인 페이지 이동
	@GetMapping("/member/login")
	public String loginPage() {
	    return "member/login";
	}
	// 내정보보기 페이지 이동
	@GetMapping("/member/myinfo")
	public String myinfoPage() {
		return "member/myinfo";
	}
	
	
	
	
}
