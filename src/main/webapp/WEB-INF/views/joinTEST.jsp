<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>


<form action="${ctx}/TEST/submit" method="POST" class="container w-25">

<div>회원가입///테스트용</div>
<hr>
<hr>
<div>
<p>첨부파일</p>
<input name="memberPhoto" type="file" multiple="multiple">
<input name="memberPhotoName" value="818462fc-77c6-4f4d-b5a1-2c5561f09e8asample.jpg">
<input name="memberPhotoPath" value="C:\\file_repo\\2023-05-26\\">
</div>
<hr>
<section class="d-flex flex-column">
<div>
<p>아이디</p>
<input name="memberID" value="">
</div>
<div>
<p>비밀번호</p>
<input name="memberPW" value="">
</div>
<div>
<p>이름</p>
<input name="memberName" value="">
</div>
<div>
<p>나이</p>
<input name="memberAge" value="">
</div>

<div>
<p>생일</p>
<input name="memberBirthYear" value="">
<input name="memberBirthMonth" value="">
<input name="memberBirthDay" value="">
</div>

<div>
<p>이메일</p>
<input name="memberEmail" value="">
</div>

<div>
<p>휴대전화</p>
<input name="memberTel" value="">
</div>
<div>
<p>개인정보동의정책</p>
<input name="memberPolicyAgreement" value="YES">
</div>
<div>
<p>이용약관동의</p>
<input name="memberTermsAgreement" value="YES">
</div>
<div>
<p>이벤트동의</p>
<input name="memberEventAgreement" value="YES">
</div>

</section>
<button class="btn btn-primary">가입</button>

</form>