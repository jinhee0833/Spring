<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[media/list.jsp]</title>
<style type="text/css">
*{
  font-family: gulim;
  font-size: 20px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>${title}</DIV>
 
<FORM name='frm' method='POST' action=''>
  <TABLE align='center' border='1px' cellspacing='0px' cellpadding='5px'>
<!--     <TR>
      <TH>번호</TH>
      <TH>포스터</TH>
      <TH>제목</TH>
      <TH>등록일</TH>
      <TH>파일</TH>
      <TH>기타</TH>
    </TR> -->
    
    <c:forEach var="dto" items="${list }">
    <TR>
      <TD>${dto.mediano }</TD>
      <TD><A href='./read.do?mediano=${dto.mediano }'><img src='./storage/${dto.poster }' width='150'></A></TD>
      <TD><A href='./read.do?mediano=${dto.mediano }'>${dto.title }</A></TD>
      <TD>${dto.rdate.substring(0, 10) }</TD>
      <TD>${dto.filename } (${dto.filesizeUnit })</TD>
      <TD>
        <input type='button' value='수정' onclick="location.href='./update.do?mediano=${dto.mediano }&mediagroupno=${mediagroupno}'">
        <input type='button' value='삭제' onclick="location.href='./delete.do?mediano=${dto.mediano }&mediagroupno=${mediagroupno}'">  
        <br>
        <input type='button' value='  다운로드  '  
               onclick="location.href='${root}/download.do?dir=/media/storage&filename=${dto.filename }'"> 

      </TD>
    </TR>
    </c:forEach>
    
  </TABLE>
 
  <DIV class='bottom'>
    <input type='button' value='등록' 
           onclick="location.href='./create.do?mediagroupno=${mediagroupno}'">
    <input type='button' value='전체 미디어 목록' onclick="location.href='../mediagroup/list.do'">
  </DIV>
</FORM>
 
</body>
</html>

 