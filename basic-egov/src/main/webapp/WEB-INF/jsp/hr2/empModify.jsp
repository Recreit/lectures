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
	<title>사원정보수정</title>
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
</head>
<body>
	<h1>사원정보수정</h1>
	<hr>
	<form name="frm" action="<%=contextPath %>/hr2/empModify.do" method="post">
		*empno :			<input type="text" name="empno" id="empno" value="<%=empvo.get("empno") %>" readonly/> 
		*ename :			<input type="text" name="ename" id="ename" value="<%=Utils.toEmptyBlank(empvo.get("ename"))%>" maxlength="10"/> 
		sal :			<input type="text" name="sal" id="sal" value="<%=Utils.toEmptyBlank(empvo.get("sal")) %>"  maxlength="7"/> 
		
		manager :
			<select name="manager" id="manager">
				<option value=""> </option>
				<%
					for(EmpVo emp: empList) {
				%>
				<option value="<%=emp.getEmpno()%>" <%=Utils.toEmptyBlank(empvo.get("manager")).equals(emp.getEmpno()) ? "selected":"" %>><%=emp.getEname() %></option>
				<%
					}
				%>
			</select>
		deptno :
			<select name="deptno" id="deptno">
				<option value=""></option>
				<%
					for(DeptVo dept: deptList) {
				%>
				<option value="<%=Utils.toEmptyBlank(dept.getDeptno()) %>" <%=Utils.toEmptyBlank(empvo.get("deptno")).equals(dept.getDeptno()) ? "selected":"" %>><%=dept.getDname() %></option> 
				<%
					}
				%>
			</select>
		hiredate :		<input type="text" name="hiredate" id="hiredate" value="<%=Utils.toEmptyBlank(empvo.get("hiredate")) %>"/> 
		*age :			<input type="text" name="age" id="age" value="<%=Utils.toEmptyBlank(empvo.get("age")) %>"  maxlength="3"/> 
		comm : 			<input type="text" name="comm" id="comm" value="<%=Utils.toEmptyBlank(empvo.get("comm")) %>"  maxlength="7"/> 
		<input type="submit" value="수정완료">
	</form>
	
	<script>
	$(function(){
		$('#deptno').change(changeDept);
	});
	
	function changeDept() {
		// alert($(this).val());
		//변경된 부서번호를 서버에 보낼 준비를 한다.
		var deptno = $('#deptno').val();
		//ajax를 이용하여 지정된 url을 호출한다.
		$.ajax({
			url : '<%=contextPath%>/hr2/deptEmpList.do',
			data : { deptno : deptno },
			method : "post",
			dataType : "json",
			//서버에서 내려준 지정된 부서의 사원 목록을 manager select 태그에 옵션으로 세팅.
			success : function(data, status, jqXHR) {
				
				$('#manager').empty();
				$('#manager').append('<option value=""></option>');
				var list = data.deptEmpList;
				var listLength = data.deptEmpList.length;
				for ( var i = 0; i < listLength; i++) {
					
					var option = $('<option value="' + 'list[i].empno' + '">' + list[i].ename + '</option>');
					$('#manager').append(option);
				}
			},
			error : function(jqXHR, status, errorThrown) {
				alert('ERROR: ' + JSON.stringify(jqXHR));
			}
		});
		
	}
	
	</script>
</body>
</html>

