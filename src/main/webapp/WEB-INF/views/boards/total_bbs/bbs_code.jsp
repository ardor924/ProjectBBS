<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>
<!-- 메인컨텐츠 : START-->
<div class="main">
    <section class="bbs-area">

         <!-- 게시판 헤드 -->
        <fieldset class="bbs-headline">
            <div class="row-between">
                <h2 class="bbs-title">전체 게시글 보기</h2><!--타이틀명만 수정-->  
                <div class="post-search">
                    <form class="post-search-frm" action="getPostListFromDB.do" method="POST">
                        <select class="search-option form-select" >
                            <option value="none">선택</option>
                            <option value="postTitle">제목</option>
                            <option value="postContents">내용</option>
                            <option value="postWriter">글쓴이</option>
                        </select>
                        <input type="text" name="keyword" id="keyword" class="search-input form-control rounded-0 rounded-start" placeholder="검색어를 입력 하세요">
                        <button class="btn btn-primary search-btn btn-lg rounded-0 rounded-end">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                </div>
            </div>   


        </fieldset>

        <!-- 게시판 메인 -->
        <fieldset class="bbs-main">
            <hr class="section-line">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>게시판명</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>작성일</th>
                    </tr>
                </thead>
                <tbody>
                	<c:if test="${totalPostingList == null || totalPostingList eq null}">
                	<tr>
                		<td>
                			<h2>현재 게시판에 게시글이 없습니다.</h2>
                		</td>
                	</tr>	
                	</c:if>
					<!-- 반복문 적용 -->
                    <c:forEach var="li" items="${totalPostingList}">
                    <tr>
                        <td>${li.bbsNo}</td>
                       	<c:forEach var="bli" items="${boardList}">
                        <c:if test="${bli.bbsNo == li.bbsNo}">
                        <td>${bli.bbsName}</td>
                        <td>
                            <a href="${ctx}/bbs/${bli.bbsNameForURL}/${li.bbsPostNo}" class="post-link">${li.postTitle}</a>
                        	</c:if>
                        	</c:forEach>
                        </td>
                        <td>${li.postWriter}</td>
                        <td>${li.postHit}</td>
                        <td>
                        <c:choose>
	                        <c:when test="${regDateIsToday}">
	                        	<fmt:formatDate value="${li.postRegdate}" pattern="HH:mm" type="date"/>
	                        </c:when>
	                        <c:otherwise>
	                        	<fmt:formatDate value="${li.postRegdate}" pattern="yyyy.MM.dd" type="date"/>
	                        </c:otherwise>
                        </c:choose>
						</td>
                    </tr>
                    </c:forEach>
                    <!-- 반복문 적용 -->                 
                </tbody>
            </table>
        </fieldset>
        <!-- 게시판 메인 -->
        <fieldset class="bbs-bottom">
            <hr class="section-line">
            <div class="row-between">
                <div class="bbs-bottom-left">
                    <select class="form-select" name="" id="">
                        <option value="none" selected>선택</option>
                        <option value="10">10개씩</option>
                        <option value="15">15개씩</option>
                        <option value="20">20개씩</option>
                    </select>
                </div>
                <div class="bbs-bottom-right">
                    <button class="btn btn-outline-warning">더미데이터</button>
                    <button class="btn btn-outline-secondary">목록</button>
                    <c:choose>
                    <c:when test="${isLogin == null}">
                    	<a class="btn btn-primary" onclick="javascript:alert('글쓰기 기능을 사용하기 위해서는 로그인이 필요합니다.')">글쓰기</a>                            
                    </c:when>
                    <c:otherwise>                           
                    	<a href="${ctx}/bbs/${bbsNameForURL}/write-page"class="btn btn-primary">글쓰기</a>
                    </c:otherwise>
                    </c:choose>                    
                </div>
            </div>
            <div class="row-center">
                <ul class="pagingBlock pagination">                              
<%--                     <c:if test="${bp.prevPage > 0}">
                      <li class="page-item"><!--이전 페이징 블럭이 0이하 일 경우, 이전 버튼 비활성화-->
                         <a class="page-link" href="webDevBoard_1.do?i=${bp.prevPage}&cntPerPage=${bp.cntPerPage}">
                             <i class="fa-solid fa-angle-left"></i>이전
                         </a>
                      </li>
                    </c:if> --%>

                    <c:forEach var="i" begin="${bp.blockStartPage}" end="${bp.blockEndPage}">	  
                        <li class="page-item ${bp.currentPage == i ? 'active':''}"><!-- 현재 페이지가 i일 경우 active(현재위치표시역할) -->
                            <a class="page-link" href="">${i}</a>
                        </li>
                    </c:forEach>

<%--                     <c:if test="${bp.blockEnd < bp.totalPage}">
                        <li class="page-item"><!-- 전체게시글 수가 페이징 블럭의 끝번호 보다 작을 경우 disabled(버튼 비활성화) -->
                            <a class="page-link" href="webDevBoard_1.do?i=${bp.nextPage}&cntPerPage=${bp.cntPerPage}">
                                다음<i class="fa-solid fa-angle-right"></i>
                            </a>
                        </li>
                    </c:if> --%>
                </ul> 
            </div>
        </fieldset>

    </section>
</div>
<!-- ./ 메인컨텐츠 : END-->