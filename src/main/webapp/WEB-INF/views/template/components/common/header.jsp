<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>   
<!-- -----------------------헤더 : START--------------------------- -->
<header>
    <!-- 글로벌내비 -->
    <div class="gnb">
        <div class="gnb-left">
            <div class="gnb-item">
                <a href="${ctx}" class="gnb-link">LOGO</a>
            </div>
        </div>
        <div class="gnb-right">
        	<!-- 미로그인시 로그인 / 회원가입 표시 -->
        	<c:if test="${sessionScope.isLogin == 'NO' || sessionScope.isLogin == null}">
	            <div class="gnb-item">
	                <a href="${ctx}/members/login" class="gnb-link">로그인</a>
	            </div>

	            <div class="gnb-item">
	                <a href="${ctx}/members/join" class="gnb-link">회원가입</a>
	            </div>
         	</c:if>
            <!-- 멤버 로그인시 마이페이지 표시 -->
            <c:if test="${sessionScope.isLogin == 'YES'}">
            <div class="gnb-item dropdown">
                <button type="button" class="gnb-link btn dropdown-toggle" data-bs-toggle="dropdown">
                    마이페이지
                </button>
                <ul class="dropdown-menu">
                    <li>
                        <a href="${ctx}/members/myinfo" class="gnb-link">내정보수정</a>
                    </li>
                    <li>
                        <a href="${ctx}/members/logout" class="gnb-link">로그아웃</a>
                    </li>
                </ul>
            </div>
            </c:if>
            <!--멤버 로그인시 마이페이지 표시 -->
            <!-- 관리자 로그인시 관리자 페이지 표시 -->
            <c:if test="${sessionScope.memberGrant == 'ADMIN'}">
            <div class="gnb-item">
                <a href="${ctx}/admin" class="gnb-link">관리자페이지</a>
            </div>
            </c:if>
            <!-- 관리자 로그인시 관리자 페이지 표시 -->
            <div class="gnb-item">
                <a href="${ctx}/bbs/viewTest" class="gnb-link">게시판뷰테스트</a>
            </div>            
        </div>
    </div>
    <!-- 글로벌내비 -->
    <!-- 배너 -->
    <div class="header-banner">
        <div class="header-banner-frame">
            <img class="header-banner-image" src="${ctx}/resources/img/banner.jpg" alt="배너이미지">
        </div>
    </div>
    <!-- 배너 -->            
</header>
<!-- ----------------------- ./헤더 : END--------------------------- -->
    
    