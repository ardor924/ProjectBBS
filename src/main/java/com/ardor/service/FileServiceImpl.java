package com.ardor.service;


import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ardor.mapper.FileMapper;
import com.ardor.model.FileDTO;
import com.ardor.model.FileDTO.EntityType;
import com.ardor.model.FileDTO.IsTemp;
import com.ardor.model.MemberDTO;


@Service
public class FileServiceImpl implements FileService{
	
	//================================= 의존성추가 =================================
	
	@Autowired UtilityService utilService;
	@Autowired FileMapper fileMapper;
	@Autowired PostingService postingService;
	@Autowired MemberService memberService;

	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
	//================================ 전역변수설정 ================================
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

	
	
	
	//===================================== 등록 =====================================
	
	// [Temp] 파일업로드
	@Transactional
	@Override
	public Map<String, Object> uploadTempFiles(EntityType entityType, MultipartFile file) {
		// 로컬변수설정
		Map<String, Object> response = new HashMap<>();
		
		try
		{
			// --------------- 필수 파라미터 생성 -------------- 
			String fileRoot = "C:\\file_repo\\temp\\";
			Date fileRegdate = utilService.getNowDate();
			String fileStrRegdate = utilService.getFolderDate();
			String uuid = UUID.randomUUID().toString();
			String fileRealName = file.getOriginalFilename();
			String fileName = uuid+fileRealName;
			String filePath = fileRoot + fileStrRegdate + "\\";
        	String fileToken = UUID.randomUUID().toString(); // 파일고유의 세션토큰 생성
        	
            // --------------- 파일 업로드 로직 --------------- 
        	
			// 폴더생성
			File folderGenerator = new File(fileRoot + fileStrRegdate);
			String message = folderGenerator.exists() ? "폴더가 이미 존재합니다!" : (folderGenerator.mkdirs() ? "폴더가 생성되었습니다!" : "폴더 생성에 실패했습니다!");
			System.out.println("------------파일 업로드 로직-----------------");
			System.out.println("폴더생성결과 : "+message);
			System.out.println("---------------------------------------------");
        	
	        // 물리 폴더에 파일 저장
	        File saveFile = new File(filePath, fileName);
	        file.transferTo(saveFile);
        	
	        // ----------------- DB 등록 로직 ----------------- 
	        
	        // 파일정보를 DB에 등록
	        FileDTO fileDTO = new FileDTO();      
	        fileDTO.setFileName(fileName);
	        fileDTO.setFileRealName(fileRealName);
	        fileDTO.setFilePath(filePath);
	        fileDTO.setFileRegdate(fileRegdate);
	        fileDTO.setIsTemp(IsTemp.TRUE);
	        fileDTO.setEntityType(entityType); // entityType =>  회원 : MEMBER , 게시글 : POSTING , 댓글 : REPLY  , (V) 임시파일 : TEMP
	        fileDTO.setFileToken(fileToken);
	        
	        
	        // DB등록 성공시 실행
	        boolean success = fileMapper.insertFileInfoToDB(fileDTO);
	        if(!success) new RuntimeException("DB등록 실패");
	        
	        // ----------------- 응답생성 및 응답전송 -----------------
	        
	        // DB등록 성공 응답 데이터 생성
	        String responseMessage = "이미지가 업로드되었습니다.";
	        // 폴더이름 생성
	        String folderName = setFolderName(entityType);
	        // 파일 이름 특수 문자 인코팅 에러처리
        	String encodedFileName = URLEncoder.encode(fileName, "UTF-8");
        	// 이미지 url생성
        	String imageUrl = "http://localhost:8080"+"/myapp"+"/images/" +folderName+"/" + fileStrRegdate+"/"  + encodedFileName; 

        	// 응답 보내기      	
        	response.put("fileToken", fileToken);
	        response.put("url", imageUrl);
	        response.put("responseMessage", responseMessage);
	        response.put("filePath", filePath);
	        response.put("fileName", fileName);
	        
	        return response; // 파일업로드 & DB등록 성공후 응답메세지 송출
		}
		
		catch(IOException e)
		{
	        LOGGER.error("파일 업로드 중 예외가 발생했습니다.", e);
	        response.put("error", "파일 업로드 중 예외가 발생했습니다.");
		}
		catch(DataAccessException e)
		{
	        LOGGER.error("DB 등록 중 예외가 발생했습니다.", e);
	        response.put("error", "DB 등록 중 예외가 발생했습니다.");
		}

		
		return response; // 파일업로드 혹은 DB등록 실패로 catch블록에서 에러가 생길시 응답메세지 송출
	}
	
	
	// [실제폴더] 파일 업로드
	@Transactional
	@Override
	public boolean uploadFiles(EntityType entityType,String fileIdentifier,int entityPK) {
		// 로컬변수설정
		boolean uploadSuccess = true;
		// temp파일 리스트 가져오기
		List<FileDTO> tempFileList = fileMapper.getAllTempFiles();
		
		try
		{
			for(FileDTO file : tempFileList)
			{	
				// fileIdentifier == memberIMG의 fileToken
				if(fileIdentifier.equals(file.getFileToken()))
				{
					// --------------- 필수 파라미터 생성 -------------- 
					String fileRoot = "C:\\file_repo\\";
					String folderName = setFolderName(entityType);
					Date fileRegdate = utilService.getNowDate();
					String fileStrRegdate = utilService.getFolderDate();
					String uuid = UUID.randomUUID().toString();
					String fileName = file.getFileName();
					String fileRealName = file.getFileRealName();
					String filePath = fileRoot +folderName+"\\" + fileStrRegdate + "\\";
					
					// --------------- 파일 업로드 로직 -------------- 
					// 폴더경로 재설정
					String sourceFilePath = file.getFilePath()+file.getFileName();
					String destinationFilePath = fileRoot +folderName+"\\" + fileStrRegdate + "\\"+fileName;			
					Path sourcePath = Path.of(sourceFilePath);
					Path destinationPath = Path.of(destinationFilePath);
					
					// 폴더생성
					File folderGenerator = new File(fileRoot + folderName + "\\" +  fileStrRegdate);
					String message = folderGenerator.exists() ? "폴더가 이미 존재합니다!" : (folderGenerator.mkdirs() ? "폴더가 생성되었습니다!" : "폴더 생성에 실패했습니다!");
					System.out.println(message);
					
					// ------------------- 파일 이동 ------------------
					// 파일 이름 특수 문자 인코팅 에러처리
					String encodedFileName = URLEncoder.encode(fileName, "UTF-8");				
					// 파일이동
					Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
					
					// ----------------- DB 등록 로직 ----------------- 
					
					// 파일 DB정보 수정		
					FileDTO fileDTO = new FileDTO();      
					fileDTO.setFilePath(filePath);
					fileDTO.setIsTemp(IsTemp.FALSE);
					fileDTO.setEntityType(entityType);
					fileDTO.setFileNo(file.getFileNo());
					fileDTO.setMemberNo(entityType.equals(EntityType.MEMBER) ? entityPK : 0);
					fileDTO.setPostNo(entityType.equals(EntityType.POSTING) ? entityPK : 0);
					fileDTO.setReplyNo(entityType.equals(EntityType.REPLY) ? entityPK : 0);
					
					boolean updateDBSuccess = fileMapper.updateFileInfoToDB(fileDTO);
					if(!updateDBSuccess) System.out.println("DB수정실패"); uploadSuccess = false;
				}
				// fileIdentifier == postingIMG의 fileName
				else if(fileIdentifier.equals(file.getFileName()))
				{
					// --------------- 필수 파라미터 생성 -------------- 
					String fileRoot = "C:\\file_repo\\";
					String folderName = setFolderName(entityType);
					Date fileRegdate = utilService.getNowDate();
					String fileStrRegdate = utilService.getFolderDate();
					String uuid = UUID.randomUUID().toString();
					String fileName = file.getFileName();
					String fileRealName = file.getFileRealName();
					String filePath = fileRoot +folderName+"\\" + fileStrRegdate + "\\";
					
					// --------------- 파일 업로드 로직 -------------- 
					// 폴더경로 재설정
					String sourceFilePath = file.getFilePath()+file.getFileName();
					String destinationFilePath = fileRoot +folderName+"\\" + fileStrRegdate + "\\"+fileName;			
					Path sourcePath = Path.of(sourceFilePath);
					Path destinationPath = Path.of(destinationFilePath);
					
					// 폴더생성
					File folderGenerator = new File(fileRoot + folderName + "\\" +  fileStrRegdate);
					String message = folderGenerator.exists() ? "폴더가 이미 존재합니다!" : (folderGenerator.mkdirs() ? "폴더가 생성되었습니다!" : "폴더 생성에 실패했습니다!");
					System.out.println(message);
					
					// ------------------- 파일 이동 ------------------
					// 파일 이름 특수 문자 인코팅 에러처리
					String encodedFileName = URLEncoder.encode(fileName, "UTF-8");				
					// 파일이동
					Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
					
					// ----------------- DB 등록 로직 ----------------- 
					
					// 파일 DB정보 수정		
					FileDTO fileDTO = new FileDTO();      
					fileDTO.setFilePath(filePath);
					fileDTO.setIsTemp(IsTemp.FALSE);
					fileDTO.setEntityType(entityType);
					fileDTO.setFileNo(file.getFileNo());
					fileDTO.setMemberNo(entityType.equals(EntityType.MEMBER) ? entityPK : 0);
					fileDTO.setPostNo(entityType.equals(EntityType.POSTING) ? entityPK : 0);
					fileDTO.setReplyNo(entityType.equals(EntityType.REPLY) ? entityPK : 0);
					
					boolean updateDBSuccess = fileMapper.updateFileInfoToDB(fileDTO);
					if(!updateDBSuccess) System.out.println("DB수정실패"); uploadSuccess = false;
				}

			}

		}
		catch(IOException e)
		{
	        LOGGER.error("파일 업로드 중 예외가 발생했습니다.", e);
		}
		catch(DataAccessException e)
		{
	        LOGGER.error("DB 등록 중 예외가 발생했습니다.", e);
		}
		

		
		return uploadSuccess;
	}
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	

