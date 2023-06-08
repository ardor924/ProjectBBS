document.addEventListener("DOMContentLoaded", function() {


  // 에러 메시지 출력 함수
  function displayErrorMessage(elementId, message) {
      var formAlert = document.getElementById(elementId);
      formAlert.textContent = message;
      formAlert.style.display = "block";
  }

  // 서버로부터 가져온 데이터와 일치 여부 확인
  if (resultMSG !== "null") {
      displayErrorMessage("login-fail-alert", "아이디 혹은 비밀번호가 일치하지 않습니다.");
  }




});