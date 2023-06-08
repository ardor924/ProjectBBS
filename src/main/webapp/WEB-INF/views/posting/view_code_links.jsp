<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %> --%>
    <!-- 게시글 하단 링크모음 -->
    <section class="bbs-link-area">
        <fieldset>                            
            <div class="row-between">
                <div class="row-left">
                    <button class="row-item btn btn-outline-dark"><i class="xi-pen"></i> 글쓰기</button>
                </div>
                <div class="row-right">
                    <button type="button" class="row-item btn btn-outline-success">수정</button>
                    <button type="button" class="row-item btn btn-outline-danger m-0" onclick="javascript:document.delPosting.submit();">삭제</button>
                </div>
            </div>                               
        </fieldset>
    </section>
    <!-- 게시글 하단 링크모음 -->