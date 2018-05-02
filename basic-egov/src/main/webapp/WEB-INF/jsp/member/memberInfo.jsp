<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import ="com.ohhoonim.vo.MemberVo" %>
<%
	MemberVo vo = (MemberVo) request.getAttribute("memberVo");
%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<title>회원정보</title>
	<link rel="stylesheet" href="./css/w3.css">
</head>
<body>
<h1>회원정보</h1>
<hr>
mbr_id : <%= vo.getMbr_id() %>
<br>mbr_code : <%= vo.getMbr_code() %>
<br>pwd : <%= vo.getPwd() %>
<br>contact : <%= vo.getContact() %>
<br>sav_pnt : <%= vo.getSav_pnt() %>
<br>buy_pnt : <%= vo.getBuy_pnt() %>
<br>chn_id : <%= vo.getChn_id() %>
</body>
</html>