package com.ardor.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ardor.mapper.FileMapper;
import com.ardor.mapper.PostingMapper;
import com.ardor.model.FileDTO;
import com.ardor.model.FileDTO.EntityType;
import com.ardor.model.FileDTO.IsTemp;
import com.ardor.model.PostingDTO;
import com.ardor.model.PostingDTO.SearchTarget;
import com.ardor.model.PostingDTO.SortOrder;
import com.ardor.model.PostingDTO.isNotice;
import com.ardor.service.BoardService;
import com.ardor.service.FileService;
import com.ardor.service.PostingService;
import com.ardor.service.UtilityService;

@Controller
public class PostingController {

	@Autowired UtilityService utilService;
	@Autowired FileService fileService;
	@Autowired PostingService postingService;
	@Autowired BoardService boardService;
	
	
	
	
	
	@Autowired PostingMapper postingMapper;
	@Autowired FileMapper fileMapper;
	
	
	
	
	// ------------------------ 테스트 ------------------------//
	// !!!!!! 테스트!!!!!! 게시글 보기 화면템플릿(이렇게 만들면 성공)
	@GetMapping("/bbs/viewTest")
	public String postViewTestPage() {
		return "/posting/example_view_page";
	}
	
	// !!!!!!!!!!!!!!!!!!!!더미데이터 생성!!!!!!!!!!!!!!!!!!! //
	@GetMapping("/bbs/SpringWeb/dummy")
	public String createDummy(Model model) {
		String SpringWeb = "SpringWeb"; // <- 테스트할 bbsNameForURL이름
		//더미생성
		boolean success = utilService.dummy();
		if(success)
		{	model.addAttribute("resultMsg", "더미데이터 생성성공");
			return "redirect:/bbs/"+SpringWeb;
		}
		else
		{	model.addAttribute("resultMsg", "더미데이터 생성실패");
			return "redirect:/";
		}
	}
	

	// ------------------------ 테스트 ------------------------//
	
	
	
	
	
	
	
	
	// ========================================== 게시글 쓰기 :START ========================================== // 
	
	
	// 게시글 쓰기 페이지 이동 :
	@GetMapping("/bbs/{bbsNameForURL}/write-page")
	public String writingPage(@PathVariable String bbsNameForURL,Model model) {	

		model.addAttribute("bbsNameForURL", bbsNameForURL); //(화면출력용 실제게시판이름으로 파라미터전송)		
		return "/posting/writing_page";	
	}
	
//	
//	// 게시글 쓰기 페이지에서 select선택후 bbsName받아와서 bbsName과 bbsNameForURL 보내기
//	@GetMapping("/bbs/{bbsName}/write-page/selecting")
//	public String writingPageBySelecting(@PathVariable String bbsName,Model model) {		
//		
//		bbsNameForURL = postingService.getBbsNameForURLByBbsName(bbsName);
//		return "redirect:/bbs/{bbsNameForURL}/write-page";	
//	}
//	
	
	// 게시글 쓰기 폼 제출
	@PostMapping("/bbs/{bbsNameForURL}/write-page/submit")
	String submitWriting
	(
		PostingDTO postingDTO,
		@PathVariable String bbsNameForURL,
		@RequestParam("fileNameList") List<String> fileNameList, 
		@RequestParam(value="postHit" , defaultValue="0" ) int postHit , 
		@RequestParam(value="postNotice" , defaultValue="NO" ) String postNoticeStr , 
		Model model
	) 
	
