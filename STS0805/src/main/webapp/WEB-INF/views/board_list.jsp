<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	.btn{
		float:right;
		margin-right:400px;
	}
</style>
</head>
<body>
	<div align="center">
		<h1><b> BOARD LIST </b></h1>
		<!-- ��ư -->
		<div class="btn">
		<input type="button" value="�۾���" onclick="location.href='board_form.do'">
		</div>
		<table border=1 width="800">
			<tr bgcolor="lightblue" height="30" >
				<td>�� ȣ</td>
				<td>�� ��</td>
				<td>�� ��</td>
				<td>�� ��</td>
				<td>�� ��</td>
				<td>�� ��</td>
				<td> �� �� �� �� </td>
			</tr>
		<!-- �ڷᰡ ������� -->
			<c:if test="${empty bean}">
			<tr><td colspan=7>�ڷᰡ �����ϴ�.</td></tr>
		</c:if>
		<!-- �ڷᰡ ������� -->
		<c:forEach var="h" items="${bean}">
		<div align="center">
		
		<tr >
			<td>${h.hobby_idx }</td>
			<td>${h.name }</td>
			<td><a href='board_detail.do?idx=${h.hobby_idx }'>${h.title }</a></td>
			<td>${h.content }</td>
			<td>${h.gender }</td>
			<td>${h.hobby }</td>
			<td><img src="<%=request.getContextPath()%>/upload/${h.img_file_name }" width=100></td>
		</tr>
		</div>
		</c:forEach>
		</table>	
	</div>
</body>
</html>