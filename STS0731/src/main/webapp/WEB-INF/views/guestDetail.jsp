<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head> <title>[board/guestList.jsp]</title>
	<style type="text/css">
		td{font-size:16pt; font-weight:bold; }
		a{ text-decoration:none ; font-size:20pt; font-weight:bold; }
		a:hover{ text-decoration:underline ; font-size:24pt; font-weight:bold; color:red; }
	</style>
</head>
<body>
<div align="center">
	<font size=7><b> [guestDetail.jsp=detail.do] </b></font> <p>

	<table width="800"  border="1" cellspacing="0" cellpadding="0">
	
		
		<tr align="center">
			<td  colspan="5"><font size="20"> ${NAME} 님의 상세 데이터</font></td>
		</tr>
	
	
		<tr bgcolor="pink" height="50" align="center">
		  <td>사 번</td> <td>이 름</td> <td>제 목</td> <td>날 짜</td> <td>급 여</td>
		</tr>
		
	
		<tr height="35">
			<td> ${SABUN} </td>
			<td> ${NAME} </td>
			<td> ${TITLE}</td>
			<td> <fmt:formatDate value="${NALJA}" pattern="yyyy-MM-dd"/> </td>
			<td> ${PAY} </td>
		</tr>

	</table>
	
	<p>
	<h1>
		<a href="index.jsp">[index.jsp]</a> 
		<a href="guest.do">[신규등록]</a>
		<a href="list.do">[전체출력]</a>
	</h1>
</div><br>
</body>
</html>






