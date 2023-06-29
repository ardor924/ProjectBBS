package com.ardor.model;

import java.util.Date;

public class FileDTO {
	
	
    private int fileNo;
    
    private String fileName;
    private String filePath;
    private String fileRealName;
    
    private int fileSize;
    private String fileExtension;
    private String fileDescription;
    private String mediaType;
    
    private Date fileRegdate;
    
    
    private IsTemp isTemp;
    private EntityType entityType;
    private String fileToken;
    
    
    private int memberNo;
    private int postNo;
    private int replyNo;
   
	// 임시 저장용 캐시파일 체크
	public enum IsTemp{
        TRUE,
        FALSE
	} 
	
	// 참조폴더
	public enum EntityType{
		TEMP,
		MEMBER,
		POSTING,
		REPLY
	}
    
    
    //기본생성자
    public FileDTO(){}


    // 인자생성자
	public FileDTO(int fileNo, String fileName, String filePath, String fileRealName, int fileSize,
			String fileExtension, String fileDescription, String mediaType, Date fileRegdate, IsTemp isTemp,
			EntityType entityType, String fileToken, int memberNo, int postNo, int replyNo) {
		super();
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileRealName = fileRealName;
		this.fileSize = fileSize;
		this.fileExtension = fileExtension;
		this.fileDescription = fileDescription;
		this.mediaType = mediaType;
		this.fileRegdate = fileRegdate;
		this.isTemp = isTemp;
		this.entityType = entityType;
		this.fileToken = fileToken;
		this.memberNo = memberNo;
		this.postNo = postNo;
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


	public String getMediaType() {
		return mediaType;
	}


	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}


	public Date getFileRegdate() {
		return fileRegdate;
	}


	public void setFileRegdate(Date fileRegdate) {
		this.fileRegdate = fileRegdate;
	}


	public IsTemp getIsTemp() {
		return isTemp;
	}


	public void setIsTemp(IsTemp isTemp) {
		this.isTemp = isTemp;
	}


	public EntityType getEntityType() {
		return entityType;
	}


	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}


	public String getFileToken() {
		return fileToken;
	}


	public void setFileToken(String fileToken) {
		this.fileToken = fileToken;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public int getPostNo() {
		return postNo;
	}


	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	@Override
	public String toString() {
		return "FileDTO [fileNo=" + fileNo + ", fileName=" + fileName + ", filePath=" + filePath + ", fileRealName="
				+ fileRealName + ", fileSize=" + fileSize + ", fileExtension=" + fileExtension + ", fileDescription="
				+ fileDescription + ", mediaType=" + mediaType + ", fileRegdate=" + fileRegdate + ", isTemp=" + isTemp
				+ ", entityType=" + entityType + ", fileToken=" + fileToken + ", memberNo=" + memberNo + ", postNo="
				+ postNo + ", replyNo=" + replyNo + "]";
	}


    
}