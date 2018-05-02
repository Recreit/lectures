<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.ohhoonim.vo.EmpVo" %>
<%@ page import="com.ohhoonim.vo.DeptVo" %>
<%@ page import="com.ohhoonim.common.util.Utils" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp" %>
<%@ page import="java.util.List" %>
<%
	List<EmpVo> empList = (List<EmpVo>)request.getAttribute("empList");
	List<DeptVo> deptList = (List<DeptVo>)request.getAttribute("deptList");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>사원추가</title>
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
</head>
<body>
	<h1>사원추가</h1>
	<hr>
	<form name="frm" action="<%=contextPath %>/hr2/empAdd.do" method="post">
		*empno :			<input type="text" name="empno" id="empno" value=""  maxlength="4"/> 
							<input type="button" id="checkDup" value="중복체크"><br>
		*ename :			<input type="text" name="ename" id="ename" value=""  maxlength="10"/><br>
		sal :			<input type="text" name="sal" id="sal" value=""  maxlength="7"/><br>
		manager :
			<select name="manager" id="manager">
				<option value=""> </option>
				<%
					for(EmpVo emp: empList) {
				%>
				<option value="<%=emp.getEmpno()%>"><%=emp.getEname() %></option>
				<%
					}
				%>
			</select><br>
		deptno :
			<select name="deptno" id="deptno">
				<option value=""></option>
				<%
					for(DeptVo dept: deptList) {
				%>
				<option value="<%=dept.getDeptno() %>"><%=dept.getDname() %></option> 
				<%
					}
				%>
			</select><br>
		hiredate :		<input type="text" name="hiredate" id="hiredate" value=""/><br>
		*age :			<input type="text" name="age" id="age" value=""  maxlength="3"/><br>
		comm : 			<input type="text" name="comm" id="comm" value=""  maxlength="7"/> 
		<input type="hidden" id="isDupCheck" name="isDupCheck" value="false">
		<input type="submit" value="직원추가">
	</form>
	
	<script>
	$(function(){
		
		$('#checkDup').click(checkDup);
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
	
	function checkDup() {
		if( $('#empno').val() != '') {
			$.ajax({
				url : '<%=contextPath%>/hr2/checkDupEmp.do',
				data : { empno : $('#empno').val()},
				method : "post",
				dataType : "json",
				success : function(data, status, jqXHR) {
					// alert(JSON.stringify(data));
					if(!data.isDup) {
						alert("사용할 수 있는 사원번호입니다.");
						$('#empno').attr('readonly' , 'readonly');
						$('#empno').css('background-color', 'gray');
						$('#isDupCheck').val("true");
					} else {
						alert("사용할 수 없는 사원번호입니다.");
						$('#empno').val('');
						$('#empno').focus();
					}
				},
				error : function(jqXHR, status, errorThrown) {
					alert('ERROR: ' + JSON.stringify(jqXHR));
				}
			});
		} else {
			alert('사원번호를 입력해 주세요');
		}
	}

	
	</script>
	
</body>
</html>

