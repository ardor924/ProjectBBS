// 폼 제출 이벤트 핸들러 등록
document.querySelector(".category-form").addEventListener("submit", function(event) {
  event.preventDefault(); // 폼 제출 기본 동작 막기

  // 각 입력 필드의 값 가져오기
  var catCode = document.getElementById("catCode").value;
  var catName = document.getElementById("catName").value;

  // 에러 메시지 출력 함수
  function displayErrorMessage(elementId, message) {
      var formAlert = document.getElementById(elementId);
      formAlert.textContent = message;
      formAlert.style.display = "block";
	  formAlert.focus();
  }




/*-*------------------------------------------------ */


  // 유효성 검사 및 에러 메시지 출력
  if (catCode.trim() === "") {
      displayErrorMessage("catCode-alert", "카테고리코드를 입력하세요.");
      return;
  }

  if (catName.trim() === "") {
      displayErrorMessage("catName-alert", "카테고리명을 입력하세요.");
      return;
  }


  // 유효성 검사 통과 및 서버 데이터 일치 시 카테고리폼 제출
  document.querySelector(".category-form").submit();
});




