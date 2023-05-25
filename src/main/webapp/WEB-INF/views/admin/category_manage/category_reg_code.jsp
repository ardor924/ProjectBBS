<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- -----------------------컨텐츠 : START--------------------------- -->
<div class="contents">
    <div class="categoryreg-wrap">
        <div class="categoryreg-box bg-light">
            <div class="categoryreg-navigation">
                <fieldset class="row-center m-0">
                    <div class="nav-left">
                        <h5>카테고리 등록</h5>
                    </div>
                </fieldset>
            </div>
            <form class="categoryreg-form" action="#login.do" method="POST" >
                <fieldset class="row-none m-0">
                    <div class="row-none">
                        <label for="catCode" class="label-field"><span class="text-danger me-1">*</span>카테고리코드</label>
                        <span class="form-alert" id="catCode-alert"></span>
                    </div>
                    <div class="input-box">
                        <input type="text" class="input-box-element form-control" 
                        name="catCode" id="catCode" placeholder="ex) 100,200,300...">
                    </div>
                </fieldset>
                <fieldset class="row-none m-0">
                    <div class="row-none">
                        <label for="catName" class="label-field"><span class="text-danger me-1">*</span>카테고리명</label>
                        <span class="form-alert" id="catName-alert"></span>
                    </div>
                    <div class="input-box">
                        <input type="text" class="input-box-element form-control" 
                        name="catName" id="catName" placeholder="ex) 웹개발,AI,게임개발,알고리즘예제...">
                    </div>
                </fieldset>
                <fieldset class="row-none m-0">
                    <div class="row-none">
                        <label for="catDescription" class="label-field">카테고리설명</label>
                        <span class="form-alert" id="catDescription-alert"></span>
                    </div>
                    <div class="input-box">
                        <input type="text" class="input-box-element form-control" 
                        name="catDescription" id="catDescription" placeholder="ex) 웹개발 : 스프링 MVC 를 이용한 웹개발 게시판 카테고리">
                    </div>
                </fieldset>



                <fieldset class="row-center">
                    <button class="btn btn-orange btn-50">카테고리 등록</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<!-- -----------------------./컨텐츠 :END--------------------------- -->