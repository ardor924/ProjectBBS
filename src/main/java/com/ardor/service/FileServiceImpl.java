package com.ardor.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ardor.mapper.FileMapper;
import com.ardor.model.FileDTO;
import com.ardor.model.MemberDTO;

@Service
public class FileServiceImpl implements FileService{

	
	@Autowired UtilityService utilService;
	@Autowired FileMapper fileMapper;
	
	@Autowired
	private ServletContext servletContext;

	
	FileInputStream in = null;  // 설명 : 다운로드시 FileInputStream과 ServletOutputStream를 사용하여 구현
	ServletOutputStream out = null; // HttpServletResponse 필요  -> 다운시 setContentType과 setContentLength ,setHeader 로 받기위함
	

	
	// 파일 업로드
	@Override
	public Map<String, Object> uploadFile(MultipartFile file) {
	    Map<String, Object> response = new HashMap<>();

		
        String errorMessage = "이미지 업로드 중 오류가 발생했습니다.";

		
		// 이미지 업로드 로직 수행
		try {
			// 필수 파라미터 생성
			String fileRoot = "C:\\file_repo\\";
			Date fileRegdate = utilService.getNowDate();
			String fileStrRegdate = utilService.getFolderDate();
			String uuid = UUID.randomUUID().toString();
			String filePath = fileRoot + fileStrRegdate + "\\";
			
			// 폴더생성
	        File folderGenerator = new File(fileRoot + fileStrRegdate);
	        if (!folderGenerator.exists()) {
	            folderGenerator.mkdirs(); // mkdir 가아닌 mkdirs여야 폴더가 생성됨
	        } else {
	            System.out.println("폴더가 이미 존재합니다!");
	        }
			
	        // 물리 폴더에 파일 저장
	        File saveFile = new File(filePath, uuid+file.getOriginalFilename());
	        file.transferTo(saveFile);
	        
	        
	        // 파일정보를 DB에 등록
	        String fileName = uuid+file.getOriginalFilename();
	        String fileRealName = file.getOriginalFilename();
	        
	        FileDTO fileDTO = new FileDTO();      
	        fileDTO.setFileName(fileName);
	        fileDTO.setFileRealName(fileRealName);
	        fileDTO.setFilePath(filePath);
	        fileDTO.setFileRegdate(fileRegdate);
	        
	        System.out.println(fileDTO.toString());
	        
	        
	        int success = fileMapper.insertFileToDB(fileDTO);
	                
	        if(success == 0) {
	        		System.out.println("DB등록 실패");
	        }
	        
	        	System.out.println("DB등록 성공");
	        // 이미지 업로드 성공 응답 데이터 생성
	        String responseMessage = "이미지가 업로드되었습니다.";
	        
	        
	        String imageUrl = "http://localhost:8080"+"/myapp"+"/images/"+fileStrRegdate + "/" + fileName;
	        
	        
	        response.put("url", imageUrl);
	        response.put("message", responseMessage);
	        response.put("filePath", filePath);
	        response.put("fileRealName", fileRealName);
	        
	        
	        
			
	        return response;
	        
		} catch (Exception e) {
			return response;
		}

	}
	
	
	
	
	
	// 이미지 출력용
	@Override
	public void processProfilePhoto(MemberDTO memberInfo, HttpServletResponse response, HttpServletRequest request) throws IOException
	{
		
		String memberPhotoPath =  memberInfo.getMemberPhotoPath().trim();
		String memberPhotoName =  memberInfo.getMemberPhotoName().trim();
		

		// 기본 프로필사진일때의 실제경로 변환처리
		if(memberPhotoPath.equals("${ctx}/resources/img/") )
		{
			// 기본프로필의 ${ctx} 부분을 없애고 공백으로 대신함
			memberPhotoPath = memberPhotoPath.replace("${ctx}", "");
			 // "/resources/img/" 를 실제 프로젝트 경로로 변환 
			memberPhotoPath = servletContext.getRealPath(memberPhotoPath); 
			
		}
		
		
		// 이미지파일 출력처리
		try 
		{
			File file = new File(memberPhotoPath, memberPhotoName);
			System.out.println("memberPhotoPath : "+memberPhotoPath);
			if(file.exists())
			{
				in = new FileInputStream(file);  
				out = response.getOutputStream();
				
				response.setContentType("application/pdf"); // 설명 : PDF다운 받기 위한설정
				response.setContentLength((int) file.length()); 
				response.setHeader("Content-Disposition", "attachment;filename="+memberPhotoPath+memberPhotoName); // 필수. 없으면 바이너리로 표기된 페이지만 전환됨
				
				for(int i = in.read(); i != -1; i = in.read()) 
				{
					out.write(i);
				}	
			}
			else 
			{
				System.out.println("------------------------------------");
				System.out.println("파일이 해당경로에 존재하지 않습니다");
				System.out.println("------------------------------------");
			}
		} 
		
		catch (IOException e) 
		{
			System.out.println("------------------------------------");
			System.out.println("파일을 생성하는데 실패했습니다");
			System.out.println("------------------------------------");
		}
	
	}
	
	
	
	

	
}
