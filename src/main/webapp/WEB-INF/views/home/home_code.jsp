<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 메인컨텐츠 : START-->
<div class="main">
    <!-- 배너1 -->
    <section class="banner-area1 row-none mt-0 border">
        <div class="main-banner-frame">
            <img class="main-banner-image" src="${ctx}/resources/img/main-banner.png" alt="메인배너"/>
            <p class="main-banner-text">--대문 샘플--</p>
        </div>
    </section>

    <!-- 배너2 -->                    
    <section class="banner-area2 row-between">
        <div class="main-banner-frame border">
            <img class="main-banner-image" src="${ctx}/resources/img/some-banner.jpg" alt="더미이미지"/>
        </div>
        <div class="main-banner-frame border flex-grow-1 flex-column">
            <div class="site-link">
                <img src="${ctx}/resources/img/site-link.jpg" alt="사이트링크jpg" class="site-link-image">
            </div>
            <a href="#link_1" class="banner-link bg-warning">링크1 : 깃헙</a>
            <a href="#link_2" class="banner-link bg-success">링크2 : 포트폴리오사이트</a>
            <a href="#link_3" class="banner-link bg-primary">링크3 : AI-Chat 사이트</a>
            <a href="#link_4" class="banner-link bg-danger">링크4 : 팀프로젝트</a>
            <a href="#link_5" class="banner-link bg-secondary">링크5 : 코드업/백준 사이트</a>
            <a href="#link_6" class="banner-link bg-info">링크6 : 스택 오버플로우</a>
        </div>
    </section>

    <!-- 게시판 프리뷰 -->
    <section class="bbs-area row-between">
        <!-- 게시판 미리보기 1 -->
        <table class="bbs-preview table table-hover border">
            <thead>
                <tr>
                    <th scope="col" colspan="4">전체글 보기</th>
                    <th><a href="#" class="fw-light">더보기 ></a></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>프리뷰1</td>
                    <td>관리자</td>
                    <td>23.04.02 14:42</td>
                    <td>15</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>프리뷰2</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>8</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>프리뷰3</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>8</td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>프리뷰4</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>8</td>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>프리뷰5</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>8</td>
                </tr>
                <tr>
                    <th scope="row">6</th>
                    <td>프리뷰6</td>
                    <td>관리자</td>
                    <td>23.04.02 14:42</td>
                    <td>15</td>
                </tr>
                <tr>
                    <th scope="row">7</th>
                    <td>프리뷰7</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>458</td>
                </tr>
                <tr>
                    <th scope="row">8</th>
                    <td>프리뷰8</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>28</td>
                </tr>
                <tr>
                    <th scope="row">9</th>
                    <td>프리뷰9</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>18</td>
                </tr>
                <tr>
                    <th scope="row">10</th>
                    <td>프리뷰10</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>84</td>
                </tr>
            </tbody>
        </table>
        <!-- ./ 게시판 미리보기 1 -->
        <!-- 게시판 미리보기 2 -->
        <table class="bbs-preview table table-hover border">
            <thead>
                <tr>
                    <th scope="col" colspan="4">공지사항</th>
                    <th scope="col"><a href="#" class="fw-light">더보기 ></a></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>프리뷰1</td>
                    <td>관리자</td>
                    <td>23.04.02 14:42</td>
                    <td>152</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>프리뷰2</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>81</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>프리뷰3</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>98</td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>프리뷰4</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>78</td>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>프리뷰5</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>68</td>
                </tr>
                <tr>
                    <th scope="row">6</th>
                    <td>프리뷰6</td>
                    <td>관리자</td>
                    <td>23.04.02 14:42</td>
                    <td>15</td>
                </tr>
                <tr>
                    <th scope="row">7</th>
                    <td>프리뷰7</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>458</td>
                </tr>
                <tr>
                    <th scope="row">8</th>
                    <td>프리뷰8</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>28</td>
                </tr>
                <tr>
                    <th scope="row">9</th>
                    <td>프리뷰9</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>18</td>
                </tr>
                <tr>
                    <th scope="row">10</th>
                    <td>프리뷰10</td>
                    <td>사용자1</td>
                    <td>23.04.03 10:20</td>
                    <td>84</td>
                </tr>
            </tbody>
        </table>                        
        <!-- ./ 게시판 미리보기 2 -->
    </section>
</div>
<!-- ./ 메인컨텐츠 : END-->    