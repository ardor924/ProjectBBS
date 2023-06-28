	package com.ardor.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.ardor.model.FileDTO;
import com.ardor.model.FileDTO.isTEMP;
import com.ardor.model.MemberDTO;
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
    	String photoType = "memberProfileIMG";
    	
    	System.out.println("312526523546234556243");

		// 파일 업로드 및 이미지 URL생성
		Map<String, Object> response = fileService.uploadTempFiles(photoType,memberPhoto);
			        
		return ResponseEntity.ok(response);
	}
	
	
	
	
	// 회원프로필 이미지 링크 생성 
	@GetMapping("/members/profilePhoto/{memberID}")
	public String getProfilePhoto
	(
		@PathVariable String memberID,
		@RequestParam(value="photoType" , defaultValue="memberProfileIMG" ) String photoType
	) 
	{	
		String url = "";
		// memberID로 PK값 가져오기
		MemberDTO memberDTO = memberService.getMemberInfoBymemberID(memberID);
		int MemberNo = memberDTO.getMemberNo();

		//memberID로 파일정보 가져오기
		List<FileDTO> files =  fileService.getAllFilesBysomePK(photoType, MemberNo);
		if(!files.isEmpty())
		{			
			for(FileDTO file : files)
			{
				Date date = file.getFileRegdate();
				String strDate = utilService.getStrDateFromDate(date);
				
				String fileName = file.getFileName(); 
				
				// 리다이렉트
				url = "redirect:/images/" + photoType+"/" +  strDate+"/"+ fileName;
				System.out.println("fileName : "+url);
			}
		}
		// 회원프사가 없는경우
		else
		{       
			System.out.println("MemberNo"+MemberNo);
			photoType = "default-member-photo";
			url = "redirect:/images/" + photoType+"/" +  "9999-12-31"+"/"+ "defaul-profile.png";
		}
		
		

		
		return url;
    }	    


    
    
    
//	-----------------------------------CKeditor5업로드로직--------------------------------------------------------------------    
    
    
    @ResponseBody
    @PostMapping("/bbs/{bbsNameForURL}/writing/upload")
    public ResponseEntity<Object> insertBbsImgToDB
    (
    	@RequestParam(value="photoType" , defaultValue="postingIMG" ) String photoType , 	
    	@RequestParam("bbsIMG") MultipartFile bbsIMG
    )
    { 	    	
    	Map<String, Object> response = new HashMap<String, Object>();
    	System.out.println("------------------------CKeditor5경로-------------------------------");
    	
    	response = fileService.uploadTempFiles(photoType,bbsIMG);		
    	    	
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	
    	return ResponseEntity.ok(response);

    }
    
    
    
    
    
	
    // 이미지 URL 요청 처리
    @GetMapping("/images/{photoType}/{date}/{filename:.+}")
    public ResponseEntity<Resource> getImage(HttpServletRequest request, @PathVariable String photoType, @PathVariable String date, @PathVariable String filename) {
    	String imagePath;
    	
    	// 이미지 경로 세팅
    	if(photoType.equals("default-member-photo")) // 회원기본이미지인경우
    	{
    		ServletContext servletContext = request.getServletContext();
    		String contextPath = "/resources/img/default-member-photo.png";
            imagePath = servletContext.getRealPath(contextPath);

    	}
    	else
    	{
    		imagePath = fileService.setImagePath(photoType,date,filename);
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
    
    
    
    
    
    // 페이지 새로고침 혹은 이동시 Temp파일 및 DB에서 정보 삭제
    @GetMapping("/removeTempFile")
    public ResponseEntity<Resource> removeTempFile() {
        isTEMP fileTemp = isTEMP.TRUE;
        fileService.deleteTempFileFromDB(fileTemp); // DB에서 삭제
        fileService.deleteAllTempFiles(); // 잔류 temp 파일 삭제
        return ResponseEntity.ok().build(); // 작업이 완료되었음을 응답으로 전달
    }

    
	
	
	
	
}
