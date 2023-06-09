<!-- START================================================================================================ -->
<!----------------------------------------- 기본설정(상단) ----------------------------------------- -->
<!-- UTF-8설정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 템플릿설정 -->
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>
<!--현재파일의 CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/admin/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin/category/manage.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/admin/footer.css"> 
<!-----------------------------------------./기본설정(상단) ---------------------------------------- -->
<!-- ================================================================================================ END-->






<!-- START================================================================================================ -->
<!---------------------------------- 현재 파일의 뷰 프레임 :START---------------------------------- -->

<!-- Body : START -->
<body>
    <!-- Wrapper : START-->
    <div class="admin-page-wrapper container">    
    	
		<!--헤더 : START-->
		<%@ include file="/WEB-INF/views/template/components/admin/header.jsp" %>
		<!--헤더 : START-->
				
		<!--컨텐츠 : START-->
		<div class="contents">
        		<div class="admin-panel mb-3">
				<!--카테고리 사이드 박스 : START-->
				<%@ include file="/WEB-INF/views/admin/category_list_code.jsp" %>
				<!--카테고리 사이드 박스 : END-->
				
				
				<!--관리자패널 : START-->
				<%@ include file="/WEB-INF/views/admin/category/manage_code.jsp" %>
				<!--./관리자패널 : END-->
				
				
				<!--관리자 링크 박스 : START-->
				<%@ include file="/WEB-INF/views/admin/category/manage_admin_links_code.jsp" %>
				<!--./관리자 링크 박스 : END-->
			</div>
        </div>
		<!--./컨텐츠 : END-->
		
		<!--푸터 : START-->
		<%@ include file="/WEB-INF/views/template/components/admin/footer.jsp" %>
		<!--./푸터 : END-->
		
    </div>
    <!-- ./ Wrapper : END-->

</body>
<!-- ./ Body : END -->


<!---------------------------------- ./ 현재 파일의 페이지 :END---------------------------------- -->
<!-- ================================================================================================ END-->





<!-- START================================================================================================ -->
<!-- ---------------------------------- 자바스크립트 :START ---------------------------------- -->

<!-- 카테고리 수정페이지이동 및 삭제폼 제출 -->
<script src="${ctx}/resources/js/admin/category/category_manage.js"></script>


<!-- 삭제 결과메세지 -->
<script>
  var responseMsg = "${responseMSG}";
  if (responseMsg !== "") {
    alert(responseMsg);
    console.log(responseMsg)
  }
</script>
<!-- ---------------------------------- 자바스크립트 :END ---------------------------------- -->
<!-- ================================================================================================ END-->






<!-- START================================================================================================ -->
<!----------------------------------------- 기본설정(하단) ----------------------------------------- -->
<!-- 템플릿설정 -->
<%@ include file="/WEB-INF/views/template/layout/html_bottom.jsp" %>
<!----------------------------------------./ 기본설정(하단) ----------------------------------------- -->
<!-- ================================================================================================ END-->






