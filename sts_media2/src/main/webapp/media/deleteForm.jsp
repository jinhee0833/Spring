<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sts.blog.media.MediaDTO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[media/deleteForm.jsp]</title>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>미디어 삭제</DIV>
 
<FORM name='frm' method='POST' action='./delete.do' >
  <input type='hidden' name='mediagroupno' value='${dto.mediagroupno }'>
  <input type='hidden' name='mediano' value='${dto.mediano }'>
  
  <DIV class='content'>
    파일을 삭제하면 복구 할 수 없습니다.<br><br>
    삭제하시려면 '삭제 진행' 버튼을 클릭하세요.<br><br>
  </DIV>   
 
  <DIV class='bottom'>
    <input type='submit' value='삭제 진행'>
    <input type='button' value='목록' onclick="location.href='./list.do?mediagroupno=${dto.mediagroupno }'">
  </DIV>
</FORM>
 
</body>
</html>
 
 