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
  
   FileInputStream in = new FileInputStream(sFilePath); //����
   String sMimeType = getServletContext().getMimeType(sFilePath);
   System.out.println("sMimeType>>>"+sMimeType );
   // octet-stream��  8��Ʈ�� �� �Ϸ��� �����͸� ���մϴ�. �������� ���� ���� ������ �ǹ��մϴ�.
   if(sMimeType == null) sMimeType = "application/octet-stream";

   response.setContentType(sMimeType);
   String sEncoding = new String(fileName.getBytes("euc-kr"),"8859_1");
   response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
   ServletOutputStream out2 = response.getOutputStream();
   int numRead;

   // ����Ʈ �迭b�� 0�� ���� numRead���� 
   while((numRead = in.read(b, 0, b.length)) != -1) {
    out2.write(b, 0, numRead);
   }
   out2.flush(); 
   out2.close();
   in.close();
%>
</body>
</html>










