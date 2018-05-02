<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ohhoonim.vo.EmpVo" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp" %>
<%@ page import="com.ohhoonim.common.util.Utils" %>
<%
	List<EmpVo> list = (List<EmpVo>)request.getAttribute("empList");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>사원목록</title>
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
</head>
<body>
	<h1>사원목록</h1>
	<hr>
	<a href="<%=contextPath %>/hr2/empAddView.do">직원추가</a>
	<hr>
	<table>
		<tr>
			<th>empno   </th>
			<th>ename   </th>
			<th>sal     </th>
			<th>manager </th>
			<th>deptno  </th>
			<th>hiredate</th>
			<th>age     </th>
			<th>comm    </th>
		</tr>
		<% for (EmpVo row: list) { %>
		<tr>
			<td><a href="<%=contextPath %>/hr2/empDetail.do?empno=<%=row.getEmpno() %>"><%=Utils.toEmptyBlank(row.getEmpno()) %></a></td>
			<td><%=Utils.nullSpace(row.getEname())%></td>
			<td><%=Utils.nullSpace(row.getSal()) %></td>
			<td><%=Utils.nullSpace(row.getManager()) %></td>
			<td><%=Utils.nullSpace(row.getDeptno()) %></td>
			<td><%=Utils.nullSpace(row.getHiredate()) %></td>
			<td><%=Utils.nullSpace(row.getAge()) %></td>
			<td><%=Utils.nullSpace(row.getComm()) %></td>
		</tr>
		<% } %>
	</table>	
	
</body>
</html>



