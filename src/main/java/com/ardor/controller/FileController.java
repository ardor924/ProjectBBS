package com.ardor.controller;

import java.util.List;
import java.util.Map;

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

import com.ardor.service.FileService;
import com.ardor.service.MemberService;
import com.ardor.service.UtilityService;
@Controller
public class FileController {

	@Autowired FileService fileService;
	@Autowired UtilityService utilService;
	@Autowired MemberService memberService;
	
	
	// 파일업로드 및 주소가져오기
	@ResponseBody
	@PostMapping("/images")
	public ResponseEntity<Object> insertFileToDB(@RequestParam("memberPhoto") MultipartFile memberPhoto){
		
    	// 이미지 타입으로 폴더설정
    	String photoType = "profilePhotoIMG";

		// 파일 업로드 및 이미지 URL생성
		Map<String, Object> response = fileService.uploadTempFile(photoType,memberPhoto);
			        
		return ResponseEntity.ok(response);
	}
	
//	
//	// 회원프로필 이미지 링크 생성 
//	@GetMapping("/members/profilePhoto/{memberID}")
//	public void getProfilePhoto(@PathVariable String memberID, HttpServletResponse response,HttpServletRequest request) {
//		
//	    // 회원 고유 ID를 기반으로 DB에서 회원 정보 조회
//	    MemberDTO memberInfo = memberService.getMemberInfoBymemberID(memberID);
//	    
//	    if (memberInfo != null) {
//            try {
//				fileService.processProfilePhoto(memberInfo, response,request);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//        } else {
//            // 회원 정보가 없거나 비밀번호가 일치하지 않는 경우에 대한 처리
//        }
//    }	    
//	    
//	    
//	    
//
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    
    
    
//	-----------------------------------CKeditor5업로드로직--------------------------------------------------------------------    
    
    
    @ResponseBody
    @PostMapping("/bbs/{bbsNameForURL}/writing/upload")
    //public ResponseEntity<Object> insertBbsImgToDB(@PathVariable String bbsNameForURL, @PathVariable("bbsIMG") MultipartFile bbsIMG) {
    public ResponseEntity<Object> insertBbsImgToDB(@RequestParam("bbsIMG") MultipartFile bbsIMG) {
    	
    	
    	System.out.println("------------------------CKeditor5 테스트 진입성공------------------------------");
    	System.out.println("bbsIMG 파라미터 확인용 : "+bbsIMG.getOriginalFilename());
    	    	
    	
    	// 이미지 타입으로 폴더설정
    	String photoType = "postContentsIMG";
    	
    	// 파일 업로드 및 이미지 URL생성
    	Map<String, Object> response = fileService.uploadTempFile(photoType,bbsIMG);
    	
    	
    	return ResponseEntity.ok(response);
    }
    
    
    
    
    
	
    // 이미지 URL 요청 처리
    @GetMapping("/images/{folderName}/{date}/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String folderName,@PathVariable String date, @PathVariable String filename) {
    	String imagePath;
    	// 실제 물리폴더에 업로드된경우
    	if(folderName != "temp") { imagePath = "C:\\file_repo\\" + folderName + "\\"+ date + "\\" + filename;}
    	
    	// 임시Temp이미지의 경우
    	else
    	{
    	 imagePath = "C:\\file_temp\\" + date + "\\" + filename;	
    	}	
        Resource resource = new FileSystemResource(imagePath);

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
    
    
    
    
    
    
    
    
    
    
	
	
	
	
}
