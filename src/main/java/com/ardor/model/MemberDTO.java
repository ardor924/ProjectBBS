package com.ardor.model;

import java.util.Date;

public class MemberDTO {
	
    private int memberNo;
    private String memberPhotoName;
    private String memberPhotoPath;
    private Date memberPhotoRegdate;
    
    private String memberID;
    private String memberPW;
    private String memberName;
    private Integer memberAge;
    private Date memberBirth;
    private String memberEmail;
    private String memberTel;

    
    private AgreementStatus memberPolicyAgreement;
    private AgreementStatus memberTermsAgreement;
    private AgreementStatus memberEventAgreement;
    
    private Date memberRegdate;
    private MemberGrant memberGrant;
    
    // 관리자권한부여  Enum
    public enum MemberGrant {
        ADMIN,
        USER
    }
    
    // 동의 상태 Enum
    public enum AgreementStatus {
        YES,
        NO
    }

    // 기본 생성자
     public MemberDTO() {}

	public MemberDTO(int memberNo, String memberPhotoName, String memberPhotoPath, Date memberPhotoRegdate,
			String memberID, String memberPW, String memberName, Integer memberAge, Date memberBirth,
			String memberEmail, String memberTel, AgreementStatus memberPolicyAgreement,
			AgreementStatus memberTermsAgreement, AgreementStatus memberEventAgreement, Date memberRegdate,
			MemberGrant memberGrant) {
		super();
		this.memberNo = memberNo;
		this.memberPhotoName = memberPhotoName;
		this.memberPhotoPath = memberPhotoPath;
		this.memberPhotoRegdate = memberPhotoRegdate;
		this.memberID = memberID;
		this.memberPW = memberPW;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.memberBirth = memberBirth;
		this.memberEmail = memberEmail;
		this.memberTel = memberTel;
		this.memberPolicyAgreement = memberPolicyAgreement;
		this.memberTermsAgreement = memberTermsAgreement;
		this.memberEventAgreement = memberEventAgreement;
		this.memberRegdate = memberRegdate;
		this.memberGrant = memberGrant;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberPhotoName() {
		return memberPhotoName;
	}

	public void setMemberPhotoName(String memberPhotoName) {
		this.memberPhotoName = memberPhotoName;
	}

	public String getMemberPhotoPath() {
		return memberPhotoPath;
	}

	public void setMemberPhotoPath(String memberPhotoPath) {
		this.memberPhotoPath = memberPhotoPath;
	}

	public Date getMemberPhotoRegdate() {
		return memberPhotoRegdate;
	}

	public void setMemberPhotoRegdate(Date memberPhotoRegdate) {
		this.memberPhotoRegdate = memberPhotoRegdate;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberPW() {
		return memberPW;
	}

	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(Integer memberAge) {
		this.memberAge = memberAge;
	}

	public Date getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public AgreementStatus getMemberPolicyAgreement() {
		return memberPolicyAgreement;
	}

	public void setMemberPolicyAgreement(AgreementStatus memberPolicyAgreement) {
		this.memberPolicyAgreement = memberPolicyAgreement;
	}

	public AgreementStatus getMemberTermsAgreement() {
		return memberTermsAgreement;
	}

	public void setMemberTermsAgreement(AgreementStatus memberTermsAgreement) {
		this.memberTermsAgreement = memberTermsAgreement;
	}

	public AgreementStatus getMemberEventAgreement() {
		return memberEventAgreement;
	}

	public void setMemberEventAgreement(AgreementStatus memberEventAgreement) {
		this.memberEventAgreement = memberEventAgreement;
	}

	public Date getMemberRegdate() {
		return memberRegdate;
	}

	public void setMemberRegdate(Date memberRegdate) {
		this.memberRegdate = memberRegdate;
	}

	public MemberGrant getMemberGrant() {
		return memberGrant;
	}

	public void setMemberGrant(MemberGrant memberGrant) {
		this.memberGrant = memberGrant;
	}




}
