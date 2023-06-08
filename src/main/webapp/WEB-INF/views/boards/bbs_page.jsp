<!-- START================================================================================================ -->
<!----------------------------------------- 기본설정(상단) ----------------------------------------- -->
<!-- UTF-8설정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 템플릿설정 -->
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>
<!--현재파일의 CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/common/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/common/snb.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/boards/bbs_list.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/common/footer.css"> 
<!-----------------------------------------./기본설정(상단) ---------------------------------------- -->
<!-- ================================================================================================ END-->






<!-- START================================================================================================ -->
<!---------------------------------- 현재 파일의 뷰 프레임 :START---------------------------------- -->

<!-- Body : START -->
<body>
    <!-- Wrapper : START-->
    <div class="wrapper container">    
    
		<!--헤더 : START-->
		<%@ include file="/WEB-INF/views/template/components/common/header.jsp" %>
		<!--헤더 : START-->
		
		<!--컨텐츠 : START-->
		<div class="contents">
			<!--사이드 내비 : START-->
			<%@ include file="/WEB-INF/views/template/components/common/snb.jsp" %>		
			<!--./ 사이드 내비 : END-->
			
			<!--메인컨텐츠 : START-->
			<%@ include file="/WEB-INF/views/boards/bbs_code.jsp" %>		
			<!--./ 메인컨텐츠 : END-->
		</div>	
		<!--./컨텐츠 : END-->
		
		<!--푸터 : START-->
		<%@ include file="/WEB-INF/views/template/components/common/footer.jsp" %>
		<!--./푸터 : END-->
		
    </div>
    <!-- ./ Wrapper : END-->

</body>
<!-- ./ Body : END -->


<!---------------------------------- ./ 현재 파일의 페이지 :END---------------------------------- -->
<!-- ================================================================================================ END-->





<!-- START================================================================================================ -->
<!-- ---------------------------------- 자바스크립트 :START ---------------------------------- -->

<!-- 게시판 게시글옵션변경 폼 제출 -->
<script>
<%-- var ctx = "<%= request.getContextPath() %>";
var bbsNameForURL = "<%= request.getAttribute("bbsNameForURL") %>"; --%>


/* POST방식 */
 
/*게시글갯수*/
function submitFormWithOption(targetFrmId, targetName) {
    var form = document.getElementById(targetFrmId); 
    form.action = ctx+"/bbs/" + bbsNameForURL  + "/changeOption/" + form[targetName].value;
    form.submit();
}


/*GET방식*/
/* function changePageOption(targetId) {
    var targetElement = document.getElementById(targetId); // 파라미터의 값을 전송하는 용도
    var targetValue = targetElement.value; // 파라미터의 값  
    var url = ctx + '/bbs/' + bbsNameForURL + '?' + targetElement.getAttribute('id') + '=' + targetValue;
    location.href = url; */

</script>

<!-- ---------------------------------- 자바스크립트 :END ---------------------------------- -->
<!-- ================================================================================================ END-->






<!-- START================================================================================================ -->
<!----------------------------------------- 기본설정(하단) ----------------------------------------- -->
<!-- 템플릿설정 -->
<%@ include file="/WEB-INF/views/template/layout/html_bottom.jsp" %>
<!----------------------------------------./ 기본설정(하단) ----------------------------------------- -->
<!-- ================================================================================================ END-->






