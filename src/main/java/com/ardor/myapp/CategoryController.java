package com.ardor.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

	//카테고리 등록 페이지 이동
	@GetMapping("admin/category_manage/category_reg")
	public String categoryPage() {
		return "admin/category_manage/category_reg";
	}
}
