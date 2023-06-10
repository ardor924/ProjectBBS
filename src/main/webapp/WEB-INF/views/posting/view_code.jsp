<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>


    <section class="bbs-area">               
	    <!-- 게시판 헤드 : START -->
	    <fieldset class="bbs-headline">
	        <div class="bbs-headline-row row-between">
	            <h6 class="bbs-title">${bbsName} 게시판</h6><!--타이틀명만 수정-->  
	            <form method="POST" id="moveToBbsFrm">
	                <input type="hidden" name="currentPage" value="{bp.current_page}"/>
	                <input type="hidden" name="pageRows" value="{bp.page_rows}"/>
	                <input type="hidden" name="searchTarget" value="{bDto.searchTarget}"/>
	                <input type="hidden" name="keyWord" value="{bDto.keyWord}"/>
	                <input type="hidden" name="orderBy" value="{bDto.orderBy}"/>
	                <!-- <a href="" class=""> -->
	                <a onclick="submitFormWithOption('moveToBbsFrm','currentPage','event')">
	                    <i class="xi-view-list"></i>
	                    <span>목록</span>
	                </a>
	             </form>
	        </div>
	    </fieldset>
	    <!-- ./게시판 헤드 : END -->
                    
        <!-- 게시판 메인 : START-->
        <fieldset class="bbs-main">
            <h4>${postingDTO.postTitle}</h4>
            <div class="row-between mt-4">
                <div class="row-left">
                    <div class="row-item profile-photo-frame">
                        <img src="${ctx}/members/profilePhoto/${postingDTO.postWriter}" class="profile-photo">
                    </div>
                    <div class="row-item">
                        <h6 class="writer-name">${postingDTO.postWriter}</h6>  
                        <p class="posting-regdate">
                        <c:choose>
	                        <c:when test="${regDateIsToday}">
	                        	<fmt:formatDate value="${postingDTO.postRegdate}" pattern="HH:mm" type="date"/>
	                        </c:when>
	                        <c:otherwise>
	                        	<fmt:formatDate value="${postingDTO.postRegdate}" pattern="yyyy.MM.dd" type="date"/>
	                        </c:otherwise>
                        </c:choose>
                        </p>
                    </div>
                </div>
                <div class="row-right">
                    <span class="text-thin">조회 ${postingDTO.postHit}</span>
                </div>
            </div>


            <div class="view-contents">
            	${postingDTO.postContents}
            </div>
                
        </fieldset>
        <!-- ./게시판 메인 : END-->                           
	</section>
