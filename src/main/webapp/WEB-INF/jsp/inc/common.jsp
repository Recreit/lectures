<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	String contextPath = request.getContextPath();
%>
<link type="text/css" rel="stylesheet" href="<%=contextPath %>/css/common.css">

    <!--상단 메뉴-->
    <div id="topmenu1">
        <table id="menu0">
            <tr>
            <td id="mainimage">
                <a href="<%=contextPath %>/main.jsp"><h1>BOARDLAND</h1></a>
            </td>
            <td id="search">
                <input type="text" name="searchinput" id="searchinput" placeholder="통합검색">
                <input type="button" value="검색" name="searchbtn" id="searchbtn">
                <input type="button" value="상세검색" name="detailsearchbtn" id="detailsearchbtn">
            </td>
            </tr>
        </table>
    </div>
    <!--상단 메뉴바-->
    <div id="menubar">
        <ul id="topmenu2">
            <li><a href="<%=contextPath %>/main.jsp">메인</a></li>
            <li><a href="Notice_party.html">모임</a></li>
            <li><a href="Notice_review.html">리뷰</a></li>
            <li><a href="Notice_free.html">게시판</a></li>
            <li><a href="<%=contextPath %>/gameinfo/gameList.do">랭킹</a></li>
        </ul>
        <table id="loginmenu">
            <tr>
            <td><a href="<%=contextPath %>/member/memberAddView.do"><input type="button" value="회원가입" id="Signinbutton"></a></td>
            <td><a href="Member_login.html"><input type="button" value="로그인" id="loginbutton"></a></td>
            </tr>
        </table>
    </div>
    <div style="clear:both;"></div>
    <!--상단 메뉴 끝-->