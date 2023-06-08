<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %> --%>
<!-- 메인컨텐츠 : START-->
<div class="main">
    <section class="bbs-area">
                    
	    <!-- 게시판 헤드 : START -->
	    <fieldset class="bbs-headline">
	        <div class="bbs-headline-row row-between">
	            <h6 class="bbs-title">테스트게시판</h6><!--타이틀명만 수정-->  
	            <form action="${ctx}/bbs/${bbsName}" method="POST" class="move-to-bbs-frm">
	                <input type="hidden" name="current_page" value="{bp.current_page}"/>
	                <input type="hidden" name="page_rows" value="{bp.page_rows}"/>
	                <input type="hidden" name="search_type" value="{bDto.search_type}"/>
	                <input type="hidden" name="keyword" value="{bDto.keyword}"/>
	                <input type="hidden" name="board_idx" value="{bDto.board_idx}"/>
	                <a class="">
	                    <i class="xi-view-list"></i>
	                    <span>목록</span>
	                </a>
	             </form>
	        </div>
	    </fields>
	    <!-- ./게시판 헤드 : END -->
                    
        <!-- 게시판 메인 : START-->
        <fieldset class="bbs-main">
            <h4>파일 입출력 처리 (2)</h4>
            <div class="row-between mt-4">
                <div class="row-left">
                    <div class="row-item profile-photo-frame">
                        <img src="${ctx}/resources/img/viewExample/kitty.jpg" class="profile-photo">
                    </div>
                    <div class="row-item">
                        <h6 class="writer-name">루시 페번시</h6>  
                        <p class="posting-regdate">
                            2023-06-02
                        </p>
                    </div>
                </div>
                <div class="row-right">
                    <span class="text-thin">조회 17</span>
                </div>
            </div>


            <div class="view-contents">
                <h2>repellat consequatur earum illum</h2>
                <br>
                <p> 
                    `Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Dolorem sapiente cupiditate possimus corporis dignissimos eos, 
                    quasi quod repellat. Dolores repellat consequatur earum illum voluptates 
                    aliquam eos magni libero recusandae minima?`
                </p>
                <br>
                <img src="${ctx}/resources/img/viewExample/CM_Keynote_Title.jpg" alt="" style="width: 850px;" class="text-xl-center">
                <p> 
                    `Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Dolorem sapiente cupiditate possimus corporis dignissimos eos, 
                    quasi quod repellat. Dolores repellat consequatur earum illum voluptates 
                    aliquam eos magni libero recusandae minima?`
                </p>
                <p> 
                    `Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Dolorem sapiente cupiditate possimus corporis dignissimos eos, 
                    quasi quod repellat. Dolores repellat consequatur earum illum voluptates 
                    aliquam eos magni libero recusandae minima?`
                </p>
                <p> 
                    `Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Dolorem sapiente cupiditate possimus corporis dignissimos eos, 
                    quasi quod repellat. Dolores repellat consequatur earum illum voluptates 
                    aliquam eos magni libero recusandae minima?`
                </p>
                <br>
                <br>
                <img src="${ctx}/resources/img/viewExample/some-banner.jpg" alt="" style="width: 650px; margin-right: 150px;" class="">
                <br>
                <br>
                <p> 
                    `Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Dolorem sapiente cupiditate possimus corporis dignissimos eos, 
                    quasi quod repellat. Dolores repellat consequatur earum illum voluptates 
                    aliquam eos magni libero recusandae minima?`
                </p>
                <p> 
                    `Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Dolorem sapiente cupiditate possimus corporis dignissimos eos, 
                    quasi quod repellat. Dolores repellat consequatur earum illum voluptates 
                    aliquam eos magni libero recusandae minima?`
                </p>
                <br>
                <br>
                <img src="${ctx}/resources/img/viewExample/banner_20.png" alt="" style="width: 850px;" class="text-xl-center">
                <br>
                <br>
                <p> 
                    `Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Dolorem sapiente cupiditate possimus corporis dignissimos eos, 
                    quasi quod repellat. Dolores repellat consequatur earum illum voluptates 
                    aliquam eos magni libero recusandae minima?`
                </p>
                <img src="${ctx}/resources/img/viewExample/cake.jpg" alt="" style="width: 850px;" class="text-xl-center">
                <br>
                <br>
                <p>possimus corporis dignissimos eos</p>
                <p>Dolores repellat consequatur earum illum voluptates</p>
                <p>
                    Dolorem sapiente cupiditate possimus corporis dignissimos eos, 
                    quasi quod repellat.  
                    aliquam eos magni libero recusandae minima?`
                </p>
            </div>
        </fieldset>
        <!-- ./게시판 메인 : END-->
                    
        <!-- 게시판 하단(댓글) : START -->
        <fieldset class="bbs-bottom">
            <ul class="reply-submit-box">
                <form action="boardViewPage.do" method="POST" class="replyFrm">
                    <h6>아슬란</h6>
                    <textarea id="reply_textarea" class="textarea-none reply-textarea" 
                    onkeyup="autoResize(this)" onkeydown="autoResize(this)" 
                    rows="1" placeholder="댓글을 남겨보세요"></textarea>
                    
                    <div class="row-between mb-0">
                        <div>
                            <a href=""><i class="reply-icon xi-camera-o"></i></a>
                            <a href=""><i class="reply-icon xi-emoticon-cool-o"></i></a>
                        </div>
                        <a onclick="">등록</a>
                    </div>
                </form>
            </ul>


            <div class="comment-container">
                <!-- 댓글헤드 -->
                <div class="comment-container-top row-between">
                    <div class="row-left">
                        
                        <span class="reply-text-bold">댓글 60 <i class="xi-message-o"></i></span>
                    </div>
                    <div class="row-right">
                        <a>
                            <span class="reply-text-sm">Like 128</span>
                            <i class="reply-text-icon xi-heart-o"></i>
                        </a>
                    </div>
                </div>
                <!-- 댓글헤드 -->
                <hr class="section-line">
                <!-- 댓글옵션 -->
                <div class="comment-option row-default">
                    <a>
                        <span class="reply-text">등록순</span>
                    </a>
                    <a>
                        <span class="reply-text-sm">최신순</span>
                    </a>
                </div>
                <!-- 댓글옵션 -->

                <!-- 댓글반복문 -->
                <ul class="comment-area">
                    <li class="comment-item row-default">
                        <div class="comment-writer-photo-frame row-left">
                            <a>
                                <img class="comment-writer-photo" src="${ctx}/resources/img/viewExample/aslan.jpg" alt="">
                            </a>
                        </div>
                        <div class="comment-box row-right">
                            <div class="comment-writer-box">
                                <a>
                                    <h6>아슬란</h6>
                                </a>
                            </div>
                            <div class="comment-text-box">
                                <p>
                                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                                </p>
                            </div>
                            <div class="comment-info-box">
                                <span>2023-05-28 13:27</span>
                                <a>답글쓰기</a>
                            </div>
                        </div>
                    </li>
                    <div class="comment-tool">
                        <a class="comment-tool-link">
                            <i class="comment-tool-icon xi-ellipsis-v"></i>
                        </a>
                        <ul class="comment-tool-more">
                            <li class="comment-tool-more-item">
                                <a href="">수정</a> 
                            </li>
                            <li class="comment-tool-more-item">
                                <a href="">삭제</a> 
                            </li>
                        </ul>
                    </div>
                </ul>
                <!-- 댓글반복문 -->
               <!-- 댓글반복문 -->
               <ul class="comment-area">
                   <li class="comment-item row-default">
                       <div class="comment-writer-photo-frame row-left">
                           <a>
                               <img class="comment-writer-photo" src="${ctx}/resources/img/viewExample/kitty.jpg" alt="" >
                           </a>
                       </div>
                       <div class="comment-box row-right">
                           <div class="comment-writer-box">
                               <a>
                                   <h6>루시</h6>
                               </a>
                           </div>
                           <div class="comment-text-box">
                               <p>
                                   Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                               </p>
                               <img class="comment-contents-photo" src="${ctx}/resources/img/viewExample/kitty-cute.gif" alt="">
                           </div>
                           <div class="comment-info-box">
                               <span>2023-05-28 13:55</span>
                               <a>답글쓰기</a>
                           </div>
                       </div>
                   </li>
                   <div class="comment-tool">
                       <a class="comment-tool-link">
                           <i class="comment-tool-icon xi-ellipsis-v"></i>
                       </a>
                   </div>
               </ul>
               <!-- 댓글반복문 -->
               <!-- 댓글반복문 -->
               <ul class="comment-area">
                   <li class="comment-item row-default">
                       <div class="comment-writer-photo-frame row-left">
                           <a>
                               <img class="comment-writer-photo" src="${ctx}/resources/img/viewExample/sample.jpg" alt="" >
                           </a>
                       </div>
                       <div class="comment-box row-right">
                           <div class="comment-writer-box">
                               <a>
                                   <h6>관리자</h6>
                               </a>
                           </div>
                           <div class="comment-text-box">
                               <p>
                                   Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                                   Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                                   Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                               </p>
                           </div>
                           <div class="comment-info-box">
                               <span>2023-05-28 14:11</span>
                               <a>답글쓰기</a>
                           </div>
                       </div>
                   </li>
                   <div class="comment-tool">
                       <a class="comment-tool-link">
                           <i class="comment-tool-icon xi-ellipsis-v"></i>
                       </a>
                   </div>
               </ul>
               <!-- 댓글반복문 -->
               <!-- 대댓글 예시 반복 -->
               <ul class="comment-area--rep">
                   <li class="comment-item--rep row-default">
                       <div class="comment-writer-photo-frame row-left">
                           <a>
                               <img class="comment-writer-photo" src="${ctx}/resources/img/viewExample/micky.jpg" alt="" >
                           </a>
                       </div>
                       <div class="comment-box row-right">
                           <div class="comment-writer-box">
                               <a>
                                   <h6>미키 마우스</h6>
                               </a>
                           </div>
                           <div class="comment-text-box">
                               <p>
                                   Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                                   Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                                   Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                                   Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                                   Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                                   Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                                   Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque, aliquid. Laudantium dolor quia, repellat delectus nihil quis dolores alias numquam ratione quisquam, quo non consequuntur deleniti mollitia soluta quibusdam autem.
                               </p>
                           </div>
                           <div class="comment-info-box">
                               <span>2023-05-28 16:31</span>
                               <a>답글쓰기</a>
                           </div>
                       </div>
                   </li>
                   <div class="comment-tool">
                       <a class="comment-tool-link">
                           <i class="comment-tool-icon xi-ellipsis-v"></i>
                       </a>
                   </div>
				</ul>
                <!-- 대댓글 예시 반복 -->
                <!-- 대댓글 예시 반복 -->
                <ul class="comment-area--rep">
                    <li class="comment-item--rep row-default">
                        <div class="comment-writer-photo-frame row-left">
                            <a>
                                <img class="comment-writer-photo" src="${ctx}/resources/img/viewExample/sailormoon.jpg" alt="" >
                            </a>
                        </div>
                        <div class="comment-box row-right">
                            <div class="comment-writer-box">
                                <a>
                                    <h6>Mooon</h6>
                                </a>
                            </div>
                            <div class="comment-text-box">
                                <img class="comment-contents-photo" src="${ctx}/resources/img/viewExample/wow.gif" alt="">
                                <p>
                                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                </p>
                            </div>
                            <div class="comment-info-box">
                                <span>2023-05-28 18:55</span>
                                <a>답글쓰기</a>
                            </div>
                        </div>
                    </li>
                    <div class="comment-tool">
                        <a class="comment-tool-link">
                            <i class="comment-tool-icon xi-ellipsis-v"></i>
                        </a>
                    </div>
                </ul>
                <!-- 대댓글 예시 반복 -->
                <!-- 대댓글 예시 반복 -->
                <ul class="comment-area--rep">
                    <li class="comment-item--rep row-default">
                        <div class="comment-writer-photo-frame row-left">
                            <a>
                                <img class="comment-writer-photo" src="${ctx}/resources/img/viewExample/bambi.jpg" alt="" >
                            </a>
                        </div>
                        <div class="comment-box row-right">
                            <div class="comment-writer-box">
                                <h6>BAAAMbi</h6>
                            </div>
                            <div class="comment-text-box">
                                <a>
                                    <img class="comment-contents-emoticon" src="${ctx}/resources/img/viewExample/emoji1.gif" alt="">
                                </a>
                            </div>
                            <div class="comment-info-box">
                                <span>2023-05-29 00:55</span>
                                <a>답글쓰기</a>
                            </div>
                        </div>
                    </li>
                    <li class="comment-tool">
                        <a class="comment-tool-link">
                            <i class="comment-tool-icon xi-ellipsis-v"></i>
                        </a>
                    </li>
                </ul>
                <!-- 대댓글 예시 반복 -->
                <!-- 대댓글 예시 반복 -->
                <ul class="comment-area--rep">
                    <li class="comment-item--rep row-default">
                        <div class="comment-writer-photo-frame row-left">
                            <a>
                                <img class="comment-writer-photo" src="${ctx}/resources/img/viewExample/bukki.png" alt="" >
                            </a>
                        </div>
                        <div class="comment-box row-right">
                            <div class="comment-writer-box">
                                <h6>BUUUkkI's</h6>
                            </div>
                            <div class="comment-text-box">
                                <a>
                                    <img class="comment-contents-emoticon" src="${ctx}/resources/img/viewExample/emoji5.gif" alt="">
                                </a>
                            </div>
                            <div class="comment-info-box">
                                <span>2023-05-29 01:03</span>
                                <a>답글쓰기</a>
                            </div>
                        </div>
                    </li>
                    <li class="comment-tool">
                        <a class="comment-tool-link">
                            <i class="comment-tool-icon xi-ellipsis-v"></i>
                        </a>
                    </li>
                </ul>
                <!-- 대댓글 예시 반복 -->
                <!-- 댓글반복문 -->
                <ul class="comment-area">
                    <li class="comment-item row-default">
                        <div class="comment-writer-photo-frame row-left">
                            <a>
                                <img class="comment-writer-photo" src="${ctx}/resources/img/viewExample/hamtorry.jpg" alt="" >
                            </a>
                        </div>
                        <div class="comment-box row-right">
                            <div class="comment-writer-box mb-1">
                                <a>
                                    <h6>토리다햄햄</h6>
                                </a>
                            </div>
                            <div class="comment-text-box">
                                <p>
                                    quis dolores alias numquam ratione quisquam
                                </p>
                                <img class="comment-contents-photo" src="${ctx}/resources/img/viewExample/Emoji6hamJoy.gif" alt="">
                                <p>
                                    tium dolor quia, repellat delectus nihil quo non conusdam autem.
                                    em ipsum dolor 
                                </p>
                            </div>
                            <div class="comment-info-box">
                                <span>2023-05-28 18:35</span>
                                <a>답글쓰기</a>
                            </div>
                        </div>
                    </li>
                    <li class="comment-tool">
                        <a class="comment-tool-link">
                            <i class="comment-tool-icon xi-ellipsis-v"></i>
                        </a>
                    </li>
				</ul>
                <!-- 대댓글작성박스 -->
                <ul class="reply-submit-box--rep">
                    <form action="boardViewPage.do" method="POST" class="replyFrm--rep">
                        <h6>아슬란</h6>
                        <textarea id="reply_textarea" class="textarea-none reply-textarea" 
                        onkeyup="autoResize(this)" onkeydown="autoResize(this)" 
                        rows="1" placeholder="댓글을 남겨보세요"></textarea>
                        
                        <div class="row-between mb-0">
                            <div>
                                <a href=""><i class="reply-icon xi-camera-o"></i></a>
                                <a href=""><i class="reply-icon xi-emoticon-cool-o"></i></a>
                            </div>
                            <a onclick="">등록</a>
                        </div>
                    </form>
                </ul>
                <!-- 대댓글작성박스 -->                                
                <!-- 댓글반복문 -->       
                <!-- 대댓글 예시 반복 -->
                <ul class="comment-area--rep">
                    <li class="comment-item--rep row-default">
                        <div class="row-left me-3">
                            <a>
                                <img src="${ctx}/resources/img/viewExample/ribon2.jpg" alt="" style="width: 35px; height: 35px; border: 1px solid #e2e6ee; border-radius: 50%;">
                            </a>
                        </div>
                        <div class="row-right">
                            <div class="comment-writer-box--rep mb-1">
                                <a>
                                    <h6>리본햄찌</h6>
                                </a>
                            </div>
                            <div class="comment-text-box--rep">
                                <p>
                                    sit amet consectetur adipisicinoluta autem.
                                </p>
                                <img src="${ctx}/resources/img/viewExample/emoji3.gif" alt="" style="width: 100px;">
                            </div>
                            <div class="comment-info-box--rep mt-2">
                                <span>2023-05-29 01:03</span>
                                <a>답글쓰기</a>
                            </div>
                        </div>
                        <li class="comment-tool">
                            <a class="comment-tool-link">
                                <i class="comment-tool-icon xi-ellipsis-v"></i>
                            </a>
                        </li>
                    </li>
                </ul>
                <!-- 대댓글 예시 반복 -->
                <!-- 댓글반복문 -->
                <ul class="comment-area">
                    <li class="comment-item row-default">
                        <div class="row-left me-3">
                            <a>
                                <img src="${ctx}/resources/img/viewExample/sample.jpg" alt="" style="width: 35px; height: 35px; border: 1px solid #e2e6ee; border-radius: 50%;">
                            </a>
                        </div>
                        <div class="row-right">
                            <div class="comment-writer-box mb-1">
                                <a>
                                    <h6>관리자</h6>
                                </a>
                            </div>
                            <div class="comment-text-box">
                                <p>
                                    lor amet contur adipisicinaliquid Laudaem.
                                </p>
                                <img src="${ctx}/resources/img/viewExample/emoji5.gif" alt="" style="width: 100px;">
                            </div>
                            <div class="comment-info-box mt-2">
                                <span>2023-05-28 13:27</span>
                                <a>답글쓰기</a>
                            </div>
                        </div>
                    </li>
                    <li class="comment-tool">
                        <a class="comment-tool-link">
                            <i class="comment-tool-icon xi-ellipsis-v"></i>
                        </a>
                    </li>
                </ul>                                                                
			</div>
		</fieldset>
        <!-- ./게시판 하단 : END -->                 
	</section>

    <!-- 게시글 하단 링크모음 -->
    <section class="bbs-link-area">
        <fieldset>                            
            <div class="row-between">
                <div class="row-left">
                    <button class="row-item btn btn-outline-dark"><i class="xi-pen"></i> 글쓰기</button>
                </div>
                <div class="row-right">
                    <button type="button" class="row-item btn btn-outline-success">수정</button>
                    <button type="button" class="row-item btn btn-outline-danger m-0" onclick="javascript:document.delPosting.submit();">삭제</button>
                </div>
            </div>                               
        </fieldset>
    </section>

    </section>
    <!-- 현재 게시판목록 -->
    <section class="mt-5 ps-3 pe-3">
    	<fieldset class="bbs-headline mb-0 pb-0">
    		<div class="row-between  mb-0 pb-0 ms-2">
    			<h5>현재게시판 : ${bbsName}</h5>
    			<a href="${ctx}/bbs/${bbsName}">전체글 보기 ></a>
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
    <!-- ./ 현재 게시판목록 : END-->
    
    
</div>
<!-- ./ 메인컨텐츠 : END-->