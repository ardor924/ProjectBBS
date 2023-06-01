<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- -----------------------컨텐츠 : START--------------------------- -->
    <div class="contents">
        <div class="join-wrap">
            <div class="join-box bg-light">
                <div class="join-navigation">
                    <fieldset class="row-around m-0">
                        <div class="nav-left">
                            <a href="${ctx}/members/login">
                                <p>로그인</p>
                            </a>                               
                        </div>
                        <div class="nav-right">
                            <a href="${ctx}/members/join">
                                <h6 class="text-primary fw-bolder">회원가입</h6>
                                <div class="selected-nav-underline"></div>
                            </a>
                        </div>
                    </fieldset>
                </div>
<%--                 <form class="join-form" id="joinForm" action="${ctx}/member/join/submit" method="POST" > --%>
                <form class="join-form" id="joinForm" action="${ctx}/members/join/submit" method="POST" >
                    <fieldset class="column-center mt-5 mb-0">
                        <div class="my-photo-frame">
                            <img src="${ctx}/resources/img/default-member-photo.png" id="my-photo-frame" class="my-photo" type="button" alt="기본이미지">
                            <button class="btn btn-secondary" id="profile-image-upload-btn" type="button">등록하기</button>
                            <input type="file" id="memberPhoto" name="memberPhoto" accept=".jpg, .jpeg, .gif, .png, .bmp, .webp" style="display: none;" multiple="multiple">                           							                       
							<input type="hidden" id="memberPhotoPath" name="memberPhotoPath">
							<input type="hidden" id="memberPhotoName" name="memberPhotoName">   
							<input type="hidden" id="memberPhotoRealName" name="memberPhotoRealName">   
							<input type="hidden" id="memberPhotoRegdateStr" name="memberPhotoRegdateStr">                            
                        </div>
                    </fieldset>
                    <!-- 회원가입 폼 작성 오류시 발생 -->
                    <!-- <div class="form-alert">* 필수입력정보입니다</div> -->
                    <fieldset class="row-none mt-3 mb-0">
                        <div class="row-none">
                            <label for="memberID" class="label-field"><span class="text-danger me-1">*</span>아이디</label>
                            <span class="form-alert" id="memberID-alert"></span>
                        </div>
                        <div class="input-box">
                            <input type="text" class="input-box-element form-control" 
                            name="memberID" id="memberID" placeholder="아이디를 입력하세요 (영문/숫자 5~20자)">
                            <div class="btn btn-blue id-check" id="check-duplicate-button" type="button">중복확인</div>
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
                            name="memberName" id="memberName" placeholder="이름을 입력하세요">
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
                                <option value="none">월</option>
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

                    <fieldset class="row-none m-0">
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
                    
                    <div class="row-none mt-3 mb-2 pt-0 pb-0">
                        <label for="memberAgreement" class="label-field"><span class="text-danger me-1">*</span>약관동의</label>
                    </div>
                    
                    <div class="mb-3 p-3 border rounded bg-white">
                        <fieldset class="row-between mt-3 mb-1">
                            <div class="policy_terms-areement">
                                <label for="policy-agree"class="policy_terms-checkbox"><span class="text-danger me-1">(필수)</span>개인정보처리방침 동의</label>
                            </div>                      
                            <div class="policy_terms-areement">
                                <p for=""class="policy_terms-detail">상세보기</p>    
                                <input id="policy-agree" class="policy_terms-checkbox"type="checkbox" onchange="handleAgreementCheckbox('policy-agree', 'memberPolicyAgreement')">
                                <input type="hidden" id="memberPolicyAgreement" name="memberPolicyAgreement" value="NO"> 
                            </div>
                        </fieldset>                            
                        <p class="form-alert" id="policy-agree-alert"></p>

                        <fieldset class="row-between mt-0 mb-1">
                            <div class="policy_terms-areement">
                                <label for="terms-agree"class="policy_terms-checkbox" ><span class="text-danger me-1">(필수)</span>ProjectBBS 이용약관 동의</label>
                            </div>                      
                            <div class="policy_terms-areement">
                                <p for=""class="policy_terms-detail">상세보기</p>    
                                <input id="terms-agree" class="policy_terms-checkbox"type="checkbox" onchange="handleAgreementCheckbox('terms-agree', 'memberTermsAgreement')">
                                <input type="hidden" id="memberTermsAgreement" name="memberTermsAgreement" value="NO">   
                            </div>
                        </fieldset>
                        <p class="form-alert" id="terms-agree-alert"></p>

                        <fieldset class="row-between mt-0">
                            <div class="policy_terms-areement">
                                <label for="event-agree"class="policy_terms-checkbox" >(선택)이벤트/마케팅 수신 동의</label>
                                <span class="form-alert"></span>
                            </div>                      
                            <div class="policy_terms-areement">
                                <p for=""class="policy_terms-detail">상세보기</p>    
                                <input id="event-agree" class="policy_terms-checkbox"type="checkbox" onchange="handleAgreementCheckbox('event-agree', 'memberEventAgreement')">
                                <input type="hidden" id="memberEventAgreement" name="memberEventAgreement" value="NO">                                  
                            </div>
                        </fieldset>
                    </div>

                    <fieldset class="row-evenly mb-4">
                        <button class="btn btn-green btn-40">가입하기</button>
                        <a href="${ctx}/" class="btn btn-red btn-40">가입취소</a>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
<!-- -----------------------./컨텐츠 :END--------------------------- -->