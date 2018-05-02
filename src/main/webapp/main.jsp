<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ssk.vo.GameVo" %>
<%@ page import="ssk.vo.GenreVo" %>
<%@ page import="java.util.Map" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp" %>
<%

%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>메인페이지</title>
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=contextPath %>/css/common.css">
</head>
<body>
<div id="wrapper">
        <!--콘텐츠-->
        <div id="contents">
            <div class="header">
                <h2>최근 리뷰</h2>
            </div>
            <div id="recentReview">
                <a href="Notice_review.html" id="moreBtn">+ 더보기</a>
                <table class="ReviewImages">
                    <tbody>
                        <tr>
                            <td>
                                <a href="Contents_review1.html">
                                    <img src="img/game1.jpg" alt="game1">
                                    <br>
                                    12시땡 하루 1개 리뷰 미드...
                                </a>
                            </td>
                            <td>
                                <a href="Contents_review1.html">
                                    <img src="img/review2.jpg" alt="review2">
                                    <br>
                                    12시땡 하루 1개 리뷰 미드...
                                </a>
                            </td>
                            <td>
                                <a href="Contents_review1.html">
                                    <img src="img/game3.jpg" alt="game3">
                                    <br>
                                    12시땡 하루 1개 리뷰 미드...
                                </a>
                            </td>
                            <td>
                                <a href="Contents_review1.html">
                                    <img src="img/game4.jpg" alt="game4">
                                    <br>
                                    12시땡 하루 1개 리뷰 미드...
                                </a>
                            </td>
                            <td>
                                <a href="Contents_review1.html">
                                    <img src="img/review1.jpg" alt="review1">
                                    <br>
                                    미친 왕의 궁전 간단 리뷰 : ...
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="header">
                <h2>최근 게시글</h2>
            </div>
            <div class="recentNotice">
                <a href="Notice_free.html" id="moreBtn">+ 전체보기</a>
                <table class="list_table">
                    <colgroup>
                        <col width="5%" />
                        <col width="5%" />
                        <col width="30%" />
                        <col width="10%" />
                        <col width="10%" />
                    </colgroup>
                    <thead>
                        <tr>
                            <th>분류</th>
                            <th>번호</th>
                            <th>제목</th>
                            <th>이름</th>
                            <th>등록일자</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>모임</td>
                            <td>1</td>
                            <td><a href="Contents_review1.html">서울시 정기모임 모집!</a></td>
                            <td>판다</td>
                            <td>2018-02-19</td>
                        </tr>
                        <tr>
                            <td>자게</td>
                            <td>2</td>
                            <td>[스플렌더] 혹시 스플렌더 5인 해보신분 있으신가요?</td>
                            <td>허걱스</td>
                            <td>2018-02-19</td>
                        </tr>
                        <tr>
                            <td>후기</td>
                            <td>3</td>
                            <td>[산타마리아 +]2018년 2월 15일 설연휴 시작 모임 후기 </td>
                            <td>홍차</td>
                            <td>2018-02-19</td>
                        </tr>
                        <tr>
                            <td>자게</td>
                            <td>326</td>
                            <td>이제야 미니어처 하나 완성이네요.</td>
                            <td>허걱스</td>
                            <td>2018-02-19</td>
                        </tr>
                        <tr>
                            <td>후기</td>
                            <td>325</td>
                            <td>친구들과 후기[사진부족]</td>
                            <td>사과</td>
                            <td>2018-02-19</td>
                        </tr>
                        <tr>
                            <td>후기</td>
                            <td>325</td>
                            <td>친구들과 후기[사진부족]</td>
                            <td>사과</td>
                            <td>2018-02-19</td>
                        </tr>
                        <tr>
                            <td>후기</td>
                            <td>325</td>
                            <td>친구들과 후기[사진부족]</td>
                            <td>사과</td>
                            <td>2018-02-19</td>
                        </tr>
                        <tr>
                            <td>잡담</td>
                            <td>327</td>
                            <td>지름액 순항 중...</td>
                            <td>바나나</td>
                            <td>2018-02-19</td>
                        </tr>
                        <tr>
                            <td>잡담</td>
                            <td>326</td>
                            <td>이제야 미니어처 하나 완성이네요.</td>
                            <td>허걱스</td>
                            <td>2018-02-19</td>
                        </tr>
                        <tr>
                            <td>후기</td>
                            <td>325</td>
                            <td>친구들과 후기[사진부족]</td>
                            <td>사과</td>
                            <td>2018-02-19</td>
                        </tr>
                        <tr>
                            <td>후기</td>
                            <td>324</td>
                            <td>12시땡 하루 1개 리뷰 스코빌 ( Scoville )</td>
                            <td>불곰</td>
                            <td>2018-02-19</td>
                        </tr>
                        <tr>
                            <td>후기</td>
                            <td>323</td>
                            <td>[산타마리아 +]2018년 2월 15일 설연휴 시작 모임 후기 </td>
                            <td>홍차</td>
                            <td>2018-02-12</td>
                        </tr>
                        <tr>
                            <td>문의</td>
                            <td>322</td>
                            <td>티유 vs 사무라이</td>
                            <td>홍차</td>
                            <td>2018-02-10</td>
                        </tr>
                        <tr>
                            <td>거래</td>
                            <td>144</td>
                            <td>두도시, 드림홈, 웁스마이쉽 팝니다</td>
                            <td>바나나</td>
                            <td>2018-02-19</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>