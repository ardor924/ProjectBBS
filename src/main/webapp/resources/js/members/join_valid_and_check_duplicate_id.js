//===========================================================아이디 중복체크===============================================================//
//-----------------------------------------------------------------------------------------------------------------------------------------//

// 아이디중복체크 완료 변수
var isDuplicateChecked = false;

// 중복 검사 버튼 클릭 이벤트 핸들러
const checkButton = document.getElementById('check-duplicate-button');
checkButton.addEventListener('click', checkDuplicateID);


// 아이디 중복검사
async function checkDuplicateID(){
	
	// memberID input에서 값을 가져옴
  	const memberIDInput = document.getElementById('memberID');
  	const memberIDValue = memberIDInput.value;	

	// 아이디 중복체크를 위한 정규식 유효성검사
	const memberIDRegex = /^[a-zA-Z0-9]{4,20}$/;
	
	// input값에 입력한 아이디 유효성검사
	if(!memberIDRegex.test(memberIDValue)){ // 입력값이 (영문숫자 4~20자가 아닐때 리턴)
		alert("아이디는 영문과 숫자로 이루어진 4~20자여야 합니다.");
		return;
	// 아이디 유효성검사 통과후 서버에 데이터 전송	
	}else{
		
		try {
			// 컨트롤러에 memberID 비동기로 값을 보내기
			const response = await axios.post(window.ctx+'/member/join/checkID', { memberID: memberIDValue }); // 서버로 전송되는 데이터 객체
		
			// 응답을 받아와서 중복인경우 로직실행
			const isDuplicate = response.data.isDuplicate; // 중복여부
			const statusMessage = response.data.statusMessage; // 중복일때 메세지
	
			// 아이디중복 확인용 콘솔
			console.log("isDuplicate : "+isDuplicate)

		
		
			// 아이디가 중복이라는 응답을 받았을때 조건문 실행
			if (isDuplicate == "true"){
				alert(statusMessage)
				return; // 아이디가 중복인경우 리턴
				
			// 아이디가 중복이 아니라는 응답을 받았다면 아이디중복체크 완료 변수에 true값 할당	
			}else{
				alert(statusMessage)
				isDuplicateChecked = true;
				
			}
		
		// try문에서 에러발생시 처리할것들		
		}catch(error){
			console.error(error);
			alert('중복 검사 요청에 실패했습니다. 다시 시도해주세요.');	
		}finally{
			// 아이디 중복체크가 완료여부 콘솔 확인용 
			console.log("isDuplicateChecked : "+isDuplicateChecked)
		}

		}; // ./else문 : END
	
	
}; // ./checkDuplicateID() 함수 :END

//-----------------------------------------------------------------------------------------------------------------------------------------//
//===========================================================아이디 중복체크===============================================================//




//===========================================================유효성검사=================================================================//
//-----------------------------------------------------------------------------------------------------------------------------------------//



