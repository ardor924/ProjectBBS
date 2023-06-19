<!-- START================================================================================================ -->
<!----------------------------------------- 기본설정(상단) ----------------------------------------- -->
<!-- UTF-8설정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 템플릿설정 -->
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>
<!--현재파일의 CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/common/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/common/snb.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/posting/view.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/reply/reply.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/posting/view_links.css"> 
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
			
			<!--------------- 메인컨텐츠 : START ---------------------------------->
			<div class="main">
			
				<!--게시글보기 : START-->
				<%@ include file="/WEB-INF/views/posting/view_code.jsp" %>		
				<!--./ 게시글보기 : END-->
				
				<!--댓글 리스트 : START-->
				<%@ include file="/WEB-INF/views/reply/reply_code.jsp" %>
				<!--./ 댓글 리스트 : END-->
				
				<!-- 게시글 하단 링크모음 : START-->
				<%@ include file="/WEB-INF/views/posting/view_code_links.jsp" %>
				<!-- ./게시글 하단 링크모음 : END -->
				
				<!-- 게시글 하단 목록 리스트 : START-->
				<%@ include file="/WEB-INF/views/posting/view_code_bbs_list.jsp" %>
				<!-- ./게시글 하단 목록 리스트 : END-->
			
			</div>
			<!-------------./ 메인컨텐츠 : END ----------------------------------->
			
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

<!-- 현재JSP의 JS파일 -->
<script src="${ctx}/resources/js/posting/view_textarea_setting.js"></script>

<!-- 게시판 게시글옵션변경 폼 제출 -->
<script src="${ctx}/resources/js/boards/board_dynamic_form.js"></script>


<!-- ---------------------------------- 자바스크립트 :END ---------------------------------- -->
<!-- ================================================================================================ END-->

<script type="text/javascript">
function submitFormWithOption(targetFrmId) {
    console.log("진입성공!")



var form = document.getElementById(targetFrmId);
form.action = ctx + "/bbs/" + bbsNameForURL;
form.submit();




}

</script>




<!-- START================================================================================================ -->
<!----------------------------------------- 기본설정(하단) ----------------------------------------- -->
<!-- 템플릿설정 -->
<%@ include file="/WEB-INF/views/template/layout/html_bottom.jsp" %>
<!----------------------------------------./ 기본설정(하단) ----------------------------------------- -->
<!-- ================================================================================================ END-->






