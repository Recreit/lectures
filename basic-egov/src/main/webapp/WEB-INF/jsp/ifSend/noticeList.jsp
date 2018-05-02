<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ohhoonim.vo.NoticeVo" %>
<%@ page import="java.util.Map" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp" %>
<%@ page import="com.ohhoonim.common.util.Utils" %>
<%
	List<NoticeVo> list = (List<NoticeVo>)request.getAttribute("noticeList");
	String noticeDate = (String)request.getAttribute("noticeDate");
	Map<String, Object> resultMap = (Map<String, Object>)request.getAttribute("sendNoticeResult");
	
	boolean sendResult = false;
	int resultCnt = 0;
	
	if (resultMap != null) {
		sendResult = (boolean) resultMap.get("sendResult");
		resultCnt = (int) resultMap.get("sendCount");
	}
	
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>공고목록(송신)</title>
	<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<h1>공고목록(송신)</h1>
	<hr>
	<form name="frm" id="frm" action="<%=contextPath %>/ifSend/noticeList.do" method="post">
		공고등록일: <input type="text" name="noticeDate" id="noticeDate" value="<%=noticeDate%>">
		<input type="submit" value="조회">
		<input type="button" value="송신" id="sendNotice">
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
		
		if (<%=sendResult%>) {
			alert('송신한 데이터 수는 <%=resultCnt%>개 입니다.');
		}
		
		$('#noticeDate').datepicker({
			  dateFormat: "yymmdd"
		});
		
		$('#sendNotice').click(sendNotice);
	});
	
	function sendNotice(){
		document.frm.action = '<%=contextPath %>/ifSend/sendNotice.do';
		document.frm.submit();
	}
	
	</script>
</body>
</html>