	//===================================== 삭제 =====================================
	
	// [1개] 파일삭제
	@Override
	public boolean deleteFileByFileNo(int fileNo) {
		return fileMapper.deleteFileByFileNo(fileNo);
	}
	
	// [특정엔티티] 파일삭제  (entityType사용)
	@Override
	public boolean deleteFilesByEntityType(EntityType entityType) {
		return fileMapper.deleteFilesByEntityType(entityType);
	}
	
	
	// [특정엔티티] 파일삭제  (entityPK사용)
	@Override
	public boolean deleteFilesByEntityPK(int entityPK) {
		return fileMapper.deleteFilesByEntityPK(entityPK);
	}
	
	// [Temp] 파일삭제 (DB삭제)
	@Override
	public boolean deleteAllTempFilesFromDB() {
		return fileMapper.deleteAllTempFilesFromDB();
	}

	// [Temp] 파일삭제 (실제폴더)
	@Override
	public boolean deleteAllTempFiles() {

		List<FileDTO> tempFiles = fileMapper.getAllTempFiles();
		
		for(FileDTO file : tempFiles)
		{
            String filePath = file.getFilePath() + file.getFileName();
            File deleteFile = new File(filePath);

            if (deleteFile.exists())
            {
                try
                {
                    if (deleteFile.delete()){LOGGER.info("이미지 삭제 성공: {}", filePath);} 
                    else {LOGGER.error("이미지 삭제 실패: {}", filePath);}
                } 
                catch (SecurityException e)
                {LOGGER.error("이미지 삭제 중 예외 발생: {}", filePath, e);}
            } 
            else
            {LOGGER.warn("삭제할 이미지가 존재하지 않습니다: {}", filePath);}
		}
		
		
		return false;
	}
	
