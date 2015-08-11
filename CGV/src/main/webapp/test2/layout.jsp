<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
	<div class="title_1">
		<!-- summerHeader.jsp -->
		<tiles:insertAttribute name="header" />
	</div>

	<div>
		<tiles:insertAttribute name="main" />
	</div>

	<div class="bottom_1">
		<!-- footer.jsp -->
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>