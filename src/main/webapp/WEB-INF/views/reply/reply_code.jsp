<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ include file="/WEB-INF/views/template/layout/html_top.jsp" %> --%>
<!-- 댓글영역 -->
	<section class="reply-area">
        <!-- 게시글 하단(댓글) : START -->
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
<!-- 댓글영역 -->