	{
		/* 	notice : 
		 *  홈화면 사이드바에서 바로 게시글을 작성하거나, 게시글 폼 제출시 게시판이름이 폼으로 제출안되는 경우가 발생함 
		 *  JSP를 통해 가져온 bbsNameSelect의 경우 값이 선택되지 않고 파라미터가 컨트롤러에 온다면 에러발생
		 *  때문에, URL로 넘어온 게시판이름과 비교하는 로직이 필요해서 예외처리코드 작성
		*/
	
		
		// ================파라미터 생성 및 조합 영역============= //
		
		// 게시판 실제이름 가져오기
		String bbsName = boardService.getRealNameFromUrlName(bbsNameForURL); // (URLName => RealName)
			
		// 게시판 PK번호 가져오기
		int bbsNo = boardService.getBbsNoByUrlName(bbsNameForURL); // (URL이름으로 조회)
		
		// 공지사항 Enum값 처리
		isNotice postNotice = utilService.convertToEnumNotice(postNoticeStr);	
		
		// 게시글 등록일자 처리
		Date postRegdate = utilService.getNowDate();
		
		// 게시글번호 생성 및 추가
		int bbsPostNo = postingService.addBbsPostNo(bbsNo); //(각각의 게시판마다 별도의 게시글 번호를 1부터 순차적으로 생성) 
		
		// 엔티티타입 설정 
		EntityType entityType = EntityType.POSTING;
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		

		

		// ========================DB저장 영역================== //
				

		
		// DTO에 파라미터 세팅
		postingDTO.setBbsPostNo(bbsPostNo);
		postingDTO.setBbsNo(bbsNo);
		postingDTO.setPostHit(postHit);
		postingDTO.setPostNotice(postNotice);
		postingDTO.setPostRegdate(postRegdate);

		// DB에 게시글정보 저장
		boolean success =  postingService.regPosting(postingDTO);
		
		
		
		
		// ========================유틸기능 영역================== //
	
		// 응답메세지
		String headerMsg = "게시글 등록";
		String goodMsg = headerMsg+"요청에 성공했습니다";
		String badMsg = headerMsg+"요청에 실패했습니다";
		
		// 이미지폴더 분류
		String photoType = "postingIMG";
		
		// 게시판 이미지 파일 업로드처리
		int postNo = postingService.getPostNo(bbsNo, bbsPostNo);
		for(String fileName : fileNameList)
		{	
			boolean uploadSuccess = fileService.uploadFiles(entityType, photoType, postNo);
		}

		fileService.deleteAllTempFiles();// 물리폴더의 잔류 temp파일 삭제
		fileService.deleteAllTempFilesFromDB(); // DB에서 삭제		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		
		

		
		
		
		// ========================파라미터 전송 영역================== //
		
		//성공
		if(success) // (DB등록성공)
		{	
			model.addAttribute("resultMSG", goodMsg);
			return "redirect:/bbs/"+bbsNameForURL ;
		}
		
		// 실패
		else 
		{	
			model.addAttribute("resultMSG", badMsg);
			return "redirect:/bbs/"+bbsNameForURL+"/writing";
		}

		
		
	} // ./게시글쓰기 폼 제출 : END
	
	
	// ========================================== 게시글 쓰기 : END ========================================== // 
	
	
	
