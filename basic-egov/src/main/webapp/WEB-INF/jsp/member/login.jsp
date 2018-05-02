<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file = "/WEB-INF/jsp/common/common.jsp" %>
<% 
	String loginFail = request.getParameter("loginFail");
	loginFail = loginFail == null ? "": loginFail; 
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<title>메인</title>
	<link rel="stylesheet" href="./css/w3.css">
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<%
		if (Boolean.parseBoolean(loginFail)) {
			out.print("<span style='color:red;'>로그인에 실패하였습니다.</span>");
		}
	%>
	<form name="loginForm" method="post" action="<%=contextRoot %>/LoginProcess.do"> 
		<label for="id">아이디</label><input type="text" name="id" value="AAA1"><br>
		<label for="pwd">패스워드</label><input type="password" name="pwd" value="2222"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>