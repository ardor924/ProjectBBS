package com.ardor.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
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
import com.ardor.model.FileDTO.folderRef;
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
	public Map<String, Object> uploadTempFiles(String photoType,MultipartFile file) {		
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
        	String fileToken = UUID.randomUUID().toString(); // 세션토큰 생성

			
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
	        fileDTO.setFolderRef(folderRef.TEMP);
	        fileDTO.setFileToken(fileToken);
	        
	        // DB등록 성공시 실행
	        boolean success = fileMapper.insertFileToDB(fileDTO);
	        if(!success) new RuntimeException("DB등록 실패");
	        
	        // 이미지 업로드 성공 응답 데이터 생성
	        String responseMessage = "이미지가 업로드되었습니다.";
	        
	        // 파일 이름 특수 문자 인코팅 에러처리
        	String encodedFileName = URLEncoder.encode(fileName, "UTF-8");
        	// 이미지 url생성
        	String imageUrl = "http://localhost:8080"+"/myapp"+"/images/" +photoType+"/" + fileStrRegdate+"/"  + encodedFileName; 
        	


        	
        	
        	// 응답 보내기      	
        	response.put("fileToken", fileToken);
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
	public boolean uploadFiles(String photoType,String fileToken, int pkNo) {
		
		boolean uploadSuccess = true;
		
		// 물리폴더 파일 이동 (임시폴더에서 물리폴더로)
		FileDTO fDto = new FileDTO();
		fDto.setFileTemp(isTEMP.TRUE);

		List<FileDTO> files = fileMapper.getAllTempFiles(fDto.getFileTemp());
		
		System.out.println("fileToken : "+fileToken);

		
		for(FileDTO file : files)
		{	
			System.out.println("-------------------------------------");
			if(fileToken.equals(file.getFileToken()))
			{				
				{				
					// 필수 파라미터 생성
					String fileRoot = "C:\\file_repo\\";
					String folderName = getFolderName(photoType);
					Date fileRegdate = utilService.getNowDate();
					String fileStrRegdate = utilService.getFolderDate();
					String uuid = UUID.randomUUID().toString();
					String fileName = file.getFileName();
					String fileRealName = file.getFileRealName();
					String filePath = fileRoot +folderName+"\\" + fileStrRegdate + "\\";
					
					
					String sourceFilePath = file.getFilePath()+file.getFileName();
					String destinationFilePath = fileRoot +folderName+"\\" + fileStrRegdate + "\\"+fileName;
					
					Path sourcePath = Path.of(sourceFilePath);
					Path destinationPath = Path.of(destinationFilePath);
					
					
					
					// 폴더생성
					File folderGenerator = new File(fileRoot + folderName + "\\" +  fileStrRegdate);
					String message = folderGenerator.exists() ? "폴더가 이미 존재합니다!" : (folderGenerator.mkdirs() ? "폴더가 생성되었습니다!" : "폴더 생성에 실패했습니다!");
					System.out.println(message);
					
					// (2) 파일 DB정보 수정		
					FileDTO fileDTO = new FileDTO();      
					fileDTO.setFilePath(filePath);
					fileDTO.setFileTemp(isTEMP.FALSE);
					if(folderName == "memberProfileIMG")fileDTO.setFolderRef(folderRef.MEMBER);
					if(folderName == "postingIMG")fileDTO.setFolderRef(folderRef.POSTING);
					if(folderName == "replyIMG")fileDTO.setFolderRef(folderRef.REPLY);
					
					fileDTO.setFileNo(file.getFileNo());
					
					
					// 파일 테이블에 게시글 PK 세팅
					fileDTO.setMemberNo(folderName.equals("memberProfileIMG") ? pkNo : 0);
					fileDTO.setPostNo(folderName.equals("postingIMG") ? pkNo : 0);
					fileDTO.setReplyNo(folderName.equals("replyIMG") ? pkNo : 0);		
					
					System.out.println("folderName"+folderName);
					System.out.println("pkNo :"+pkNo);
					System.out.println("filePath :"+filePath);
					System.out.println("fileTemp :"+fileDTO.getFileTemp());
					System.out.println("fileRef :"+fileDTO.getFolderRef());
					
					boolean updateSuccess = fileMapper.updateFileInfo(fileDTO);
					
					
					if(!updateSuccess) System.out.println("DB변경실패"); uploadSuccess = false;
					
					
					// 파일이동	
					try
					{
						// 파일 이름 특수 문자 인코팅 에러처리
						String encodedFileName = URLEncoder.encode(fileName, "UTF-8");				
						// 파일이동
						Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
						
					}
					catch(IOException e)
					{
						System.out.println("파일생성실패");
					}
				}
			}
			else if(fileToken.equals(file.getFileName()))
			{
				System.out.println("fileToken : "+fileToken);
				// 필수 파라미터 생성
				String fileRoot = "C:\\file_repo\\";
				String folderName = getFolderName(photoType);
				Date fileRegdate = utilService.getNowDate();
				String fileStrRegdate = utilService.getFolderDate();
				String uuid = UUID.randomUUID().toString();
				String fileName = file.getFileName();
				String fileRealName = file.getFileRealName();
				String filePath = fileRoot +folderName+"\\" + fileStrRegdate + "\\";
				
				
				String sourceFilePath = file.getFilePath()+file.getFileName();
				String destinationFilePath = fileRoot +folderName+"\\" + fileStrRegdate + "\\"+fileName;
				
				Path sourcePath = Path.of(sourceFilePath);
				Path destinationPath = Path.of(destinationFilePath);
				
				
				
				// 폴더생성
				File folderGenerator = new File(fileRoot + folderName + "\\" +  fileStrRegdate);
				String message = folderGenerator.exists() ? "폴더가 이미 존재합니다!" : (folderGenerator.mkdirs() ? "폴더가 생성되었습니다!" : "폴더 생성에 실패했습니다!");
				System.out.println(message);
				
				// (2) 파일 DB정보 수정		
				FileDTO fileDTO = new FileDTO();      
				fileDTO.setFilePath(filePath);
				fileDTO.setFileTemp(isTEMP.FALSE);
				if(folderName == "memberProfileIMG")fileDTO.setFolderRef(folderRef.MEMBER);
				if(folderName == "postingIMG")fileDTO.setFolderRef(folderRef.POSTING);
				if(folderName == "replyIMG")fileDTO.setFolderRef(folderRef.REPLY);
				
				fileDTO.setFileNo(file.getFileNo());
				
				
				// 파일 테이블에 게시글 PK 세팅
				fileDTO.setMemberNo(folderName.equals("memberProfileIMG") ? pkNo : 0);
				fileDTO.setPostNo(folderName.equals("postingIMG") ? pkNo : 0);
				fileDTO.setReplyNo(folderName.equals("replyIMG") ? pkNo : 0);		
				
				System.out.println("folderName"+folderName);
				System.out.println("pkNo :"+pkNo);
				System.out.println("filePath :"+filePath);
				System.out.println("fileTemp :"+fileDTO.getFileTemp());
				System.out.println("fileRef :"+fileDTO.getFolderRef());
				
				boolean updateSuccess = fileMapper.updateFileInfo(fileDTO);
				
				
				if(!updateSuccess) System.out.println("DB변경실패"); uploadSuccess = false;
				
				
				// 파일이동	
				try
				{
					// 파일 이름 특수 문자 인코팅 에러처리
					String encodedFileName = URLEncoder.encode(fileName, "UTF-8");				
					// 파일이동
					Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
					
				}
				catch(IOException e)
				{
					System.out.println("파일생성실패");
				}
			}
			
			
		}

			
		return uploadSuccess;
	}

	
	
	// 프로필 이미지 출력
	@Override
	public void processProfilePhoto(MemberDTO memberInfo, HttpServletResponse response, HttpServletRequest request) throws IOException
	{

		// 삭제함
	}
	
	
	
	
	
	
	// 파일정보 수정
	@Override
	public boolean updateFiles(FileDTO fileDTO) {
		return fileMapper.updateFileInfo(fileDTO);
	}
	
	
	
	
	
	
	
	
	// 임시폴더내의 파일 제거
	@Override
	public void deleteAllTempFiles() {
		
		List<FileDTO> tempFiles = fileMapper.getAllTempFiles(isTEMP.TRUE); 
		
		for(FileDTO file : tempFiles)
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
                        LOGGER.error("이미지 삭제 실패: {}", filePath);
                    }
                } 
                catch (SecurityException e)
                {
                    LOGGER.error("이미지 삭제 중 예외 발생: {}", filePath, e);
                }
            } 
            else 
            {
                LOGGER.warn("삭제할 이미지가 존재하지 않습니다: {}", filePath);
            }
        }
	}
	
	
	
	

	
	// 파일 삭제 로직
	@Override
    public boolean deleteFiles(int PK, String photoType) {
        boolean allDeleted = true;
        FileDTO somePk = new FileDTO();
        String folderName = getFolderName(photoType);
        
        // 파일 테이블에 게시글 PK 세팅
        FileDTO fileDTO = new FileDTO();
        fileDTO.setMemberNo(folderName.equals("memberProfileIMG") ? PK : 0);
        fileDTO.setPostNo(folderName.equals("postingIMG") ? PK : 0);
        fileDTO.setReplyNo(folderName.equals("replyIMG") ? PK : 0);		
        List<FileDTO> files = fileMapper.getAllFilesBysomePK(fileDTO);
        
        
        
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
	
	
	//  temp내의 파일정보 DB에서 삭제
	@Override
	public boolean deleteTempFileFromDB(isTEMP TRUE) {
		System.out.println("----------deleteTempFileFromDB-----------------");
		System.out.println("isTemp:"+TRUE);
		System.out.println("----------deleteTempFileFromDB-----------------");
		return fileMapper.deleteTempFileFromDB(TRUE);
	}
	
	
	
	
	
	
	// 임시 Temp파일 전부 가져오기
	@Override
	public List<FileDTO> getAllTempFiles(isTEMP TEMP) {
		return fileMapper.getAllTempFiles(TEMP);
	}
	
	// postNo에 해당하는 파일 전부 가져오기
	@Override
	public List<FileDTO> getAllFilesBysomePK(String photoType, int somePK) {
		FileDTO fileDTO = new FileDTO();
		
        fileDTO.setMemberNo(photoType.equals("memberProfileIMG") ? somePK : 0);
        fileDTO.setPostNo(photoType.equals("postingIMG") ? somePK : 0);
        fileDTO.setReplyNo(photoType.equals("replyIMG") ? somePK : 0);	
			
		return fileMapper.getAllFilesBysomePK(fileDTO);
	}
	
	// 폴더이름 필터링
	@Override
	public String getFolderName(String photoType) {
		
		if((photoType.equals("replyIMG")))
		{
			photoType = "replyIMG";
		}
		else if((photoType.equals("postingIMG")))
		{
			photoType = "postingIMG";
		}
		else if((photoType.equals("memberProfileIMG")))
		{
			photoType = "memberProfileIMG";
		}
		
		return photoType;
	}
	
	

	
	
	
	// 이미지 파일 가져와서 폴더 분류
	@Override
	public String setImagePath(String photoType, String date, String filename) {
	    String imagePath = "";
	    String folderName = "";
	    String basePath = "";

	    List<FileDTO> tempList = fileMapper.getAllTempFiles(isTEMP.TRUE);

	    System.out.println("photoType : "+photoType);
	    
	    if (!tempList.isEmpty()) 
	    {
	        basePath = "C:\\file_repo\\temp\\";
	        imagePath = basePath + date + "\\" + filename;  System.out.println(-1);
	    } 
	    else
	    {
	        basePath = "C:\\file_repo\\";
	        System.out.println(0);
	        if(photoType.equals("memberProfileIMG"))
	        {
	        	imagePath = basePath + "\\"+photoType+"\\" + date + "\\" + filename; System.out.println(1);
	        }
	        
	        
	        else if(photoType.equals("postingIMG"))
	        {
	        	imagePath = basePath + "\\"+photoType+"\\" + date + "\\" + filename; System.out.println(2);
	        }
	        
	        else if(photoType.equals("replyIMG"))
	        {
	        	imagePath = basePath + "\\"+photoType+"\\" + date + "\\" + filename; System.out.println(3);
	        }
	        
	        
	        
	    }

	    

	    return imagePath;
	}
	
	
}
