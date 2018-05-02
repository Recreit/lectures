<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.ohhoonim.vo.EmpVo" %>
<%@ page import="com.ohhoonim.vo.DeptVo" %>
<%@ page import="com.ohhoonim.common.util.Utils" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%
	Map<String,Object> empvo = (Map<String,Object>)request.getAttribute("empvo");
	List<EmpVo> empList = (List<EmpVo>)request.getAttribute("empList");
	List<DeptVo> deptList = (List<DeptVo>)request.getAttribute("deptList");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>사원정보</title>
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
</head>
<body>
	<h1>사원정보</h1>
	<hr>
		<a href="<%=contextPath%>/hr2/empList.do">목록보기</a>
		<a href="<%=contextPath%>/hr2/empRemove.do?empno=<%=empvo.get("empno")%>">사원삭제</a>
		<a href="<%=contextPath%>/hr2/empModifyView.do?empno=<%=empvo.get("empno")%>">사원수정</a>
	<hr>
	<ul>
		<li>empno : <%=empvo.get("empno") %></li>    
		<li>ename : <%=empvo.get("ename") %> </li>
		<li>sal : <%=Utils.toEmptyBlank(empvo.get("sal")) %></li>
		<li>manager : <%=Utils.toEmptyBlank(empvo.get("manager")) %></l1>
		<li>manager name : <%=Utils.toEmptyBlank(empvo.get("managerName")) %></li>
		<li>deptno : <%=Utils.toEmptyBlank(empvo.get("deptno")) %></li>
		<li>dname : <%=Utils.toEmptyBlank(empvo.get("dname")) %></li>
		<li>hiredate : <%=Utils.toEmptyBlank(empvo.get("hiredate")) %></li>
		<li>age : ${empvo.age}</li>
		<li>comm : ${empvo.comm}</li>
	</ul>
	<!-- $형태는 입력값이 있으면 반환해줌. null체크 필요 없음. -->
</body>
</html>

