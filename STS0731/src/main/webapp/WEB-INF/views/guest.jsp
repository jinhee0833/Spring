<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head> <title>[board/guest.jsp]</title>
	<style type="text/css">
		input,b{ font-size:20pt; font-weight:bold;}
		a{ text-decoration:none ; font-size:20pt; font-weight:bold; }
		a:hover{ text-decoration:underline ; font-size:24pt; font-weight:bold; color:red; }
	</style>
</head>
<body>
	<font size=7> [guest.jsp=guest.do] </font> <p>
	<form action="insert.do">
  	 <b>사번:</b> <input type="text" name="sabun" value="1178"> <br>
	 <b>이름:</b> <input type="text" name="name" value="HONG"> <br>
	 <b>제목:</b> <input type="text" name="title" value="summer"> <br>
	 <b>급여:</b> <input type="text" name="pay" value="74"> <p>
	             <input type="submit" value="스프링STS저장">
	             <input type="submit" value="데이타취소">
	</form>
	
	<p>
	<h1>
		<a href="index.jsp">[index.jsp]</a> 
		<a href="guest.do">[신규등록]</a>
		<a href="list.do">[전체출력]</a>
	</h1>
</body>
</html>