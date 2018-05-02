<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="ssk.vo.GameVo" %>
<%@ page import="ssk.vo.GenreVo" %>
<%@ page import="ssk.common.util.Utils" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp" %>
<%@ page import="java.util.List" %>
<%
	List<GameVo> gameList = (List<GameVo>)request.getAttribute("gameList");
	List<GenreVo> genreList = (List<GenreVo>)request.getAttribute("genreList");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>보드게임 추가</title>
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
</head>
<body>
	<h1>게임추가</h1>
	<hr>
	<form name="frm" action="<%=contextPath %>/gameinfo/gameAdd.do" method="post">
		*game_id :			<input type="text" name="game_id" id="game_id" value=""  maxlength="7"/> 
							<input type="button" id="checkDup" value="중복체크"><br>
		*title_ko :			<input type="text" name="title_ko" id="title_ko" value=""  maxlength="100"/><br>
		*title_en :			<input type="text" name="title_en" id="title_en" value=""  maxlength="100"/><br>
		*designer :			<input type="text" name="designer" id="designer" value=""  maxlength="40"/><br>
		*make_year :			<input type="text" name="make_year" id="make_year" value=""  maxlength="4"/><br>
		*play_min :			<input type="text" name="play_min" id="play_min" value=""  maxlength="2"/><br>
		*play_max :			<input type="text" name="play_max" id="play_max" value=""  maxlength="2"/><br>
		<input type="submit" value="게임추가">
	</form>
	
	<script>
	
	</script>
	
</body>
</html>

