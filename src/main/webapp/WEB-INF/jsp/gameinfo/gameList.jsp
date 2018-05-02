<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ssk.vo.GameVo" %>
<%@ page import="ssk.vo.GenreVo" %>
<%@ page import="java.util.Map" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp" %>
<%
List<GameVo> gameList = (List<GameVo>)request.getAttribute("gameList");
Map<String,List<GenreVo>> genreList = (Map<String,List<GenreVo>>)request.getAttribute("genreList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>보드게임 목록</title>
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
</head>
<body>
	<h1>게임목록</h1>
	<hr>
	<a href="<%=contextPath %>/gameinfo/gameAddView.do">게임추가</a>
	<hr>
	<table>
		<tr>
			<th>game_id</th>
			<th>title_ko</th>
			<th>title_en</th>
			<th>designer</th>
			<th>make_year</th>
			<th>play_min</th>
			<th>play_max</th>
			<th>genre_name</th>
		</tr>
		<% for (GameVo row: gameList) { %>
		<tr>
			<td><a href="<%=contextPath%>/gameinfo/gameDetail.do?game_id=<%=row.getGame_id() %>"><%=row.getGame_id() %></a></td>
			<td><%=row.getTitle_ko() %></td>
			<td><%=row.getTitle_en() %></td>
			<td><%=row.getDesigner() %></td>
			<td><%=row.getMake_year() %></td>
			<td><%=row.getPlay_min() %></td>
			<td><%=row.getPlay_max() %></td>
			<td>
			<%		
			List<GenreVo> codeList = genreList.get(row.getGame_id());
			String genreNameString = "";
			for (GenreVo code : codeList) {
				genreNameString += code.getGenre_name() + ", ";
			} 
			%>
			<%=genreNameString.substring(0, genreNameString.length()-2) %>
			</td>
		</tr>
		<% } %>
	</table>
</body>
</html>