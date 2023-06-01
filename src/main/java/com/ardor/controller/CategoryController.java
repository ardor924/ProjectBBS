package com.ardor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ardor.model.CategoryDTO;
import com.ardor.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired CategoryService categoryService;

	//카테고리 등록 페이지 이동
	@GetMapping("/admin/category/reg")
	public String categoryPage() {
		return "/admin/category_manage/category_reg_page";
	}
	
	//카테고리 관리 페이지 이동
	@GetMapping("/admin/category")
	public String categoryManagePage(Model model, CategoryDTO categoryDTO) {	
		List<CategoryDTO> catList = categoryService.getAllCategoryList(categoryDTO);
		model.addAttribute("catList", catList);		
		return "/admin/category_manage/category_manage_page";
	}
	
	
	//카테고리 수정 페이지 이동
	@GetMapping("/admin/category/edit/{catCode}")
	public String categoryEditPage(@PathVariable String catCode,Model model) {
		
		CategoryDTO categoryDTO = categoryService.getCategoryInfo(catCode);
		
		// categoryDTO 반환성공시
		if(categoryDTO != null) 
		{
			model.addAttribute("categoryDTO", categoryDTO);			
			return "/admin/category_manage/category_edit_page";
		}
		// categoryDTO 반환실패시
		else 
		{
			model.addAttribute("categoryDTO", categoryDTO);			
			model.addAttribute("resultMSG", "기존 카테고리를 가져오는데 실패했습니다");			
			return "redirect:/admin/category";
		}
		

	}
	
	// 카테고리 수정 폼 제출
	@PostMapping("/admin/category/edit/submit")
	public String categoryEditSubmit(CategoryDTO categoryDTO) {
		
		boolean success = categoryService.updateCategory(categoryDTO);
		
		if(success) 
		{
			return "redirect:/admin/category";
		}
		else 
		{	
			return "redirect:/admin/category/edit/"+categoryDTO.getCatCode();
		}
		
		
	}
	
	
	
	// 카테고리 등록 폼 제출
	@PostMapping("/admin/category/reg/submit")
	public String categorySubmit(CategoryDTO categoryDTO) 
	{		
		
		boolean success = categoryService.registerCategory(categoryDTO);
		System.out.println("status : " +success);
		
		if(success) 
		{
			return "redirect:/admin/category";			
		}
		else 
		{	
			return "redirect:/admin/category/reg";
		}
		
	}
	
	
	
	
	
	//카테고리 삭제
	@GetMapping("/admin/category/delete/{catCode}")
	public String categoryDelete(@PathVariable String catCode, Model model) {
		
		boolean success = categoryService.deleteCategory(catCode);
		
		if(success) 
		{	
			model.addAttribute("responseMsg", "삭제 성공");
			return "redirect:/admin/category";
		}
		else 
		{	
			model.addAttribute("responseMsg", "삭제 실패");
			return "/admin/category_manage/category_manage_page";
		}
		
	}
	
	
	
}
