<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %> --%>
<!-- 메인컨텐츠 : START-->
<div class="main">
    <section class="bbs-area">
    
    
        <!-- 게시글 헤드 : START -->
        <fieldset class="bbs-headline  m-0 p-0">
            <div class="row-between  m-0 p-0">
                <h2 class="bbs-title">글수정</h2><!--타이틀명만 수정-->  
                <div class="btn-wrap">
		            <form action="${ctx}/bbs/${bbsNameForURL}/${bbsPostNo}" id="moveToViewPosting" method="POST">
		                <input type="hidden" name="currentPage" value="${currentPage}"/>
		                <input type="hidden" name="pageRows" value="${pageRows}"/>
		                <input type="hidden" name="searchTarget" value="${searchTarget}"/>
		                <input type="hidden" name="keyWord" value="${keyWord}"/>
		                <input type="hidden" name="orderBy" value="${orderBy}"/>
		                <a type="button" class="btn-item btn btn-danger" onclick="document.getElementById('moveToViewPosting').submit();">
		                	<i class="fa-solid fa-x"></i>
		                 	취소
		                </a>
		            </form>                    
					<button type="submit" id="editSubmitBtn" class="btn-item btn btn-success">
					    <i class="fa-solid fa-check"></i> 수정
					</button>
                </div>	                
            </div>
        </fieldset>
        <!-- ./게시글 헤드 : END -->
        <hr class="section-line  mt-0 pt-0">



        <!-- 게시글 메인 : START-->
        <fieldset class="bbs-main">
            <form class="writing-form" id="editForm" name="editForm">
                <input type="hidden" name="postWriterName" value="${memberName}">
                <input type="hidden" name="postWriterID" value="${memberID}">
                <input type="hidden" name="fileTokenList" id="fileTokenList">
                <input type="hidden" name="fileNameList" id="fileNameList">
                <input type="hidden" name="fileRegdateList" id="fileRegdateList">
                <input type="hidden" id="bbsPostNo" name="bbsPostNo" value="${bbsPostNo}">
                <div class="row-between textarea-wrap form-group border-0">
					<select class="select-boards" name="bbsNameSelect" id="bbsNameSelect" onchange="sendBbsName(this)">
					    <option value="">------------------------------------------------게시판선택------------------------------------------------</option>
					    <c:forEach var="cLi" items="${catList}">
					        <c:forEach var="bLi" items="${boardList}">
					            <c:if test="${cLi.catNo eq bLi.catNo}">
								<option value="${bLi.bbsNameForURL}"  ${bbsNameForURL eq bLi.bbsNameForURL ? 'selected' : ''} >[${cLi.catCode}]${cLi.catName} : ${bLi.bbsName}</option>					            </c:if>
					        </c:forEach>
					    <option value="">-----------------------------------------------------------------------------------------------------------</option>
					    </c:forEach>
					</select>
                    <div class="notice-check">
                        <label for="notice_check" class="notice_checkbox" >공지사항 등록</label>
                        <input name="postNotice" id="notice_check" class="notice_checkbox" type="checkbox">
                    </div>      
                </div>
                <div class="textarea-wrap form-group border">
                    <input class="textara-input form-text" name="postTitle" placeholder="제목을 입력해 주세요." value="${postingDTO.postTitle}"/>
                </div>
                
                 <div>
                    <textarea class="textarea-none" id="editor" name="postContents">${postingDTO.postContents}</textarea>
                 </div>
            </form>
        </fieldset>
        <!-- ./게시글 메인 : END-->
        <hr class="section-line">        

        <!-- 게시글 하단 : START -->
        <fieldset class="bbs-bottom">
            <!-- <hr class="section-line"> -->   
                <div class="textarea-wrap form-group border">
                    <input class="textara-input form-text" name="postTag" placeholder="#태그를 입력해 주세요."/>
                </div>            
        </fieldset>
        <!-- ./게시글 하단 : END -->

    </section>
    
    <!-- 현재 게시판목록 -->
    <section class="mt-5 ps-3 pe-3">
    	<fieldset class="bbs-headline mb-0 pb-0">
    		<div class="row-between  mb-0 pb-0 ms-2">
    			<h5>현재게시판 : ${bbsName}</h5>
    			<a href="${ctx}/bbs/${bbsNameForURL}">전체글 보기 ></a>
    		</div>
    	</fieldset>
    	<fieldset class="bbs-main">
	    	<div class="row-none">
	    		<table class="table table-hover">
	    			<tbody>
	    				<!-- 반복문처리 -->
	    				<tr>
	    					<td>129</td>
	    					<td>자바스크립트 에서 문서 로드할때 코드실행하는법</td>
	    					<td>아슬란</td>
	    					<td>23.06.07</td>
	    					<td>14</td>
	    				</tr>
	    				<!-- 반복문처리 -->
	    				<!-- 반복문처리 -->	    				
	    				<tr>
	    					<td>128</td>
	    					<td>컨트롤러에서 @Autowired할때...</td>
	    					<td>루시</td>
	    					<td>23.05.24</td>
	    					<td>19</td>
	    				</tr>
	    				<!-- 반복문처리 -->
	    				<!-- 반복문처리 -->	    				
	    				<tr>
	    					<td>127</td>
	    					<td>pom.xml 의존성 추가</td>
	    					<td>관리자</td>
	    					<td>23.05.11</td>
	    					<td>161</td>
	    				</tr>
	    				<!-- 반복문처리 -->
	    				<!-- 반복문처리 -->	    				
	    				<tr>
	    					<td>125</td>
	    					<td>서비스클래스의 비지니스 로직 구현 방법</td>
	    					<td>에드먼드</td>
	    					<td>23.05.05</td>
	    					<td>24</td>
	    				</tr>
	    				<!-- 반복문처리 -->
	    				<!-- 반복문처리 -->
	    				<tr>
	    					<td>124</td>
	    					<td>스프링 설치방법5 (마지막)</td>
	    					<td>관리자</td>
	    					<td>23.05.02</td>
	    					<td>23</td>
	    				</tr>
	    				<!-- 반복문처리 -->
	    				<!-- 반복문처리 -->
	    				<tr>
	    					<td>123</td>
	    					<td>스프링 설치방법4</td>
	    					<td>관리자</td>
	    					<td>23.05.01</td>
	    					<td>50</td>
	    				</tr>
	    				<!-- 반복문처리 -->
	    				<!-- 반복문처리 -->
	    				<tr>
	    					<td>122</td>
	    					<td>스프링 설치방법3</td>
	    					<td>관리자</td>
	    					<td>23.05.01</td>
	    					<td>47</td>
	    				</tr>
	    				<!-- 반복문처리 -->
	    				<!-- 반복문처리 -->
	    				<tr>
	    					<td>121</td>
	    					<td>스프링 설치방법2</td>
	    					<td>관리자</td>
	    					<td>23.05.01</td>
	    					<td>84</td>
	    				</tr>
	    				<!-- 반복문처리 -->
	    				<!-- 반복문처리 -->
	    				<tr>
	    					<td>120</td>
	    					<td>스프링 설치방법1</td>
	    					<td>관리자</td>
	    					<td>23.05.01</td>
	    					<td>110</td>
	    				</tr>
	    				<!-- 반복문처리 -->
	    			</tbody>
	    		</table>
	    	</div>
	    </fieldset>
	    <fieldset class="bbs-bottom">
            <div class="row-center">
                <ul class="pagingBlock pagination">                              
                    <c:if test="${bp.prevPage > 0}">
                      <li class="page-item"><!--이전 페이징 블럭이 0이하 일 경우, 이전 버튼 비활성화-->
                         <a class="page-link" href="webDevBoard_1.do?i=${bp.prevPage}&cntPerPage=${bp.cntPerPage}">
                             <i class="fa-solid fa-angle-left"></i>이전
                         </a>
                      </li>
                    </c:if>

                    <c:forEach var="i" begin="${bp.blockStart}" end="${bp.blockEnd}">	  
                        <li class="page-item ${bp.currentPage == i ? 'active':''}"><!-- 현재 페이지가 i일 경우 active(현재위치표시역할) -->
                            <a class="page-link" href="webDevBoard_1.do?i=${i}&cntPerPage=${bp.cntPerPage}">${i}</a><!-- i로 페이지 이동 -->
                        </li>
                    </c:forEach>

                    <c:if test="${bp.blockEnd < bp.totalPage}">
                        <li class="page-item"><!-- 전체게시글 수가 페이징 블럭의 끝번호 보다 작을 경우 disabled(버튼 비활성화) -->
                            <a class="page-link" href="webDevBoard_1.do?i=${bp.nextPage}&cntPerPage=${bp.cntPerPage}">
                                다음<i class="fa-solid fa-angle-right"></i>
                            </a>
                        </li>
                    </c:if>
                </ul> 
            </div>	    	
	    </fieldset>	
    </section>    
    <!-- 현재 게시판목록 -->
    
    
</div>
<!-- ./ 메인컨텐츠 : END-->