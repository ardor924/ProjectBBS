<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 관리자링크 : START -->                  
<div class="admin-links-box">
    <div class="admin-links-navigation">
        <fieldset class="row-center">
            <div class="nav-headline">
                <h5>관리자링크</h5>
            </div>
        </fieldset>
    </div>
    <div class="admin-links-list">
        <div class="row-center">
            <a class="admin-link-item btn btn-outline-dark" href="${ctx}/">홈페이지</a>
        </div>
        <div class="row-center">
            <a class="admin-link-item btn btn-outline-dark" href="${ctx}/admin">메인설정</a>
        </div>
        <div class="row-center">
            <a class="admin-link-item btn btn-outline-dark" href="${ctx}/admin/membership">회원관리</a>
        </div>
        <div class="row-center">
            <a class="admin-link-item btn btn-outline-dark" href="${ctx}/admin/category/reg">카테고리등록</a>
        </div>
        <div class="row-center">
            <a class="admin-link-item btn btn-purple" href="${ctx}/admin/category">카테고리관리</a>
        </div>
        <div class="row-center">
            <a class="admin-link-item btn btn-outline-dark" href="${ctx}/admin/bbs/reg">게시판등록</a>
        </div>
        <div class="row-center">
            <a class="admin-link-item btn btn-outline-dark" href="${ctx}/admin/bbs">게시판관리</a>
        </div>
        <div class="row-center">
            <a class="admin-link-item btn btn-outline-dark" href="${ctx}/test">테스트페이지</a>
        </div>
    </div>
</div>
<!-- 관리자링크 : END -->