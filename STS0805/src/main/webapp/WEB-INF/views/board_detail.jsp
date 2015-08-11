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
		<!-- 버튼 -->
		<div class="btn">
		<input type="button" value="글쓰기" onclick="location.href='board_form.do'">
		</div>
		<table border=1 width="800">
			<tr bgcolor="lightblue" height="30" >
				<td>번 호</td>
				<td>이 름</td>
				<td>제 목</td>
				<td>내 용</td>
				<td>성 별</td>
				<td>취 미</td>
				<td> 파 일 이 름 </td>
				<td>삭 제</td>
				<td>수 정</td>
			</tr>
		
		<!-- 자료가 있을경우 -->	
		<div align="center">	
		<tr>
			<td>${bean.hobby_idx}</td>
			<td>${bean.name}</td>
			<td>${bean.title}</td>
			<td>${bean.content}</td>
			<td>${bean.gender}</td>
			<td>${bean.hobby}</td>
			<td><a href="board_download.do?fname=${bean.img_file_name }"><img src="<%=request.getContextPath()%>/upload/${bean.img_file_name }" width=100></a></td>
			<td><input type="button" value="삭  제" onclick="location.href='board_delete.do?idx=${bean.hobby_idx}'"></td>
			<td><input type="button" value="수  정" onclick="location.href='board_edit_form.do?a=${bean.name}&b=${bean.title}&c=${bean.gender}&d=${bean.hobby}&e=<%=request.getContextPath()%>/upload/${bean.img_file_name }&f=${bean.hobby_idx }'"></td>
			<input type="button" value="목록보기" onclick="location.href='board_list.do'">
		</tr>
		</div>
		</table>	
		
	</div>
</body>
</html>