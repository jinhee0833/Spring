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
		<h1><b> BOARD DETAIL </b></h1>
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
				<td>�� ��</td>
				<td>�� ��</td>
			</tr>
		
		<!-- �ڷᰡ ������� -->	
		<div align="center">	
		<tr>
			<td>${bean.hobby_idx}</td>
			<td>${bean.name}</td>
			<td>${bean.title}</td>
			<td>${bean.content}</td>
			<td>${bean.gender}</td>
			<td>${bean.hobby}</td>
			<td><a href="board_download.do?fname=${bean.img_file_name }"><img src="<%=request.getContextPath()%>/upload/${bean.img_file_name }" width=100></a></td>
			<td><input type="button" value="��  ��" onclick="location.href='board_delete.do?idx=${bean.hobby_idx}'"></td>
			<td><input type="button" value="��  ��" onclick="location.href='board_edit_form.do?a=${bean.name}&b=${bean.title}&c=${bean.gender}&d=${bean.hobby}&e=<%=request.getContextPath()%>/upload/${bean.img_file_name }&f=${bean.hobby_idx }'"></td>
			<input type="button" value="��Ϻ���" onclick="location.href='board_list.do'">
		</tr>
		</div>
		</table>	
		
	</div>
</body>
</html>