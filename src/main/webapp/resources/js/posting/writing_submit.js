// 제출버튼 생성
const submitButton = document.getElementById('writingSubmitBtn');

submitButton.addEventListener('click', function(event) {
    event.preventDefault(); // 폼 제출 방지

    /* 유효성 검사 */

    var bbsName = document.getElementById('bbsNameSelect').value; // 게시판 선택 값 가져오기
    var postTitle = document.editForm.elements.postTitle.value; // 제목 값 가져오기

    /* 게시판이름 없을시 리턴 */
    if (bbsName == "" || bbsName == "null") {
        alert("게시판을 선택하세요");
        return;
    }
    /* 게시글 제목 없을시 리턴 */
    if (postTitle == "" || postTitle == "null") {
        alert("제목을 입력하세요");
        document.editForm.elements.postTitle.focus();
        return;
    }

    document.editForm.submit();
});