<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [mediagroup/list.jsp] </title>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>[미디어그룹보기]</DIV>
 
<FORM name='frm' method='POST' action=''>
  <TABLE width='50%' align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <TR>
      <TH>그룹번호</TH>
      <TH>그룹명</TH>
      <TH>기타</TH>
    </TR>
    
		<c:forEach var="dto" items="${list }">
    <TR>
      <TD align='center'>${dto.mediagroupno }</TD>
      <TD><A href='../media/list.do?mediagroupno=${dto.mediagroupno }'>${dto.title }</A></TD>
      <TD align='center'>
        <input type='button' value='수정' onclick="location.href='./update.do?mediagroupno=${dto.mediagroupno }'">
        <input type='button' value='삭제' onclick="location.href='./delete.do?mediagroupno=${dto.mediagroupno }'">
      </TD>
    </TR>
    </c:forEach>

  </TABLE>
 
  <DIV class='bottom'>
    <input type='button' value='등록' onclick="location.href='./create.do'">
  </DIV>
</FORM>
 
</body>
</html>


