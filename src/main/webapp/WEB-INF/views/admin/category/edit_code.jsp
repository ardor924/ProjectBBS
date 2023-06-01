<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- -----------------------컨텐츠 : START--------------------------- -->
<div class="contents">
    <div class="categoryreg-wrap">
        <div class="categoryreg-box bg-light">
            <div class="categoryreg-navigation">
                <fieldset class="row-center m-0">
                    <div class="nav-left">
                        <h5>카테고리 수정</h5>
                    </div>
                </fieldset>
            </div>
            <form class="category-form" action="${ctx}/admin/category/edit/submit" method="POST" >
            	<input type="hidden" name="catNo" value="${categoryDTO.catNo}">
                <fieldset class="row-none m-0">
                    <div class="row-none">
                        <label for="catCode" class="label-field"><span class="text-danger me-1">*</span>카테고리코드</label>
                        <span class="form-alert" id="catCode-alert"></span>
                    </div>
                    <div class="input-box">
                        <input type="text" class="input-box-element form-control" 
                        name="catCode" id="catCode" value="${categoryDTO.catCode}" readonly="readonly">
                    </div>
                </fieldset>
                <fieldset class="row-none m-0">
                    <div class="row-none">
                        <label for="catName" class="label-field"><span class="text-danger me-1">*</span>카테고리명</label>
                        <span class="form-alert" id="catName-alert"></span>
                    </div>
                    <div class="input-box">
                        <input type="text" class="input-box-element form-control" 
                        name="catName" id="catName" value="${categoryDTO.catName}">
                    </div>
                </fieldset>
                <fieldset class="row-none m-0">
                    <div class="row-none">
                        <label for="catDescription" class="label-field">카테고리설명</label>
                        <span class="form-alert" id="catDescription-alert"></span>
                    </div>
                    <div class="input-box">
                        <input type="text" class="input-box-element form-control" 
                        name="catDescription" id="catDescription" value="${categoryDTO.catDescription}">
                    </div>
                </fieldset>


                <fieldset class="row-center">
                    <button class="btn btn-gold btn-50">카테고리 수정</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<!-- -----------------------./컨텐츠 :END--------------------------- -->