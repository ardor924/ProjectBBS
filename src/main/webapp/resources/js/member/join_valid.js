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
    var memberIDRegex = /^[a-zA-Z0-9]{5,20}$/;
    var memberPWRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*+=\-`~?])[a-zA-Z\d!@#$%^&*+=\-`~?]{8,20}$/
    var memberNameErrorMessage = "이름은 최소 3자 이상 입력해야 합니다.";
    var memberEmail1Regex = /^[a-zA-Z0-9._%+-]+$/;
    var memberEmail2Regex = /^[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    var memberPolicyAgreeErrorMessage = "개인정보 처리 방침에 동의해야 합니다.";
    var memberTermsAgreeErrorMessage = "ProjectBBS 이용약관에 동의해야 합니다.";
  
    // 에러 메시지 출력 함수
    function displayErrorMessage(elementId, message) {
      var formAlert = document.getElementById(elementId);
      formAlert.textContent = message;
      formAlert.style.display = "inline-block";
    }
  
  
    // 1. memberID: 영문/숫자 5~20자
    if (!memberIDRegex.test(memberID)) {
      displayErrorMessage("memberID-alert", "아이디는 영문과 숫자로 이루어진 5~20자여야 합니다.");
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
  
    // 2. memberPW: 영문/숫자/특수문자 포함 8~20자
    if (!memberPWRegex.test(memberPW)) {
      displayErrorMessage("memberPW-alert", "비밀번호는 영문, 숫자, 특수문자를 포함한 8~20자여야 합니다.");
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
  
    // 3. memberPWConfirm: mPW와 동일한지 확인
    if (memberPW !== memberPWConfirm) {
      displayErrorMessage("memberPW_Confirm-alert", "비밀번호가 일치하지 않습니다.");
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }
  
    // 4. memberName: 최소 3자 이상
    if (memberName.length < 3) {
      displayErrorMessage("memberName-alert", memberNameErrorMessage);
      event.preventDefault(); // 폼 제출 기본 동작 막기
      return;
    }

    // 5-1. memberEmail1 : @ 이전의 이메일 정규식 사용
    if (!memberEmail1Regex.test(memberEmail1)) {
    displayErrorMessage("memberEmail_1-alert", "올바른 이메일 형식이 아닙니다.");
    event.preventDefault(); // 폼 제출 기본 동작 막기
    return;
    }
    
    // 5-2. memberEmail2 : @ 이후의 이메일 정규식 사용
    if (!memberEmail2Regex.test(memberEmail2)) {
    displayErrorMessage("memberEmail_1-alert", "올바른 이메일 형식이 아닙니다.");
    event.preventDefault(); // 폼 제출 기본 동작 막기
    return;
    }
    
    // 6-1. memberPolicy-agree: 반드시 체크해야 함
    if (!memberPolicyAgree) {
    displayErrorMessage("policy-agree-alert", memberPolicyAgreeErrorMessage);
    event.preventDefault(); // 폼 제출 기본 동작 막기
    return;
    }
    
    // 6-2. memberTerms-agree: 반드시 체크해야 함
    if (!memberTermsAgree) {
    displayErrorMessage("terms-agree-alert", memberTermsAgreeErrorMessage);
    event.preventDefault(); // 폼 제출 기본 동작 막기
    return;
    }
    


    // 모든 조건을 만족하는 경우 회원가입 폼 제출
    document.querySelector(".join-form").submit();
});