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
    
    
    private int postNo;
    private int memberNo;
   
	// 임시 저장용 캐시파일 체크
	public enum isTEMP{
        TRUE,
        FALSE
	} 
    
    
    //기본생성자
    public FileDTO(){}



    // 생성자
	public FileDTO(int fileNo, String fileName, String filePath, String fileRealName, int fileSize, String fileType,
			String fileExtension, String fileDescription, Date fileRegdate, isTEMP fileTemp, int postNo, int memberNo) {
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
		this.postNo = postNo;
		this.memberNo = memberNo;
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



	@Override
	public String toString() {
		return "FileDTO [fileNo=" + fileNo + ", fileName=" + fileName + ", filePath=" + filePath + ", fileRealName="
				+ fileRealName + ", fileSize=" + fileSize + ", fileType=" + fileType + ", fileExtension="
				+ fileExtension + ", fileDescription=" + fileDescription + ", fileRegdate=" + fileRegdate
				+ ", fileTemp=" + fileTemp + ", postNo=" + postNo + ", memberNo=" + memberNo + "]";
	};
    
    
    
	

}
