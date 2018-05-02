<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ssk.vo.MemberVo" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp" %>
<%
List<MemberVo> list = (List<MemberVo>)request.getAttribute("memberList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>회원목록</title>
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
</head>
<body>
	<h1>회원목록</h1>
	<hr>
	<a href="<%=contextPath %>/member/memberAddView.do">회원추가</a>
	<hr>
	<table>
		<tr>
			<th>mbr_id</th>
			<th>mbr_code</th>
			<th>pwd</th>
			<th>mbr_nick</th>
			<th>mbr_mail</th>
			<th>area_code</th>
			<th>mbr_gen</th>
		</tr>
		<% for (MemberVo row: list) { %>
		<tr>
			<td><%=row.getMbr_id() %></td>
			<td><%=row.getMbr_code() %></td>
			<td><%=row.getPwd() %></td>
			<td><%=row.getMbr_nick() %></td>
			<td><%=row.getMbr_mail() %></td>
			<td><%=row.getArea_code() %></td>
			<td><%=row.getMbr_gen() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>