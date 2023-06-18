<!-- START================================================================================================ -->
<!----------------------------------------- 기본설정(상단) ----------------------------------------- -->
<!-- UTF-8설정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 템플릿설정 -->
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>
<!--현재파일의 CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/common/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/common/snb.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/posting/writing.css"> 
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
			<%@ include file="/WEB-INF/views/posting/writing_code.jsp" %>		
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

<!-- 현재JSP의 JS파일 -->
<script src="${ctx}/resources/js/api/ckeditor5/build/ckeditor.js"></script><!-- ckEditor5 Full npm 빌드-->
<script src="${ctx}/resources/js/api/ckeditor5/editor_setting.js"></script><!-- ckEditor5 설정파일-->

<script src="${ctx}/resources/js/posting/writing_submit.js"></script><!-- 게시글 폼 제출-->

<!-- bbsNameForURL이 none일때 select option변경으로 GET요청 -->
<script>
    function sendBbsName(selectElement, targetElement) {
        var bbsName = selectElement.value;
        console.log(bbsNameForURLelement)
        var bbsNameForURLelement = document.getElementById(targetElement);
        var bbsNameForURL = bbsNameForURLelement.value;
        if (bbsName !== '' && bbsNameForURL !== '') {
            window.location.href = '${ctx}/bbs/' + bbsNameForURL + '/write-page';
        }
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






