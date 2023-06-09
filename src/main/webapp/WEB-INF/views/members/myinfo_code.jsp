<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- -----------------------컨텐츠 : START--------------------------- -->
<div class="contents">
    <div class="myinfo-wrap">
        <div class="myinfo-box bg-light">
            <div class="myinfo-navigation">
                <fieldset class="row-center m-0">
                    <div class="nav-left">
                        <h5>회원정보수정</h5>
                    </div>
                </fieldset>
            </div>
            <form class="myinfo-form" id="myinfoForm" method="POST" >
                <fieldset class="column-center mt-5 mb-0">
                    <div class="my-photo-frame">
                        <img src="${ctx}/members/profilePhoto/${memberDTO.memberID}" id="my-photo-frame" class="my-photo" type="button" alt="기본이미지">
                        <button class="btn btn-secondary" id="profile-image-upload-btn" type="button">등록하기</button>
                        <input type="file" id="memberPhoto" name="memberPhoto" accept=".jpg, .jpeg, .gif, .png, .bmp, .webp" style="display: none;" multiple="multiple">    
                       	<input type="hidden" id="fileToken" name="fileToken">
                    </div>
                </fieldset>
                <fieldset class="row-none mt-3 mb-0">
                    <div class="row-none">
                        <label for="memberId" class="label-field"><span class="text-danger me-1">*</span>아이디</label>
                        <span class="form-alert" id="memberID-alert"></span>
                    </div>
                    <div class="input-box">
                        <input type="text" class="input-box-element form-control" 
                        name="memberID" id="memberID" value="${memberDTO.memberID}" readonly>
                    </div>
                </fieldset>
                <fieldset class="row-none m-0">
                    <div class="row-none">
                        <label for="memberPW" class="label-field"><span class="text-danger me-1">*</span>비밀번호</label>
                        <span class="form-alert" id="memberPW-alert"></span>
                    </div>
                    <div class="input-box">
                        <input type="text" class="input-box-element form-control" 
                        name="memberPW" id="memberPW" placeholder="비밀번호를 입력하세요 (영문/숫자/특수문자 포함 8~20자)">
                    </div>
                </fieldset>
                <fieldset class="row-none m-0">
                    <div class="row-none">
                        <label for="memberPW_Confirm" class="label-field"><span class="text-danger me-1">*</span>비밀번호 확인</label>
                        <span class="form-alert" id="memberPW_Confirm-alert"></span>
                    </div>
                    <div class="input-box">
                        <input type="text" class="input-box-element form-control" 
                        name="memberPW_Confirm" id="memberPW_Confirm" placeholder="비밀번호를 다시 입력하세요">
                    </div>
                </fieldset>
                <fieldset class="row-none m-0">
                    <div class="row-none">
                        <label for="memberName" class="label-field"><span class="text-danger me-1">*</span>이름</label>
                        <span class="form-alert" id="memberName-alert"></span>
                    </div>
                    <div class="input-box">
                        <input type="text" class="input-box-element form-control" 
                        name="memberName" id="memberName" placeholder="이름을 입력하세요" value="${memberDTO.memberName}">
                    </div>
                </fieldset>
                <fieldset class="row-none m-0">
                    <div class="row-none">
                        <label for="memberBirth" class="label-field">생년월일</label>
                    </div>
                    <div class="input-box-apart">

                        <input type="text" class="input-box-element-apart form-control ms-0" 
                        name="memberBirthYear" id="memberBirthYear" placeholder="년(4자)" maxlength="4">

                        <select name="memberBirthMonth" id="memberBirthMonth" class="input-box-element-apart"> 
                            <option value>월</option>
                            <option value="01">1</option>
                            <option value="02">2</option>
                            <option value="03">3</option>
                            <option value="04">4</option>
                            <option value="05">5</option>
                            <option value="06">6</option>
                            <option value="07">7</option>
                            <option value="08">8</option>
                            <option value="09">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                        
                        <input type="text" class="input-box-element-apart form-control me-0" 
                        name="memberBirthDay" id="memberBirthDay" placeholder="일" maxlength="2">

                    </div>        
                </fieldset>

                <fieldset class="row-none m-0">
                    <div class="row-none">
                        <label for="memberEmail" class="label-field"><span class="text-danger me-1">*</span>이메일</label>
                        <span class="form-alert" id="memberEmail_1-alert"></span>
                    </div>
                    <div class="input-box-apart">

                        <input type="text" class="input-box-element-apart form-control ms-0" 
                        name="memberEmail_1" id="memberEmail_1" placeholder="이메일주소">

                        <span>@</span>

                        <input type="text" class="input-box-element-apart form-control me-0" 
                        name="memberEmail_2" id="memberEmail_2" placeholder="예) naver.com">

                    </div>        
                </fieldset>

                <fieldset class="row-none mt-0 mb-4">
                    <div class="row-none">
                        <label for="memberTel" class="label-field">휴대전화</label>
                    </div>
                    <div class="input-box-apart">

                        <input type="text" class="input-box-element-apart form-control ms-0" 
                        name="memberTel_1" id="memberTel_1" placeholder="010" maxlength="3">
                        <span>-</span>
                        <input type="text" class="input-box-element-apart form-control" 
                        name="memberTel_2" id="memberTel_2" placeholder="xxxx" maxlength="4">
                        <span>-</span>
                        <input type="text" class="input-box-element-apart form-control me-0" 
                        name="memberTel_3" id="memberTel_3" placeholder="xxxx" maxlength="4">

                    </div>        
                </fieldset>

                <fieldset class="row-evenly mb-4">
                    <button class="btn btn-purple btn-40">수정하기</button>
                    <a href="${ctx}/" class="btn btn-red btn-40">수정취소</a>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<!-- -----------------------./컨텐츠 :END--------------------------- -->