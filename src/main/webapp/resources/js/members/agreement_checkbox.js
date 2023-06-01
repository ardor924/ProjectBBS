// 동의 체크박스 상태 변경 시 동작

function handleAgreementCheckbox(checkboxId, inputId) {
    var checkbox = document.getElementById(checkboxId);
    var input = document.getElementById(inputId);
    if (checkbox.checked) {
        input.value = "YES";  // 체크된 경우 "YES"로 설정
    } else {
        input.value = "NO";   // 체크가 해제된 경우 "NO"로 설정
    }

}
