/* 문서가 로드되면 즉시 실행*/
document.addEventListener("DOMContentLoaded", function() 

{
	
});



/*카테고리 수정 페이지 이동*/
function moveCategoryEditPage(){
	var confirmMsg = "수정하시겠습니까?";	
  	window.confirm(confirmMsg) ? null : event.preventDefault(); // 삼항 연산자 사용
}





/*카테고리 삭제폼 제출*/
function categoryDelete(){
	var confirmMsg = "삭제하시겠습니까?";	
  	window.confirm(confirmMsg) ? null : event.preventDefault(); // 삼항 연산자 사용
}

