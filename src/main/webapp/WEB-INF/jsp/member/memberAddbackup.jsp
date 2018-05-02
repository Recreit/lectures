<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="ssk.vo.MemberVo" %>
<%@ page import="ssk.common.util.Utils" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp" %>
<%@ page import="java.util.List" %>
<%
	List<MemberVo> gameList = (List<MemberVo>)request.getAttribute("memberList");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>회원 추가</title>
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
</head>
<body>
	<h1>회원 추가</h1>
	<hr>
	<form name="frm" action="<%=contextPath %>/member/memberAdd.do" method="post">
		*mbr_id :			<input type="text" name="mbr_id" id="mbr_id" value=""  maxlength="16"/> 
							<input type="button" id="checkDup" value="중복체크"><br>
		*mbr_code :			<input type="text" name="mbr_code" id="mbr_code" value=""  maxlength="4"/><br>
		*pwd :			<input type="text" name="pwd" id="pwd" value=""  maxlength="20"/><br>
		*mbr_nick :			<input type="text" name="mbr_nick" id="mbr_nick" value=""  maxlength="16"/><br>
		*mbr_mail :			<input type="text" name="mbr_mail" id="mbr_mail" value=""  maxlength="40"/><br>
		*area_code :			<input type="text" name="area_code" id="area_code" value=""  maxlength="4"/><br>
		*mbr_gen :		<select name="mbr_gen" id="mbr_gen">
							<option value="M">남성</option>
							<option value="F">여성</option>	
						</select><br>
		<input type="submit" value="회원추가">
	</form>
	
	<script>
	
	</script>
	
</body>
</html>