	// ========================================== 게시글 조회 : START ========================================== // 
	

	
	//게시판 조회 페이지:
	@PostMapping("/bbs/{bbsNameForURL}/{bbsPostNo}")
	public String viewPage
	(
			Model model,
			@PathVariable String bbsNameForURL,
			@PathVariable("bbsPostNo") int bbsPostNo,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "10") int pageRows,
			@RequestParam(defaultValue = "TITLE") SearchTarget searchTarget,
			@RequestParam(defaultValue = "") String keyWord,
			@RequestParam(defaultValue = "IDX_DESC") SortOrder orderBy
	) 
	
	{
		
		/* 	notice : 
		 * 	개별 게시글번호로 URL을 받아오면 rest API 관점에서 사용자에게 직관적이면서도 
		 * 	보안상으로도 PK값인 PostNo를 노출하지 않아도 되므로 안전하면서
		 *  여러 게시판에 순차적으로 자동증가시킬수 있음
		 *  !다만! 동시성 문제나 트랜잭션 처리에 있어 에러처리를 확실히 할것
		*/
		
		// ================파라미터 생성 및 조합 영역============= //
		
		// 게시판 실제이름 가져오기
		String bbsName = boardService.getRealNameFromUrlName(bbsNameForURL); // (URLName => RealName)
		
		// 게시판 PK번호 가져오기
		int bbsNo = boardService.getBbsNoByUrlName(bbsNameForURL); // (URL이름으로 조회)
		
		// 게시글 PK번호 가져오기
		int postNo = postingService.getPostNo(bbsNo, bbsPostNo); // (게시판번호, 개별 게시글번호로 검색하여 조회)
		
		// 게시글 1개 가져오기
		PostingDTO postingDTO = postingService.getPosting(postNo); // (게시글 PK값으로 조회)
		
		// 게시판정렬
		// SortOrder orderBy = postingService.setOrderBy()
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		
		
		
		// ========================유틸기능 영역================== //
		
		// 오늘날짜인지 확인
		// boolean regDateIsToday = postingService.hasTodayPostings(bbsNo);  // (게시글 생성일이 오늘날자인경우 작성시간 분만 표시하는 용도)
		
		// 조회수증가
		postingService.addHitUp(postingDTO);
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		
		

		
		// ========================파라미터 전송 영역================== //
		

		// 파라미터 보내기
		//model.addAttribute("regDateIsToday", regDateIsToday); 
		model.addAttribute("postingDTO", postingDTO);
		model.addAttribute("bbsNameForURL", bbsNameForURL);
		model.addAttribute("bbsName", bbsName);
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageRows", pageRows);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("searchTarget", searchTarget);
		model.addAttribute("keyWord", keyWord);
		
		
		
		
		
		return "/posting/view_page";
	}
	
	
	
	
	// ========================================== 게시글 조회 : END ========================================== // 
	
	
	
	
	// ========================================== 게시글 수정 : START ========================================== // 
	
	//게시판 수정 페이지:
	@PostMapping("/bbs/{bbsNameForURL}/{bbsPostNo}/edit-page")
	public String editPage
	(
		Model model,
		@PathVariable String bbsNameForURL, 
		@PathVariable int bbsPostNo,
		@RequestParam(defaultValue = "1") int currentPage,
		@RequestParam(defaultValue = "10") int pageRows,
		@RequestParam(defaultValue = "TITLE") SearchTarget searchTarget,
		@RequestParam(defaultValue = "") String keyWord,
		@RequestParam(defaultValue = "IDX_DESC") SortOrder orderBy
	) 
	{
		// ================파라미터 생성 및 조합 영역============= //
		// 게시판 PK번호 가져오기
		int bbsNo = boardService.getBbsNoByUrlName(bbsNameForURL); // (URL이름으로 조회)
		
		// 게시글 PK번호 가져오기
		int postNo = postingService.getPostNo(bbsNo, bbsPostNo); // (게시판번호, 개별 게시글번호로 검색하여 조회)
		
		// 게시글 1개 가져오기
		PostingDTO postingDTO = postingService.getPosting(postNo); // (게시글 PK값으로 조회)
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		
		
		// ========================파라미터 전송 영역================== //
		

		// 파라미터 보내기
		model.addAttribute("postingDTO", postingDTO);
		model.addAttribute("bbsNameForURL", bbsNameForURL);
		model.addAttribute("bbsPostNo", bbsPostNo);
		
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageRows", pageRows);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("searchTarget", searchTarget);
		model.addAttribute("keyWord", keyWord);
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		
		
		
		return "/posting/edit_page";
	}
	
	
	
	
	
	// 게시글 수정 폼 제출
	@PostMapping("/bbs/{bbsNameForURL}/{bbsPostNo}/edit-page/submit")
	String submitEditing
	(
		PostingDTO postingDTO,
		@PathVariable String bbsNameForURL,
		@RequestParam("fileNameList") List<String> fileNameList, 
		@PathVariable("bbsPostNo") int bbsPostNo,
		@RequestParam(value="postHit" , defaultValue="0" ) int postHit , 
		@RequestParam(value="postNotice" , defaultValue="NO" ) String postNoticeStr , 
		Model model
	) 
	
	{

		/* 	notice : 
		 *  홈화면 사이드바에서 바로 게시글을 작성하거나, 게시글 폼 제출시 게시판이름이 폼으로 제출안되는 경우가 발생함 
		 *  JSP를 통해 가져온 bbsNameSelect의 경우 값이 선택되지 않고 파라미터가 컨트롤러에 온다면 에러발생
		 *  때문에, URL로 넘어온 게시판이름과 비교하는 로직이 필요해서 예외처리코드 작성
		*/
		
	
		// ================파라미터 생성 및 조합 영역============= //
		
		// 게시판 실제이름 가져오기
		String bbsName = boardService.getRealNameFromUrlName(bbsNameForURL); // (URLName => RealName)
			
		// 게시판 PK번호 가져오기
		int bbsNo = boardService.getBbsNoByUrlName(bbsNameForURL); // (URL이름으로 조회)
		
		// 게시글 PK번호 가져오기
		int postNo = postingService.getPostNo(bbsNo, bbsPostNo); // (게시판번호, 개별 게시글번호로 검색하여 조회)
		
		// 공지사항 Enum값 처리
		isNotice postNotice = utilService.convertToEnumNotice(postNoticeStr);	
		
		// 게시글 등록일자 처리
		Date postRegdate = utilService.getNowDate();
				
		// 엔티티 타입 설정
		EntityType entityType = EntityType.POSTING;
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		
				
		
		
		
		
		
		// ========================유틸기능 영역================== //

		
		// 응답메세지
		String headerMsg = "게시글 수정";
		String goodMsg = headerMsg+"요청에 성공했습니다";
		String badMsg = headerMsg+"요청에 실패했습니다";
		
		
		
		// 이미지폴더 분류
		String photoType = "postingIMG";
		
		// 기존의파일제거(물리+DB)
		fileService.deleteUnmodifiedFiles(fileNameList, postNo);
		
		// 게시판 이미지 파일 업로드처리
		for(String fileName : fileNameList)
		{
			fileService.uploadFiles(entityType, fileName, postNo);
		}
		
		
		fileService.deleteAllTempFiles();// 물리폴더의 잔류 temp파일 삭제
		fileService.deleteAllTempFilesFromDB(); // DB에서 삭제

		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		
		
		
		
		
		
		


		
		

		// ========================파라미터 전송 영역================== //
				

		
		// DTO에 파라미터 세팅
		postingDTO.setPostNo(postNo);
		postingDTO.setPostNotice(postNotice);
		postingDTO.setPostRegdate(postRegdate);
		System.out.println("postNo : "+postNo);
		// DB에 게시글정보 업데이트
		boolean success =  postingService.updatePostingByPostingDTO(postingDTO);
		
		
		//성공
		if(success) // (DB등록성공)
		{	
			model.addAttribute("resultMSG", goodMsg);
			return "redirect:/bbs/"+bbsNameForURL ;

		}
		
		// 실패
		else 
		{	
			model.addAttribute("resultMSG", badMsg);
			return "redirect:/bbs/"+bbsNameForURL+"/writing";

		}

		
		
	} // ./게시글쓰기 폼 제출 : END
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ========================================== 게시글 수정 : END ========================================== // 
	
	
	
	
	
	
	// ========================================== 게시글 삭제 : START ========================================== // 
	
	//게시판 삭제
	@PostMapping("/bbs/{bbsNameForURL}/{bbsPostNo}/delete")
	public String deletePosting
	(
		Model model,
		@PathVariable String bbsNameForURL,	
		@PathVariable("bbsPostNo") int bbsPostNo
	) 
	{	
		System.out.println("------------------게시글 삭제------------------------");
		// ================파라미터 생성 및 조합 영역============= //
				
		// 게시판 실제이름 가져오기
		String bbsName = boardService.getRealNameFromUrlName(bbsNameForURL); // (URLName => RealName)
		
		// 게시판 PK번호 가져오기
		int bbsNo = boardService.getBbsNoByUrlName(bbsNameForURL); // (URL이름으로 조회)
		
		// 게시글 PK번호 가져오기
		int postNo = postingService.getPostNo(bbsNo, bbsPostNo); // (게시판번호, 개별 게시글번호로 검색하여 조회)
		
		
		// ========================유틸기능 영역================== //

		
		// 응답메세지
		String headerMsg = "게시글 삭제";
		String goodMsg = headerMsg+"요청에 성공했습니다";
		String badMsg = headerMsg+"요청에 실패했습니다";
		
		// 물리폴더 이미지 삭제
		boolean deleteResult = fileService.deleteFilesByEntityPK(postNo);
		System.out.println(deleteResult ? "게시글 이미지 삭제 성공" : "");
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
		
		
		/*------------------------------*/
		
		// DB에 게시글정보 저장
		boolean success =  postingService.deletePostingByPostNo(postNo);
		
		//성공
		if(success) // (DB삭제성공)
		{	
			//model.addAttribute("deleteResultMSG", deleteResultMSG);
			model.addAttribute("resultMSG", goodMsg);
			return "redirect:/bbs/"+bbsNameForURL ;

		}
		
		// 실패
		else 
		{	
			model.addAttribute("resultMSG", badMsg);
			return "redirect:/bbs/"+bbsNameForURL+"/"+bbsPostNo;

		}
		
		
	}
	
	
	// ========================================== 게시글 삭제 : END ========================================== // 

	
	
	
	
	
}
