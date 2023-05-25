<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
            <div class="gnb-item">
                <a href="${ctx}/member/login" class="gnb-link">로그인</a>
            </div>
            <div class="gnb-item">
                <span class="gnb-link">|</span>
            </div>
            <div class="gnb-item">
                <a href="${ctx}/member/join" class="gnb-link">회원가입</a>
            </div>
            <!-- 멤버 로그인시 마이페이지 표시 -->
            <div class="gnb-item dropdown">
                <button type="button" class="gnb-link btn dropdown-toggle" data-bs-toggle="dropdown">
                    마이페이지
                </button>
                <ul class="dropdown-menu">
                    <li>
                        <a href="${ctx}/member/myinfo" class="gnb-link">내정보수정</a>
                    </li>
                    <li>
                        <a href="#logout.do" class="gnb-link">로그아웃</a>
                    </li>
                </ul>
            </div>
            <!--멤버 로그인시 마이페이지 표시 -->
            <!-- 관리자 로그인시 관리자 페이지 표시 -->
            <div class="gnb-item dropdown">
                <button type="button" class="gnb-link btn dropdown-toggle" data-bs-toggle="dropdown" id="dropdownMenuButton">
                    관리자 페이지
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <li><a href="#memberListPage.do" class="dropdown-item">회원관리</a></li>
                    <li><a href="#bbsListPage.do" class="dropdown-item">게시판관리</a></li>
                    <li><a href="#categoryListPage.do" class="dropdown-item">카테고리관리</a></li>
                    <li><a href="${ctx}/admin/category_manage/category_reg" class="dropdown-item">카테고리등록</a></li>
                </ul>
            </div>
            <!-- 관리자 로그인시 관리자 페이지 표시 -->
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
    
    