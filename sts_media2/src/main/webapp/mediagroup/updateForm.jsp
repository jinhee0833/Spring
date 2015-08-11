<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[mediagroup/updateForm.jsp]</title>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>

<DIV class='title'>미디어 그룹 수정</DIV>

<FORM name='frm' method='POST' action='./update.do'>
  <input type='hidden' name='mediagroupno' value='${dto.mediagroupno }'>

  <TABLE align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <TR>
      <TH>미디어 그룹 제목</TH>
      <TD><INPUT type='text' name='title' size='50' value='${dto.title }'></TD>    
    </TR>
  </TABLE>    

  <DIV class='bottom'>
    <input type='submit' value='수정'>
    <input type='button' value='목록' onclick="location.href='./list.do'">
  </DIV>
</FORM>

</body>
</html>

