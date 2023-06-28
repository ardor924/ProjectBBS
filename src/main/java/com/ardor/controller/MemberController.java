package com.ardor.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.ardor.mapper.MemberMapper;
import com.ardor.model.FileDTO;
import com.ardor.model.FileDTO.folderRef;
import com.ardor.model.FileDTO.isTEMP;
import com.ardor.model.MemberDTO;
import com.ardor.model.MemberDTO.AgreementStatus;
import com.ardor.model.MemberDTO.MemberGrant;
import com.ardor.service.FileService;
import com.ardor.service.MemberService;
import com.ardor.service.UtilityService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	UtilityService utilService;
	@Autowired
	FileService fileService;
	@Autowired
	private PasswordEncoder passwordEncoder;




	// 회원가입 페이지 이동
	@GetMapping("/members/join")
	public String joinPage(MemberDTO memberDTO) {
		return "members/join_page";
	}

	
	// 회원가입(DB에정보등록)
	@PostMapping("/members/join/submit")
	public String joinSubmit(					
		MemberDTO memberDTO,
		@RequestParam(value = "photoType", defaultValue = "memberProfileIMG") String photoType, 
		@RequestParam("fileToken") String fileToken, 
		@RequestParam("memberID") String memberID, 
		@RequestParam("memberBirthYear") String memberBirthYear, 
		@RequestParam("memberBirthMonth") String memberBirthMonth,
		@RequestParam("memberBirthDay") String memberBirthDay,
		@RequestParam("memberEmail_1") String memberEmail_1,
		@RequestParam("memberEmail_2") String memberEmail_2,
		@RequestParam("memberTel_1") String memberTel_1,
		@RequestParam("memberTel_2") String memberTel_2,
		@RequestParam("memberTel_3") String memberTel_3
	)
	{
		System.out.println("fileToken :"+fileToken);
		
		// 스프링 시큐리티 비밀번호 암호화
	    String password = memberDTO.getMemberPW();
	    String encryptedPassword = passwordEncoder.encode(password);
	    memberDTO.setMemberPW(encryptedPassword);
		
		// 중복아이디가 입력되었는지 처리
		Map<String, Object> requestMemberData = utilService.parseStringToObject(memberID);
	    boolean isDuplicate = memberService.checkDuplicateID(requestMemberData);
	    if(isDuplicate ) return "redirect:/member/join/page?error=duplicate";
		
		// 파라미터 생성 및 조합
		
		// 파라미터조합 및 회원나이 추가
		Date memberBirth = utilService.mergeBirth(memberBirthYear, memberBirthMonth, memberBirthDay);
		Integer memberAge = utilService.calculateAgeFromBirth(memberBirth);
		String memberEmail = utilService.mergeEmails(memberEmail_1, memberEmail_2);		
		String memberTel = utilService.mergeTelephones(memberTel_1, memberTel_2, memberTel_3);
		
		// 정책및 이용약관 Enum값 처리
 		AgreementStatus memberPolicyAgreement = utilService.convertToAgreementStatus(memberDTO.getMemberPolicyAgreement().toString());
 		AgreementStatus memberTermsAgreement = utilService.convertToAgreementStatus(memberDTO.getMemberTermsAgreement().toString());
 		AgreementStatus memberEventAgreement = utilService.convertToAgreementStatus(memberDTO.getMemberEventAgreement().toString());
		
		// 선택사항 파라미터 미입력시 처리	
 		
		// 회원등록일 생성
		Date memberRegdate = utilService.getNowDate();
		
		// 관리자 권한부여 설정
		MemberGrant memberGrant = utilService.setAdminPermission();
		
		
		// DTO에 파라미터 세팅
		memberDTO.setMemberBirth(memberBirth);
		memberDTO.setMemberAge(memberAge);
		memberDTO.setMemberEmail(memberEmail);
		memberDTO.setMemberTel(memberTel);
 		memberDTO.setMemberPolicyAgreement(memberPolicyAgreement);
 		memberDTO.setMemberTermsAgreement(memberTermsAgreement);
 		memberDTO.setMemberEventAgreement(memberEventAgreement);
		memberDTO.setMemberRegdate(memberRegdate);
		memberDTO.setMemberGrant(memberGrant);
		
		

		// 디버깅용 memberParam 출력
		utilService.showMemberParams(memberDTO);
		
		// DB에 회원정보 저장
		memberService.joinMembers(memberDTO);
		
		// 프사를 file테이블에 저장
		// 회원아이디로 memberNo PK값 가져오기
		memberDTO = memberService.getMemberInfoBymemberID(memberID);
		int memberNo = memberDTO.getMemberNo();
		boolean imgUploadsucces = fileService.uploadFiles(photoType,fileToken, memberNo);
		// 이미지 업로드 성공시 temp폴더 내 파일 이동후 temp파일삭제
		if(imgUploadsucces)
		{
			fileService.uploadFiles(photoType, fileToken, memberNo);
		};

		isTEMP fileTemp = isTEMP.TRUE;
		fileService.deleteTempFileFromDB(fileTemp); // DB에서 삭제
		// 잔류 temp파일 삭제
		fileService.deleteAllTempFiles();

		
		return "members/login_page";
	}


	
	// 로그인 페이지 이동
	@GetMapping("/members/login")
	public String loginPage() {
		return "members/login_page";
	}

	
	// 로그인(DB조회)
	@PostMapping("/members/login/submit")
	public String loginSubmit(HttpSession session, HttpServletRequest request, MemberDTO memberDTO) {
		
		


		
		// 입력된정보를 DB와 대조 
		MemberDTO activeMember = memberService.getMemberInfoBymemberID(memberDTO.getMemberID());
				
		// 로그인 성공 
		//회원이 입력한 비밀번호와 DB에 저장된 암호화된 비밀번호를 대조 matches(~~)
	    if (activeMember != null && passwordEncoder.matches(memberDTO.getMemberPW(), activeMember.getMemberPW())) {
	    	
	    	
			//필수 회원정보를 session에 담아서 처리
			session.setAttribute("memberID", activeMember.getMemberID());
			session.setAttribute("memberPW", activeMember.getMemberPW());
			session.setAttribute("memberName", activeMember.getMemberName());
			session.setAttribute("memberRegdate", activeMember.getMemberRegdate());
			
			// 회원 권한식별 (조건문 삼항연산자처리)
			session.setAttribute("memberGrant", (activeMember.getMemberGrant() == MemberGrant.ADMIN) ? "ADMIN" : "USER");
		
			// 로그인 상태 session 처리
			session.setAttribute("isLogin", "YES");
	
			// 로그인 결과 메세지
			request.setAttribute("resultMSG", "로그인에 성공했습니다");	
			
			return "redirect:/";
			
			
		// 로그인 실패 
		}else {
			// 로그인 결과 메세지
			session.setAttribute("isLogin", "NO");
			request.setAttribute("resultMSG", "로그인에 실패했습니다");	
			return "/members/login_page";
		}
			
		
	}
	
	
	
	// 내정보보기 페이지 이동
	@GetMapping("/members/myinfo")
	public String myinfoPage(@SessionAttribute("memberID") String memberID,Model model) {
		MemberDTO memberDTO = memberService.getMemberInfoBymemberID(memberID);	
				
		model.addAttribute("memberDTO", memberDTO);	
		
		return "members/myinfo_page";
	}
	
	
	
	
	
	
	
	
	
	
	
	// 아이디 중복검사
	@PostMapping("/members/join/checkID")
	public ResponseEntity<Object> checkDuplicateID(@RequestBody Map<String, Object> requestData){
		Map<String, Object> responese = new HashMap<>();		



		
	    // 중복아이디인지 확인 중복이면 true 중복이 아니면 false 반환
	    boolean isDuplicate = memberService.checkDuplicateID(requestData);
	    
	    
	    // 아이디가 중복인경우
	    if(isDuplicate) {	    	
			String statusMessage = "중복된 아이디입니다. 다른 아이디를 입력해주세요.";
			responese.put("isDuplicate", "true");
			responese.put("statusMessage", statusMessage);
			return ResponseEntity.ok(responese);
	    	
	    // 중복에 해당 없는경우	
	    }else {
	    	String statusMessage = "사용 가능한 아이디입니다";
	    	responese.put("isDuplicate", "false");
			responese.put("statusMessage", statusMessage);
			return ResponseEntity.ok(responese);
	    }
	    
	}
	

	
	// 로그아웃
	@RequestMapping("/members/logout")
	public String memberLogout(HttpSession session,HttpServletRequest request) {
		
		session.removeAttribute("memberID");
		session.removeAttribute("memberPW");
		session.removeAttribute("memberName");
		session.removeAttribute("memberRegdate");
		
		session.removeAttribute("isLogin");
		
		session.removeAttribute("memberGrant");
		
		request.setAttribute("resultMsg","정상적으로 로그아웃처리 되었습니다.");
		
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 테스트 페이지
	@GetMapping("/TEST/page")
	public String joinTestPage() {
		return "joinTEST";
	}

	// 테스트 폼 제출
	@PostMapping("/TEST/submit")
	public String joinTestSubmit(MemberDTO memberDTO ,  @RequestParam("memberBirthYear") String memberBirthYear, 
														@RequestParam("memberBirthMonth") String memberBirthMonth,
														@RequestParam("memberBirthDay") String memberBirthDay
	) {
		
		// 파라미터 가져오기		
		String memberID = memberDTO.getMemberID();
		String memberPW = memberDTO.getMemberPW();
		String memberName = memberDTO.getMemberName();
		int memberAge = memberDTO.getMemberAge();

		String memberBirthStr = memberBirthYear + memberBirthMonth + memberBirthDay;
		Date memberBirth = utilService.stringToDate(memberBirthStr);
		String memberEmail = memberDTO.getMemberEmail();
		String memberTel = memberDTO.getMemberTel();
		
		AgreementStatus memberPolicyAgreement = memberDTO.getMemberPolicyAgreement();
		AgreementStatus memberTermsAgreement = memberDTO.getMemberTermsAgreement();
		AgreementStatus memberEventAgreement = memberDTO.getMemberEventAgreement();
		
		Date memberRegdate = utilService.getNowDate();
		
		MemberGrant memberGrant = utilService.setAdminPermission();
		
		System.out.println("------------------------디버깅용-------------------------------");
		
		System.out.println("아이디 : "+memberID);
		System.out.println("비번 : "+memberPW);
		System.out.println("이름 : "+memberName);
		System.out.println("나이 : "+memberAge);
		System.out.println("이메일 : "+memberEmail);
		System.out.println("생일 : " + memberBirth); 
		System.out.println("휴대전화 : "+memberTel);
		
		System.out.println("개인정보동의 : "+ memberPolicyAgreement);
		System.out.println("이용약관동의 : "+ memberTermsAgreement);
		System.out.println("이벤트수신동의 : "+ memberEventAgreement);
		
		System.out.println("가입일 : "+memberRegdate);
		
		System.out.println("관리자권한 : "+memberGrant);
		System.out.println("------------------------디버깅용-------------------------------");
		
		
		System.out.println("회원가입 등록 컨트롤러 진입!!!!!!!");
		
		
		// 파라미터 DTO에 세팅		
		memberDTO.setMemberBirth(memberBirth);
		memberDTO.setMemberRegdate(memberRegdate);
		memberDTO.setMemberGrant(memberGrant);
		int success = memberService.joinMembers(memberDTO); 
		
		if(success != 0) {
			System.out.println("DB등록성공");
		}

		return "test";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
