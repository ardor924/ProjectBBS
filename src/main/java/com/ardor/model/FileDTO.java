package com.ardor.model;

import java.util.Date;

public class FileDTO {
	
	
    private int fileNo;
    
    private String fileName;
    private String filePath;
    private String fileRealName;
    
    private int fileSize;
    private String fileType;
    private String fileExtension;
    private String fileDescription;
    
    private Date fileRegdate;
    
    
    private isTEMP fileTemp;
    
    private folderRef folderRef;
    private String fileToken;
    
    
    private int postNo;
    private int memberNo;
    private int replyNo;
   
	// 임시 저장용 캐시파일 체크
	public enum isTEMP{
        TRUE,
        FALSE
	} 
	
	// 참조폴더
	public enum folderRef{
		TEMP,
		MEMBER,
		POSTING,
		REPLY
	}
    
    
    //기본생성자
    public FileDTO(){}


    // 생성자
	public FileDTO(int fileNo, String fileName, String filePath, String fileRealName, int fileSize, String fileType,
			String fileExtension, String fileDescription, Date fileRegdate, isTEMP fileTemp,
			com.ardor.model.FileDTO.folderRef folderRef, String fileToken, int postNo, int memberNo, int replyNo) {
		super();
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileRealName = fileRealName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.fileExtension = fileExtension;
		this.fileDescription = fileDescription;
		this.fileRegdate = fileRegdate;
		this.fileTemp = fileTemp;
		this.folderRef = folderRef;
		this.fileToken = fileToken;
		this.postNo = postNo;
		this.memberNo = memberNo;
		this.replyNo = replyNo;
	}


	public int getFileNo() {
		return fileNo;
	}


	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getFileRealName() {
		return fileRealName;
	}


	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}


	public int getFileSize() {
		return fileSize;
	}


	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public String getFileExtension() {
		return fileExtension;
	}


	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}


	public String getFileDescription() {
		return fileDescription;
	}


	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}


	public Date getFileRegdate() {
		return fileRegdate;
	}


	public void setFileRegdate(Date fileRegdate) {
		this.fileRegdate = fileRegdate;
	}


	public isTEMP getFileTemp() {
		return fileTemp;
	}


	public void setFileTemp(isTEMP fileTemp) {
		this.fileTemp = fileTemp;
	}


	public folderRef getFolderRef() {
		return folderRef;
	}


	public void setFolderRef(folderRef folderRef) {
		this.folderRef = folderRef;
	}


	public String getFileToken() {
		return fileToken;
	}


	public void setFileToken(String fileToken) {
		this.fileToken = fileToken;
	}


	public int getPostNo() {
		return postNo;
	}


	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	



}
