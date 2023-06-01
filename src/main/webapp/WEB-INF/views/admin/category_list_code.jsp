<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %> --%>
<!-- 카테고리 사이드 박스 : START-->
<div class="category-list-box">
    <div class="row-center">
        <h5 class="category-title">카테고리 목록</h5>
    </div>
    <!-- 반복문 적용 -->
    	<c:forEach var="cLi" items="${catList}">
    <!-- <hr> -->
    <div class="row-none">
        <h6 class="category-title text-center">${cLi.catName}</h6>
    </div>
    <!-- <hr> -->    
    <ul class="row-none ps-4">
    		<c:forEach var="bLi" items="${boardList}">
    		<c:if test="${cLi.catNo eq bLi.catNo}">
        <li class="category-item"><a href="../bbs_page/bbs_101.html">${bLi.bbsName}</a></li>
    		</c:if>
    		</c:forEach>
    </ul>
    	</c:forEach>
    <!-- 반복문 적용 -->
</div>
<!-- 카테고리 사이드 박스 : END -->