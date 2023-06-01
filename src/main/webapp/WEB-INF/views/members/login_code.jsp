<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- -----------------------컨텐츠 : START--------------------------- -->
<div class="contents">
    <div class="login-wrap">
        <div class="login-box bg-light">
            <div class="login-navigation">
                <fieldset class="row-around m-0">
                    <div class="nav-left">
                        <a href="${ctx}/members/login">
                            <h6 class="text-primary fw-bolder">로그인</h6>
                            <div class="selected-nav-underline"></div>
                        </a>                               
                    </div>
                    <div class="nav-right">
                        <a href="${ctx}/members/join">
                            <p>회원가입</p>
                        </a>
                    </div>
                </fieldset>
            </div>
            <form class="login-form" action="${ctx}/members/login/submit" method="POST" >
                <fieldset class="row-none  mt-4">

                    <p class="form-alert" id="memberID-alert"></p>
                    <div class="row-default mt-0">
                        <div class="input-box">
                            <div class="input-box-icon">
                                <i class="xi-user"></i>
                            </div>
                            <input type="text" class="input-box-element form-control" 
                            name="memberID" id="memberID" placeholder="아이디를 입력하세요">
                        </div>
                    </div>

                    <p class="form-alert" id="memberPW-alert"></p>
                    <div class="row-default mt-0">
                        <div class="input-box">
                            <div class="input-box-icon">
                                <i class="xi-lock"></i>
                            </div>
                            <input type="text" class="input-box-element form-control"
                            name="memberPW" id="memberPW" placeholder="비밀번호를 입력하세요">
                        </div>
                    </div>

                </fieldset>
                <p class="form-alert" id="login-fail-alert"></p>


                <fieldset class="row-between">
                    <div class="remember-login">
                        <input id="remember-checkbox" class="remember-checkbox"type="checkbox">
                        <label for="remember-checkbox"class="remember-checkbox" >로그인 상태 유지</label>
                      </div>                      
                    <div class="forgot-pw">
                        <a href="#PWforgotPage.do">비밀번호 찾기</a>
                    </div>
                </fieldset>
                <fieldset class="row-center">
                    <button class="btn btn-blue btn-50">로그인</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<!-- -----------------------./컨텐츠 :END--------------------------- -->