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
	<h1>게임정보</h1>
	<hr>
		<a href="<%=contextPath%>/gameinfo/gameList.do">목록보기</a>
	<hr>
	<ul>
		<li>game_id : <%=gameDetail.get("game_id") %></li>
		<li>title_ko : <%=gameDetail.get("title_ko") %></li>
		<li>title_en : <%=gameDetail.get("title_en") %></li>
		<li>designer : <%=gameDetail.get("designer") %></li>
		<li>make_year : <%=gameDetail.get("make_year") %></li>
		<li>play_min : <%=gameDetail.get("play_min") %></li>
		<li>play_max : <%=gameDetail.get("play_max") %></li>
		<li>genre_name : 
		<%		
			String genreNameString = "";
			for (GenreVo code : codeList) {
				genreNameString += code.getGenre_name() + ", ";
			} 
			%>
		<%=genreNameString.substring(0, genreNameString.length()-2) %>
		</li>
		<li>genre : 
		<%		
			String genreString = "";
			for (GenreVo code : codeList) {
				genreString += code.getGenre() + ", ";
			} 
			%>
		<%=genreString.substring(0, genreString.length()-2) %>
	</ul>
	<!-- $형태는 입력값이 있으면 반환해줌. null체크 필요 없음. -->
</body>
</html>

