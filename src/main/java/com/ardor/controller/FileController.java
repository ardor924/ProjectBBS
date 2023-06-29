	package com.ardor.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ardor.model.FileDTO.EntityType;
import com.ardor.service.FileService;
import com.ardor.service.MemberService;
import com.ardor.service.UtilityService;

@Controller
public class FileController {
	
	//========================== 의존성추가 ==========================

	@Autowired FileService fileService;
	@Autowired UtilityService utilService;
	@Autowired MemberService memberService;
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

	
	//============================== 회원 ============================
		
	// [Temp] 파일업로드 & DB등록
	@ResponseBody
	@PostMapping("/members/temp/upload")
	public ResponseEntity<Object> uploadMemberProfileImgToTemp
	(
		@RequestParam("memberProfileIMG") MultipartFile memberProfileIMG)
	{	
		// 파일업로드 & DB등록 (임시폴더)
		Map<String, Object> response = fileService.uploadTempFiles(EntityType.TEMP, memberProfileIMG);

		return ResponseEntity.ok(response);
	}
	
	
	// 회원프사 URL생성 (snb와 myInfo에출력)
	@GetMapping("/members/profilePhoto/{memberID}")
	public String getMemberProfilePhoto
	(
		@PathVariable String memberID
	)
	{		
		// 프사URL 가져오기 (memberID사용)
		String url = fileService.getMemberProfileImgUrlByMemberID(memberID); // 프사있다면 => DB정보로 링크생성	, 프사없다면 =>	기본값설정으로 링크생성
		
		return url;
	}

	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
	//============================ 게시글 ============================
	
	// [Temp] 파일업로드 & DB등록
	@ResponseBody
	@PostMapping("/postings/temp/upload")
	public ResponseEntity<Object> uploadPostingImgToTemp
	(
		@RequestParam("postingIMG") MultipartFile postingIMG
	)
	{	
		// 파일업로드 & DB등록 (임시폴더)
		Map<String, Object> response = fileService.uploadTempFiles(EntityType.TEMP,postingIMG);
		
		return ResponseEntity.ok(response);
	}
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
	//============================== 댓글 ============================
	
	// [Temp] 파일업로드 & DB등록
	@ResponseBody
	@PostMapping("/replies/temp/upload")
	public ResponseEntity<Object> uploadReplyImgToTemp
	(
		@RequestParam("replyIMG") MultipartFile replyIMG
	)
	{	
		// 파일업로드 & DB등록 (임시폴더)
		Map<String, Object> response = fileService.uploadTempFiles(EntityType.TEMP,replyIMG);
		
		return ResponseEntity.ok(response);
	}
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
	
	//============================== 유틸 ============================

    // 이미지 URL 요청 처리
    @GetMapping("/images/{folderName}/{date}/{fileName:.+}")
    public ResponseEntity<Resource> getImagePath
    (
    	HttpServletRequest request,
    	@PathVariable String folderName,
    	@PathVariable String date,
    	@PathVariable String fileName
    )
    {
    	// 로컬변수
    	String imagePath = "";
    	
    	// -----------------이미지 경로 세팅-----------------
    	
    	 // 경로세팅 (회원프사 기본이미지로)
    	if(folderName.equals("default-member-photo"))
    	{
    		ServletContext servletContext = request.getServletContext();
    		String contextPath = "/resources/img/default-member-photo.png"; // 프로젝트내부 img폴더의 이미지파일 경로에 접근
            imagePath = servletContext.getRealPath(contextPath);
    	}
    	// 경로세팅 (폴더명에 따라 : 폴더명은 EntityType에 따라 배치함)
    	else
    	{
    		imagePath = fileService.setImagePath(folderName,date,fileName);
    	}
    	
    	Resource resource = new FileSystemResource(imagePath); // 물리경로로 파일 리소스생성
    	
        if (resource.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // 이미지 타입에 맞게 설정

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }    	
    }

    
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
	
}
