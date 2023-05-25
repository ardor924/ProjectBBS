package com.ardor.model;

import java.util.Date;

public class MemberDTO {
	
    private int memberNo;
    private String memberPhotoName;
    private String memberPhotoURL;
    private String memberID;
    private String memberPW;
    private String memberName;
    private int memberAge;
    private Date memberBirth;
    private String memberEmail;
    private String memberTel;
    private String memberPolicyAgreement;
    private String memberTermsAgreement;
    private String memberEventAgreement;
    private Date memberRegdate;
    private String memberGrant;

    // 기본 생성자
    public MemberDTO(){};

    // 생성자
	public MemberDTO(int memberNo, String memberPhotoName, String memberPhotoURL, String memberID, String memberPW,
			String memberName, int memberAge, Date memberBirth, String memberEmail, String memberTel,
			String memberPolicyAgreement, String memberTermsAgreement, String memberEventAgreement, Date memberRegdate,
			String memberGrant) {
		super();
		this.memberNo = memberNo;
		this.memberPhotoName = memberPhotoName;
		this.memberPhotoURL = memberPhotoURL;
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

	// 게터세터
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

	public String getMemberPhotoURL() {
		return memberPhotoURL;
	}

	public void setMemberPhotoURL(String memberPhotoURL) {
		this.memberPhotoURL = memberPhotoURL;
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

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
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

	public String getMemberPolicyAgreement() {
		return memberPolicyAgreement;
	}

	public void setMemberPolicyAgreement(String memberPolicyAgreement) {
		this.memberPolicyAgreement = memberPolicyAgreement;
	}

	public String getMemberTermsAgreement() {
		return memberTermsAgreement;
	}

	public void setMemberTermsAgreement(String memberTermsAgreement) {
		this.memberTermsAgreement = memberTermsAgreement;
	}

	public String getMemberEventAgreement() {
		return memberEventAgreement;
	}

	public void setMemberEventAgreement(String memberEventAgreement) {
		this.memberEventAgreement = memberEventAgreement;
	}

	public Date getMemberRegdate() {
		return memberRegdate;
	}

	public void setMemberRegdate(Date memberRegdate) {
		this.memberRegdate = memberRegdate;
	}

	public String getMemberGrant() {
		return memberGrant;
	}

	public void setMemberGrant(String memberGrant) {
		this.memberGrant = memberGrant;
	}

	
	// 디버그용 toString
	@Override
	public String toString() {
		return "MemberDTO [memberNo=" + memberNo + ", memberPhotoName=" + memberPhotoName + ", memberPhotoURL="
				+ memberPhotoURL + ", memberID=" + memberID + ", memberPW=" + memberPW + ", memberName=" + memberName
				+ ", memberAge=" + memberAge + ", memberBirth=" + memberBirth + ", memberEmail=" + memberEmail
				+ ", memberTel=" + memberTel + ", memberPolicyAgreement=" + memberPolicyAgreement
				+ ", memberTermsAgreement=" + memberTermsAgreement + ", memberEventAgreement=" + memberEventAgreement
				+ ", memberRegdate=" + memberRegdate + ", memberGrant=" + memberGrant + "]";
	};
    


	
	

    

}
