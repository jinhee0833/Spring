<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="sts.blog.reply.ReplyDTO" %>
<%@ page import="sts.blog.media.MediaDTO" %>
 
<%
MediaDTO mediaDTO = (MediaDTO)request.getAttribute("mediaDTO");
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[reply/list.jsp]</title>
 
<script type="text/JavaScript"
        src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
 
<script type="text/javascript">
//-------------------------------------------------------------------------
// 댓글을 등록합니다.
//-------------------------------------------------------------------------
function createProc(){
	// var replyno = document.getElementById("replyno");
	// replyno.innerHTML = 0;
	
  $("#replyno").val(0);  //  Spring 콘트롤러에서 생성되는 DTO의 초기값
  
  // var mediano = encodeURIComponent(mediano);
  // var replyno = encodeURIComponent(replyno);
  // var params = "?mediano=" + mediano + "&replyno=" + replyno;
  
  var params = $("#frm").serialize();  // 전달할 데이터
 
  // alert(params);
  // return;
 
  $.ajaxSetup({ dataType: "text" });     // Ajax 객체 준비
  $.post("./create.do", params, createProcResponse); // POST 방식
}
 
function createProcResponse(data, textStatus){
  alert(data.replace(/^\s*|\s*$/g, '')); // 정규 표현식: 공백 삭제
  window.location.reload();              // 새로고침
}
//-------------------------------------------------------------------------
 
 
// -------------------------------------------------------------------------
// 수정할 댓글을 가져옵니다.
// -------------------------------------------------------------------------
function updateForm(replyno){
$("#replyno").val(replyno);
 
  var params = "replyno=" +  replyno;  // 전달할 데이터
  $.ajaxSetup({ dataType: "text" });   // Ajax 객체 준비
  $.get("./read.do", params, updateFormResponse); // GET 방식
}
 
function updateFormResponse(data, textStatus){
  $("#content").val(data.replace(/^\s*|\s*$/g, '')); // HTML 지원, 출력 대상
  
  // document.frm.action='./update.do';
  document.frm.btnCreate.style.display = 'none';
  document.frm.btnUpdate.style.display = '';
  document.frm.btnCancel.style.display = '';
}
// -------------------------------------------------------------------------
 
function cancel(){
document.frm.content.value='';
// document.frm.action='./create.do';
  document.frm.btnCreate.style.display = ''; 
  document.frm.btnDelete.style.display = 'none';
  document.frm.btnUpdate.style.display = 'none';
document.frm.btnCancel.style.display = 'none';
}
 
//-------------------------------------------------------------------------
// 댓글을 수정합니다.
//-------------------------------------------------------------------------
function updateProc(){
var params = $("#frm").serialize();  // 전달할 데이터
 
$.ajaxSetup({ dataType: "text" });   // Ajax 객체 준비
$.post("./update.do", params, updateProcResponse); // POST 방식
}
 
function updateProcResponse(data, textStatus){
var sw = data.replace(/^\s*|\s*$/g, ''); // 응답 문자열 좌우 공백 제거
var result = sw.split("/"); // 배열명과 변수명이 같은 형식
if (result[0] == 'FAIL'){
alert(result[1]);
}else{ // SUCCESS
alert(result[1]);
window.location.reload(); // 새로고침
}
  
}
//-------------------------------------------------------------------------
 
// -------------------------------------------------------------------------
// 삭제할 댓글을 가져옵니다.
// -------------------------------------------------------------------------
function deleteForm(replyno){
  $("#replyno").val(replyno);
    
  var params = "replyno=" +  replyno;  // 전달할 데이터
  $.ajaxSetup({ dataType: "text" });   // Ajax 객체 준비
  $.get("./read.do", params, deleteFormResponse); // GET 방식
}
 
function deleteFormResponse(data, textStatus){
  $("#content").val(data.replace(/^\s*|\s*$/g, '')); // HTML 지원, 출력 대상
  
  // document.frm.action='./update.do';
  document.frm.btnCreate.style.display = 'none';
  document.frm.btnDelete.style.display = '';
  document.frm.btnCancel.style.display = '';
}
// -------------------------------------------------------------------------
 
//-------------------------------------------------------------------------
// 댓글을 삭제합니다.
//-------------------------------------------------------------------------
function deleteProc(){
var params = $("#frm").serialize();  // 전달할 데이터
 
$.ajaxSetup({ dataType: "text" });   // Ajax 객체 준비
$.post("./delete.do", params, deleteProcResponse); // POST 방식
}
 
function deleteProcResponse(data, textStatus){
  var sw = data.replace(/^\s*|\s*$/g, ''); // 응답 문자열 좌우 공백 제거
  var result = sw.split("/"); // 배열명과 변수명이 같은 형식
  if (result[0] == 'FAIL'){
    alert(result[1]);
  }else{ // SUCCESS
    alert(result[1]);
    window.location.reload(); // 새로고침
  }
  
}
//-------------------------------------------------------------------------
 
</script>
 
<style type="text/css">
*{
  font-family: 돋움체;
  font-size: 20px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'><%=mediaDTO.getTitle() %> 댓글 목록</DIV>
<DIV style='width: 70%; margin: 0 auto;'>
  <TABLE width="100%" align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <TR>
      <TH>번호</TH>
      <TH>제목</TH>
      <TH>등록일</TH>
      <TH>기타</TH>
      <TH>mediano</TH>
    </TR>
    <%
    ArrayList list = (ArrayList)request.getAttribute("list");
    for(int i=0; i<list.size(); i++){
      ReplyDTO dto = (ReplyDTO)list.get(i);
      int replyno = dto.getReplyno();
    %>
    <TR>
      <TD><%=replyno %></TD>
      <TD><%=dto.getContent() %></TD>
      <TD><%=(dto.getRdate()).substring(0, 16) %></TD>
      <TD>
        <input type='button' value='수정' 
               onclick="updateForm(<%=replyno %>)">
        <input type='button' value='삭제' 
               onclick="deleteForm(<%=replyno %>)">  
      </TD>
      <TD><%=dto.getMediano() %></TD>
    </TR>
    <%
    }
    %>
  </TABLE>
  <DIV style='width: 100%; margin: 5px auto; text-align: center;'>
    <FORM name='frm' id='frm' method='POST' action=''>
      <input type='hidden' name='mediano' id='mediano' value='<%=mediaDTO.getMediano() %>'>
      <input type='hidden' name='replyno' id='replyno' value=''>
      
      <TEXTAREA name='content' id='content' rows='3' cols='71'></TEXTAREA><br>
      패스워드: <input type='password' name='passwd' value=''>
      <input type='button' name='btnCreate' value='등록' 
             onclick="createProc()">
      <input type='button' name='btnDelete' value='삭제 진행' style='display: none;'
             onclick="deleteProc()">
      <input type='button' name='btnUpdate' value='수정 저장' style='display: none;'
             onclick="updateProc()">
      <input type='button' name='btnCancel' value='취소' style='display: none;'
             onclick='cancel()'>
      <input type='button' value='닫기' 
             onclick="location.href='../media/list.do?mediagroupno=<%=mediaDTO.getMediagroupno() %>'">
    </FORM>
  </DIV>
 
</DIV>
</body>
</html>
 