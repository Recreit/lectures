<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ohhoonim.vo.EmpVo"%>
<%@ include file="/WEB-INF/jsp/inc/commonBoard.jsp" %>
<%
	EmpVo empvo = (EmpVo)request.getAttribute("empvo");
%>
<html>
	<head>
		<title>상세보기</title>
	</head>
	<body>
		<h1>상세보기</h1>
		<hr>
		<!-- 
		<a href="<%=contextRoot%>/board/boardRemove.do?empno=<%=empvo.getEmpno()%>">삭제</a><br/>
		 -->
		<a href="<%=contextRoot%>/board/boardRemove.do?empno=${empvo.empno}">삭제</a><br/>
		<a href="<%=contextRoot%>/board/boardModifyView.do?empno=${empvo.empno}"">수정화면이동</a>
		<hr>
		empno : ${empvo.empno}<br>
		Ename : ${empvo.ename}<br>
		Sal : ${empvo.sal}<br>
		Manager : ${empvo.manager}<br>
		Deptno : ${empvo.deptno}<br>
		Hiredate : ${empvo.hiredate}<br>
		Age : ${empvo.age}<br>
		Comm : ${empvo.comm}<br>
		
		
	</body>
</html>