	// [업데이트] 파일삭제 (Temp파일)
	@Transactional // 게시글 수정할때 이미지를 수정하면 삭제전의 기존파일을 지움
	@Override 
	public boolean deleteUnmodifiedFiles(List<String> fileNames,int entityPK)
	{ 
		// 로컬변수 설정
	    boolean success = true;
	    
	    
	    // [특정엔티티] 파일조회 
	    List<FileDTO> existingFiles = fileMapper.getFilesByEntityPK(entityPK);
	    

	    // 삭제 대상 파일 식별을 위한 Set 생성
	    Set<String> fileNamesToDelete = new HashSet<>();
	    
	    // 기존 파일 목록 순회
	    for(FileDTO existingFile : existingFiles)
	    {
	        fileNamesToDelete.add(existingFile.getFileName());	// set에 모든 삭제대상 추가(일단 모든파일담기)
	    }
	    // 현재 업데이트한 파일 목록 순회하여 삭제 대상 파일 식별
	    for (String fileName : fileNames)
	    {
	        fileNamesToDelete.remove(fileName); // set의 삭제대상에서 이름이 같은파일 set에서 제거
	    }
	    // 삭제 대상 파일 목록 순회하여 삭제
	    for (FileDTO existingFile : existingFiles)
	    {
	    	if (fileNamesToDelete.contains(existingFile.getFileName())) // 기존파일에서 이름이 포함되는지 식별
	    	{
	            System.out.println("삭제할 파일: " + existingFile.getFileName());
	            // 파일 삭제
	            deleteFile(existingFile);
	            // DB 정보 삭제
	            deleteFileInfo(existingFile);
	    	}

	    }
	        

	    return success;
	}
	
