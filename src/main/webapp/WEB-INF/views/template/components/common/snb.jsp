<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>    --%>
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
	            <form  action="#writeBoardPage.do">
	                <button class="btn btn-blue btn-100" onclick="alert('게시글을 작성하기 위해서는 로그인이 필요합니다.')">게시글작성</button>
	            </form>    
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
            <h5 class="snb-title">전체 글 보기</h5>
        </div>
        <!-- 반복문 적용 -->
        <hr>
        <div class="row-none">
            <h6 class="snb-title text-center">웹개발</h6>
        </div>
        <hr>    
        <ul class="row-none ps-4">
            <li class="snb-text"><a href="../bbs_page/bbs_101.html">Java-Spring</a></li>
            <li class="snb-text"><a href="#">JS / Jquery</a></li>
            <li class="snb-text"><a href="#">Angura.js</a></li>
            <li class="snb-text"><a href="#">CSS / Bootstrap</a></li>
        </ul>
        <!-- 반복문 적용 -->
        <!-- 반복문 적용 -->
        <hr>
        <div class="row-none">
            <h6 class="snb-title text-center">언어&문법</h6>
        </div>
        <hr>    
        <ul class="row-none ps-4">
            <li class="snb-text"><a href="#">Java</a></li>
            <li class="snb-text"><a href="#">C#</a></li>
            <li class="snb-text"><a href="#">Python</a></li>
            <li class="snb-text"><a href="#">JavaScript</a></li>
            <li class="snb-text"><a href="#">Ruby</a></li>
        </ul>
        <!-- 반복문 적용 -->
        <!-- 반복문 적용 -->
        <hr>
        <div class="row-none">
            <h6 class="snb-title text-center">빅데이터,AI,크롤링</h6>
        </div>
        <hr>    
        <ul class="row-none ps-4">
            <li class="snb-text"><a href="#">Python 크롤링</a></li>
            <li class="snb-text"><a href="#">데이터 마이닝</a></li>
            <li class="snb-text"><a href="#">머신러닝 / 딥러닝</a></li>
        </ul>
        <!-- 반복문 적용 -->
        <!-- 반복문 적용 -->
        <hr> 
        <div class="row-none">
            <h6 class="snb-title text-center">게임개발</h6>
        </div>
        <hr>    
        <ul class="row-none ps-4">
            <li class="snb-text"><a href="#">유니티</a></li>
            <li class="snb-text"><a href="#">언리얼엔진</a></li>
        </ul>
        <!-- 반복문 적용 -->
        <!-- 반복문 적용 -->
        <hr>
        <div class="row-none">
            <h6 class="snb-title text-center">알고리즘예제</h6>
        </div>
        <hr>    
        <ul class="row-none ps-4">
            <li class="snb-text"><a href="#">Java 백준</a></li>
            <li class="snb-text"><a href="#">python 코드업</a></li>
        </ul>
        <!-- 반복문 적용 -->
        <!-- 반복문 적용 -->
        <hr>
        <div class="row-none">
            <h6 class="snb-title text-center">CS지식</h6>
        </div>
        <hr>    
        <ul class="row-none ps-4">
            <li class="snb-text"><a href="#">디자인 패턴</a></li>
            <li class="snb-text"><a href="#">운영체제</a></li>
            <li class="snb-text"><a href="#">데이터베이스</a></li>
            <li class="snb-text"><a href="#">자료구조</a></li>
        </ul>
        <!-- 반복문 적용 -->
    </div>
    <!-- ./ 카테고리 더미 데이터 -->
</div>
<!-- ./ 사이드 내비 : END -->