<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@  page import="java.io.*"  %>
<%@  page import="java.sql.*"  %>
<%@  page import="java.util.*"  %>

<html>
<head><title>[boardDownLoad]</title>
	<style type="text/css">
		a{font-size:22pt; text-decoration:none; }
		a:hover{ 
		 	font-size:24pt; color:blue; 
			font-family:Comic Sans MS;
		}
		input,select,td{font-size:12pt; font-weight:bold;  }
	</style>
</head>
<body>
	<font size=6><b> [boardDownLoad.jsp] </b></font><p>
	<%
     String fileName = request.getParameter( "fname" );
     String savePath = "upload";
     ServletContext context = config.getServletContext();
     String sDownloadPath = context.getRealPath(savePath);
     String sFilePath = sDownloadPath + "\\" + fileName;
     byte b[] = new byte[4096];
  
   FileInputStream in = new FileInputStream(sFilePath); //원본
   String sMimeType = getServletContext().getMimeType(sFilePath);
   System.out.println("sMimeType>>>"+sMimeType );
   // octet-stream은  8비트로 된 일련의 데이터를 뜻합니다. 지정되지 않은 파일 형식을 의미합니다.
   if(sMimeType == null) sMimeType = "application/octet-stream";

   response.setContentType(sMimeType);
   String sEncoding = new String(fileName.getBytes("euc-kr"),"8859_1");
   response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
   ServletOutputStream out2 = response.getOutputStream();
   int numRead;

   // 바이트 배열b의 0번 부터 numRead까지 
   while((numRead = in.read(b, 0, b.length)) != -1) {
    out2.write(b, 0, numRead);
   }
   out2.flush(); 
   out2.close();
   in.close();
%>
</body>
</html>










