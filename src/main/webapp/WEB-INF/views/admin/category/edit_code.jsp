<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 현재 설정화면 박스 : START -->
 <div class="current-configuration-box">
     <!-- 여기부터 Include : START-->
     <div class="category-edit-navigation">
         <fieldset class="row-center">
             <div class="nav-headline">
                 <h5>카테고리 수정</h5>
             </div>
         </fieldset>
     </div>
     <form class="category-edit-form" action="${ctx}/admin/category/edit/submit" method="POST" >
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
         <fieldset class="row-none mb-3">
             <div class="row-none">
                 <label for="catDescription" class="label-field">카테고리설명</label>
                 <span class="form-alert" id="catDescription-alert"></span>
             </div>
             <div class="input-box">
                 <textarea type="text" class="input-box-element form-control" 
                 name="catDescription" id="catDescription" placeholder="ex) 웹개발 : 스프링 MVC 를 이용한 웹개발 게시판 카테고리" rows="4"></textarea>                           
             </div>
         </fieldset>
         <fieldset class="row-center mb-3">
             <button class="btn btn-green btn-100">카테고리 수정</button>
         </fieldset>
     </form>
     <!-- 여기까지 Include : END-->
 </div>
 <!-- 현재 설정화면 박스 : END -->