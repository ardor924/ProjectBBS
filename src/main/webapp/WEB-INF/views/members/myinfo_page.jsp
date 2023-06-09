<!-- START================================================================================================ -->
<!----------------------------------------- 기본설정(상단) ----------------------------------------- -->
<!-- UTF-8설정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 템플릿설정 -->
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>
<!--현재파일의 CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/membership/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/members/myinfo.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/membership/footer.css"> 
<!-----------------------------------------./기본설정(상단) ---------------------------------------- -->
<!-- ================================================================================================ END-->






<!-- START================================================================================================ -->
<!---------------------------------- 현재 파일의 뷰 프레임 :START---------------------------------- -->

<!-- Body : START -->
<body>
    <!-- Wrapper : START-->
    <div class="wrapper-myinfo container">    
    
		<!--헤더 : START-->
		<%@ include file="/WEB-INF/views/template/components/membership/header.jsp" %>
		<!--헤더 : START-->
		
		<!--컨텐츠 : START-->
		<%@ include file="/WEB-INF/views/members/myinfo_code.jsp" %>
		<!--./컨텐츠 : END-->
		
		<!--푸터 : START-->
		<%@ include file="/WEB-INF/views/template/components/membership/footer.jsp" %>
		<!--./푸터 : END-->
		
    </div>
    <!-- ./ Wrapper : END-->

</body>
<!-- ./ Body : END -->


<!---------------------------------- ./ 현재 파일의 페이지 :END---------------------------------- -->
<!-- ================================================================================================ END-->





<!-- START================================================================================================ -->
<!-- ---------------------------------- 자바스크립트 :START ---------------------------------- -->
<script type="text/javascript">
window.ctx = "${pageContext.request.contextPath}";
</script>

<!-- 회원가입 유효성검사 -->
<script src="${ctx}/resources/js/members/myinfo_valid.js"></script>

<!-- 프로필 사진 업로드 로직 -->
<script src="${ctx}/resources/js/common/upload_profile_origin.js"></script>


<!-- ---------------------------------- 자바스크립트 :END ---------------------------------- -->
<!-- ================================================================================================ END-->





<!-- START================================================================================================ -->
<!----------------------------------------- 기본설정(하단) ----------------------------------------- -->
<!-- 템플릿설정 -->
<%@ include file="/WEB-INF/views/template/layout/html_bottom.jsp" %>
<!----------------------------------------./ 기본설정(하단) ----------------------------------------- -->
<!-- ================================================================================================ END-->






