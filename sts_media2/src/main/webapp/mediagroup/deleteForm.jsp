<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [mediagroup/deleteForm.jsp]</title>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>

<DIV class='title'>[mediagroup/deleteForm.jsp]</DIV>

<FORM name='frm' method='POST' action='./delete.do'>
  <input type='hidden' name='mediagroupno' value='${mediagroupno }'>

  <DIV class="content">
    미디어 그룹을 삭제 하시겠습니까?<br><br>
    삭제하면 관련 미디어 파일도 전부 삭제됩니다.<br><br>
  </DIV>
  <DIV class='bottom'>
    <input type='submit' value='삭제 진행'>
    <input type='button' value='목록' onclick="location.href='./list.do'">
  </DIV>
</FORM>

</body>
</html>
