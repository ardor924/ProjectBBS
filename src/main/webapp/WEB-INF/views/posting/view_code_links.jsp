<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>
    <!-- 게시글 하단 링크모음 -->
    <section class="bbs-link-area">
        <fieldset>                            
            <div class="row-between">
                <div class="row-left">
                    <a class="row-item btn btn-outline-dark" href="${ctx}/bbs/${bbsNameForURL}/write-page"><i class="xi-pen"></i> 글쓰기</a>
                </div>
                <c:if test="${sessionScope.memberID == postingDTO.postWriterID}">
                <div class="row-right">
                    <button type="button" class="row-item btn btn-outline-success" onclick="goEditPage('${postingDTO.bbsPostNo}')">수정</button>
                    <button type="button" class="row-item btn btn-outline-danger m-0" onclick="deleteThisPosting('${postingDTO.bbsPostNo}')">삭제</button>
                </div>
                </c:if>
            </div>                               
        </fieldset>
    </section>
    <!-- 게시글 하단 링크모음 -->