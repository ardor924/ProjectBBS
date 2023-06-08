package com.ardor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ardor.model.BoardDTO;
import com.ardor.model.CategoryDTO;
import com.ardor.service.BoardService;
import com.ardor.service.CategoryService;

@Controller
public class AdminController {
	
	@Autowired CategoryService categoryService;
	@Autowired BoardService boardService;
	
	// 관리자 메인 페이지 이동
	@GetMapping("/admin")
	public String adminMainPage(Model model) {
		return "/admin/main_page";
	}
	
	// 회원관리 페이지 이동
	@GetMapping("/admin/members")
	public String membershipManagePage() {
		return "/admin/membership/manage_page";
	}
	
	
	
	// 카테고리관리 페이지 이동
	@GetMapping("/admin/category")
	public String categoryManagePage(Model model, CategoryDTO categoryDTO) {	
		List<CategoryDTO> catList = categoryService.getAllCategoryList();
		model.addAttribute("catList", catList);	
		return "/admin/category/manage_page";
	}		
	// 카테고리등록 페이지 이동
	@GetMapping("/admin/category/reg")
	public String categoryRegPage() {
		return "/admin/category/reg_page";
	}
	// 카테고리 등록 폼 제출
	@PostMapping("/admin/category/reg/submit")
	public String categoryRegSubmit(CategoryDTO categoryDTO) 
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
	// 카테고리수정 페이지 이동
	@GetMapping("/admin/category/edit/{catCode}")
	public String categoryEditPage(@PathVariable String catCode,Model model) {
		
		CategoryDTO categoryDTO = categoryService.getCategoryInfo(catCode);
		
		// categoryDTO 반환성공시
		if(categoryDTO != null) 
		{
			model.addAttribute("categoryDTO", categoryDTO);			
			return "/admin/category/edit_page";
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
			return "/admin/category/manage_page";
		}
		
	}
	

	
	// 게시판등록 페이지 이동
	@GetMapping("/admin/bbs/reg")
	public String bbsRegPage(Model model) {
		
		// 카테고리 전체 목록 가져오기
		List<CategoryDTO> catList = categoryService.getAllCategoryList();
		// 카테고리 목록 파라미터 보내기
		if(catList != null)
		{	
			model.addAttribute("catList", catList);
			model.addAttribute("resultMSG", "카테고리 목록을 불러오는데 성공했습니다.");
			return "/admin/bbs/reg_page";

		}else
		{	
			model.addAttribute("resultMSG", "카테고리 목록을 불러오는데 실패했습니다.");
			return "/admin/bbs/reg_page";

		}
		
	}
	// 게시판 등록 폼 제출
	@PostMapping("/admin/bbs/reg/submit")
	public String bbsRegSubmit(BoardDTO baordDTO,Model model) {
		
		boolean success = boardService.regBoards(baordDTO);
		
		if(success)
		{	
			model.addAttribute("resultMSG", "게시판 등록 성공");
			return "redirect:/admin";
		}
		else
		{
			model.addAttribute("resultMSG", "게시판 등록 실패");
			return "/admin/bbs/reg";
		}
		
		
	}
	
	
	
	// 게시판수정 페이지 이동
	@GetMapping("/admin/bbs/edit")
	public String bbsEditPage() {
		return "/admin/bbs/edit_page";
	}
	// 게시판관리 페이지 이동
	@GetMapping("/admin/bbs")
	public String bbsManagePage() {
		return "/admin/bbs/manage_page";
	}
	

}
