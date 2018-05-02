<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="ssk.vo.GameVo" %>
<%@ page import="ssk.vo.GenreVo" %>
<%@ page import="ssk.common.util.Utils" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%
Map<String,Object> gameDetail = (Map<String,Object>)request.getAttribute("gameDetail");
Map<String,List<GenreVo>> genreList = (Map<String,List<GenreVo>>)request.getAttribute("genreList");
List<GenreVo> codeList = genreList.get(gameDetail.get("game_id"));
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>게임정보</title>
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
</head>
<body>
	<hr>
		<a href="<%=contextPath%>/gameinfo/gameList.do">목록보기</a>
	<hr>
	<div id="wrapper">
    <!--콘텐츠-->
    	<div id="contents">
            <!-- 게임의 상단 개요-->
            <div class="infogameTab">
                <div class="infoGameImage">
                    <a href="game1_Top.html"><img src="<%=contextPath%>/img/<%=gameDetail.get("game_id") %>.jpg" alt="<%=gameDetail.get("game_id") %>"></a>
                </div>
                <div class="infoGameScore">
                    <div>
                        전체순위 1위&nbsp;&nbsp;평점 8.4 / 10
                    </div>
                    <div>
                        <h1 style="display:inline"><%=gameDetail.get("title_ko") %></h1>&nbsp; (2002년)<br>
                        <span id="GrayTitle"><%=gameDetail.get("title_en") %></span>
                    </div>
                    <div>
                        <span>리뷰 : 36 개</span>&nbsp;&nbsp;
                        <span>한줄평 : 106 개</span>&nbsp;&nbsp;
                        <span>보유 : 856 명</span>
                    </div>
                </div>
            </div>
            <!--공통 좌측 서브메뉴-->
            <div id="submenu">
                <ul>
                    <li><a href="<%=contextPath%>/gameinfo/gameDetail.do?game_id=<%=gameDetail.get("game_id") %>">기본정보</a></li>
                    <li><a href="game1_Comment.html">한줄평</a></li>
                    <li><a href="">리뷰</a></li>
                    <li><a href="">관련 게시글</a></li>
                </ul>
            </div>
            <!--우측 컨텐츠-->
            <div id="gameinfo_table">
                <div id="gameinfo_basicData">
                    <ul>
                        <li><label for="gameinfo_korname" class="gameinfo">한국어명</label><%=gameDetail.get("title_ko") %></li>
                        <li><label for="gameinfo_enname" class="gameinfo">정식명칭</label><%=gameDetail.get("title_en") %></li>
                        <li><label for="gameinfo_designer" class="gameinfo">디자이너</label><%=gameDetail.get("designer") %></li>
                        <li><label for="gameinfo_gameclass" class="gameinfo">게임분류</label>		
                        <%	String genreNameString = "";
							for (GenreVo code : codeList) {
							genreNameString += code.getGenre_name() + "게임, ";
							} 
						%>
						<%=genreNameString.substring(0, genreNameString.length()-2) %>
						</li>
                        <li><label for="gameinfo_year" class="gameinfo">출시년도</label><%=gameDetail.get("make_year") %>년</li>
                        <li><label for="gameinfo_player" class="gameinfo">플레이 인원</label><%=gameDetail.get("play_min") %>-<%=gameDetail.get("play_max") %>명</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

