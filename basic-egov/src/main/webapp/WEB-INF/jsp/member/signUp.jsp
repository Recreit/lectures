<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file = "/WEB-INF/jsp/common/common.jsp" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<title>회원가입</title>
	<link rel="stylesheet" href="./css/w3.css">
</head>
<body>
<h1>회원가입</h1>
<hr>
	<a href="<%=contextRoot %>/memberInfo.do?mbr_id=AAA1">회원정보보기</a>
<hr>
<form name="frm" action="<%=contextRoot %>/signUpProcess.do" method="post">
	 <label for="mbr_id">아이디</label><input type ="text" name="mbr_id" id ="mbr_id" value ="">
	 <label for="mbr_code">회원구분</label><input type ="text" name="mbr_code" id ="mbr_code" value ="">
	 <label for="pwd">패스워드</label><input type ="text" name="pwd" id ="pwd" value ="">
	 <label for="contact">연락처</label><input type ="text" name="contact" id ="contact" value ="">
     <label for="sav_pnt">포인트</label><input type ="text" name="sav_pnt" id ="sav_pnt" value ="">
     <label for="buy_pnt">구매포인트</label><input type ="text" name="buy_pnt" id ="buy_pnt" value ="">
     <label for="chn_id">체인점번호</label><input type ="text" name="chn_id" id ="chn_id" value ="">
	<input type="submit" value="회원가입">
</form>
</body>
</html>