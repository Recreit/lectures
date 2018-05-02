<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file = "/WEB-INF/jsp/common/common.jsp" %>
<%
	String memberId = (String) session.getAttribute("memberId");
	memberId = memberId == null ? "": memberId;
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<title>메인</title>
	<link rel="stylesheet" href="./css/w3.css">
</head>
<body>
<h1>메인</h1>
<hr>
	<%
		if (memberId.equals("")) {
	%>
	<a href="<%=contextRoot %>/Login.do">로그인</a>
	<a href="<%=contextRoot %>/signUp.do">회원가입</a>
	<%
		} else {
	%>
	<a href="<%=contextRoot %>/memberInfo.do">회원정보보기</a>(<%=memberId %>)
	<a href="<%=contextRoot %>/logout.do">로그아웃</a>
	<%
		}
	%>

</body>
</html>