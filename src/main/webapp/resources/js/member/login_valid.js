// 폼 제출 이벤트 핸들러 등록
document.querySelector(".login-form").addEventListener("submit", function(event) {
  event.preventDefault(); // 폼 제출 기본 동작 막기

  // 각 입력 필드의 값 가져오기
  var memberID = document.getElementById("memberID").value;
  var memberPW = document.getElementById("memberPW").value;

  // 에러 메시지 출력 함수
  function displayErrorMessage(elementId, message) {
      var formAlert = document.getElementById(elementId);
      formAlert.textContent = message;
      formAlert.style.display = "block";
  }
/*-*------------------------------------------------ */
// 서버로부터 가져온 mID, mPW 데이터 (가정)
var serverID = "admin";
var serverPW = "123456";
/*-*------------------------------------------------ */

  // 유효성 검사 및 에러 메시지 출력
  if (memberID.trim() === "") {
      displayErrorMessage("memberID-alert", "아이디를 입력하세요.");
      return;
  }

  if (memberPW.trim() === "") {
      displayErrorMessage("memberPW-alert", "비밀번호를 입력하세요.");
      return;
  }

  // 서버로부터 가져온 데이터와 일치 여부 확인
  if (memberID !== serverID || memberPW !== serverPW) {
      displayErrorMessage("login-fail-alert", "아이디 혹은 비밀번호가 일치하지 않습니다.");
  return;
  }

  // 유효성 검사 통과 및 서버 데이터 일치 시 로그인 폼 제출
  document.querySelector(".login-form").submit();
});