	// 파일 삭제 로직 구현
	private boolean deleteFile(FileDTO file)
	{
	    try
	    {
	        Files.delete(Paths.get(file.getFilePath()));
	        return true;
	    }
	    catch (IOException e)
	    {
	        LOGGER.error("파일 삭제 중 예외가 발생했습니다.", e);
	        return false;
	    }
	}
	// DB 정보 삭제 로직 구현
	private void deleteFileInfo(FileDTO file)
	{
	    try
	    {
	    	fileMapper.deleteFileByFileNo(file.getFileNo());
	    }
	    catch (DataAccessException e)
	    {
	    	LOGGER.error("DB 삭제 중 예외가 발생했습니다.", e);
	    }
	}
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
	
	//===================================== 유틸 =====================================
	
	// [엔티티타입]	폴더이름 세팅
	@Override
	public String setFolderName(EntityType entityType) {
		String folderName= "";

		folderName = entityType.equals(EntityType.MEMBER) ?  "memberProfileIMG" :	// if
            		 entityType.equals(EntityType.POSTING) ? "postingIMG" :			// else if
                     entityType.equals(EntityType.REPLY) ?   "replyIMG" :			// else if
                             							     "temp";				// else
		
		return folderName;
	}
		
	// [엔티티타입]	이미지폴더 경로 세팅 세팅
	@Override
	public String setImagePath(String entityType, String date, String fileName) {
	    String imagePath = "";
	    String basePath = "C:\\file_repo\\";

	    // entityType가 MEMBER일때
	    if(entityType.equals("MEMBER"))
	    {
	        imagePath = basePath + "memberProfileIMG\\" + date + "\\" + fileName;	    	
	    }
	    // entityType가 POSTING일때
	    else if(entityType.equals("POSTING"))
	    {
	        imagePath = basePath + "postingIMG\\" + date + "\\" + fileName;	    	
	    }
	    // entityType가 REPLY일때
	    else if(entityType.equals("REPLY"))
	    {
	        imagePath = basePath + "replyIMG\\" + date + "\\" + fileName;
	    }
	    // entityType가 Temp거나 해당사항에 없을때
	    else
	    {	
	        basePath += "temp\\";
	        imagePath = basePath + date + "\\" + fileName;
	    }
		
		return imagePath;
	}

	// [회원프사] URL생성 및 가져오기
	@Override
	public String getMemberProfileImgUrlByMemberID(String memberID) {
		// 로컬변수선언
		String url = "";
		
		// memberID로 PK값 가져오기
		MemberDTO memberDTO = memberService.getMemberInfoBymemberID(memberID);
		int memberNo = memberDTO.getMemberNo();
		System.out.println("memberNo : "+memberNo);
		
		//memberNo로 파일정보 가져오기
		List<FileDTO> files =  fileMapper.getFilesByEntityPK(memberNo);
		
		//등록된 프사가 있다면 실행
		if(!files.isEmpty())
		{			
			for(FileDTO file : files)
			{	System.out.println("fileName : "+file.getFileName());
				Date date = file.getFileRegdate();
				String strDate = utilService.getStrDateFromDate(date);				
				String fileName = file.getFileName(); 				
				url = "redirect:/images/" + "MEMBER/" +  strDate+"/"+ fileName;
			}
		}
		
		//등록된 프사가 없다면 실행
		else
		{       
			url = "redirect:/images/" + "default-member-photo/" +  "9999-12-31"+"/"+ "defaul-profile.png"; // 프사 기본값 URL생성
		}

		return url;
	}
	
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	

	
}
