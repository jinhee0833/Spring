<%@ page contentType="text/html; charset=UTF-8" %> 

<% String root = request.getContextPath(); %>
<div style="text-align: center">
  <img src="<%=root %>/menu/images/spring.jpg" width="100%" height="100px">
  <br>
  <b>
  	|&nbsp;
    <a href='<%=root %>/index.do'>HOME</a>|
    <a href='<%=root %>/member/create.do'>게시판</a>|
    <a href='<%=root %>/member/login.do'>로그인</a>|  
    <a href='<%=root %>/mediagroup/list.do'>미디어</a>|
   </b>
    <hr/> 
</div>

