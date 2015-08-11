<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sts.blog.media.MediaDTO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[media/updateForm.jsp]</title>
<style type="text/css">
*{
  font-family: ;
  font-size: 24px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>미디어 수정</DIV>
 
<FORM name='frm' method='POST' action='./update.do'
      enctype='multipart/form-data'>
  <input type='hidden' name='mediagroupno' value='${dto.mediagroupno }'>
  <input type='hidden' name='mediano' value='${dto.mediano }'>
  
  <TABLE align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <TR>
      <TH>제목</TH>
      <TD><INPUT type='text' name='title' size='50' value='${dto.title }'></TD>    
    </TR>
    <TR>
      <TH>포스터</TH>
      <TD>
      등록된 파일명: ${dto.poster }<br>
      <INPUT type='file' name='posterMF' size='50'></TD>    
    </TR>
    <TR>
      <TH>미디어 파일</TH>
      <TD>
      등록된 파일명: ${dto.filename }<br>
      <INPUT type='file' name='filenameMF' size='50'></TD>    
    </TR>    
    
  </TABLE>    
 
  <DIV class='bottom'>
    <input type='submit' value='수정'>
    <input type='button' value='목록' onclick="location.href='./list.do?mediagroupno=${dto.mediagroupno }'">
  </DIV>
</FORM>
 
</body>
</html>
 