// 제출버튼 생성
const submitButton = document.getElementById('writingSubmitBtn');

submitButton.addEventListener('click', function(event) {
    event.preventDefault(); // 폼 제출 방지

    /* 유효성 검사 */

    var bbsNameForURL = document.getElementById('bbsNameSelect').value; // 게시판 선택 값 가져오기
    var postTitle = document.editForm.elements.postTitle.value; // 제목 값 가져오기

    /* 게시판이름 없을시 리턴 */
    if (bbsNameForURL == "" || bbsNameForURL == "null") {
        alert("게시판을 선택하세요");
        return;
    }
    /* 게시글 제목 없을시 리턴 */
    if (postTitle == "" || postTitle == "null") {
        alert("제목을 입력하세요");
        document.editForm.elements.postTitle.focus();
        return;
    }






    // 폼 제출
    document.editForm.action = ctx+'/bbs/'+bbsNameForURL+"/write-page/submit"; // 폼을 제출할 URL을 지정
    document.editForm.method = 'POST'; // 폼을 POST 방식으로 설정
    document.editForm.submit();
});