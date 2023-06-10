package com.ardor.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ardor.model.BoardPagingDTO;
import com.ardor.model.PostingDTO;
import com.ardor.model.PostingDTO.SearchTarget;
import com.ardor.model.PostingDTO.SortOrder;
import com.ardor.service.BoardService;
import com.ardor.service.PostingService;
import com.ardor.service.UtilityService;

@Controller
public class BoardController {
	
	@Autowired UtilityService utilService;
	@Autowired BoardService boardService;
	@Autowired PostingService postingService;
	
	// ========================================== 게시판이동  :START ========================================== // 
	
	// (GET)게시판 페이지이동
	@GetMapping("/bbs/{bbsNameForURL}")
	public String bbsPageGet
	(
		Model model,
		@PathVariable("bbsNameForURL") String bbsNameForURL,
		@RequestParam(defaultValue = "1") int currentPage,
		@RequestParam(defaultValue = "10") int pageRows,
		@RequestParam(defaultValue = "TITLE") SearchTarget searchTarget,
		@RequestParam(defaultValue = "") String keyWord,
		@RequestParam(defaultValue = "IDX_DESC") SortOrder orderBy,
		@ModelAttribute PostingDTO postingDTO 
	) 
	{
		
		
		/* 	notice : 
		 *  게시판 PK대신 게시판이름으로 URL을 받아와 보안성 강화
		 *  게시판에 한글이나 특수문자가 URL인코딩문제를 야기할수 있으므로 
		 *  게시판등록시 URL용으로 만들어놓은 영어이름의 게시판이름을 URL로 가져와서 사용 
		 *  
		 *  클라이언트에서 보여질 프론트단 화면 에서는 사용자 친화적인 게시판 실제이름으로 설정하고,
		 *  백단에서 사용할 내부용 전달 파라미터로 공백이나 특수 문자 등을 적절히 처리할수 있는 URL용 이름을사용
		*/

		System.out.println("bbsNameForURL : "+bbsNameForURL);
		// ================파라미터 생성 및 조합 영역============= //
		
		// 게시판 실제이름 가져오기
		String bbsName = boardService.getRealNameFromUrlName(bbsNameForURL); // (URLName => RealName)
		// 게시판 PK번호 가져오기
		int bbsNo = boardService.getBbsNoByUrlName(bbsNameForURL); // (URL이름으로 조회)	
		
		// 디버그확인용 DTO 세팅
//		SortOrder orderBy = SortOrder.IDX_DESC;
//		SearchTarget searchTarget = SearchTarget.TITLE;
//		String keyWord = "음식";
		
		System.out.println("orderBy :"+orderBy);
		System.out.println("orderBy :"+orderBy);
		System.out.println("keyWord :"+keyWord);
		
		// DTO에 파라미터 세팅
		postingDTO = new PostingDTO(bbsNo,  orderBy,  searchTarget,  keyWord); 
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		
		
		
		// ========================페이징처리 영역================== //
		
		// 전체 게시글수 가져오기
		int totalRows = postingService.getTotalPostingCntBybbsNo(bbsNo);
		
		// 게시판 페이지네이션
		BoardPagingDTO bp = postingService.setBoardPaging(totalRows,pageRows,currentPage);
	
		// 게시글 전체 조회
		List<PostingDTO> postList = postingService.getBoardPostings(postingDTO, bp); // (조회하려는 게시판 PK값 이용)
		
		// ========================유틸기능 영역================== //
		
		
		// 오늘날짜인지 확인
		// boolean regDateIsToday = postingService.hasTodayPostings(bbsNo);  // (게시글 생성일이 오늘날자인경우 작성한 시,분만 표시하는 용도)
		
		// 응답메세지
		String headerMsg = "게시글 리스트";
		String goodMsg = headerMsg+"요청에 성공했습니다";
		String badMsg = headerMsg+"요청에 실패했습니다";
		
		
		// ========================파라미터 전송 영역================== //


		if(postList != null)
		{	
			model.addAttribute("bbsNameForURL", bbsNameForURL);
			model.addAttribute("bbsName", bbsName);
			// model.addAttribute("regDateIsToday", regDateIsToday ? true : null); // (게시글이 오늘작성되었는지 판단하여 true일경우 JSP에는 시간과 분만 표시)
			model.addAttribute("postList", postList);
			model.addAttribute("bp", bp);
			model.addAttribute("resultMSG", goodMsg);
			
			
			
			// JSP파라미터 보내기
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("pageRows", pageRows);
			model.addAttribute("orderBy", orderBy);
			model.addAttribute("searchTarget", searchTarget);
			model.addAttribute("keyWord", keyWord);
			
			
			
			return "/boards/bbs_page";
		}
		
		else
		{
			model.addAttribute("resultMSG", badMsg);
			return "redirect:/";
		}
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		
		
	} //./(GET)게시판 페이지이동 : END 
	
	
	
	// (POST)게시판 페이지이동 : START
	@PostMapping("/bbs/{bbsNameForURL}/changeOption/{dynamicParam}")
	public String bbsPagePost
	(
		Model model,
		@PathVariable("bbsNameForURL") String bbsNameForURL,
		@PathVariable("dynamicParam") String dynamicParam,
		@RequestParam(defaultValue = "1") int currentPage,
		@RequestParam(defaultValue = "10") int pageRows,
		@RequestParam(defaultValue = "TITLE") SearchTarget searchTarget,
		@RequestParam(defaultValue = "") String keyWord,
		@RequestParam(defaultValue = "IDX_DESC") SortOrder orderBy
	) 
	{
		
		/* 	notice : 
		 *  changetOption은 JSP에서 보내온 파라미터 옵션을 의미하는 문자열임, 
		 *  dynamicParam에는 pageOption이나 keyWord를 받아온다 
		 *  둘다 사용자에게 URL에 무엇이 바뀌었는지 표시하는 용도로사용 
		 *  (dynamicParam은 사용자경험을 위한 url표시와 파라미터값 비교용으로 사용)
		 *  
		 *  그리고 JSP에서 form으로 온 파라미터값과 dynamicParam의 값을 비교한뒤
		 *  form에서 전송받은 해당 파라미터를 GetMapping에 리다이렉트하여 Get코드를 재사용한다 
		*/
		
		
		//========================JSP 페이지에서 온 변경사항 Get으로 리턴 ================== //
		
		
    	model.addAttribute("currentPage", currentPage); // 현재페이지 (must)
    	model.addAttribute("pageRows", pageRows); // 페이지갯수 (must)
    	model.addAttribute("orderBy", orderBy); // 순서정렬
    	model.addAttribute("searchTarget", searchTarget); // 검색대상
    	model.addAttribute("keyWord", keyWord); // 검색어
    	
    	System.out.println("--------------------post---------------");
    	System.out.println("keyWsearchTargetord : "+searchTarget);
    	System.out.println("keyWord : "+keyWord);
		

	    return "redirect:/bbs/" + bbsNameForURL;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ========================================== 게시판이동  :END ========================================== // 
	
	// ======================================(Total)전체글 모두 보는 게시판  :START ======================================== // 
	
	@GetMapping("/bbs")
	public String globalPostingPage(Model model) {
		
		// 모든 게시판의 게시글 조회
		List<PostingDTO> totalPostingList = postingService.getGlobalPostings();
		
		// 파라미터 전송
		model.addAttribute("totalPostingList", totalPostingList);
		
		return "/boards/total_bbs/bbs_page";	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ========================================== 전체글 모두 보는 게시판  :END ========================================== // 

}
