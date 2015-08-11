<%@ page contentType="text/html; charset=UTF-8" %> 
 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title> [mediagroup/createForm.jsp] </title> 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head> 
<body>
 
<DIV class="title"> [미디어그룹생성]</DIV>
 
<FORM name='frm' method='POST' action='./create.do'>
  <TABLE class='table'>
    <TR>
      <TH>미디어 그룹 제목</TH>
      <TD><input type='text' name='title' size='50' value='2014 Drive 음악'></TD>
    </TR>
  </TABLE>
  
  <DIV class='bottom'>
    <input type='submit' value='등록'>
    <input type='button' value='목록' onclick="location.href='./list.do'">
  </DIV>
</FORM>
 
</body> 
</html> 
 
 