/*GET방식*/
/* function changePageOption(targetId) {
    var targetElement = document.getElementById(targetId); // 파라미터의 값을 전송하는 용도
    var targetValue = targetElement.value; // 파라미터의 값  
    var url = ctx + '/bbs/' + bbsNameForURL + '?' + targetElement.getAttribute('id') + '=' + targetValue;
    location.href = url; */


/*게시글 검색 옵션변경 제출폼 */
function submitFormWithOptionForSearchBar(targetFrmId) 
{
	
  document.getElementById(targetFrmId).addEventListener("submit", function(event) {
	    event.preventDefault(); // 폼 제출 기본 동작 중지
	    
	    console.log("진입성공!")
	    
	    var searchTarget = document.getElementById("searchTarget").value.trim();
	    var keyWord = document.getElementById("keyWord").value
	    
	    if (searchTarget === "none") {
	        alert("검색대상을 선택하세요");
	        return;
	      }

	    if (keyWord === "") {
	        alert("검색어를 입력해주세요");
	        return;
	      }
  
  var form = document.getElementById(targetFrmId);
  form.action = ctx + "/bbs";
  form.submit();

  
  
  });
  

}

/*게시글 옵션변경 제출폼 */
function submitFormWithOptionForCommon(targetFrmId) 
{
console.log("진입성공!")

var form = document.getElementById(targetFrmId);
form.action = ctx + "/bbs";
form.submit();


}



