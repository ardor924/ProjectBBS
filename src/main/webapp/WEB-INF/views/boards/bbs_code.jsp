<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %>
<!-- 메인컨텐츠 : START-->
<div class="main">
    <section class="bbs-area">

         <!-- 게시판 헤드 -->
        <fieldset class="bbs-headline">
            <div class="row-between">
                <h2 class="bbs-title">${bbsName}</h2><!--타이틀명만 수정-->  
                <div class="post-search">
                    <form class="post-search-frm" id="searchForm">
                        <select class="search-option form-select" name="searchTarget">
                            <option value="none">선택</option>
                            <option value="postTitle">제목</option>
                            <option value="postContents">내용</option>
                            <option value="postWriter">글쓴이</option>
                        </select>
                        <input type="text" name="keyWord" id="keyWord" class="search-input form-control rounded-0 rounded-start" placeholder="검색어를 입력 하세요">
                        <button class="btn btn-primary search-btn btn-lg rounded-0 rounded-end" onclick="submitFormWithOption('searchForm','keyWord')">
                            <i class="fa fa-search"></i>
                        </button>
                        <!-- 전송용 공통 파라미터 -->
						<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? bp.currentPage : ''}">
						<input type="hidden" name="pageRows" value="${pageRows ne null ? pageRows : ''}">    		            
						<input type="hidden" name="orderBy" value="${orderBy ne null ? orderBy : ''}">	                        
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
                        <th>제목</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>작성일</th>
                    </tr>
                </thead>
                <tbody>
                	<c:if test="${postList == null || postList eq null}">
                	<tr>
                		<td>
                			<h2>현재 게시판에 게시글이 없습니다.</h2>
                		</td>
                	</tr>	
                	</c:if>
					<!-- 반복문 적용 -->
                    <c:forEach var="li" items="${postList}">
                    <tr>
                        <td>${li.bbsPostNo}</td>
                        <td>
                            <a href="${ctx}/bbs/${bbsNameForURL}/${li.bbsPostNo}" class="post-link">${li.postTitle}</a>
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
        <!-- 게시판 하단 -->
        <fieldset class="bbs-bottom">
            <hr class="section-line">
            <div class="row-between">
                <div class="bbs-bottom-left">
					<form action="" id="pageRowsForm" method="POST">
						<select class="form-select" id="pageRows" name="pageRows" onchange="submitFormWithOption('pageRowsForm','pageRows')">
						    <option value="10" ${bp.pageRows eq 10 ? 'selected' : ''}>10개씩</option>
						    <option value="15" ${bp.pageRows eq 15 ? 'selected' : ''}>15개씩</option>
						    <option value="20" ${bp.pageRows eq 20 ? 'selected' : ''}>20개씩</option>
						</select>
						<!-- 전송용 공통 파라미터 -->
						<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? bp.currentPage : ''}">
						<input type="hidden" name="orderBy" value="${orderBy ne null ? orderBy : ''}">
						<input type="hidden" name="searchTarget" value="${searchTarget ne null ? searchTarget : ''}">
						<input type="hidden" name="keyWord" value="${keyWord ne null ? keyWord : ''}">    							
					</form>				                      	               		
                </div>
                <div class="bbs-bottom-right">
                    <a href="${ctx}/bbs/SpringWeb/dummy" class="btn btn-outline-warning">더미데이터</a>
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
				    <c:if test="${bp.blockPrevPage > 0}">
				        <li class="page-item">
				            <c:set var="prevPageLink" value="${ctx}/bbs/${bbsNameForURL}?currentPage=${bp.blockPrevPage}&pageRows=${bp.pageRows}&orderBy=${orderBy}"/>
				            <a class="page-link" href="${prevPageLink}">
				                <i class="fa-solid fa-angle-left"></i>이전
				            </a>
				        </li>
				    </c:if>
				
				    <c:forEach var="i" begin="${bp.blockStartPage}" end="${bp.blockEndPage}">
				        <c:set var="currentPageLink" value="${ctx}/bbs/${bbsNameForURL}?currentPage=${i}&pageRows=${bp.pageRows}&orderBy=${orderBy}"/>
				        <li class="page-item ${bp.currentPage == i ? 'active':''}">
				            <a class="page-link" href="${currentPageLink}">${i}</a>
				        </li>
				    </c:forEach>
				
				    <c:if test="${bp.blockEndPage < bp.totalPage}">
				        <c:set var="nextPageLink" value="${ctx}/bbs/${bbsNameForURL}?currentPage=${bp.blockNextPage}&pageRows=${bp.pageRows}&orderBy=${orderBy}"/>
				        <li class="page-item">
				            <a class="page-link" href="${nextPageLink}">
				                다음<i class="fa-solid fa-angle-right"></i>
				            </a>
				        </li>
				    </c:if>
				</ul>
            </div>
        </fieldset>

    </section>
</div>
<!-- ./ 메인컨텐츠 : END-->