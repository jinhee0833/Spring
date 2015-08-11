<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title"/></title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="Stylesheet" type="text/css">
</head>

<body>

<div>
    <tiles:insertAttribute name="body"></tiles:insertAttribute>
</div>

</body>

</html>
