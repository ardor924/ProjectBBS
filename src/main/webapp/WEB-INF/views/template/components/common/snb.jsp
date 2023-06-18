<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>   
<!-- 사이드 내비 : START -->
<div class="snb">
	<c:choose>
		<c:when test="${sessionScope.isLogin eq 'YES'}">
	    <div class="snb-myinfo">
	        <div class="row-center">
	            <h4 class="snb-title">나의정보</h4>
	        </div>
	        <hr>
	        <div class="row-between">
	            <a class="my-photo-frame" href="${ctx}/members/myinfo/" >
	                <img class="my-photo" src="${ctx}/members/profilePhoto/${sessionScope.memberID}">
	            </a>
	            <div class="my-info">
	                <h6 class="snb-text">${sessionScope.memberName}</h6>
	                <p class="snb-text">
	                	<span>가입</span>
	                	<fmt:formatDate value="${sessionScope.memberRegdate}" pattern="yy.MM.dd" type="date"/>
					</p>
	            </div>
	        </div>
	        <hr>
	        <div class="row-none">
	            <div class="my-posting">
	                <a href="#myPostingPage.do">내가 쓴 글보기</a>
	            </div>
	            <div class="my-posting">
	                <a href="#myReplyPage.do">내가 쓴 댓글보기</a>
	            </div>
	        </div>
	        <hr>
	        <div class="row-none">
	        	<c:choose>
	        		<c:when test="${bbsNameForURL eq null}">
	        			<a href="${ctx}/bbs/none/write-page" class="btn btn-blue btn-100">게시글작성</a>	        		
	        		</c:when>
	        		<c:otherwise>	        		
	        			<a href="${ctx}/bbs/${bbsNameForURL}/write-page" class="btn btn-blue btn-100">게시글작성</a>	        		
	        		</c:otherwise>
	        	</c:choose>
	        </div>
	    </div>
	    </c:when>
	    
	    <c:otherwise>
	    <div class="snb-myinfo">
	        <div class="row-center">
	            <h4 class="snb-title">나의정보</h4>
	        </div>
	        <hr>
	        <div class="row-between">
	            <a class="my-photo-frame" href="#" >
	                <img class="my-photo" src="${ctx}/resources/img/default-member-photo.png">
	            </a>
	            <div class="my-info">
	                <h6 class="snb-text">로그인 정보가 없습니다.</h6>
	            </div>
	        </div>
	        <hr>
	        <div class="row-none">
	            <form action="${ctx}/members/login">
	                <button class="btn btn-blue btn-100" onclick="redirectToLogin()">게시글작성</button>
	            </form>    
	        </div>
	    </div>
	    </c:otherwise>
    </c:choose>


    <div class="snb-category">
        <div class="row-center">
        	<a href="${ctx}/bbs">
            	<h5 class="snb-title">전체 글 보기</h5>
        	</a>
        </div>
        <!-- 반복문 적용 -->
        <c:forEach var="cLi" items="${catList}">
        <div class="snb-title-wrap">	
        	<div class="row-none">
            	<h6 class="snb-title text-center">${cLi.catName}</h6>
        	</div>
        </div>
        <ul class="row-none ps-4">
	        <c:forEach var="bLi" items="${boardList}">
	            <c:if test="${cLi.catNo eq bLi.catNo}">
	                <li class="snb-text">
	                    <c:url var="encodedUrl" value="/bbs/${fn:escapeXml(bLi.bbsNameForURL)}"/>
	                    <a href="${encodedUrl}">${bLi.bbsName}</a>
	                </li>
	            </c:if>
	        </c:forEach>
        </ul>
        </c:forEach>
        <!-- 반복문 적용 -->
    </div>
    <!-- ./ 카테고리 더미 데이터 -->
</div>
<!-- ./ 사이드 내비 : END -->