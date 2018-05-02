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
	<div id="contents">
    	<div class="header">
                <h2>회원가입</h2>
        </div>
        <div id="signup">
         	<form name="frm" id="frm" action="" method="post">
                <div>
                    <label for="mbr_id" class="title">아이디</label>
                    <input type="text"  name="mbr_id" id="mbr_id" placeholder="아이디 16자 이내" maxlength="16"/>
                    <input type="button" value="중복확인" id="checkDup">
                    <input type="hidden" value="3" id="mbr_code" name="mbr_code"/>
                </div> 
                <div>
                    <label for="pwd" class="title">패스워드</label>
                    <input type="password" name="pwd" id="pwd" maxlength="20">
                    <div class="warning">6-20자 이내. 대소문자,숫자를 섞어서 작성해야 합니다.</div>
                </div>
                <div>
                    <label for="pwdChk" class="title">패스워드 확인</label>
                    <input type="password" name="pwdChk" id="pwdChk" maxlength="20">
                </div>
                <div>
                    <label for="mbr_nick" class="title">별명</label>
                    <input type="text" name="mbr_nick" id="mbr_nick" maxlength="16">
                </div>
                <div>
                    <label for="mbr_mail" class="title">이메일</label>
                    <input type="text" name="mbr_mail" id="mbr_mail" maxlength="40">
                </div>
                <div>
                    <label for="area_code" class="title">지역</label>
                    <select name="area_code" id="area_code">
                   			<option value=""></option>
                            <option value="10">서울</option>
                            <option value="20">경기</option>
                            <option value="30">인천</option>
                            <option value="40">대전</option>
                            <option value="50">대구</option>
                            <option value="60">울산</option>
                            <option value="70">광주</option>
                            <option value="80">부산</option>
                            <option value="90">강원</option>
                            <option value="11">충북</option>
                            <option value="22">충남</option>
                            <option value="33">전북</option>
                            <option value="44">전남</option>
                            <option value="55">경북</option>
                            <option value="66">경남</option>
                            <option value="77">제주</option>
                    </select>
                </div>
                <div>
                    <label for="mbr_gen" class="title">성별</label>
                    <input type="radio" name="mbr_gen" value="M" id="male">
                    <label for="male">남</label>
                    <input type="radio" name="mbr_gen" value="F" id="female">
                    <label for="female">여</label>
                    <!-- radio는 name을 같게 해주면 중복 선택이 안 되게 해준다. -->
                </div>
                <div>
                    <label for="rcv_mail" class="title">메일수신</label>
                    <input type="checkbox" name="rcv_mail" id="rcv_mail" checked>
                </div>
                <div class="buttons">
                    <input type="button" value="회원가입" id="frmSubmit">
                    <input type="button" value="취소">
                </div>
                </form>
            </div>
        </div>
    
    <!--바닥글-->
    <div id="footer">
    </div>
    <!--스크립트-->
    <script>
        $(function(){
            $('#frmSubmit').click(frmSubmit);
        });
        function frmSubmit(){
        	var id1 = $('#mbr_id').val();
            var pwd1 = $('#pwd').val();
            var pwd2 = $('#pwdChk').val();
            var email = $('#mbr_mail').val();
            if (id1.length > 2) {
	            if (pwd1.length > 5){
	                if (pwd1 != pwd2) {
	                    alert('패스워드가 일치하지 않습니다.');
	                } else if (email.length > 6)  {
	                    var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	                    if (!email.match(regExp)) {
	                        alert('이메일 형식이 아닙니다.');
	                    } else {
	                		document.frm.action = '<%=contextPath %>/member/memberAdd.do';
	                		document.frm.submit();
	                    }
	                } else {
	                    alert('이메일을 입력해 주세요.');
	                }
	            } else {
	                alert('패스워드의 길이는 6자 이상입니다.');
	            }
	        } else {
	        	alert('아이디를 3자 이상 입력해 주세요.');
	        }
        }
    </script>

</body>
</html>

