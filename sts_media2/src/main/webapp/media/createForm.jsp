<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[media/createForm.jsp]</title>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>

<DIV class='title'>미디어 등록</DIV>

<FORM name='frm' method='POST' action='./create.do'
      enctype='multipart/form-data'>
  <input type='hidden' name='mediagroupno' value='${mediagroupno }'>
  
  <TABLE align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <TR>
      <TH>제목</TH>
      <TD><INPUT type='text' name='title' size='50' value='mp3'></TD>    
    </TR>
    <TR>
      <TH>포스터</TH>
      <TD><INPUT type='file' name='posterMF' size='50'></TD>    
    </TR>
    <TR>
      <TH>미디어 파일</TH>
      <TD><INPUT type='file' name='filenameMF' size='50'></TD>    
    </TR>    
    
  </TABLE>    

  <DIV class='bottom'>
    <input type='submit' value='등록'>
    <input type='button' value='목록' onclick="location.href='./list.do?mediagroupno=${mediagroupno }'">
  </DIV>
</FORM>

</body>
</html>

