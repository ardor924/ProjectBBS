<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %> --%>
<!-- 현재 설정화면 박스 : START -->
<div class="current-configuration-box">
    <!-- 여기부터 Include : START-->
    <div class="bbs-reg-navigation">
        <fieldset class="row-center">
            <div class="nav-headline">
                <h5>게시판 등록</h5>
            </div>
        </fieldset>
    </div>
    <form class="bbs-reg-form" action="${ctx}/admin/bbs/reg/submit" method="POST" >
        <fieldset class="row-none m-0">
            <div class="row-none">
                <label for="catCode" class="label-field"><span class="text-danger me-1">*</span>카테고리</label>
                <span class="form-alert" id="catCode-alert"></span>
            </div>
            <div class="input-box">
                <select name="catNo" id="catNo" class="form-control">
            			<c:forEach var="li" items="${catList}">
                    <option value="${li.catNo}">${li.catName} [${li.catCode}]</option>
            			</c:forEach>
                </select>
            </div>
        </fieldset>
        <fieldset class="row-none m-0">
            <div class="row-none">
                <label for="bbsName" class="label-field"><span class="text-danger me-1">*</span>게시판이름</label>
                <span class="form-alert" id="bbsName-alert"></span>
            </div>
            <div class="input-box">
                <input type="text" class="input-box-element form-control" 
                name="bbsName" id="bbsName" placeholder="ex) Java-Spring , Python 크롤링 , 언리얼엔진 ...">
            </div>
        </fieldset>
        <fieldset class="row-none mb-3">
            <div class="row-none">
                <label for="bbsDescription" class="label-field">게시판 설명</label>
                <span class="form-alert" id="bbsDescription-alert"></span>
            </div>
            <div class="input-box">
                <textarea class="input-box-element form-control" 
                name="bbsDescription" id="bbsDescription" placeholder="ex) 웹개발 : 스프링레거시MVC 프로젝트 학습용 게시판" rows="4"></textarea>
            </div>
        </fieldset>
        <fieldset class="row-center mb-3">
            <button class="btn btn-blue btn-100">게시판 등록</button>
        </fieldset>
    </form>
    <!-- 여기까지 Include : END-->
</div>
<!-- 현재 설정화면 박스 : END -->