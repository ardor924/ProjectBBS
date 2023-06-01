<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 현재 설정화면 박스 : START -->
<div class="current-configuration-box">
    <!-- 여기부터 Include : START-->
    <div class="bbs-edit-navigation">
        <fieldset class="row-center">
            <div class="nav-headline">
                <h5>게시판 수정</h5>
            </div>
        </fieldset>
    </div>
    <form class="bbs-edit-form" action="#login.do" method="POST" >
        <fieldset class="row-none m-0">
            <div class="row-none">
                <label for="catCode" class="label-field"><span class="text-danger me-1">*</span>카테고리</label>
                <span class="form-alert" id="catCode-alert"></span>
            </div>
            <div class="input-box">
                <select name="catNo" id="catNo" class="form-control">
                    <option value="">웹개발 [100]</option>
                    <option value="">언어&문법 [200]</option>
                    <option value="">빅데이터,AI,크롤링 [300]</option>
                    <option value="">게임개발 [400]</option>
                </select>
            </div>
        </fieldset>
        <fieldset class="row-none m-0">
            <div class="row-none">
                <label for="catName" class="label-field"><span class="text-danger me-1">*</span>게시판이름</label>
                <span class="form-alert" id="catName-alert"></span>
            </div>
            <div class="input-box">
                <input type="text" class="input-box-element form-control" 
                name="catName" id="catName" placeholder="ex) Java-Spring , Python 크롤링 , 언리얼엔진 ...">
            </div>
        </fieldset>
        <fieldset class="row-none mb-3">
            <div class="row-none">
                <label for="catDescription" class="label-field">게시판 설명</label>
                <span class="form-alert" id="catDescription-alert"></span>
            </div>
            <div class="input-box">
                <textarea type="text" class="input-box-element form-control" 
                name="catDescription" id="catDescription" placeholder="ex) 웹개발 : 스프링레거시MVC 프로젝트 학습용 게시판" rows="4"></textarea>
            </div>
        </fieldset>
        <fieldset class="row-center mb-3">
            <button class="btn btn-green btn-100">게시판 수정</button>
        </fieldset>
    </form>
    <!-- 여기까지 Include : END-->
</div>
<!-- 현재 설정화면 박스 : END -->