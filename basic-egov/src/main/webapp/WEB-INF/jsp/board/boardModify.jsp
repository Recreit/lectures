<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ohhoonim.vo.EmpVo" %>
<%@ page import="com.ohhoonim.vo.DeptVo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ohhoonim.common.util.Utils" %>
<%@ include file="/WEB-INF/jsp/inc/commonBoard.jsp" %>
<%
	
	EmpVo empVo = (EmpVo)request.getAttribute("empvo");
	List<DeptVo> deptList = (List<DeptVo>)request.getAttribute("deptList");
%>
<html>
	<head>
		<title>수정</title>
	</head>
	<body>
		<h1>수정</h1>
		<hr>
		 
		<form action="<%=contextRoot%>/board/boardModify.do" name="frm" method="post">
			*empno : <input name="empno" type="text" value="<%=Utils.toEmptyBlank(empVo.getEmpno())%>" readonly><br>
			*ename : <input name="ename" type="text" value="<%=Utils.toEmptyBlank(empVo.getEname())%>"><br>
			sal :    <input name="sal" type="text" value="<%=Utils.toEmptyBlank(empVo.getSal())%>"><br>
			manager : <input name="manager" type="text" value="<%=Utils.toEmptyBlank(empVo.getManager())%>"><br>
			
			deptno : <select name="deptno">
						<%
							for(DeptVo dept: deptList) {
						%>
						<option value="<%=dept.getDeptno()%>" <%=empVo.getDeptno().equals(dept.getDeptno()) ? "selected": "" %>><%=dept.getDname()%></option>
						<%
							}
						%>
					 </select>
			<br>
			hiredate : <input name="hiredate" type="text" value="<%=Utils.dateFommatter(empVo.getHiredate())%>"><br>
			*age :<input name="age" type="text" value="<%=Utils.toEmptyBlank(empVo.getAge())%>"><br>
			comm : <input name="comm" type="text" value="<%=Utils.toEmptyBlank(empVo.getComm())%>"><br>
			<input type="submit" value="직원수정">
		</form>
		
	</body>
</html>