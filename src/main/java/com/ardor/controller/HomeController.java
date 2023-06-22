package com.ardor.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ardor.model.BoardDTO;
import com.ardor.model.CategoryDTO;
import com.ardor.model.PostingDTO;
import com.ardor.service.BoardService;
import com.ardor.service.CategoryService;
import com.ardor.service.PostingService;

@Controller
public class HomeController {
	
	@Autowired CategoryService categoryService;
	@Autowired BoardService boardService;
	@Autowired PostingService postingService;
	
	// 홈페이지 이동
	@RequestMapping("/")
	public String goHomePage(HttpSession session,Model model) {		
		
		// 카테고리 & 게시판 전체 내역 가져오기
		List<CategoryDTO> catList  = categoryService.getAllCategoryList();
		List<BoardDTO> boardList = boardService.getAllBoardList();
		
		// 전체게시글 샘플
		List<PostingDTO> totalPostingSample = postingService.getGlobalPostingSample();
		
		
		// 파라미터 보내기
		if(catList != null && boardList != null && totalPostingSample != null)
		{
			session.setAttribute("catList", catList);
			session.setAttribute("boardList", boardList);
			session.setAttribute("totalPostingSample", totalPostingSample);
			model.addAttribute("resultMSG", "카테고리,게시판 목록 불러오기 성공");
			return "/home/home_page";
		}
		else
		{
			model.addAttribute("resultMSG", "카테고리,게시판 목록 불러오기 실패");
			return "/home/home_page";
		}
		
	}

	
}
