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
                    <form class="post-search-frm" id="searchForm" method="POST">
                        <select class="search-option form-select" id="searchTarget" name="searchTarget">
                            <option value="none">선택</option>
                            <option value="TITLE">제목</option>
                            <option value="CONTENTS">내용</option>
                            <option value="WRITER">글쓴이</option>
                        </select>
                        <input type="text" name="keyWord" id="keyWord" class="search-input form-control rounded-0 rounded-start" placeholder="검색어를 입력 하세요">
                        <button class="btn btn-primary search-btn btn-lg rounded-0 rounded-end" onclick="submitFormWithOptionForSearchBar('searchForm','event')">
                            <i class="fa fa-search"></i>
                        </button>
                        <!-- 전송용 공통 파라미터 -->
						<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? currentPage : ''}">
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
	                    <c:choose>
	                    	<c:when test="${orderBy eq 'IDX_ASC'}">
	                        	<th scope="col">
	                        		<form method="POST" id="IDX_DESC-orderForm">
										<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? bp.currentPage : ''}">
										<input type="hidden" name="pageRows" value="${pageRows ne null ? pageRows : ''}">    	                        		
										<input type="hidden" name="searchTarget" value="${searchTarget ne null ? searchTarget : ''}">
										<input type="hidden" name="keyWord" value="${keyWord ne null ? keyWord : ''}">    											
										<input type="hidden" name="orderBy" value="${orderBy eq 'IDX_DESC' ? 'IDX_ASC' : 'IDX_DESC'}">	
										<a onclick="submitFormWithOptionForCommon('IDX_DESC-orderForm','orderBy','event')">번호</a>
										<i class='fa-solid fa-sort-up'></i>									                      			
	                        		</form>
	                        	</th>
	                    	</c:when>
	                    	<c:otherwise>
	                         	<th scope="col">
	                        		<form method="POST" id="IDX_ASC-orderForm">
										<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? bp.currentPage : ''}">
										<input type="hidden" name="pageRows" value="${pageRows ne null ? pageRows : ''}">    	                        		
										<input type="hidden" name="searchTarget" value="${searchTarget ne null ? searchTarget : ''}">
										<input type="hidden" name="keyWord" value="${keyWord ne null ? keyWord : ''}">    											
										<input type="hidden" name="orderBy" value="${orderBy eq 'IDX_DESC' ? 'IDX_ASC' : 'IDX_DESC'}">	
										<a onclick="submitFormWithOptionForCommon('IDX_ASC-orderForm','orderBy','event')">번호</a>
										<i class='fa-solid fa-sort-down'></i>									                      			
	                        		</form>
	                        	</th>                   		
	                    	</c:otherwise>
	                    </c:choose>
                        <th>게시판이름</th>
                        <th>제목</th>
                        <th>작성자</th>
	                    <c:choose>
	                    	<c:when test="${orderBy eq 'HIT_ASC'}">
	                        	<th scope="col">
	                        		<form method="POST" id="HIT_DESC-orderForm">
										<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? bp.currentPage : ''}">
										<input type="hidden" name="pageRows" value="${pageRows ne null ? pageRows : ''}">    	                        		
										<input type="hidden" name="searchTarget" value="${searchTarget ne null ? searchTarget : ''}">
										<input type="hidden" name="keyWord" value="${keyWord ne null ? keyWord : ''}">    											
										<input type="hidden" name="orderBy" value="HIT_DESC">	
										<a onclick="submitFormWithOptionForCommon('HIT_DESC-orderForm','orderBy','event')">조회수</a>
										<i class='fa-solid fa-sort-up'></i>									                      			
	                        		</form>
	                        	</th>
	                    	</c:when>
	                    	<c:otherwise>
	                         	<th scope="col">
	                        		<form method="POST" id="HIT_ASC-orderForm">
										<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? bp.currentPage : ''}">
										<input type="hidden" name="pageRows" value="${pageRows ne null ? pageRows : ''}">    	                        		
										<input type="hidden" name="searchTarget" value="${searchTarget ne null ? searchTarget : ''}">
										<input type="hidden" name="keyWord" value="${keyWord ne null ? keyWord : ''}">    											
										<input type="hidden" name="orderBy" value="HIT_ASC">	
										<a onclick="submitFormWithOptionForCommon('HIT_ASC-orderForm','orderBy','event')">조회수</a>
										<i class='fa-solid fa-sort-down'></i>									                      			
	                        		</form>
	                        	</th>                   		
	                    	</c:otherwise>
	                    </c:choose>				
 	                    <c:choose>
	                    	<c:when test="${orderBy eq 'REGDATE_ASC'}">
	                        	<th scope="col">
	                        		<form method="POST" id="REGDATE_DESC-orderForm">
										<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? bp.currentPage : ''}">
										<input type="hidden" name="pageRows" value="${pageRows ne null ? pageRows : ''}">    	                        		
										<input type="hidden" name="searchTarget" value="${searchTarget ne null ? searchTarget : ''}">
										<input type="hidden" name="keyWord" value="${keyWord ne null ? keyWord : ''}">    											
										<input type="hidden" name="orderBy" value="REGDATE_DESC">	
										<a onclick="submitFormWithOptionForCommon('REGDATE_DESC-orderForm','orderBy','event')">작성일</a>
										<i class='fa-solid fa-sort-up'></i>									                      			
	                        		</form>
	                    	</c:when>
	                    	<c:otherwise>
	                         	<th scope="col">
	                        		<form method="POST" id="REGDATE_ASC-orderForm">
										<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? bp.currentPage : ''}">
										<input type="hidden" name="pageRows" value="${pageRows ne null ? pageRows : ''}">    	                        		
										<input type="hidden" name="searchTarget" value="${searchTarget ne null ? searchTarget : ''}">
										<input type="hidden" name="keyWord" value="${keyWord ne null ? keyWord : ''}">    											
										<input type="hidden" name="orderBy" value="REGDATE_ASC">	
										<a onclick="submitFormWithOptionForCommon('REGDATE_ASC-orderForm','orderBy','event')">작성일</a>
										<i class='fa-solid fa-sort-down'></i>									                      			
	                        		</form>
	                        	</th>                   		
	                    	</c:otherwise>
	                    </c:choose>                       
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
                        <td>${li.postNo}</td>
                       	<c:forEach var="bli" items="${boardList}">
                        <c:if test="${bli.bbsNo == li.bbsNo}">
                        <td>${bli.bbsName}</td>
                        <td>
                        	<form action="${ctx}/bbs/${bli.bbsNameForURL}/${li.bbsPostNo}" id="goViewForm${li.bbsPostNo}" method="POST">
                            	<a class="post-link" onclick="document.getElementById('goViewForm${li.bbsPostNo}').submit();">${li.postTitle}</a>
								<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? bp.currentPage : ''}">
								<input type="hidden" name="pageRows" value="${pageRows ne null ? pageRows : ''}">   
								<input type="hidden" name="orderBy" value="${orderBy ne null ? orderBy : ''}">
								<input type="hidden" name="searchTarget" value="${searchTarget ne null ? searchTarget : ''}">
								<input type="hidden" name="keyWord" value="${keyWord ne null ? keyWord : ''}">                                	
                        	</form>
                        </td>
                        </c:if>
                        </c:forEach>
                        <td>${li.postWriterName}</td>
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
					<form id="pageRowsForm" method="POST">
						<select class="form-select" id="pageRows" name="pageRows" onchange="submitFormWithOptionForCommon('pageRowsForm','event')">
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
                    <button class="btn btn-outline-warning">더미데이터</button>
                    <button class="btn btn-outline-secondary">목록</button>
                    <c:choose>
                    <c:when test="${isLogin == null}">
                    	<a class="btn btn-primary" onclick="javascript:alert('글쓰기 기능을 사용하기 위해서는 로그인이 필요합니다.')">글쓰기</a>                            
                    </c:when>
                    <c:otherwise>                           
                    	<a href="${ctx}/bbs/total/write-page"class="btn btn-primary">글쓰기</a>
                    </c:otherwise>
                    </c:choose>                    
                </div>
            </div>
            <div class="row-center">
				<ul class="pagingBlock pagination">
				    <c:if test="${bp.blockPrevPage > 0}">
				        <li class="page-item">
				        	<form action="${ctx}/bbs/${bbsNameForURL}" id="prevCurrentPageFrm" method="POST">
								<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? bp.blockPrevPage : ''}">			            	
								<input type="hidden" name="pageRows" value="${pageRows ne null ? pageRows : ''}">   				            	
								<input type="hidden" name="orderBy" value="${orderBy ne null ? orderBy : ''}">
								<input type="hidden" name="searchTarget" value="${searchTarget ne null ? searchTarget : ''}">
								<input type="hidden" name="keyWord" value="${keyWord ne null ? keyWord : ''}">    	
				            	<a class="page-link" onclick="submitFormWithOptionForCommon('prevCurrentPageFrm${i}','event')">
				            		<i class="fa-solid fa-angle-left"></i>이전
				            	</a>
				        	</form>
				        </li>
				    </c:if>
				
				    <c:forEach var="i" begin="${bp.blockStartPage}" end="${bp.blockEndPage}">
				        <li class="page-item ${bp.currentPage == i ? 'active':''}">
				        	<form action="${ctx}/bbs/${bbsNameForURL}" id="moveCurrentPageFrm${i}" method="POST">
								<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? i : ''}">			            	
								<input type="hidden" name="pageRows" value="${pageRows ne null ? pageRows : ''}">   				            	
								<input type="hidden" name="orderBy" value="${orderBy ne null ? orderBy : ''}">
								<input type="hidden" name="searchTarget" value="${searchTarget ne null ? searchTarget : ''}">
								<input type="hidden" name="keyWord" value="${keyWord ne null ? keyWord : ''}">    	
				            	<a class="page-link" onclick="submitFormWithOptionForCommon('moveCurrentPageFrm${i}','event')">${i}</a>
				        	</form>
				        </li>
				    </c:forEach>
				
				    <c:if test="${bp.blockEndPage < bp.totalPage}">
				        <li class="page-item">
				        	<form action="${ctx}/bbs/${bbsNameForURL}" id="nextCurrentPageFrm${i}" method="POST">
								<input type="hidden" name="currentPage" value="${bp.currentPage ne null ? bp.blockNextPage : ''}">			            	
								<input type="hidden" name="pageRows" value="${pageRows ne null ? pageRows : ''}">   				            	
								<input type="hidden" name="orderBy" value="${orderBy ne null ? orderBy : ''}">
								<input type="hidden" name="searchTarget" value="${searchTarget ne null ? searchTarget : ''}">
								<input type="hidden" name="keyWord" value="${keyWord ne null ? keyWord : ''}">    	
				            	<a class="page-link" onclick="submitFormWithOptionForCommon('nextCurrentPageFrm${i}','event')">
									다음<i class="fa-solid fa-angle-right"></i>
								</a>
				        	</form>
				        </li>
				    </c:if>
				</ul>
            </div>
        </fieldset>

    </section>
</div>
<!-- ./ 메인컨텐츠 : END-->