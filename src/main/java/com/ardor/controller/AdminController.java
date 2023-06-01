package com.ardor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	
	// 관리자 메인 페이지 이동
	@GetMapping("/admin")
	public String adminMainPage() {
		return "/admin/main_page";
	}
	

}
