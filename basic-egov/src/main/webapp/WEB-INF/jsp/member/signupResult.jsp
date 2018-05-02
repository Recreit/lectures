<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file = "/WEB-INF/jsp/common/common.jsp" %>
<%
	String memberId = (String) session.getAttribute("memberId");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<title>회원가입결과</title>
	<link rel="stylesheet" href="./css/w3.css">
</head>
<body>
<h1>회원가입결과</h1>
<hr>
<a href="<%=contextRoot %>/memberInfo.do">회원정보보기</a>
<a href="<%=contextRoot %>/main.do">메인페이지</a>
</body>
</html>