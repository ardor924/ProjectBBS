<!-- 1 JSP인코딩 -->
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!-- 2 taglib-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 날짜시간 포맷형식지정 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <!-- fn:escapeXml() :  특수 문자를 HTML 엔티티로 인코딩하는 함수제공  -->
<!-- 3 contextPath-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ProjectBBS</title>

    <!-- 4. 제이쿼리 JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!-- 5. 액시오스 Axios -->
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    

    <!-- 5. 부트스트랩 Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- 6. 폰트어썸 / XE Icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

    <!-- 7. 공통 CSS -->
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/global/font.css"> 
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/global/button.css"> 
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/template/global/global.css"> 
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/api/ckeditor5.css"> 
	
	<!-- 8. 공통 JS -->
	<script type="text/javascript">var ctx = "<%= request.getContextPath() %>";</script>
	<script type="text/javascript">var ctx_resources = "<%= request.getContextPath() %>/resources";</script>
	<script type="text/javascript">var resultMSG = "<%= request.getAttribute("resultMSG") %>";</script>
	<script type="text/javascript">var bbsNameForURL = "<%= request.getAttribute("bbsNameForURL")%>";</script>
	<script src="${ctx}/resources/js/common/redirect_message.js"></script>

</head>