<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ohhoonim.vo.NoticeVo" %>
<%@ page import="java.util.Map" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp" %>
<%@ page import="com.ohhoonim.common.util.Utils" %>
<%
	List<NoticeVo> list = (List<NoticeVo>)request.getAttribute("noticeList");
	String noticeDate = (String)request.getAttribute("noticeDate");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>공고목록</title>
	<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<h1>공지목록</h1>
	<hr>
	<form name="frm" id="frm" action="<%=contextPath %>/ifRcv/noticeList.do" method="post">
		공고등록일: <input type="text" name="noticeDate" id="noticeDate" value="<%=noticeDate%>">
		<input type="submit" value="조회">
	</form>
	<hr>
	<table class="w3-table-all">
		<tr class="w3-red">
			<th>notice_date</th>
			<th>notice_iden</th>
			<th>notice_state</th>
			<th>employ_type</th>
			<th>cate_state</th>
			<th>person</th>
			<th>quali_field</th>
			<th>language_code</th>
			<th>region_code</th>
			<th>contents</th>
			<th>manager</th>
			<th>apply_date</th>
			<th>magam_date</th>
			<th>career_cnt</th>
			<th>reference</th>
		</tr>
		<% for (NoticeVo row: list) { %>
		<tr>
			<td><%=Utils.nullSpace(row.getNotice_date())%></td>
			<td><%=Utils.nullSpace(row.getNotice_iden())%></td>
			<td><%=Utils.nullSpace(row.getNotice_state())%></td>
			<td><%=Utils.nullSpace(row.getEmploy_type())%></td>
			<td><%=Utils.nullSpace(row.getCate_state())%></td>
			<td><%=Utils.nullSpace(row.getPerson())%></td>
			<td><%=Utils.nullSpace(row.getQuali_field())%></td>
			<td><%=Utils.nullSpace(row.getLanguage_code())%></td>
			<td><%=Utils.nullSpace(row.getRegion_code())%></td>
			<td><%=Utils.nullSpace(row.getContents())%></td>
			<td><%=Utils.nullSpace(row.getManager())%></td>
			<td><%=Utils.nullSpace(row.getApply_date())%></td>
			<td><%=Utils.nullSpace(row.getMagam_date())%></td>
			<td><%=Utils.nullSpace(row.getCareer_cnt())%></td>
			<td><%=Utils.nullSpace(row.getReference())%></td>
		</tr>
		<% } %>
	</table>	
	
	<script>
	$(function(){
		$('#noticeDate').datepicker({
			  dateFormat: "yymmdd"
		});
	});
	
	</script>
</body>
</html>



