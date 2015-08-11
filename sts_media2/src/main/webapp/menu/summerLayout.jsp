<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="Stylesheet" type="text/css">
</head>

<body>

	<div class="title_1">
		<!-- summerHeader.jsp -->
		<tiles:insertAttribute name="header" />
	</div>

	<div>
		<tiles:insertAttribute name="body" />
	</div>

	<div class="bottom_1">
		<!-- footer.jsp -->
		<tiles:insertAttribute name="footer" />
	</div>

</body>

</html>
