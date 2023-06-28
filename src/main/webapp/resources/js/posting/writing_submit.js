// 제출버튼 생성
const submitButton = document.getElementById('writingSubmitBtn');

submitButton.addEventListener('click', function(event) {
    event.preventDefault(); // 폼 제출 방지
 	window.onbeforeunload = null;

    /* 유효성 검사 */

    var bbsNameForURL = document.getElementById('bbsNameSelect').value; // 게시판 선택 값 가져오기
    var postTitle = document.editForm.elements.postTitle.value; // 제목 값 가져오기

	const fileNameList = [];
	const fileRegDateList = [];








	// 게시글 리턴 + 이미지 업로드 파라미터 세팅 
	const editorData = editor.getData(); // 에디터 컨텐츠를 가져오기
	const tempElement = document.createElement('div'); // 임시 요소를 생성
	tempElement.innerHTML = editorData; // 에디터 컨텐츠를 임시 요소에 할당
	
	
	const imgElements = tempElement.querySelectorAll('img'); // 임시 요소 내의 모든 img 태그를 가져오기
	
	const imgSrcList = Array.from(imgElements).map(img => {
	  const src = img.src;
	  const startIndex = src.indexOf('postingIMG/') + 11; // "postingIMG/" 이후 문자열의 시작 인덱스
	  const endIndex = src.indexOf('/', startIndex); // 다음 "/" 문자의 인덱스
	
	  const fileRegDate = src.substring(startIndex, endIndex); // fileRegDate 추출
	  const fileName = src.substring(endIndex + 1); // fileName 추출
	
	  fileRegDateList.push(fileRegDate); // fileRegDateList에 추가
	  fileNameList.push(fileName); // fileNameList에 추가
	
	  return src; // img 태그의 src 속성 값 반환
	});
	
	console.log("File Name List:", fileNameList);



	// fileNameList에 파일이름 추가 + 디코딩 하여 한글로 넘기기
	const fileNameListElement = document.getElementById('fileNameList');
	fileNameListElement.value = fileNameList.map(fileName => decodeURIComponent(fileName)).join(',');
	
	console.log("fileNameListElement.value : "+fileNameListElement.value)
	
	
	
	
	

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


	    // 파일 개수 체크
    if (fileNameList.length >= 10) {
        alert("최대 10개까지 파일을 업로드할 수 있습니다.");
        reject("파일 개수 초과");
        return;
    }

	



    // 폼 제출
    document.editForm.action = ctx+'/bbs/'+bbsNameForURL+"/write-page/submit"; // 폼을 제출할 URL을 지정
    document.editForm.method = 'POST'; // 폼을 POST 방식으로 설정
	document.editForm.enctype = "multipart/form-data"
    document.editForm.submit();
});