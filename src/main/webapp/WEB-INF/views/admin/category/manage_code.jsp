<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>
<!-- -----------------------컨텐츠 : START--------------------------- -->
<div class="contents">
    <div class="categoryreg-wrap">
        <div class="categoryreg-box bg-light">
            <div class="categoryreg-navigation">
                <fieldset class="row-center m-0">
                    <div class="nav-left">
                        <h5>카테고리 관리</h5>
                    </div>
                </fieldset>
            </div>
            <hr>
            <div class="category-table p-4">
                <table class="table table-hover">
                    <thead class="text-start">
                    	<tr>
                        	<th scope="col" class="col-3">카테고리코드</th>
                        	<th scope="col" class="col-6">카테고리이름</th>
                        	<th scope="col" class="col-3 text-center">수정/삭제</th>
                    	<tr>
                    </thead>
                    <tbody>
	                    <tr>
	                    <!--  등록된 카테고리가 없을때 -->
                       	<c:if test="${catList == null}">
	                        <td class="text-center" colspan="3">
	                            <h3>등록된 카테고리가 없습니다.</h3>
	                        </td>                                
                       	</c:if>                        
	                    </tr>                  
                    	<!-- 반복문적용 -->
                    	<c:forEach var="li" items="${catList}">
                    	<tr>
	                        <td scope="row" class="col-3">
	                            <p>${li.catCode}</p>
	                        </td>
	                        <td scope="row" class="col-6">
	                            <p>${li.catName}</p>
	                        </td>
	                        <td scope="row" class="col-3 text-center">
	                            <a href="${ctx}/admin/category/edit/${li.catCode}" onclick="moveCategoryEditPage()" class="btn btn-success btn-sm">수정</a>
	                            <a href="${ctx}/admin/category/delete/${li.catCode}" onclick="categoryDelete()" class="btn btn-danger btn-sm">삭제</a>
	                        </td>
                    	<tr>
                    	</c:forEach>
                    	<!-- 반복문적용 -->
                    </tbody>
                </table>
                <fieldset class="row-center mt-4">
                    <a href="${ctx}/admin/category/reg" class="btn btn-purple btn-90">카테고리 등록 페이지로</a>
                </fieldset>
            </div>
        </div>
    </div>
</div>
<!-- 수정페이지이동 및 삭제 폼제출 -->
<%-- <form action="${ctx}/admin/category_manage/edit" id="move-category-edit-page"></form>
<form action="${ctx}/admin/category_manage/delete" id="category-delete"></form> --%>
<!-- -----------------------./컨텐츠 :END--------------------------- -->