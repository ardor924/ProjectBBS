package com.ardor.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ardor.mapper.FileMapper;
import com.ardor.model.FileDTO;
import com.ardor.model.FileDTO.isTEMP;
import com.ardor.model.MemberDTO;

@Service
public class FileServiceImpl implements FileService{
    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);


	@Autowired UtilityService utilService;
	@Autowired FileMapper fileMapper;
	@Autowired PostingService postingService;
	
	@Autowired
	private ServletContext servletContext;

	String errorMessage = "이미지 업로드 중 오류가 발생했습니다.";
	FileInputStream in = null;  // 설명 : 다운로드시 FileInputStream과 ServletOutputStream를 사용하여 구현
	ServletOutputStream out = null; // HttpServletResponse 필요  -> 다운시 setContentType과 setContentLength ,setHeader 로 받기위함
	
	
	// 임시 파일 업로드
	@Override
	public Map<String, Object> uploadTempFile(String photoType,MultipartFile file) {		
		Map<String, Object> response = new HashMap<>();
		
		// 임시 이미지 업로드 로직 수행
		try 
		{
			// 필수 파라미터 생성
			String fileRoot = "C:\\file_repo\\temp\\";
			Date fileRegdate = utilService.getNowDate();
			String fileStrRegdate = utilService.getFolderDate();
			String uuid = UUID.randomUUID().toString();
			String fileRealName = file.getOriginalFilename();
			String fileName = uuid+fileRealName;
			String filePath = fileRoot + fileStrRegdate + "\\";
			
			// 폴더생성
			File folderGenerator = new File(fileRoot + fileStrRegdate);
			String message = folderGenerator.exists() ? "폴더가 이미 존재합니다!" : (folderGenerator.mkdirs() ? "폴더가 생성되었습니다!" : "폴더 생성에 실패했습니다!");
			System.out.println(message);

			
	        // 물리 폴더에 파일 저장
	        File saveFile = new File(filePath, fileName);
	        file.transferTo(saveFile);
			
	        // 파일정보를 DB에 등록
	        FileDTO fileDTO = new FileDTO();      
	        fileDTO.setFileName(fileName);
	        fileDTO.setFileRealName(fileRealName);
	        fileDTO.setFilePath(filePath);
	        fileDTO.setFileRegdate(fileRegdate);
	        fileDTO.setFileTemp(isTEMP.TRUE);
	        
	        // DB등록 성공시 실행
	        boolean success = fileMapper.insertFileToDB(fileDTO);
	        if(!success) new RuntimeException("DB등록 실패");
	        
	        // 이미지 업로드 성공 응답 데이터 생성
	        String responseMessage = "이미지가 업로드되었습니다.";
	        
	        // 파일 이름 특수 문자 인코팅 에러처리
        	String encodedFileName = URLEncoder.encode(fileName, "UTF-8");
        	// 이미지 url생성
        	String imageUrl = "http://localhost:8080"+"/myapp"+"/images/" + fileStrRegdate + "/" + encodedFileName; 
        	
        	// 세션토큰 생성
        	String sessionToken = UUID.randomUUID().toString();

        	
        	
        	// 리스트에 파일
        	
        	response.put("sessionToken", sessionToken);
	        response.put("url", imageUrl);
	        response.put("responseMessage", responseMessage);
	        response.put("filePath", filePath);
	        response.put("fileName", fileName);
			
	        return response;
		}
		
		catch (Exception e)
		{
			return response;
		}
	
	}

	
	
	// 파일 업로드 로직
	@Override
	public boolean uploadFile(String photoType,int postNo) {

	// Temp파일 전부 가져오기
	isTEMP fileTemp = isTEMP.TRUE;	
	List<FileDTO> tempFiles =  getAllTempFiles(fileTemp);	
	// temp 파일 삭제
	boolean successDeleteFiles = deleteFiles(postNo,"게시글PK");
	
	// 파일 DB정보 수정 & 실제 물리폴더에 파일생성
	boolean successUpdateFileInfo = updateFiles(photoType,tempFiles); 
			
		return true;
	}
	

	
	// 실제 물리폴더에 파일생성	
	@Override
	public boolean updateFiles(String photoType, List<FileDTO> files) {
		
		
		try {
			for(FileDTO file : files)
			{
				// 필수 파라미터 생성
				String fileRoot = "C:\\file_repo\\";
				String folderName = (photoType.equals("profilePhotoIMG")) ? "ProfilePhoto" : "TextAreaPostContents";
				Date fileRegdate = utilService.getNowDate();
				String fileStrRegdate = utilService.getFolderDate();
				String uuid = UUID.randomUUID().toString();
				String fileName = file.getFileName();
				String fileRealName = file.getFileRealName();
				String filePath = fileRoot +folderName+"\\" + fileStrRegdate + "\\";
				
				// 폴더생성
				File folderGenerator = new File(fileRoot + fileStrRegdate);
				String message = folderGenerator.exists() ? "폴더가 이미 존재합니다!" : (folderGenerator.mkdirs() ? "폴더가 생성되었습니다!" : "폴더 생성에 실패했습니다!");
				System.out.println(message);
				
				
				// 물리 폴더에 파일 저장
				File saveFile = new File(filePath, fileName);		
				saveFile.createNewFile();
			}
			
		}

		

        
        
		catch (Exception e)
		{
			
		}
		
		
		return false;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	// 파일 삭제 로직
	@Override
    public boolean deleteFiles(int PK, String whatPK) {
        boolean allDeleted = true;
        
        
        List<FileDTO> files = whatPK.equals("게시글PK") ? fileMapper.getAllFilesByPostNo(PK) : null;
        
        for (FileDTO file : files)
        {
            String filePath = file.getFilePath() + file.getFileName();
            File deleteFile = new File(filePath);

            if (deleteFile.exists())
            {
                try {
                    if (deleteFile.delete())
                    {
                        LOGGER.info("이미지 삭제 성공: {}", filePath);
                    } 
                    else 
                    {
                        allDeleted = false;
                        LOGGER.error("이미지 삭제 실패: {}", filePath);
                    }
                } 
                catch (SecurityException e)
                {
                    allDeleted = false;
                    LOGGER.error("이미지 삭제 중 예외 발생: {}", filePath, e);
                }
            } 
            else 
            {
                LOGGER.warn("삭제할 이미지가 존재하지 않습니다: {}", filePath);
            }
        }

        return allDeleted;
    }
	
	
	
	
	
	
	// 임시 Temp파일 전부 가져오기
	@Override
	public List<FileDTO> getAllTempFiles(isTEMP TEMP) {
		return fileMapper.getAllTempFiles(TEMP);
	}
	
	// postNo에 해당하는 파일 전부 가져오기
	@Override
	public List<FileDTO> getAllFilesByPostNo(int postNo) {
		return fileMapper.getAllFilesByPostNo(postNo);
	}
	
}