// 폼 제출 이벤트 핸들러 등록
document.querySelector(".join-form").addEventListener("submit", function(event) {

	// 각 입력 필드의 값 가져오기
    var memberID = document.getElementById("memberID").value;
    var memberPW = document.getElementById("memberPW").value;
    var memberPWConfirm = document.getElementById("memberPW_Confirm").value;
    var memberName = document.getElementById("memberName").value;
    var memberEmail1 = document.getElementById("memberEmail_1").value;
    var memberEmail2 = document.getElementById("memberEmail_2").value;
    var memberPolicyAgree = document.getElementById("policy-agree").checked;
    var memberTermsAgree = document.getElementById("terms-agree").checked;
	
	// 유효성 검사 및 에러 메시지 출력
    var memberIDRegex = /^[a-zA-Z0-9]{4,20}$/;
    var memberPWRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*+=\-`~?])[a-zA-Z\d!@#$%^&*+=\-`~?]{8,20}$/
    var memberNameErrorMessage = "이름은 최소 2자 이상 입력해야 합니다.";
    var memberEmail1Regex = /^[a-zA-Z0-9._%+-]+$/;
    var memberEmail2Regex = /^[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    var memberPolicyAgreeErrorMessage = "개인정보 처리 방침에 동의해야 합니다.";
    var memberTermsAgreeErrorMessage = "ProjectBBS 이용약관에 동의해야 합니다.";
	
	// 에러 메시지 출력 함수
	function displayErrorMessage(elementId, message) {
  	var formAlert = document.getElementById(elementId);
  	formAlert.textContent = message;
  	formAlert.style.display = "inline-block";
	formAlert.focus();
	}


	// 유효성 검사 실패 시 해당 input에 포커스를 주는 함수
	function setFocusOnInput(inputElementId) {
  	var inputElement = document.getElementById(inputElementId);
  	if (inputElement) {
    	inputElement.focus(); // input에 포커스

		// 포커스할때 CSS에 보더스타일 추가
    	inputElement.classList.add("highlight-border"); 

    	// 2초 후에 CSS에서 보더 스타일 제거
    	setTimeout(function () {
      		inputElement.classList.remove("highlight-border");
    	}, 2000); 

  		}
	}
	
	// -----------유효성검사 실행---------------------//

    // 1 memberID: 영문/숫자 4~20자
    if (!memberIDRegex.test(memberID)) {
      displayErrorMessage("memberID-alert", "아이디는 영문과 숫자로 이루어진 4~20자여야 합니다.");
	  setFocusOnInput("memberID") // 해당 input요소에 포커스
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
	
    // 2. memberPW: 영문/숫자/특수문자 포함 8~20자
    if (!memberPWRegex.test(memberPW)) {
      displayErrorMessage("memberPW-alert", "비밀번호는 영문, 숫자, 특수문자를 포함한 8~20자여야 합니다.");
	  setFocusOnInput("memberPW") // 해당 input요소에 포커스
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
  
    // 3. memberPWConfirm: mPW와 동일한지 확인
    if (memberPW !== memberPWConfirm) {
      displayErrorMessage("memberPW_Confirm-alert", "비밀번호가 일치하지 않습니다.");
	  setFocusOnInput("memberPWConfirm") // 해당 input요소에 포커스
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
  
    // 4. memberName: 최소 2자 이상
    if (memberName.length < 2) {
      displayErrorMessage("memberName-alert", memberNameErrorMessage);
	  setFocusOnInput("memberName") // 해당 input요소에 포커스
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
	
    // 5-1. memberEmail1 : @ 이전의 이메일 정규식 사용
    if (!memberEmail1Regex.test(memberEmail1)) {
      displayErrorMessage("memberEmail_1-alert", "올바른 이메일 형식이 아닙니다.");
	  setFocusOnInput("memberEmail_1") // 해당 input요소에 포커스
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
    
    // 5-2. memberEmail2 : @ 이후의 이메일 정규식 사용
    if (!memberEmail2Regex.test(memberEmail2)) {
      displayErrorMessage("memberEmail_1-alert", "올바른 이메일 형식이 아닙니다.");
	  setFocusOnInput("memberEmail_2") // 해당 input요소에 포커스
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
    
    // 6-1. memberPolicy-agree: 반드시 체크해야 함
    if (!memberPolicyAgree) {
      displayErrorMessage("policy-agree-alert", memberPolicyAgreeErrorMessage);
	  setFocusOnInput("policy-agree") // 해당 input요소에 포커스
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
    
    // 6-2. memberTerms-agree: 반드시 체크해야 함
    if (!memberTermsAgree) {
      displayErrorMessage("terms-agree-alert", memberTermsAgreeErrorMessage);
	  setFocusOnInput("terms-agree") // 해당 input요소에 포커스
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
	
    // 7. 아이디 중복 검사 버튼이 클릭되지 않은 경우
    if (window.isDuplicateChecked == false) {
      displayErrorMessage("memberID-alert", "아이디 중복 검사가 필요합니다.");
	  setFocusOnInput("memberID") // 해당 input요소에 포커스
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
    
	
	
    // 모든 조건을 만족하는 경우 회원가입 폼 제출
    document.querySelector(".join-form").submit();



	
});
	
	



//-----------------------------------------------------------------------------------------------------------------------------------------//
//===========================================================유효성검사==================================================================/
