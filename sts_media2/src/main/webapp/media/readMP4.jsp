<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sts.blog.media.MediaDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [media/readMP4.jsp]</title>
<style type="text/css">
*{
  font-family: ;
  font-size: 24px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>

<DIV class='title'>음악 듣기</DIV>

<DIV class='content'>
  ${dto.title }<br><br>
  <VIDEO controls src="./storage/${dto.filename }" poster='./storage/${dto.poster }' width='500px' />
</DIV>

<FORM name='frm' method='POST' action=''>

  <DIV class='bottom'>
    <input type='button' value='수정' 
           onclick="location.href='./update.do?mediano=${dto.mediano }'">
    <input type='button' value='삭제' 
           onclick="location.href='./delete.do?mediano=${dto.mediano }'">

    <input type='button' value='목록' 
           onclick="location.href='./list.do?mediagroupno=${dto.mediagroupno }'">
    <input type='button' value='댓글' 
           onclick="location.href='../reply/list.do?mediano=${dto.mediano }'">
  </DIV>
</FORM>

</body>
</html>

