<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>write form</title>
<script type="text/javascript">
	
	
	function send(f) {
		var isCheck = false; // 초기 체크값 설정
		var filename = document.getElementById("upload_f").value;
		var file_len = filename.length;
		var file_extension = filename.substr(file_len - 3, file_len);
		
		if(file_extension.toLowerCase() == "jpg" || file_extension.toLowerCase() == "png") {
			isCheck = true;
		}
		if(isCheck == false) {
			alert("확장자가 jpg, png 인 파일만 업로드가 가능합니다.");
			document.getElementById("upload_f").select();
			document.selection.clear();
			return false;
		} else {
			f.submit();
		}
	}
</script>
</head>
<body>
<!-- 파일업로드할때는 꼭 써줘야 합니다. -->
<form action="board_insert.do" enctype="multipart/form-data" method="post">
	<table border=1>
		<tr>
			<td>title</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>content</td>
			<td><textarea cols="50" rows="10" name="content"></textarea></td>
		</tr>
		<tr>
			<td>gender</td>
			<td>
				<input type="radio" value="남자" name="gender">남자
				<input type="radio" value="여자" name="gender">여자
			</td>
		</tr>
		<tr>
			<td>hobby</td>
			<td>
				<input type="checkbox" value="축구" name="hobby">축구
				<input type="checkbox" value="야구" name="hobby">야구
				<input type="checkbox" value="공부" name="hobby">공부
				<input type="checkbox" value="코딩" name="hobby">코딩
			</td>
		</tr>
		<tr>
			<td>img_file_name</td>
			<td>
				<input type="file" name="upload_f" id="upload_f">
			</td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="submit" value="전송저장하기">&nbsp;
				<input type="reset" value="입력취소하기">
				<input type="button" value="목록보기" onclick="location.href='board_list.do'">
			</td>
		</tr>
	</table>
	
	<!-- <input type="submit" value="전송" onclick="send(this.form)"> -->
</form>
</body>
</html>