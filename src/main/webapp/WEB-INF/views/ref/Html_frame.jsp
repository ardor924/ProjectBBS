<!-- 홈페이지 구조 -->


<!-- include:file -->
<!-- -----------------------html_top.jsp--------------------------- -->
<%@ include file="${ctx}/templete/layout/html_top.jsp" %>
<!-- -----------------------./ html_top--------------------------- -->
<!-- include:file -->


<!-- -----------------------뷰 프레임--------------------------- -->


	<!-- 해당 파일의 CSS -->
	<link rel="stylesheet" type="text/css" href="${ctx}/css/home.css"> 
	<!-- 해당 파일의 CSS -->
	
	<body>
	<!-- -----------------------헤더 : START--------------------------- -->
	    <%@ include file="${ctx}/templete/components/header.jsp" %>
	<!-- -----------------------헤더 :END--------------------------- -->
	
	<!-- -----------------------컨텐츠 : START--------------------------- -->
		 <%@ include file="${ctx}/templete/components/snb.jsp" %>
	    <%@ include file="${ctx}/home/home_code.jsp" %>
	<!-- -----------------------컨텐츠 :END--------------------------- -->
	
	<!-- -----------------------푸터 : START--------------------------- -->
	    <%@ include file="${ctx}/templete/components/footer.jsp" %>
	<!-- -----------------------푸터 :END--------------------------- -->
	</body>

<!-- -----------------------뷰 프레임--------------------------- -->


<!-- 해당 파일의 JS -->
<script src="${ctx}/js/home.js"></script> 
<!-- 해당 파일의 JS -->


<!-- include:file -->
<!-- -----------------------html_bottom.jsp--------------------------- -->
<%@ include file="${ctx}/templete/layout/html_bottom.jsp" %>
<!-- -----------------------html_bottom.jsp--------------------------- -->
<!-- include:file -->
