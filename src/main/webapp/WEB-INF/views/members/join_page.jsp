<!-- START================================================================================================ -->
<!----------------------------------------- 기본설정(상단) ----------------------------------------- -->
<!-- UTF-8설정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 템플릿설정 -->
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>
<!--현재파일의 CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/membership/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/members/join.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/membership/footer.css"> 
<!-----------------------------------------./기본설정(상단) ---------------------------------------- -->
<!-- ================================================================================================ END-->






<!-- START================================================================================================ -->
<!---------------------------------- 현재 파일의 뷰 프레임 :START---------------------------------- -->

<!-- Body : START -->
<body>
    <!-- Wrapper : START-->
    <div class="wrapper-join container">    
    
		<!--헤더 : START-->
		<%@ include file="/WEB-INF/views/template/components/membership/header.jsp" %>
		<!--헤더 : START-->
		
		<!--컨텐츠 : START-->
		<%@ include file="/WEB-INF/views/members/join_code.jsp" %>
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


<!-- 회원가입 유효성검사 및 아이디 중복검사 스크립트-->
<script src="${ctx}/resources/js/members/join_valid_and_check_duplicate_id.js"></script>
<%-- <!-- 회원가입 유효성검사 -->
<script src="${ctx}/resources/js/member/join_valid.js"></script>
<!-- 아이디 중복 확인 스크립트 -->
<script src="${ctx}/resources/js/member/check_duplicate_id.js"></script> --%>
<!-- 동의 체크박스 상태 스크립트 -->
<script src="${ctx}/resources/js/members/agreement_checkbox.js"></script>
<!-- 프로필 사진 업로드 로직 -->
<script src="${ctx}/resources/js/common/upload_profile_origin.js"></script>

<!-- 리다이렉트된 페이지의 JavaScript 섹션 -->
<script>
window.addEventListener('DOMContentLoaded', (event) => {
  const urlParams = new URLSearchParams(window.location.search);
  const error = urlParams.get('error');
  
  if (error === 'duplicate') {
    alert('중복된 아이디를 입력했습니다.');
  }
});
</script>

<script src="${ctx}/resources/js/common/removeTemp.js"></script> <!-- 새로고침 페이지 이동시 temp삭제 -->


<!-- ---------------------------------- 자바스크립트 :END ---------------------------------- -->
<!-- ================================================================================================ END-->






<!-- START================================================================================================ -->
<!----------------------------------------- 기본설정(하단) ----------------------------------------- -->
<!-- 템플릿설정 -->
<%@ include file="/WEB-INF/views/template/layout/html_bottom.jsp" %>
<!----------------------------------------./ 기본설정(하단) ----------------------------------------- -->
<!-- ================================================================================================ END-->






