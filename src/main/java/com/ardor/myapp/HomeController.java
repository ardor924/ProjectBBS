package com.ardor.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// 홈페이지 이동
	@RequestMapping("/")
	public String goHomePage() {		
		return "home/home";
	}

	
}
